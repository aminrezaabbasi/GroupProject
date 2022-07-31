package application;

import java.util.ArrayList;

/**
 * The Gift class represents gift objects. Gifts can have a name, price, targeted gender, and interest categories
 * that the gift is associated with (e.g. sports, games, etc). Each gift can have 1 to 3 different interests
 * that it is categorized under. The rateGift method can be called to rate the quality of a gift for a specific 
 * person based on the person's rating of the gift's interest categories. 
 *
 */
public class Gift {
	private String name;
	private int price;
	private char gender;
	private double giftRating;
	private ArrayList<Interest> giftCharacteristics;
	
	/**
	 * Gift constructor for gifts that are classified under 1 category/ interest.
	 * 
	 * @param name the name/description of the gift
	 * @param price the price of the gift
	 * @param gender 'F' if gift is female, 'M' if gift is male, 'O' if gift is other
	 * @param giftCategory Interest that categorizes gift
	 */
	public Gift (String name, int price, char gender, Interest giftCategory) {
		this.name = name;
		this.price = price;
		this.gender = gender;
		giftCharacteristics = new ArrayList<Interest>();
		giftCharacteristics.add(giftCategory);
	}
	
	/**
	 * Gift constructor for gifts that are classified under 2 categories/ interests.
	 * 
	 * @param name the name/description of the gift
	 * @param price the price of the gift
	 * @param gender 'F' if gift is female, 'M' if gift is male, 'O' if gift is other
	 * @param giftCategory1 first Interest that categorizes gift
	 * @param giftCategory2 second Interest that categorizes gift
	 */
	public Gift (String name, int price, char gender, Interest giftCategory1, Interest giftCategory2) {
		this.name = name;
		this.price = price;
		this.gender = gender;
		giftCharacteristics = new ArrayList<Interest>();
		giftCharacteristics.add(giftCategory1);
		giftCharacteristics.add(giftCategory2);
	}
	
	/**
	 * Gift constructor for gifts that are classified under 3 categories/ interests.
	 * 
	 * @param name the name/description of the gift
	 * @param price the price of the gift
	 * @param gender 'F' if gift is female, 'M' if gift is male, 'O' if gift is other
	 * @param giftCategory1 first Interest that categorizes gift
	 * @param giftCategory2 second Interest that categorizes gift
	 * @param giftCategory3 third Interest that categorizes gift
	 */
	public Gift (String name, int price, char gender, Interest giftCategory1, Interest giftCategory2, Interest giftCategory3) {
		this.name = name;
		this.price = price;
		this.gender = gender;
		giftCharacteristics = new ArrayList<Interest>();
		giftCharacteristics.add(giftCategory1);
		giftCharacteristics.add(giftCategory2);
		giftCharacteristics.add(giftCategory3);
	}
	
	/**
	 * Returns gift name and price formatted as string
	 */
	public String toString() {
		return "Gift: " + name + "\tCost: $" + price;
	}
	
	/**
	 * Checks if gift is targeted towards a specific gender. If yes, returns true; if no, returns false.
	 * 
	 * @return true if gift is gendered, false if gift is not gendered
	 */
	public boolean isGendered() {
		if (gender == 'F' || gender == 'M') return true;
		return false;
	}
	
	/**
	 * Rates gift for particular gift recipient, generating score between 0 - 10. Gift rating is a weighted average of the 
	 * user's ratings of the interests the gift is categorized under. If the user doesn't possess any of the gift's categories 
	 * (the interests a user rates vary by user age), the score for that category will be counted as 0.
	 * 
	 * @param giftRecipient the person who will receive the gift
	 */
	public void rateGift(Person giftRecipient) {
		double rating = 0;
		// Goes through each interest category gift possesses to assess what user rated those specific interests
		for (Interest category: giftCharacteristics) {
			// If user has interest that matches the gift category, the user's rating for that interest is added to running total
			for (RatedInterest interest: giftRecipient.getInterests()) {
				if (category.equals(interest)) rating += interest.getRating();
			}
		}
		// Gets weighted average of gift ratings per number of categories gift possesses (by necessity always 1-3 categories)
		rating = rating / giftCharacteristics.size();
		giftRating = rating;
	}
	
	/**
	 * Returns the gift rating (number between 0 and 10). The method rateGift() must first be called to 
	 * rate a gift for a particular user, otherwise 0 will be returned as a default value.
	 * 
	 * @return the gift rating
	 */
	public double getGiftRating() {
		return giftRating;
	}
}
