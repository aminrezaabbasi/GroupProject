package application;
/**
 * Extends Interest class to allow a numeric value to be stored with an interest. Allows interests to be compared with
 * each other and rated according to user preference.
 *
 */

public class RatedInterest extends Interest {
	private double rating = 0;
	
	/**
	 * Constructor that sets interest name.
	 * 
	 * @param interestName the name of the interest
	 */
	public RatedInterest(String interestName) {
		super(interestName);
	}
	
	/**
	 * Constructor that sets interest name and rating.
	 * 
	 * @param interestName the name of the interest
	 * @param rating the rating of the interest
	 */
	public RatedInterest(String interestName, double interestRating) {
		super(interestName);
		rating = interestRating;
	}

	/**
	 * Gets the interest rating
	 * 
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets the interest rating
	 * 
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

}
