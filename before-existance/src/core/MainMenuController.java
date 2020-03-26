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
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController {
	
	private static final int MAX_EVENTS = 5;

	private Game game = new Game();
	private Weapon defaultWeapon = new Weapon("Hands", 10);
	private Player player = new Player("Default", 100, defaultWeapon);
	private Story story = new Story(game, MAX_EVENTS);
	private int eventIndex = 0;
	private char eventChoice = 0;

	@FXML
	private Button playButton;
	
	@FXML
	private Button quitButton;
	
	@FXML
	private RadioButton choice1Button;
	
	@FXML
	private RadioButton choice2Button;
	
	@FXML
	private RadioButton choice3Button;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private SplitPane statsPane;

	@FXML
	private Label currentWeaponLabel;

	@FXML
	private Label roomCountLabel;

	@FXML
	private Label playerHealthLabel;

	@FXML
	private Label playerNameLabel;

	@FXML
	private Label eventDescriptionLabel;

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
		 * https://stackoverflow.com/questions/33646317/typing-animation-on-a-text-with-javafx/
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
		destination.setText("");
		timeline.getKeyFrames().add(keyFrame);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	void displayNextEvent(ActionEvent event) throws IOException {
		// Displays available choice text with corresponding buttons
		if (eventIndex < story.length()) {
			animateText(story.getEvent(eventIndex).getDescription(), eventDescriptionLabel);
			updateChoiceText(choice1Button, '1');
			updateChoiceText(choice2Button, '2');
			updateChoiceText(choice3Button, '3');
		} else {
			// to-be transition to the boss Room
			story = new Story(game, 5);
			eventIndex = 0;
			displayNextEvent(event);
		}
	}

	private void updateChoiceText(RadioButton choiceButton, char i) {
		// Checks for available choice text and corresponding buttons
		if (story.getEvent(eventIndex) == null || story.getEvent(eventIndex).getChoice(i) == null
				|| story.getEvent(eventIndex).getChoice(i).getDescription() == null) {
			choiceButton.setVisible(false);
		} else {
			choiceButton.setVisible(true);
			choiceButton.setText(story.getEvent(eventIndex).getChoice(i).getDescription());
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
		if (player.getName().equals("Default")) {
			nameErrorLabel.setVisible(true);
		} else {
			if (nameErrorLabel.isVisible() == true) {
				nameErrorLabel.setVisible(false);
				if(player.getName().equals("FORTNITE")) {
					playSprite();
				}
			}
			loadEventButton.setText("Load next event");
			loadEventButton.setVisible(false);
			statsPane.setVisible(true);
			nameTextBox.setVisible(false);
			statsGridPane.setVisible(true);
			playerNameLabel.setVisible(true);
			playerHealthLabel.setVisible(true);
			currentWeaponLabel.setVisible(true);
			roomCountLabel.setVisible(true);
			submitButton.setVisible(true);
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
				submitButton.setVisible(false);
				eventDescriptionLabel.setVisible(false);
			} else {
				player.dungeonSurvived();
				displayNextEvent(event);
			}
		}
	}

	public void reset() {
		// Switches button visibility to loadEventButton only
		updatePlayerStats();
		loadEventButton.setVisible(true);
		choice1Button.setSelected(false);
		choice2Button.setSelected(false);
		choice3Button.setSelected(false);
		choice1Button.setVisible(false);
		choice2Button.setVisible(false);
		choice3Button.setVisible(false);
		submitButton.setVisible(false);
		eventIndex++;
		eventChoice = 0;
	}

	public void choiceActivation(char num) {
		story.getEvent(eventIndex).getChoice(num).activate();
		player.removeHealth(story.getEvent(eventIndex).getHealthLost());
		animateText((story.getEvent(eventIndex).getChoiceResult()), eventResultLabel);
		eventResultLabel.setVisible(true);
		reset();
	}
	
	@FXML
	void choice1ButtonClicked(ActionEvent event) {
		if (choice1Button.isSelected()) {
			eventChoice = '1';
			choice2Button.setSelected(false);
			choice3Button.setSelected(false);
		} else {
			eventChoice = 0;
		}
	}
	
	@FXML
	void choice2ButtonClicked(ActionEvent event) {
		if (choice2Button.isSelected()) {
			eventChoice = '2';
			choice1Button.setSelected(false);
			choice3Button.setSelected(false);
		} else {
			eventChoice = 0;
		}
	}
	
	@FXML
	void choice3ButtonClicked(ActionEvent event) {
		if (choice3Button.isSelected()) {
			eventChoice = '3';
			choice1Button.setSelected(false);
			choice2Button.setSelected(false);
		} else {
			eventChoice = 0;
		}
	}
	
	@FXML
	void submitButtonClicked(ActionEvent event) {
		if (eventChoice == '1' || eventChoice == '2' || eventChoice == '3') {
			choiceActivation(eventChoice);
		}
	}
	
	public void playSprite() {
		int xOffset = 8;
		int yOffset = 0;
		int xSize = 38;
		int ySize = 45;
		logoImageView.setVisible(true);
		logoImageView.setViewport(new Rectangle2D(xOffset, yOffset, xSize, ySize));
		
		//Animation anim = new SpriteAnimation(logoImageView, Duration.millis(4000), 36, 6, xOffset, yOffset, xSize, ySize);
		//anim.setCycleCount(Animation.INDEFINITE);
		//anim.play();
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
