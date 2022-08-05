package application;



public class NumericInput {

	//Attribute
	private int userNumber;
	private int min;
	private int max;
	private boolean hasMax = false;
	private boolean validInput = true;
	
	//Create a constructor for validating user input for age.
	NumericInput(String userInput, int minValue) {
		min = minValue;
		setValue(userInput);
	}
	NumericInput(String userInput, int minValue,int maxValue) {
		hasMax = true;
		min = minValue;
		max = maxValue;
		setValue(userInput);
	}

	  public int getValue() {
		 return userNumber;
		  
	  }
	  void setValue(String intAsString) {
		String errorMessage = ""; 
		
		for ( char i : intAsString.toCharArray()) {
			

			if(!Character.isDigit(i)) {
				validInput = false;
			}
		}
			if (validInput) {
				userNumber = Integer.parseInt(intAsString);
				if (userNumber < min ) {
					validInput = false;
				}
				if(hasMax) {
					if (userNumber > max) {
						validInput = false;
						errorMessage = "Your input is not correct, the maximum possible input is: " + "" + max;
					}
				}
			}
		
	 }
	  public boolean inputIsValid() {
	  		return validInput;
	  		}
  	}
