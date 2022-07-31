package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The GiftList class holds a generic list of gifts from which a personalized gift list can be created for a gift recipient
 * that matches the recipients attributes and interests. The method getSortedGiftList can be called to return a list of
 * possible gifts sorted in descending order by how well they match the gift recipient.
 *
 */
public class GiftList {
	private static ArrayList<Gift> genericGiftList;
	private ArrayList<Gift> personalizedGiftList;
	
	
	/**
	 * Creates and sorts a personalized ArrayList of gifts for the giftRecipient such that all gifts in the list match the
	 * gift recipient's age, gender, and price requirements. Gifts are sorted by giftRating (a number representing how well
	 * the gift matches the recipients interests), with gifts with a higher gift rating placed earlier in the list.
	 * 
	 * @param giftRecipient the person receiving a gift
	 * @return a list of possible gifts for giftRecipient sorted to place gifts that best match the recipients interests first
	 */
	public ArrayList<Gift> getSortedGiftList(Person giftRecipient) {
		addGifts(giftRecipient);
		// randomize list order so that gifts with same gift rating won't be shown to user in the same order each time app is run
		Collections.shuffle(personalizedGiftList);
		// sort personalized gift list based on gift ratings (highest rated gifts first)
		Collections.sort(personalizedGiftList, new GiftRatingComparator());
		return personalizedGiftList;
		
	}
	
	/**
	 * Iterates through gifts in genericGiftList and adds them to the personalized gift list for the gift recipient if
	 * the recipient meets the gift's age, price, and gender requirements. If the gift is added to the list, rateGift
	 * is also called to assign the gift a rating (0 - 10) that indicates how well this gift matches the recipient's interests.
	 * 
	 * @param giftRecipient the person receiving the gift
	 */
	private void addGifts(Person giftRecipient) {
		getAllGifts();
		personalizedGiftList = new ArrayList<Gift>();
		for (Gift gift: genericGiftList) {
			boolean add = true;
			if (giftRecipient.getMaxPrice() < gift.getPrice()) add = false;
			else if (giftRecipient.getAge() < gift.getMinAge() || giftRecipient.getAge() > gift.getMaxAge()) add = false;
			else if (gift.isGendered()) {
				if (gift.getGender() != giftRecipient.getGender()) add = false;
			}
			// If gift meets price, age, and gender criteria, gift is added to personalized gift list and a gift rating (0 - 10)
			// is assigned to the gift based on giftRecipient's interests
			if (add) {
				personalizedGiftList.add(gift);
				gift.rateGift(giftRecipient);
			}
		}
	}

	/**
	 * Method that creates all possible gifts and adds them to genericGiftList.
	 * 
	 */
	private static void getAllGifts() {
		genericGiftList = new ArrayList<Gift>();
		genericGiftList.add(new Gift("Neon signs", 12, 30, 40, 'O', 
				new Interest("creativity")));
		genericGiftList.add(new Gift("Skincare set", 10, 60, 45, 'F', 
				new Interest("Beauty and perfume/cologne"), new Interest("clothing")));
		genericGiftList.add(new Gift("Digital instant camera", 8, 18, 120, 'O', 
				new Interest("creativity"), new Interest("technology")));
		genericGiftList.add(new Gift("Bluetooth keyboard", 18, 50, 35, 'O', 
				new Interest("technology"), new Interest("reading and writing")));
		genericGiftList.add(new Gift("Backpack", 8, 25, 50, 'O', 
				new Interest("travel"), new Interest("reading and writing")));
		genericGiftList.add(new Gift("Airpods by Apple", 10, 40, 200, 'O', 
				new Interest("Music/listening")));
		genericGiftList.add(new Gift("Beats headphones", 18, 40, 300, 'O', 
				new Interest("Music/listening")));
	}

}
