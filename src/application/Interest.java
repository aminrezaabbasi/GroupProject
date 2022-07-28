package application;

/**
 * The Interest class allows an interest/hobby to be stored. Can determine if two interests are the same 
 * based on their stored names.
 *
 */
public class Interest {
	private String name;
	
	/**
	 * Constructor that sets interest name.
	 * 
	 * @param interestName the name of the interest
	 */
	public Interest (String interestName) {
		name = interestName;
	}
	
	/**
	 * Gets the name of the interest.
	 * 
	 * @return interest name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Determines whether two interests are the same based on their names in a case-insensitive manner.
	 * 
	 * @param otherInterest the interest to be compared
	 * @return true if both interests have the same name, otherwise returns false
	 */
	public boolean equals(Interest otherInterest) {
		return this.name.equalsIgnoreCase(otherInterest.name);
	}
}
