package application;

import java.util.ArrayList;

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
	
}
