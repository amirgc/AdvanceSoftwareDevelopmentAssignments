package lab_10_01;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * I implemented two patterns: 1. Player to player: I used Mediator pattern.
 * Mediator also contains all gaming logic 2. Mediator to GUI: I used Observer.
 * Main screen is an observer, and mediator is an subject The game allows two
 * people play together. What is not done: determine who is the winner. Players
 * must decide which one win.
 *
 */
public class Main extends Application implements Observer {
	private static final int ROWS = ReversiMediator.ROWS;
	private static final int COLS = ReversiMediator.COLS;

	private static final int CELL_WIDTH = 50;
	private static final int CELL_HEIGHT = 50;
	private GridPane board;

	private Canvas[][] cells = new Canvas[ROWS][COLS];
	boolean blackTurn = true;

	private Label status;
	private Label firstScore;
	private Label secondScore;
	private Button resetBtn;
	private ReversiMediator mediator;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Reversi Game - Two Players");
		status = new Label("--");
		final Font font = new Font(30);
		status.setFont(font);
		GridPane grid = new GridPane();
		GridPane statusGrid = new GridPane();

		statusGrid.setHgap(10);
		statusGrid.setVgap(10);
		statusGrid.setPadding(new Insets(25, 25, 25, 25));

		firstScore = new Label("0");
		firstScore.setFont(font);
		secondScore = new Label("0");
		secondScore.setTextFill(Color.GREEN);
		secondScore.setFont(font);
		resetBtn = new Button("Reset");
		resetBtn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				resetGame();
			}
		});
		grid.setAlignment(Pos.CENTER);
		// grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

		statusGrid.add(firstScore, 0, 0);
		statusGrid.add(status, 1, 0);
		statusGrid.add(secondScore, 2, 0);
		statusGrid.add(resetBtn, 3, 0);

		grid.add(statusGrid, 0, 0);

		buildBoardGUI();
		grid.add(board, 0, 1);
		Scene scene = new Scene(grid, 600, 550);
		primaryStage.setScene(scene);
		primaryStage.show();

		initGame();
	}

	public void resetGame() {
		mediator.newGame();
	}

	private void initGame() {
		mediator = new ReversiMediatorImpl(this);
		mediator.newGame();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void buildBoardGUI() {
		board = new GridPane();
		board.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				Canvas canvas = new GridCanvas(CELL_WIDTH, CELL_HEIGHT, i, j);
				cells[i][j] = canvas;
				board.add(canvas, j, i);
				canvas.setOnMouseClicked(new EventHandler<Event>() {
					@Override
					public void handle(Event event) {
						cellClicked(event.getSource());
					}
				});
			}
		}
	}

	private void cellClicked(Object source) {
		GridCanvas canvas = (GridCanvas) source;
		boolean moveOK = mediator.place(canvas.getRow(), canvas.getColumn());
		if (!moveOK) {
			alert("Invalid move");
		}
	}

	private void draw(Canvas canvas, Color color) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		final double radius = canvas.getWidth() - 6;
		gc.setStroke(color);
		gc.setFill(color);
		gc.fillOval(3, 3, radius, radius);
	}

	@Override
	public void update() {
		System.out.println("update");
		// draw the board
		clearBoard();
		drawBoard();
		// update turn
		updateTurn();
		// update scores
		updateScores();

	}

	private void updateScores() {
		this.firstScore.setText(String.format("%5d", mediator.getFirstPlayer().getScore()));
		this.secondScore.setText(String.format("%5d", mediator.getSecondPlayer().getScore()));
	}

	private void updateTurn() {
		String turn;
		if (mediator.getTurn() == mediator.getFirstPlayer().getNumber()) {
			turn = "Black turn";
		} else {
			turn = "Green turn";
		}
		this.status.setText(turn);
	}

	private void drawBoard() {
		ObservableList<Node> children = board.getChildren();
		for (Node node : children) {
			drawCell(node);
		}
	}

	private void drawCell(Node node) {
		if (node instanceof GridCanvas) {
			GridCanvas cell = (GridCanvas) node;
			int cellData = mediator.getBoardValue(cell.getRow(), cell.getColumn());
			Color color = null;
			boolean draw;
			if (cellData == mediator.getFirstPlayer().getNumber()) {
				color = Color.BLACK;
				draw = true;
			} else if (cellData == mediator.getSecondPlayer().getNumber()) {
				color = Color.GREEN;
				draw = true;
			} else {
				draw = false;
			}
			if (draw) {
				draw(cell, color);
			} else {
				clearCell(node);
			}
		}
	}

	private void clearBoard() {
		ObservableList<Node> children = board.getChildren();
		for (Node node : children) {
			clearCell(node);
		}

	}

	private void clearCell(Node node) {
		if (node instanceof Canvas) {
			Canvas canvas = (Canvas) node;
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.WHITE);
			gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		}
	}

	private void alert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION, message);
		alert.showAndWait();
	}
}
