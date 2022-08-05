package application;
	
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

/**
 * The main class will generate the first scene and it allows user to provide inputs.
 * That would be used for generating a gift.
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		FXMLLoader loader = new FXMLLoader();
		Parent root = loader.load(new FileInputStream("src/application/newscene1.fxml"));
		GiftRecommenderController controller = (GiftRecommenderController)loader.getController();
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("Gift Recommender");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}