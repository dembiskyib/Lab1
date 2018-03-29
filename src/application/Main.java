package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	 @Override
	    public void start(Stage primaryStage) throws Exception{
	        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
	        primaryStage.setTitle("Lab1");
	        primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
	        primaryStage.show();
	    }
	 
	    public static void main(String[] args) {
	        launch(args);
	    }
}
