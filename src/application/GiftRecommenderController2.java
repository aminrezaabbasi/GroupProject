package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class GiftRecommenderController2 {
	private Person user;
	private Stage primaryStage;
	private Scene scene;
	
	@FXML
    private Label interest1;
    
    @FXML
    private Label interest2;
    
    @FXML
    private Label interest3;
    
    @FXML
    private Label interest4;
    
    @FXML
    private Label interest5;
    
    @FXML
    private Label interest6;
    
    @FXML
    private Label interest7;
    
    @FXML
    private Label interest8;
    
    @FXML
    private Label interest9;
    
    @FXML
    private Label interest10;
    
    @FXML
    private Slider interestValue1;
    
    @FXML
    private Slider interestValue2;
    
    @FXML
    private Slider interestValue3;
    
    @FXML
    private Slider interestValue4;
    
    @FXML
    private Slider interestValue5;
    
    @FXML
    private Slider interestValue6;
    
    @FXML
    private Slider interestValue7;
    
    @FXML
    private Slider interestValue8;
    
    @FXML
    private Slider interestValue9;
    
    @FXML
    private Slider interestValue10;
    
    
    public void setUser(Person person) {
    	user = person;
    	interest1.setText(user.getInterests().get(0).getName());
    }
    
    
    @FXML 
    public void nextStep2(ActionEvent event2) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
		Parent root = loader.load(new FileInputStream("src/application/scene3.fxml"));
		GiftRecommenderController3 controller = (GiftRecommenderController3)loader.getController();
		controller.setUser(user);
    	primaryStage = (Stage)((Node)event2.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	primaryStage.setScene(scene);
    	primaryStage.show();
    	

    	
    	//interests.get(0).setRating(interestValue1.getValue());
    	
    	//interestValue1.getValue();
    	//Parent root2 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
    	//primaryStage = (Stage)((Node)event2.getSource()).getScene().getWindow();
    	//scene = new Scene(root2);
    	//primaryStage.setScene(scene);
    	//primaryStage.show();
   	}
}
