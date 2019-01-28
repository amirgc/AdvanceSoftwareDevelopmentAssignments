package lab_10_02;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Develop a program that displays persons’ names on a GUI. The names are stored
 * in a collection object. As you add/remove names at runtime, your GUI should
 * be synchronized with the content change in the data collection. Use the
 * Observer Pattern to design/write the program.
 *
 */
public class MainObserver extends Application implements Observer {
	private ListView<String> list = new ListView<String>();
	private TextField txtName;
	private NameListSubject nameList = new NameListSubject();

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Observer Design Pattern Demo");
			GridPane grid = new GridPane();

			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			list = new ListView<String>();
			/**
			 * Text area
			 */

			grid.add(list, 0, 0);

			GridPane controlGrid = new GridPane();
			controlGrid.setAlignment(Pos.TOP_LEFT);
			controlGrid.setHgap(10);
			controlGrid.setVgap(10);
			controlGrid.setPadding(new Insets(25, 25, 25, 0));
			// grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");

			final int btnWidth = 90;
			txtName = new TextField();
			txtName.setPrefWidth(150);
			controlGrid.add(txtName, 0, 0);

			Button addBtn = new Button("Add");
			addBtn.setPrefWidth(btnWidth);
			controlGrid.add(addBtn, 1, 0);
			addBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					add();
				}
			});

			Button removeBtn = new Button("Remove");
			removeBtn.setPrefWidth(btnWidth);
			controlGrid.add(removeBtn, 2, 0);
			removeBtn.setDisable(true);
			removeBtn.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					remove();
				}
			});

			grid.add(controlGrid, 0, 1);

			Scene scene = new Scene(grid, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();

			nameList.attach(this);

			list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					removeBtn.setDisable(false);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void add() {
		if (!txtName.getText().isEmpty()) {
			this.nameList.addName(txtName.getText());
		}
	}

	private void remove() {
		String name = list.getSelectionModel().getSelectedItem();
		if (name != null) {
			this.nameList.removeName(name);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update() {
		this.list.getItems().clear();
		this.list.getItems().addAll(nameList.getNames());
	}
}
