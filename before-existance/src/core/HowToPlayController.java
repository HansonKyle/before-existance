package core;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
 * Handles user interaction with the buttons in the how to play scene
 */
public class HowToPlayController {

	@FXML
	private Button quitToMenuButton;
	
	/**
	 * Switches screen to the main menu
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void quitToMenuButtonClicked(ActionEvent event) throws IOException {
		Scene eventScene = new Scene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		eventScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(eventScene);
	}
}