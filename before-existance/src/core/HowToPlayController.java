package core;

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
	void quitToMainMenu(ActionEvent event) throws IOException {
		// Switches screen to main menu after death
		Parent eventSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("core/MainMenu.fxml"));
		Scene eventScene = new Scene(eventSceneParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		eventScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(eventScene);
		window.show();
	}
}