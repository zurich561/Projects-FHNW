package woche2_Taschenrechner;

import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorMain extends Application {
	
	private Calculator_View view;
	private Calculator_Controller controller;
	private Calculator_Model model;

	public void start(Stage stage) throws Exception {
		
		stage.setResizable(false);
		model = new Calculator_Model();
		view = new Calculator_View(stage, model);
		controller = new Calculator_Controller(view, model);
		view.start();

	}
	
	public static void main (String[] args) {
		launch();
	}

}
