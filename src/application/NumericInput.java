package application;

/**
 * This class will do the validation user's input for us. It validates the price and age inputs on the first page of the interface
 *
 */

public class NumericInput {

	//Attribute
	private int userNumber;
	private int min;
	private int max;
	private boolean hasMax = false;
	private boolean validInput = true;
	
	/**
	 * This is the first constructor that we will use to validate the age.
	 * @param userInput
	 * @param minValue
	 */
	NumericInput(String userInput, int minValue) {
		min = minValue;
		setValue(userInput);
	}
	
	/**
	 * This is the second constructor that we will use to validate the price.
	 * @param userInput
	 * @param minValue
	 * @param maxValue
	 */
	NumericInput(String userInput, int minValue,int maxValue) {
		hasMax = true;
		min = minValue;
		max = maxValue;
		setValue(userInput);
	}

	/**
	 * This is the getter for the class scope variable called userNumber. 
	 * @return userNumber
	 */
	  public int getValue() {
		 return userNumber;  
	  }
	  
	  /**
	   * This method will do the validation user's input, it will check whether the input is digit or not,
	   * Furthermore, it will check the possible minimum & maximum value for the price, and possible minimum value for the age. 
	   * @param intAsString
	   * @return it will not return anything.
	   */
	  void setValue(String intAsString) {
		  
		  // If the user do not provide an input for the age and price on the first page,
		  // it will returns false.
		  if (intAsString == "") {
			  validInput = false; 
		  }
		  
		  // if the user provide inputs on the first page, we want to do the following things:
		  else { 
			  // loop through the user's input.
			  for ( char i : intAsString.toCharArray()) {
		
				// Check whether the user's input contain digits or not.
				// It will returns true if all the characters are digits, otherwise it will returns false.
				if(!Character.isDigit(i)) {
					validInput = false;
					}
			  	}
			  
			  // If all the characters are digits, we want to do the following things: 
			  if (validInput) {
				  userNumber = Integer.parseInt(intAsString);
				  
				  // Check whether the user's input is smaller than the possible minimum value or not.
			      if (userNumber < min ) {
					  validInput = false;
				  }
			      
			      // check whether the user's input is bigger than the possible maximum value or not.
			      if(hasMax) {
					 if (userNumber > max) {
						 validInput = false;
					 }
							
				  }	
			  }
		  }
	  }
	  /** 
	   * This method returns true if the input provided is an integer and meets the minimum & maximum requirements.
	   * and will returns false otherwise.
	   * @return validInput
	   */
	  public boolean inputIsValid() {
	  		return validInput;
	  		}
  	}
