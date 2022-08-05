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
	import javafx.stage.Stage;
	import javafx.scene.Node;

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
	    public void nextStep(ActionEvent event) throws IOException {
	    	
	    	String genderInput = genderChoiceBox.getValue();
	    	System.out.println(genderInput) ;
	    	
	    	String ageInput = ageTextField.getText();
	    	System.out.println(ageInput);
	    	
	    	String maxPriceInput = maxPriceTextField.getText();
	    	System.out.println(maxPriceInput);
	    	
	    	int age = Integer.parseInt(ageTextField.getText());
	    	
	    	if (age < 12)
	    		user = new Child(age, Integer.parseInt(maxPriceTextField.getText()), genderChoiceBox.getValue());
	    	else
	    		user = new Adult(age, Integer.parseInt(maxPriceTextField.getText()), genderChoiceBox.getValue());
	    	

	    	FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(new FileInputStream("src/application/newscene2neww.fxml"));
			GiftRecommenderController2 controller = (GiftRecommenderController2)loader.getController();
			controller.setUser(user);
	    	primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	scene = new Scene(root);
	    	primaryStage.setScene(scene);
	    	primaryStage.show();
	     
	    	// I used this YouTube video for implementing
	    	// How can I use 2 FXML file for changing the scene.
	    	//https://www.youtube.com/watch?v=hcM-R-YOKkQ&t=319s
	    }
	    
	 }