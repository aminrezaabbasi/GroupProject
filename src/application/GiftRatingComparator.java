package application;

import java.util.Comparator;

/**
 * Compares gifts based on their gift rating. Used to sort gifts in descending order based on their gift rating.
 *
 */
public class GiftRatingComparator implements Comparator<Gift> {

	/**
	 * Compares two gifts based on gift rating. Returns -1 if o1 has a higher rating than o2, 1 if o2 has 
	 * a higher rating than o1, or 0 if the two gifts have the same rating.
	 * 
	 */
	@Override
	public int compare(Gift o1, Gift o2) {
		if (o1.getGiftRating() > o2.getGiftRating())
			return -1;
		if (o1.getGiftRating() < o2.getGiftRating())
			return 1;
		else return 0;
	}

}
