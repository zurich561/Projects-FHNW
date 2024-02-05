package woche2_Taschenrechner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class Calculator_Controller implements EventHandler<ActionEvent> {
    private static final EventHandler<? super KeyEvent> Event = null;
	private Calculator_Model model;
    private Calculator_View view;
	
	public Calculator_Controller(Calculator_View view, Calculator_Model model) {
        this.model = model;
        this.view = view;
        
		// register for events
		for (Button b : view.digits) {
			b.setOnAction(this);
		}
		
		view.btnClear.setOnAction(this);
		view.btnDelete.setOnAction(this);
		//view.btnDivision.setOnAction(this);
		view.btnEquals.setOnAction(this);
		view.btnMinus.setOnAction(this);
		view.btnPlus.setOnAction(this);
		view.btnMultiply.setOnAction(this);
		
		/*
		view.txtCalc.addEventHandler(KeyEvent.ANY, keyEvent -> {
		    String input = keyEvent.getCharacter();
		    
		    // Überprüfen, ob die Eingabe eine Ziffer ist
		    if (input.matches("[0-9]") || input.matches("+") || input.matches("-") || input.matches("=")) {
		        view.txtCalc.setText(view.txtCalc.getText() + input.toString());
		    }
		});*/
		
		view.txtCalc.setOnKeyTyped( keyEvent -> {
			 String input = keyEvent.getCharacter();
			    
			    // Überprüfen, ob die Eingabe eine Ziffer ist
			    if (input.matches("[0-9]") || input.matches("+") || input.matches("-") || input.matches("=") 
			    		|| input.matches("*")) {
			        view.txtCalc.setText(view.txtCalc.getText() + input.toString());
			    }
			
		});
		
	}

	@Override
	public void handle(ActionEvent event) {
		Button btn = (Button) event.getSource();
		
		if (btn == view.btnClear) {
			view.txtCalc.setText(""); // view.txtCalc ist der Text im Display!
		} else if (btn == view.btnEquals) {
			String result = model.calculate(view.txtCalc.getText()); // hier greift der Controller auf das Model zu für die Berechnung.
			view.txtCalc.setText(result); // Resultat aus Model wird als Text angezeigt.
		} else if (btn == view.btnDelete) {
		    String currentText = view.txtCalc.getText();
			
			if (!currentText.isEmpty()) {
		        // Um den letzten Buchstaben zu löschen, verwenden Sie die Methode "substring"
		        // um den Text ohne den letzten Buchstaben zu erhalten.
		        String newText = currentText.substring(0, currentText.length() - 1);
		        
		        // Setzen Sie den neuen Text im JTextField.
		        view.txtCalc.setText(newText);
			}
		}
		
		else { // tritt ein wenne ein Nummer Buttong gedrückt wurde. 
			view.txtCalc.setText(view.txtCalc.getText() + btn.getText()); //holt erst was bis anhin drin stand und fügt die neue Zahl dem hinzu.
		}
		
	}
	
	
	


	
	

}

