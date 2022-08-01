package application;

public class PriceValidation {
	
	//Attribute
	private double maximumPrice;
	
	//Create a constructor for validating user input for age.
	PriceValidation(double userPrice) {
		maximumPrice = userPrice; 
	}
	
	String setValue2(String intAsString2) {
		boolean validPrice = true;
		String errorMessage2 = ""; 
		
		for ( char o : intAsString2.toCharArray()) {
			
			// if any character is not a digit, set flag to false. because it will not be a number.
			if(!Character.isDigit(o) || o == '.') {
				validPrice = false;
				errorMessage2 = "Please do not enter an incorrect price, you may not include this character" + o +
						" price should only contain integers" ;
			}
				
				// if user's input only contains digits.
				if (validPrice) {
					maximumPrice = Double.parseDouble(intAsString2);
				}
				
				// check the user's input as I mentioned on the window.
				if (maximumPrice > 2000 || maximumPrice < 10 ) {
					errorMessage2 = "Excuse me, you can only enter an integer price between 10 to 2000";
			}
		}

		return errorMessage2;
		
	}

}
