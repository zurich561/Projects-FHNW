package woche2_Taschenrechner;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator_View {
	protected Stage stage;
	protected Calculator_Model model;
	
	// Define the fields in the GUI
	protected TextField txtCalc;
	protected Button digits[] = new Button[10];
	protected Button btnPlus;
	protected Button btnClear; 
	protected Button btnEquals; 
	protected Button btnMinus;
	protected Button btnDelete; 
	protected Button btnDivision;
	protected Button btnMultiply;


	public Calculator_View(Stage stage, Calculator_Model model) {
		this.stage = stage;
		this.model = model;
		
		BorderPane root = new BorderPane();
		txtCalc = new TextField();
		txtCalc.setDisable(true);
		txtCalc.setMinHeight(50);
		root.setTop(txtCalc);
		
		//root.setPrefSize(280, 400);
		
		GridPane buttons = new GridPane();
		root.setCenter(buttons); 
        
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new Button(Integer.toString(i));
			 digits[i].getStyleClass().add("number-button");
		}
		
		// special add for button 0
		buttons.add(digits[0], 1, 3);
		
		// add all other digits
		for (int i = 1; i < digits.length; i++) {
			buttons.add(digits[i], (i-1) % 3, 2 - (i-1) / 3);
		}		
		
		btnPlus = new Button("+");
		buttons.add(btnPlus, 3, 0);
		
		btnClear = new Button("C");
		buttons.add(btnClear, 0, 3);
		
		btnEquals = new Button("=");
		btnEquals.getStyleClass().add("equals-button");
		buttons.add(btnEquals, 3, 3);
		
		btnMinus = new Button ("-");
		buttons.add(btnMinus, 3, 1);
		
		btnDelete = new Button ("<");
		buttons.add(btnDelete, 2, 3);
		
		btnMultiply = new Button ("*");
		buttons.add(btnMultiply, 3, 2);
		
		//btnDivision = new Button (":");
		//buttons.add(btnDivision, 3, 2);
		
		// Configure grid columns and rows to resize to available space
		// See "GridPane" in the JavaFX API, section "Percentage Sizing"
		
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(100);
		buttons.getColumnConstraints().addAll(cc, cc, cc, cc);
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(100);
		buttons.getRowConstraints().addAll(rc, rc, rc, rc);
		
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("calculator.css").toExternalForm());
		stage.setTitle("Taschenrechner");
		stage.setScene(scene);
		
	}

	public void start() {
		stage.show();
	}

	/*
	public void showNumber(Button button, Calculator_Controller calculator_Controller) {
		button.toString()
		
	}*/

}
