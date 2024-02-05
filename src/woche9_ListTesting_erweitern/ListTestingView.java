package woche9_ListTesting_erweitern;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import woche9_ListTesting_erweitern.ListTestingModel.LIST_TYPES;
import woche9_ListTesting_erweitern.ListTestingModel.OPERATION_CHOICES;

public class ListTestingView {
	private Stage stage;
	private ListTestingModel model;

	protected final Integer[] DATA_AMOUNTS = {1000,3000,10000,30000,100000,300000,1000000,3000000, 10000000};

	private Label lblNumElements = new Label("Amount of data");
	protected ComboBox<Integer> cmbNumElements = new ComboBox<>();
	private Label lblListType = new Label("List type");
	protected ComboBox<LIST_TYPES> cmbListType = new ComboBox<>();
	private Label lblWhereToAdd = new Label("Add elements at");
	protected ComboBox<OPERATION_CHOICES> cmbWhere = new ComboBox<>();
	protected Button btnGo = new Button("Run test");
	protected Label lblResult = new Label();
	
	
	public ListTestingView(Stage stage, ListTestingModel model) {
		this.stage = stage;
		this.model = model;

		cmbNumElements.getItems().setAll(DATA_AMOUNTS);
		cmbNumElements.setValue(DATA_AMOUNTS[0]);
		
		cmbListType.getItems().setAll(LIST_TYPES.values());
		cmbListType.setValue(LIST_TYPES.ArrayList);
		
		cmbWhere.getItems().setAll(OPERATION_CHOICES.values());
		cmbWhere.setValue(OPERATION_CHOICES.Add);
		
		GridPane grid = new GridPane();
		grid.addRow(0, lblNumElements, cmbNumElements);
		grid.addRow(1, lblListType, cmbListType);
		grid.addRow(2, lblWhereToAdd, cmbWhere);
		
		VBox root = new VBox(grid, btnGo, lblResult);
		root.getStyleClass().add("vbox");

        Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("styles.css").toExternalForm());        
        stage.setScene(scene);
        stage.setTitle("List testing");
	}

	public void start() {
		stage.show();
	}

}
