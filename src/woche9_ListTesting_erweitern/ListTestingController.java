package woche9_ListTesting_erweitern;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import woche9_ListTesting_erweitern.ListTestingModel.LIST_TYPES;
import woche9_ListTesting_erweitern.ListTestingModel.OPERATION_CHOICES;

public class ListTestingController {
	private ListTestingModel model;
	private ListTestingView view;

	private final DecimalFormat timeFormatter = new DecimalFormat("0.000");
	
	public ListTestingController(ListTestingModel model, ListTestingView view) {
		this.model = model;
		this.view = view;
		
		view.btnGo.setOnAction(this::setUpTest);
	}
	
	private void setUpTest(ActionEvent e) {
		// Get selections from View
		Integer amountOfData = view.cmbNumElements.getValue();
		LIST_TYPES listType = view.cmbListType.getValue();
		OPERATION_CHOICES whereChoice = view.cmbWhere.getValue();

		float runTime = model.runTest(amountOfData, listType, whereChoice);
		
		view.lblResult.setText("Time: " + timeFormatter.format(runTime) + " seconds");
		
		// Trigger garbage collection
		System.gc();
	}

}
