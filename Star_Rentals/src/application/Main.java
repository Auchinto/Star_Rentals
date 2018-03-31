package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.*;
 
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("SR_FX.fxml"));
			Scene scene_home = new Scene(root);
			scene_home.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene_home);
			primaryStage.setTitle("Star Rentals");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/application/Star_Rental_Logo_v2.png")));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
