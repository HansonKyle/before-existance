package core;

import java.io.IOException;

import entity.Player;
import event.story.Story;
import item.Weapon;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
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
	private Button playButton;
	
	@FXML
	private Button howToPlayButton;
	
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
	private ImageView logoImageView;

	@FXML
	void startButtonClicked(ActionEvent event) throws IOException {
		// Changes scene from MainMenu to EventScene
		Parent eventSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("core/EventScene.fxml"));
		Scene eventScene = new Scene(eventSceneParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		//eventScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(eventScene);
		window.show();
	}

	@FXML
	void quitButtonClicked(ActionEvent event) {
		// Quits game by closing window
		Stage stage = (Stage) quitButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	void nameTextBoxEdit(ActionEvent event) {
		// Updates player name by text entered in text box
		player.setName(nameTextBox.getText().toUpperCase());
	}

	void updatePlayerStats() {
		// Updates the player statistics grid box with current values
		playerNameLabel.setText(" " + player.getName());
		playerHealthLabel.setText(" " + String.valueOf(player.getHealth()));
		currentWeaponLabel.setText(" " + player.getCurrentWeapon().getName() + " ("
				+ String.valueOf(player.getCurrentWeapon().getDamage()) + ")");
		roomCountLabel.setText(" " + String.valueOf(player.getDungeonsSurvived()));
	}

	public void animateText(String textToAnimate, Label destination) {
		/*
		 * Animation adapted from
		 * https://stackoverflow.com/questions/33646317/typing-animation-on-a-text-with-
		 * javafx
		 */
		final IntegerProperty i = new SimpleIntegerProperty(0);
		Timeline timeline = new Timeline();
		KeyFrame keyFrame = new KeyFrame(Duration.millis(10), EventHandler -> {
			if (i.get() > textToAnimate.length()) {
				timeline.stop();
			} else {
				destination.setText(textToAnimate.substring(0, i.get()));
				i.set(i.get() + 1);
			}
		});
		timeline.getKeyFrames().add(keyFrame);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	void displayNextEvent(ActionEvent event) throws IOException {
		// Displays available choice text with corresponding buttons
		if (eventIndex < story.length()) {
			animateText(story.getEvent(eventIndex).getDescription(), eventDescriptionLabel);
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
		// Checks for available choice text and corresponding buttons
		if (story.getEvent(eventIndex) == null || story.getEvent(eventIndex).getChoice(i) == null
				|| story.getEvent(eventIndex).getChoice(i).getDescription() == null) {
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
		// Switches screen to main menu after death
		Parent eventSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("core/MainMenu.fxml"));
		Scene eventScene = new Scene(eventSceneParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		eventScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(eventScene);
		window.show();
	}

	@FXML
	void loadEvent(ActionEvent event) throws IOException {
		// Loads next event on button clock
		if (player.getName().contentEquals("Default")) {
			nameErrorLabel.setVisible(true);
		} else {
			if (nameErrorLabel.isVisible() == true) {
				nameErrorLabel.setVisible(false);
				if(player.getName().contentEquals("FORTNITE")) {
					playSprite();
				}
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
		// Switches button visibility to loadEventButton only
		updatePlayerStats();
		loadEventButton.setVisible(true);
		choiceOneLabel.setVisible(false);
		choiceTwoLabel.setVisible(false);
		choiceThreeLabel.setVisible(false);
		choiceOneButton.setVisible(false);
		choiceTwoButton.setVisible(false);
		choiceThreeButton.setVisible(false);
		eventIndex++;
	}

	public void choiceActivation(char num) {
		story.getEvent(eventIndex).getChoice(num).activate();
		player.removeHealth(story.getEvent(eventIndex).getHealthLost());
		animateText((story.getEvent(eventIndex).getChoiceResult()), eventResultLabel);
		eventResultLabel.setVisible(true);
		reset();
	}

	@FXML
	void ChoiceOneButtonClick(ActionEvent event) {
		// Activates choice one
		choiceActivation('1');
	}

	@FXML
	void ChoiceTwoButtonClick(ActionEvent event) {
		// Activates choice two
		choiceActivation('2');
	}

	@FXML
	void ChoiceThreeButtonClick(ActionEvent event) {
		// Activates choice three
		choiceActivation('3');
	}
	
	
	public void playSprite() {
		int xOffset = 8;
		int yOffset = 0;
		int xSize = 38;
		int ySize = 45;
		logoImageView.setVisible(true);
		logoImageView.setViewport(new Rectangle2D(xOffset, yOffset, xSize, ySize));
		
		Animation anim = new SpriteAnimation(logoImageView, Duration.millis(4000), 36, 6, xOffset, yOffset, xSize, ySize);
		anim.setCycleCount(Animation.INDEFINITE);
		anim.play();
	} 
	
	public void howToPlayButtonPressed(ActionEvent event) throws IOException {
		Parent howToPlayParent = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));
		Scene howToPlayScene = new Scene(howToPlayParent);
		//This line gets stage info
		Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		howToPlayScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(howToPlayScene);
		window.show();
	}
}
