package woche4_5_Pet_Beispiel_Datei;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Version 0 is just the basic program structure,
 * with placeholders in the view
 */
public class PetMVC extends Application {
	private PetView view;
	private PetModel model;
	private PetController controller;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	
	public void init() {
		model = new PetModel();
		model.loadPets();
	}
	
	public void start(Stage stage) throws Exception {
		view = new PetView(stage, model);
		controller = new PetController(model, view);
		view.start();
	}
	
}
