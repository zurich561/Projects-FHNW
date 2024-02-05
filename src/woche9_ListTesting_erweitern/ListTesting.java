package woche9_ListTesting_erweitern;

import javafx.application.Application;
import javafx.stage.Stage;

public class ListTesting extends Application {
    private ListTestingView view;
    private ListTestingController controller;
    private ListTestingModel model;

    @Override
    public void start(Stage stage) throws Exception {
        model = new ListTestingModel();
        view = new ListTestingView(stage, model);
        controller = new ListTestingController(model, view);

        // Display the GUI after all initialization is complete
        view.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
