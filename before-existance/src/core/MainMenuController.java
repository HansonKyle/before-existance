package core;

import java.io.IOException;

import entity.Player;
import event.story.Story;
import item.Weapon;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController {

	private Game game = new Game();
	private Weapon defaultWeapon = new Weapon("Hands", 10);
	private Player player = new Player("Default", 100, defaultWeapon);
	private int maxEvents = 5;
	private Story story = new Story(game, maxEvents);
	private int eventIndex = 0;

	@FXML
	private Button startButton;

	@FXML
	private Button quitButton;

	@FXML
	private Button choiceOneButton;

	@FXML
	private Label choiceTwoLabel;

	@FXML
	private Button choiceThreeButton;

	@FXML
	private Label currentWeaponLabel;

	@FXML
	private Label roomCountLabel;

	@FXML
	private Label choiceOneLabel;

	@FXML
	private Label playerHealthLabel;

	@FXML
	private Button choiceTwoButton;

	@FXML
	private Label playerNameLabel;

	@FXML
	private Label eventDescriptionLabel;

	@FXML
	private Label choiceThreeLabel;

	@FXML
	private TextField nameTextBox;

	@FXML
	private Button loadEventButton;

	@FXML
	private GridPane statsGridPane;

	@FXML
	private Label nameErrorLabel;

	@FXML
	private Label eventResultLabel;

	@FXML
	private ImageView youDiedImage;

	@FXML
	private Button deadButton;

	@FXML
	void startButtonClicked(ActionEvent event) throws IOException {
		// Changes scene from MainMenu to EventScene
		Parent eventSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("core/EventScene.fxml"));
		Scene eventScene = new Scene(eventSceneParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(eventScene);
		window.show();
	}

	@FXML
	void quitButtonClicked(ActionEvent event) {
		Stage stage = (Stage) quitButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	void nameTextBoxEdit(ActionEvent event) {
		player.setName(nameTextBox.getText().toUpperCase());
	}

	void updatePlayerStats() { // Updates the player statistics grid box with current values
		playerNameLabel.setText(" " + player.getName());
		playerHealthLabel.setText(" " + String.valueOf(player.getHealth()));
		currentWeaponLabel.setText(" " + player.getCurrentWeapon().getName() + " ("
				+ String.valueOf(player.getCurrentWeapon().getDamage()) + ")");
		roomCountLabel.setText(" " + String.valueOf(player.getDungeonsSurvived()));
	}

	void displayNextEvent(ActionEvent event) throws IOException {
		if (eventIndex < story.length()) {
			System.out.println(story.getEvent(eventIndex).getDescription());
			eventDescriptionLabel.setText(story.getEvent(eventIndex).getDescription());
			updateChoiceText(choiceOneButton, choiceOneLabel, '1');
			updateChoiceText(choiceTwoButton, choiceTwoLabel, '2');
			updateChoiceText(choiceThreeButton, choiceThreeLabel, '3');
		} else {
			// to-be transition to the boss Room
			story = new Story(game, 5);
			eventIndex = 0;
			displayNextEvent(event);
		}
	}

	private void updateChoiceText(Button choiceButton, Label choiceLabel, char i) {
		if (story.getEvent(eventIndex) == null || story.getEvent(eventIndex).getChoice(i) == null || story.getEvent(eventIndex).getChoice(i).getDescription() == null) {
			choiceLabel.setVisible(false);
			choiceButton.setVisible(false);
		} else {
			choiceButton.setVisible(true);
			choiceLabel.setVisible(true);
			choiceLabel.setText(story.getEvent(eventIndex).getChoice(i).getDescription());
		}
	}

	@FXML
	void quitToMainMenu(ActionEvent event) throws IOException {
		Parent eventSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("core/MainMenu.fxml"));
		Scene eventScene = new Scene(eventSceneParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(eventScene);
		window.show();
	}

	@FXML
	void loadEvent(ActionEvent event) throws IOException { // Loads next event on button clock
		if (player.getName().contentEquals("Default")) {
			nameErrorLabel.setVisible(true);
		} else {
			if (nameErrorLabel.isVisible() == true) {
				nameErrorLabel.setVisible(false);
			}
			loadEventButton.setText("Load next event");
			loadEventButton.setVisible(false);
			nameTextBox.setVisible(false);
			statsGridPane.setVisible(true);
			playerNameLabel.setVisible(true);
			playerHealthLabel.setVisible(true);
			currentWeaponLabel.setVisible(true);
			roomCountLabel.setVisible(true);
			updatePlayerStats();
			eventDescriptionLabel.setVisible(true);
			eventResultLabel.setVisible(false);
			if (player.isAlive() == false) {
				FadeTransition fade = new FadeTransition();
				fade.setDuration(Duration.millis(5000));
				fade.setFromValue(0);
				fade.setToValue(1);
				fade.setCycleCount(1);
				fade.setNode(youDiedImage);
				fade.play();
				youDiedImage.setVisible(true);
				deadButton.setVisible(true);
				eventDescriptionLabel.setVisible(false);
			} else {
				displayNextEvent(event);
			}
		}
	}

	public void reset() {
		updatePlayerStats();
		System.out.println(player.getHealth());
		loadEventButton.setVisible(true);
		choiceOneLabel.setVisible(false);
		choiceTwoLabel.setVisible(false);
		choiceThreeLabel.setVisible(false);
		choiceOneButton.setVisible(false);
		choiceTwoButton.setVisible(false);
		choiceThreeButton.setVisible(false);
		eventIndex++;
	}

	@FXML
	void ChoiceOneButtonClick(ActionEvent event) {
		story.getEvent(eventIndex).getChoice('1').activate();
		player.removeHealth(story.getEvent(eventIndex).getHealthLost());
		eventResultLabel.setText(story.getEvent(eventIndex).getChoiceResult());
		eventResultLabel.setVisible(true);
		reset();
	}

	@FXML
	void ChoiceTwoButtonClick(ActionEvent event) {
		story.getEvent(eventIndex).getChoice('2').activate();
		player.removeHealth(story.getEvent(eventIndex).getHealthLost());
		eventResultLabel.setText(story.getEvent(eventIndex).getChoiceResult());
		eventResultLabel.setVisible(true);
		reset();
	}

	@FXML
	void ChoiceThreeButtonClick(ActionEvent event) {
		story.getEvent(eventIndex).getChoice('3').activate();
		player.removeHealth(story.getEvent(eventIndex).getHealthLost());
		eventResultLabel.setText(story.getEvent(eventIndex).getChoiceResult());
		eventResultLabel.setVisible(true);
		reset();
	}
}
