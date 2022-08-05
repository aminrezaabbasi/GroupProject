	package application;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.ChoiceBox;
	import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
	import javafx.scene.Node;

	/**
	 * This controller class changes the scene and helps the validation user's input. And It creates the person.
	 */
	public class GiftRecommenderController {
		private Person user;
		
		private Stage primaryStage;
		private Scene scene;

	    @FXML
	    private ChoiceBox<String> genderChoiceBox;

	    @FXML
	    private TextField maxPriceTextField;

	    @FXML
	    private TextField ageTextField;
	    
	    @FXML
	    private AnchorPane rootPane;
	    
	    @FXML
	    private Label ageGuide;
	    
	    @FXML
	    private Label priceGuide;
	    
	    
	    /**
	     * This method will changes the scene (from the fist window to the second window), and It will store the user's inputs.
	     * it helps the validation user's input by changing the guidelines to red in response to an incorrect input by user.
	     * Furthermore, it will create an object for Adult class and Child class. 
	     * @param event
	     * @throws IOException
	     */
	    @FXML
	    public void nextStep(ActionEvent event) throws IOException {
	    	
	    	ageGuide.setTextFill(Color.BLACK);
	    	priceGuide.setTextFill(Color.BLACK);
	    	NumericInput ageInput = new NumericInput(ageTextField.getText(), 1);
	    	NumericInput priceInput = new NumericInput(maxPriceTextField.getText(), 10, 2000);
	    	
	    	
	    	if (!ageInput.inputIsValid()) {
	    		ageGuide.setTextFill(Color.RED);
	    	}
	    	
	    	if(!priceInput.inputIsValid()) {
	    		priceGuide.setTextFill(Color.RED);
	    	}
	    	
	    	if (priceInput.inputIsValid() && ageInput.inputIsValid() ) {
	    	
	    		if (ageInput.getValue() < 12) { 
	    			user = new Child(ageInput.getValue(), priceInput.getValue(), genderChoiceBox.getValue());
	    		}
	    		else {
	    			user = new Adult(ageInput.getValue(), priceInput.getValue(), genderChoiceBox.getValue());
	    	    }

		    	FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/newscene2neww.fxml"));
				GiftRecommenderController2 controller = (GiftRecommenderController2)loader.getController();
				controller.setUser(user);
		    	primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		    	scene = new Scene(root);
		    	primaryStage.setScene(scene);
		    	primaryStage.show();
		   
		    	// I used this YouTube video for implementing
		    	// How can I use multiple FXML files for changing the scene.
		    	//https://www.youtube.com/watch?v=hcM-R-YOKkQ&t=319s
		    	
		    	// The teaching team (including instructor and TA) helped us to figured out how we can
		    	// change the scene and have multiple fxml files and multiple constructors classes..
	       }
	    }
	    
	 }