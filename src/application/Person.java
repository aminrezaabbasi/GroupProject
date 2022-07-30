package application;

import java.util.ArrayList;

/**
 * Abstract class representing a person. Class stores information that can be used to tailor a gift recommendation
 * to a person's age, gender, and the maximum price that can be spent on a gift for this person. getInterests 
 * method can be used to return an ArrayList containing the persons interests.
 * 
 */
public abstract class Person {
	private int age;
	private double maxPrice;
	private char gender;
	
	/**
	 * Constructor setting a person's age, gender, and the maximum price that can be spent on a gift for this person.
	 * 
	 * @param age the age of the gift recipient
	 * @param maxPrice the maximum price the gift sender wants to spend
	 * @param gender the gender of the gift recipient
	 */
	public Person(int age, double maxPrice, String gender) {
		this.age = age;
		this.maxPrice = maxPrice;
		if (gender != null) {
			if (gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("for her")) 
				this.gender = 'F';
			else if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("for him")) 
				this.gender = 'M';
		}
	}
	
	/**
	 * Gets a list of the persons interests.
	 * 
	 * @return rated interests ArrayList
	 */
	public abstract ArrayList<RatedInterest> getInterests();
	
	/**
	 * Gets the age of the gift recipient.
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Gets the maximum price that can be spent on a gift for this person.
	 * 
	 * @return maximum price
	 */
	public double getMaxPrice() {
		return maxPrice;
	}
	
	/**
	 * Gets the gender of the person. Returns 'F' for female and 'M' for male, null if gender is unspecified.
	 * 
	 * @return gender of the person ('F' = female; 'M' = male; null if unspecified)
	 */
	public char getGender() {
		return gender;
	}
}
