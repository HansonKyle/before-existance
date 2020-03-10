package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HowToPlayController {

	@FXML
	private Button returnToMainButton;

	@FXML
	//This method will change the scene to the How To Play scene when called
	public void howToPlayButtonPressed (ActionEvent event) throws IOException {	
		Parent howToPlayParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene howToPlayScene = new Scene(howToPlayParent);
		
		//This line gets stage info
		Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
		howToPlayScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		window.setScene(howToPlayScene);
		window.show();	
		}
	
}
