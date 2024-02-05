package woche2_Taschenrechner;

public class Calculator_Model {

	protected void showNumber (String number) {
		
	}

	public String calculate(String text) {
		boolean error = false;
		String result = null;
		
		
		String operator = "";
		String[] strOperator = text.split("[^\\+\\-\\*/]+"); //Operator extrahieren
		
		if (strOperator.length >= 2) {
			operator = strOperator[1];
		}
		
        String[] strValues = text.split("[+\\-*/]"); // Zahlen von Operator trennen

        int[] intValues = new int[strValues.length];

        try {
            // Zahlen aus strValues in Int Array speichern
            for (int i = 0; i < strValues.length; i++) {
                intValues[i] = Integer.parseInt(strValues[i]);
            }
        } catch (NumberFormatException e) {
            error = true;
        }
		
		
		

		
		if (error) {
			result = "Error";
		} else {
			int res = intValues[0];
	          for (int i = 1; i < intValues.length; i++) {
	                switch (operator) {
	                    case "+":
	                        res += intValues[i];
	                        break;
	                    case "-":
	                    	res -= intValues[i];
	                        break;
	                    case "*":
	                    	res *= intValues[i];
	                    	break;
	                    default:
	                        System.out.println("Ungültiger Operator: " + operator);
	                        error = true;
	                        result = "Error";
	                        break;
	                }
	          }
	          
	 		 if (!error) {
	             result = Integer.toString(res);
		}
		
         }
		
		return result;
	}
}
