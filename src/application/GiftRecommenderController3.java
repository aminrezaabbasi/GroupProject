package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GiftRecommenderController3 {
	private ArrayList<Gift> personalizedGiftList;
	int index = 0;
	
	@FXML
	private Label giftLabel;
	

	public void getGift(Person user) {
		GiftList gifts = new GiftList();
		personalizedGiftList = gifts.getSortedGiftList(user);
		giftLabel.setText(personalizedGiftList.get(index).toString());
		
	}
	
	
	@FXML
	public void getNewGift(ActionEvent event) {
		if (index < personalizedGiftList.size() - 1)
			index++;
		else
			index = 0;
		giftLabel.setText(personalizedGiftList.get(index).toString());
	}
}
