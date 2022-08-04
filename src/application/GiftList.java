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
			// If gift recipient gender set to other/ not disclosed, application will show gifts targeted at any gender
			else if (gift.isGendered() && giftRecipient.getGender() != 'O') {
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
		genericGiftList.add(new Gift("Sunglasses", 18, 70, 100, 'O', 
				new Interest("Clothing")));
		genericGiftList.add(new Gift("Hoodie", 12, 30, 60, 'O', 
				new Interest("Music/listening")));
		genericGiftList.add(new Gift("Necklace", 10, 60, 60, 'F', 
				new Interest("Clothing"), new Interest("Beauty and perfume/cologne")));
		genericGiftList.add(new Gift("Good Girl by Carolina Herrera", 18, 40, 150, 'F', 
				new Interest("Beauty and perfume/cologne")));
		genericGiftList.add(new Gift("Wireless Bluetooth Karaoke Microphone", 8, 18, 25, 'O', 
				new Interest("Music/listening")));
		genericGiftList.add(new Gift("AirForce 1 by Nike", 18, 35, 110, 'M', 
				new Interest("Sports"), new Interest("Clothing")));
		genericGiftList.add(new Gift("Board Game", 7, 30, 45, 'O', 
				new Interest("Games and movies")));
		genericGiftList.add(new Gift("Painting 3D Pen", 6, 40, 60, 'O', 
				new Interest("Creativity"), new Interest("Art")));
		genericGiftList.add(new Gift("Domino's Pizza Gift Card", 18, 1000, 50, 'O', 
				new Interest("Food/cooking")));
		genericGiftList.add(new Gift("Ski Helmet", 18, 60, 45, 'O', 
				new Interest("Sports"), new Interest("Clothing")));
		genericGiftList.add(new Gift("Converse Shoes", 12, 25, 100, 'O', 
				new Interest("Sports"), new Interest("Clothing")));
		genericGiftList.add(new Gift("Vans Clothing", 12, 40, 90, 'O', 
				new Interest("Clothing"), new Interest("Sports")));
		genericGiftList.add(new Gift("Stuffed Animal", 0, 12, 25, 'O', 
				new Interest("Dolls"), new Interest("Animals")));
		genericGiftList.add(new Gift("Personalized Name Puzzle", 0, 6, 10, 'O', 
				new Interest("Creativity"), new Interest("Art")));
		genericGiftList.add(new Gift("Wooden Building Blocks Set", 0, 5, 35, 'O', 
				new Interest("Building"), new Interest("Creativity")));
		genericGiftList.add(new Gift("Dior Sauvage Cologne Set for Men", 18, 100, 41, 'M', 
				new Interest("Beauty and perfume/cologne")));
		genericGiftList.add(new Gift("Luna Rosa Cologne Gift Set", 18, 100, 100, 'M', 
				new Interest("Beauty and perfume/cologne")));
		genericGiftList.add(new Gift("100 Piece Animal Puzzle", 6, 7, 10, 'O', 
				new Interest("Puzzles"), new Interest("Animals")));
		genericGiftList.add(new Gift("100 Piece Dinosaur Puzzle", 6, 7, 10, 'O', 
				new Interest("Puzzles"), new Interest("Dinosaurs")));
		genericGiftList.add(new Gift("300 Piece Puzzle", 8, 11, 20, 'O', 
				new Interest("Puzzles")));
		genericGiftList.add(new Gift("500 Piece Puzzle Set", 12, 100, 25, 'O', 
				new Interest("Games and movies")));
		genericGiftList.add(new Gift("Barbie Dollhouse", 4, 10, 70, 'F', 
				new Interest("Dolls"), new Interest("Building"), new Interest("Creativity")));
		genericGiftList.add(new Gift("Lego Build It Mighty Dinosaur", 7, 12, 18, 'O', 
				new Interest("Lego"), new Interest("Dinosaurs")));
		genericGiftList.add(new Gift("Lego Friendship Tree House", 8, 13, 100, 'O', 
				new Interest("Lego"), new Interest("Building")));
		genericGiftList.add(new Gift("Lego Farm and Barn Animals Care", 3, 9, 80, 'O', 
				new Interest("Lego"), new Interest("Building"), new Interest("Animals")));
		genericGiftList.add(new Gift("Lego Pet Adoption Cafe", 3, 8, 40, 'O', 
				new Interest("Lego"), new Interest("Building"), new Interest("Animals")));
		genericGiftList.add(new Gift("Multicoloured Play-Doh Starter Set", 3, 10, 8, 'O', 
				new Interest("Creativity"), new Interest("Art")));
		genericGiftList.add(new Gift("iPhone 13/ 13 Pro by Apple", 12, 80, 1500, 'O', 
				new Interest("Technology")));
		genericGiftList.add(new Gift("How-To-Cook Guide Book", 12, 100, 40, 'O', 
				new Interest("Food/cooking"), new Interest("Reading and writing")));
		genericGiftList.add(new Gift("World map", 18, 100, 60, 'O', 
				new Interest("Creativity"), new Interest("Travel")));
		genericGiftList.add(new Gift("Basketball", 12, 50, 50, 'O', 
				new Interest("Sports"), new Interest("Games and movies")));
		genericGiftList.add(new Gift("Rolex Watch", 18, 1000, 2000, 'O', 
				new Interest("Clothing")));
		genericGiftList.add(new Gift("Apple Watch by Apple", 18, 100, 500, 'O', 
				new Interest("Clothing"), new Interest("Sports"), new Interest("Music/listening")));
		genericGiftList.add(new Gift("Novel", 8, 100, 40, 'O', 
				new Interest("Reading and writing"), new Interest("Creativity")));
		genericGiftList.add(new Gift("8 Ball Pool Table", 18, 100, 1000, 'O', 
				new Interest("Sports"), new Interest("Games and movies")));
		genericGiftList.add(new Gift("Surface by Microsoft", 18, 100, 1800, 'O', 
				new Interest("Technology"), new Interest("Creativity")));
		genericGiftList.add(new Gift("Mini HD Projector", 16, 100, 150, 'O', 
				new Interest("Technology"), new Interest("Games and movies"), new Interest("Sports")));
		genericGiftList.add(new Gift("Printer", 32, 100, 200, 'O', 
				new Interest("Technology"), new Interest("Creativity"), new Interest("Reading and writing")));
		genericGiftList.add(new Gift("Favorite Musical Instrument", 8, 100, 400, 'O', 
				new Interest("Creativity"), new Interest("Music/listening")));
		genericGiftList.add(new Gift("Luggage Set", 18, 100, 400, 'O', 
				new Interest("Travel")));
		genericGiftList.add(new Gift("Digital Scale", 30, 100, 25, 'O', 
				new Interest("Technology"), new Interest("Sports")));
		genericGiftList.add(new Gift("Play Station 5", 12, 70, 750, 'O', 
				new Interest("Technology"), new Interest("Games and movies")));
		genericGiftList.add(new Gift("Remote Control Truck", 4, 12, 60, 'O', 
				new Interest("Trucks")));
		genericGiftList.add(new Gift("Stuffed Animal Crafting Kit", 7, 14, 25, 'O', 
				new Interest("Animals"), new Interest("Building")));
		genericGiftList.add(new Gift("Cineplex Movie Tickets", 13, 100, 20, 'O', 
				new Interest("Games and movies")));
		genericGiftList.add(new Gift("Fitbit Tracker", 18, 60, 80, 'O', 
				new Interest("Clothing"), new Interest("Sports")));
		genericGiftList.add(new Gift("iTunes Gift Card", 13, 100, 10, 'O', 
				new Interest("Music/listening"), new Interest("Creativity"), new Interest("Technology")));
		genericGiftList.add(new Gift("Hot Wheels 10 Car Pack", 4, 11, 13, 'O', 
				new Interest("Trucks")));
	}

}
