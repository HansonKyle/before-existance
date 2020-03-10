package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameGUI extends Application{
	
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// Start with first scene by default
		stage.setScene(scene);	
		stage.show();

	}
	
	// Launches the GUI-based version of the program
	public static void main(String[] args) {
		launch(args);
	}
}
