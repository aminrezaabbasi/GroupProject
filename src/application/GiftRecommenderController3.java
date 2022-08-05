package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GiftRecommenderController3 {
	private Person user;
	
	@FXML
	private Label giftLabel;
	
	public void setUser(Person person) {
    	user = person;
    }
}
