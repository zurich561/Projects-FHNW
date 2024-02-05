package oneTimePad;

import javafx.application.Application;
import javafx.stage.Stage;

public class OneTimePadLauncher extends Application {

	private OneTimePadView view;
	private OneTimePadController controller;
	private OneTimePadModel model;

    @Override
    public void start(Stage stage) throws Exception {
    	stage.setResizable(true);
		model = new OneTimePadModel();
		view = new OneTimePadView(stage, model);
		controller = new OneTimePadController(view, model);
		view.start();
    }

    public static void main (String[] args) {
		launch();
	}

}