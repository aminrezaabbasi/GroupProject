package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * GiftRecommenderController3 controls the display of the gift to the user on the third scene of the interface. It allows
 * users to view a gift selected for them based on input provided in the first two scenes and to select a new gift.
 *
 */
public class GiftRecommenderController3 {
	private ArrayList<Gift> personalizedGiftList;
	private int index = 0;
	
	@FXML
	private Label giftLabel;
	
	
	/**
	 * Generates a personalized gift list for user, which includes only gifts that match the user's age, max price,
	 * and gender. Gifts in the list are sorted in descending order by how well they match the individual's interests.
	 * The gift at index (which is initialized to 0) is shown to the user in the window, displaying the gift that
	 * best matches the user's interests.
	 * 
	 * @param user
	 */
	public void getGift(Person user) {
		GiftList gifts = new GiftList();
		personalizedGiftList = gifts.getSortedGiftList(user);
		giftLabel.setText(personalizedGiftList.get(index).toString());
	}
	
	
	/**
	 * Displays the next best gift in the list of possible gifts for the user. If user has gone through all possible gifts,
	 * the list starts over, displaying the gift at the first index.
	 * 
	 * @param event clicking the "next gift" button
	 */
	@FXML
	public void getNewGift(ActionEvent event) {
		if (index < personalizedGiftList.size() - 1)
			index++;
		// If user has reached gift at last index, next gift button will reset display to show first gift
		else
			index = 0;
		giftLabel.setText(personalizedGiftList.get(index).toString());
	}
}
