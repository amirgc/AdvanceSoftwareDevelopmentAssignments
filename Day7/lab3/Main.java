package lab_08_03;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

/**
 * Develop a GUI that edits user information. You will need at least 3 buttons –
 * load (from a file), undo, save. When you start, you use the ‘load’ button to
 * read an existing profile for the user, if it does exist. If not, then create
 * a new profile for the user. At any time during the edit work, you can always
 * click on ‘undo’ to restore from errors, like what the MS Word allows you to
 * do.
 *
 */
public class Main extends Application {
	private static final String FILE_NAME = "data.txt";
	private TextOriginator textOriginator;
	private TextCareTaker textCareTaker;
	private TextArea content;

	@Override
	public void start(Stage primaryStage) {

		textOriginator = new TextOriginator();
		textCareTaker = new TextCareTaker();
		try {
			primaryStage.setTitle("Memeto Design Pattern Demo");
			GridPane grid = new GridPane();

			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			/**
			 * Text area
			 */
			content = new TextArea();
			content.setPrefRowCount(30);
			content.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
				KeyCode code = event.getCode();
				boolean isSpaceOrEnterKey = code == KeyCode.SPACE || code == KeyCode.ENTER;
				if (isSpaceOrEnterKey) {
					textCareTaker.addAction(new TextMemento(content.getText()));
					System.out.println("Snapshot stored");
				}
			});
			textCareTaker.addAction(new TextMemento(content.getText()));
			grid.add(content, 0, 0);
			GridPane controlGrid = new GridPane();
			controlGrid.setAlignment(Pos.TOP_LEFT);
			controlGrid.setHgap(10);
			controlGrid.setVgap(10);
			controlGrid.setPadding(new Insets(25, 25, 25, 0));
			// grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

			final int btnWidth = 90;

			Button loadBtn = new Button("Load");
			loadBtn.setPrefWidth(btnWidth);
			controlGrid.add(loadBtn, 0, 0);
			loadBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					load();
					textCareTaker.addAction(new TextMemento(content.getText()));
				}
			});

			Button saveBtn = new Button("Save");
			saveBtn.setPrefWidth(btnWidth);
			controlGrid.add(saveBtn, 1, 0);
			saveBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					save();
				}

			});

			Button undoBtn = new Button("Undo");
			undoBtn.setPrefWidth(btnWidth);
			controlGrid.add(undoBtn, 2, 0);
			undoBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					undo();
				}
			});

			grid.add(controlGrid, 0, 1);

			Scene scene = new Scene(grid, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void load() {
		TextMemento m = textCareTaker.load(FILE_NAME);
		textOriginator.loadFromMemento(m);
		content.setText(textOriginator.getText());
	}

	private void undo() {
		TextMemento m = textCareTaker.undo();
		textOriginator.loadFromMemento(m);
		content.setText(textOriginator.getText());
	}

	private void save() {
		TextMemento m = new TextMemento(content.getText());
		textCareTaker.save(FILE_NAME, m);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
