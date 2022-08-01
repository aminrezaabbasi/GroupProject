package application;

public class AgeValidation {

	//Attribute
	private int age;
	
	//Create a constructor for validating user input for age.
	AgeValidation(int userAge) {
		age = userAge;
	}
	
	String setValue(String intAsString) {
		boolean validAge = true;
		String errorMessage = ""; 
		
		for ( char i : intAsString.toCharArray()) {
			
			// if any character is not a digit, set flag to false. because it will not be a number.
			if(!Character.isDigit(i) || i == '.') {
				validAge = false;
				errorMessage = "Please do not enter an incorrect age, you may not include this character" + i +
						" age should only contain integers" ;
			}
				// if user's input only contains digits.
				if (validAge) {
				age = Integer.parseInt(intAsString);
				}
				
				// check the user's input as I mentioned on the window.
				if (age > 100 || age < 1 ) {
					errorMessage = "Excuse me, you can only enter an integer age between 1 to 100";
			}
		}

		return errorMessage;
		
	}
}
