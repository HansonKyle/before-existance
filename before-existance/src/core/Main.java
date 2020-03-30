package core;
	
import java.io.FileInputStream; 

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	/**
	 * Launches the application and displays the menu scene to the screen
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) new FXMLLoader().load(new FileInputStream("src/core/MainMenu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}