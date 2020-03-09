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

public class MainMenuController {
	@FXML
	private Button playButton;
	
	@FXML
	private Button howToPlayButton;
	
	@FXML
	private Button quitButton;

	//This method will quit the program when called
	@FXML
	public void quitButtonClicked(ActionEvent event){
		System.out.println("Quitting Game Now...");
		System.exit(0);

	}
	
	//This method will change the scene to the How To Play scene when called
	@FXML
	public void howToPlayButtonPressed(ActionEvent event) throws IOException {
		Parent howToPlayParent = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));
		Scene howToPlayScene = new Scene(howToPlayParent);
		
		//This line gets stage info
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(howToPlayScene);
		window.show();
	}


}
