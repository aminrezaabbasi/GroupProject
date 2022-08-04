	package application;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.ChoiceBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.VBox;
	import javafx.stage.Stage;
	import javafx.scene.Node;

	public class GiftRecommenderController {
		
		//Stage applicationStage;
		
		private Stage primaryStage;
		private Scene scene;
		private Parent root;
		private Parent root2;

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
	    	
	    	Parent root = FXMLLoader.load(getClass().getResource("newscene2neww.fxml"));
	    	primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	scene = new Scene(root);
	    	primaryStage.setScene(scene);
	    	primaryStage.show();
	    	
	     }
	    	// I used this YouTube video for implementing
	    	// How can I use 2 FXML file for changing the scene.
	    	//https://www.youtube.com/watch?v=hcM-R-YOKkQ&t=319s
	    
	    @FXML 
	    public void nextStep2(ActionEvent event2) throws IOException {
	    	
	    	
	    	Parent root2 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
	    	primaryStage = (Stage)((Node)event2.getSource()).getScene().getWindow();
	    	scene = new Scene(root2);
	    	primaryStage.setScene(scene);
	    	primaryStage.show();
	    	
	     
	    	
	    	
	    }
	    
	 }