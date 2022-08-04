package application;

import java.util.ArrayList;
/**
 * For this application, the adult class represents a person who is at least 12 years old. It has interests appropriate for 
 * teenagers and adults which can be rated numerically to assign preference to the different interests.
 *
 */
public class Adult extends Person {
	private ArrayList<RatedInterest> interestList;
	
	/**
	 * Constructor that sets an adult's age, gender, and the maximum price that can be spent on a gift for the adult.
	 * New interestList is created and adult interests are added to the list.
	 * 
	 * @param age the age of the gift recipient
	 * @param maxPrice the maximum price the gift sender wants to spend
	 * @param gender the gender of the gift recipient
	 */
	public Adult(int age, int maxPrice, String gender) {
		super(age, maxPrice, gender);
		interestList = new ArrayList<RatedInterest>();
		interestList.add(new RatedInterest("Food/cooking"));
		interestList.add(new RatedInterest("Travel"));
		interestList.add(new RatedInterest("Sports"));
		interestList.add(new RatedInterest("Technology"));
		interestList.add(new RatedInterest("Music/listening"));
		interestList.add(new RatedInterest("Games and movies"));
		interestList.add(new RatedInterest("Creativity"));
		interestList.add(new RatedInterest("Clothing"));
		interestList.add(new RatedInterest("Beauty and perfume/cologne"));
		interestList.add(new RatedInterest("Reading and writing"));
	}
	
	/**
	 * Returns a list of the adult's RatedInterests.
	 */
	@Override
	public ArrayList<RatedInterest> getInterests() {
		return interestList;
	}

}
