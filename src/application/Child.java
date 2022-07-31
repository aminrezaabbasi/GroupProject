package application;

import java.util.ArrayList;

/**
 * Child class representing a person who is under 12 years old. Has interests appropriate for a child 
 * which can be rated numerically to assign preference to the different interests.
 *
 */
public class Child extends Person {
	private ArrayList<RatedInterest> interestList;
	
	/**
	 * Constructor that sets a child's age, gender, and the maximum price that can be spent on a gift for the child.
	 * New interestList is created and child interests are added to the list.
	 * 
	 * @param age the age of the gift recipient
	 * @param maxPrice the maximum price the gift sender wants to spend
	 * @param gender the gender of the gift recipient
	 */
	public Child(int age, double maxPrice, String gender) {
		super(age, maxPrice, gender);
		interestList = new ArrayList<RatedInterest>();
		interestList.add(new RatedInterest("Lego"));
		interestList.add(new RatedInterest("Puzzles"));
		interestList.add(new RatedInterest("Dolls"));
		interestList.add(new RatedInterest("Dinosaurs"));
		interestList.add(new RatedInterest("Animals"));
		interestList.add(new RatedInterest("Art"));
		interestList.add(new RatedInterest("Creativity"));
		interestList.add(new RatedInterest("Building"));
		interestList.add(new RatedInterest("Trucks"));
		interestList.add(new RatedInterest("Music/listening"));
	}
	
	/**
	 * Returns a list of the child's rated interests.
	 */
	@Override
	public ArrayList<RatedInterest> getInterests() {
		return interestList;
	}

}
