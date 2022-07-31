package application;
	
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("GroupProjectFxml.fxml"));
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("Gift Recommender");
		primaryStage.setScene(scene);
		primaryStage.show();
		//try {
			//FXMLLoader loader = new FXMLLoader();
			//VBox root = loader.load(new FileInputStream("src/application/GroupProjectFxml.fxml"));
			
		
		
//			FXMLLoader loader2 = new FXMLLoader();
//			VBox root2 = loader2.load(new FileInputStream("src/application/secondPage.fxml"));
			
			//GiftRecommenderController controller = (GiftRecommenderController)loader.getController();
			//SecondPageController controller2 = (SecondPageController)loader.getController();
			//controller2.applicationStage = primaryStage;
			//controller.applicationStage = primaryStage;
		
			//Scene scene = new Scene(root,400,400);
			//primaryStage.setScene(scene);
			//primaryStage.setTitle("Gift Recommender");
			//primaryStage.show();
			
//			Scene scene2 = new Scene(root2, 400, 400);
//			primaryStage.setScene(scene2);
//			primaryStage.setTitle("Gift Recommender");
//			primaryStage.show();
			
		//} catch(Exception e) {
			//e.printStackTrace();
		//}
	//}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
