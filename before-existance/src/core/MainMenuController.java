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
 * Handles user interaction with the buttons in the menu scene
 */
public class MainMenuController {

	@FXML
	private Button playButton;
	
	@FXML
	private Button quitButton;

	/**
	 * Change scene to view the event screen
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void startButtonClicked(ActionEvent event) throws IOException {
		Scene eventScene = new Scene(FXMLLoader.load(getClass().getResource("EventScene.fxml")));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		eventScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(eventScene);
	}
	
	/**
	 * Change scene to view the game instructions
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void howToPlayButtonPressed(ActionEvent event) throws IOException {
		Scene howToPlayScene = new Scene(FXMLLoader.load(getClass().getResource("HowToPlay.fxml")));
		Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		
		howToPlayScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(howToPlayScene);
	}
	
	/**
	 * Quits the game by closing the application stage
	 * 
	 * @param event
	 */
	@FXML
	void quitButtonClicked(ActionEvent event) {
		Stage stage = (Stage) quitButton.getScene().getWindow();
		
		stage.close();
	}
}
