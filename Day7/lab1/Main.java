package lab_08_01;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A small GUI with four buttons (labeled left, accel, right and brake), a
 * choice of conditions (labeled regular, gravel, wet and ice), and a feedback
 * text field showing the effect (in an arbitrary scale) of pressing a button in
 * a given road condition
 * 
 */
public class Main extends Application {
	private CarDriving carDriving;
	private RoadState regularState;
	private RoadState gravelState;
	private RoadState wetState;
	private RoadState iceState;
	private Label lblCarState;

	@Override
	public void start(Stage primaryStage) {
		initDriving();
		try {
			primaryStage.setTitle("State Design Pattern Demo");
			GridPane grid = new GridPane();

			grid.setAlignment(Pos.TOP_CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Label lbRoadCondition = new Label("Road Condition");
			lbRoadCondition.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			grid.add(lbRoadCondition, 0, 0, 4, 1);

			final ToggleGroup group = new ToggleGroup();

			RadioButton rb1 = new RadioButton("Regular");
			rb1.setToggleGroup(group);
			rb1.setSelected(true);
			rb1.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.setCurrentState(regularState);
				}
			});

			RadioButton rb2 = new RadioButton("Gravel");
			rb2.setToggleGroup(group);
			rb2.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.setCurrentState(gravelState);
				}
			});
			RadioButton rb3 = new RadioButton("Wet");
			rb3.setToggleGroup(group);
			rb3.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.setCurrentState(wetState);
				}
			});

			RadioButton rb4 = new RadioButton("Ice");
			rb4.setToggleGroup(group);
			rb4.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.setCurrentState(iceState);
				}
			});

			grid.add(rb1, 0, 1);
			grid.add(rb2, 1, 1);
			grid.add(rb3, 2, 1);
			grid.add(rb4, 3, 1);

			/**
			 * A big label that show current state
			 * 
			 */
			lblCarState = new Label("Ready");
			lblCarState.setFont(Font.font("Tahoma", FontWeight.BOLD, 35));
			grid.add(lblCarState, 0, 2, 4, 1);

			GridPane controlGrid = new GridPane();
			controlGrid.setAlignment(Pos.TOP_CENTER);
			controlGrid.setHgap(10);
			controlGrid.setVgap(10);
			controlGrid.setPadding(new Insets(25, 25, 25, 25));
			// grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

			final int btnWidth = 90;
			final int btnHeight = 90;
			Button accelerateBtn = new Button("Accelerate");
			accelerateBtn.setPrefWidth(btnWidth);
			accelerateBtn.setMinHeight(btnHeight);
			controlGrid.add(accelerateBtn, 1, 0);
			accelerateBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.accelerate();
					updateScreen("Accelerate");
				}
			});

			Button leftBtn = new Button("Left");
			leftBtn.setPrefWidth(btnWidth);
			leftBtn.setMinHeight(btnHeight);
			controlGrid.add(leftBtn, 0, 1);
			leftBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.left();
					updateScreen("Left");
				}

			});

			Button brakeBtn = new Button("Brake");
			brakeBtn.setPrefWidth(btnWidth);
			brakeBtn.setMinHeight(btnHeight);
			controlGrid.add(brakeBtn, 1, 1);
			brakeBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.accelerate();
					updateScreen("Brake");
				}
			});

			Button rightBtn = new Button("Right");
			rightBtn.setPrefWidth(btnWidth);
			rightBtn.setMinHeight(btnHeight);
			controlGrid.add(rightBtn, 2, 1);
			rightBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					carDriving.accelerate();
					updateScreen("Right");
				}
			});

			grid.add(controlGrid, 0, 3, 4, 1);

			Scene scene = new Scene(grid, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initDriving() {
		carDriving = new CarDriving();
		regularState = new RegularState(carDriving);
		gravelState = new GravelState(carDriving);
		wetState = new WetState(carDriving);
		iceState = new IceState(carDriving);

		carDriving.setCurrentState(regularState);
	}

	private void updateScreen(String action) {
		lblCarState.setText(action + ": " + carDriving.getLevel());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
