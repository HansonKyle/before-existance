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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * Handles user interaction with the GUI in the event scene
 */
public class EventController {
	
	private static final int MAX_EVENTS = 5;

	private Game game = new Game();
	private Weapon defaultWeapon = new Weapon("Hands", 10);
	private Player player = new Player("Default", 100, defaultWeapon);
	private Story story = new Story(game, MAX_EVENTS);
	private int eventIndex = 0;
	private char eventChoice = 0;
	
	@FXML
	private RadioButton choice1Button;
	
	@FXML
	private RadioButton choice2Button;
	
	@FXML
	private RadioButton choice3Button;
	
	@FXML
	private Button selectChoiceButton;
	
	@FXML
	private Button loadEventButton;
	
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
	
	/**
	 * Updates player name to text entered in the text box
	 * 
	 * @param event
	 */
	@FXML
	void nameTextBoxEdit(ActionEvent event) {
		player.setName(nameTextBox.getText().toUpperCase());
	}

	/**
	 * Switches screen to the main menu
	 * Button becomes visible after player dies
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void quitToMainMenu(ActionEvent event) throws IOException {
		Parent eventSceneParent = FXMLLoader.load(getClass().getClassLoader().getResource("core/MainMenu.fxml"));
		Scene eventScene = new Scene(eventSceneParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		eventScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(eventScene);
		window.show();
	}
	
	/**
	 * Updates the player statistics grid box with the current values
	 */
	void updatePlayerStats() {
		playerNameLabel.setText(" " + player.getName());
		playerHealthLabel.setText(" " + String.valueOf(player.getHealth()));
		currentWeaponLabel.setText(" " + player.getCurrentWeapon().getName() + " ("
				+ String.valueOf(player.getCurrentWeapon().getDamage()) + ")");
		roomCountLabel.setText(" " + String.valueOf(player.getDungeonsSurvived()));
	}
	
	/**
	 * Displays the text for each choice of the current event being displayed
	 * 
	 * @param event
	 * @throws IOException
	 */
	void displayNextEvent(ActionEvent event) throws IOException {
		if (eventIndex < story.length()) {
			animateText(story.getEvent(eventIndex).getDescription(), eventDescriptionLabel);
			updateChoiceText(choice1Button, '1');
			updateChoiceText(choice2Button, '2');
			updateChoiceText(choice3Button, '3');
		} else {
			// TODO: Transition to the boss room
			story = new Story(game, 5);
			eventIndex = 0;
			displayNextEvent(event);
		}
	}
	
	/**
	 * Fades the death screen into view
	 */
	private void displayDeathScreen() {
		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(5000));
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.setCycleCount(1);
		fade.setNode(youDiedImage);
		fade.play();
		
		youDiedImage.setVisible(true);
		deadButton.setVisible(true);
		selectChoiceButton.setVisible(false);
		eventDescriptionLabel.setVisible(false);
	}
	
	/**
	 * Prepares the event scene for displaying a new game event after a choice button is clicked
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void loadEvent(ActionEvent event) throws IOException {
		if (player.getName().equals("Default")) {
			nameErrorLabel.setVisible(true);
		} else {
			if (nameErrorLabel.isVisible()) {
				nameErrorLabel.setVisible(false);
				if (player.getName().equals("FORTNITE")) {
					playSprite();
				}
			}
			loadEventButton.setText("Continue");
			loadEventButton.setVisible(false);
			nameTextBox.setVisible(false);
			statsPane.setVisible(true);
			statsGridPane.setVisible(true);
			playerNameLabel.setVisible(true);
			playerHealthLabel.setVisible(true);
			currentWeaponLabel.setVisible(true);
			roomCountLabel.setVisible(true);
			selectChoiceButton.setVisible(true);
			updatePlayerStats();
			eventDescriptionLabel.setVisible(true);
			eventResultLabel.setVisible(false);
			
			// If player is still alive, move on to the next event
			if (player.isAlive()) {
				player.dungeonSurvived();
				displayNextEvent(event);
			// Otherwise, show the death screen
			} else {
				displayDeathScreen();
			}
		}
	}
	
	/**
	 * Updates a given choice button to display the choice of the current event
	 * 
	 * @param choiceButton
	 * @param choiceIndex
	 */
	private void updateChoiceText(RadioButton choiceButton, char choiceIndex) {
		// Check for available choice text and corresponding buttons
		if (story.getEvent(eventIndex) == null || story.getEvent(eventIndex).getChoice(choiceIndex) == null
				|| story.getEvent(eventIndex).getChoice(choiceIndex).getDescription() == null) {
			choiceButton.setVisible(false);
		} else {
			choiceButton.setVisible(true);
			choiceButton.setText(story.getEvent(eventIndex).getChoice(choiceIndex).getDescription());
		}
	}
	
	/**
	 * Animates text by adding each character to the label sequentially
	 * 
	 * @param textToAnimate
	 * @param destination the label to display the text on
	 */
	private void animateText(String textToAnimate, Label destination) {
		/*
		 * Animation code adapted from
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
		// Remove text before animating
		destination.setText("");
		timeline.getKeyFrames().add(keyFrame);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	/**
	 * Handles event for clicking the first choice
	 * 
	 * @param event
	 */
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
	
	/**
	 * Handles event for clicking the second choice
	 * 
	 * @param event
	 */
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
	
	/**
	 * Handles event for clicking the third choice
	 * 
	 * @param event
	 */
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
	
	/**
	 * Disables all the choice buttons from view
	 * Enables the button for loading the next event
	 */
	private void disableChoiceButtons() {
		loadEventButton.setVisible(true);
		choice1Button.setSelected(false);
		choice2Button.setSelected(false);
		choice3Button.setSelected(false);
		choice1Button.setVisible(false);
		choice2Button.setVisible(false);
		choice3Button.setVisible(false);
		selectChoiceButton.setVisible(false);
	}
	
	/**
	 * Activates the choice that was selected
	 * 
	 * @param event
	 */
	@FXML
	void selectChoiceButtonClicked(ActionEvent event) {
		if (eventChoice == '1' || eventChoice == '2' || eventChoice == '3') {
			story.getEvent(eventIndex).getChoice(eventChoice).activate();
			player.removeHealth(story.getEvent(eventIndex).getHealthLost());
			animateText((story.getEvent(eventIndex).getChoiceResult()), eventResultLabel);
			eventResultLabel.setVisible(true);
			updatePlayerStats();
			disableChoiceButtons();
			
			// Increment index to prepare for next event
			eventIndex++;
			// Reset event choice
			eventChoice = 0;
		}
	}
	
	/**
	 * Plays an animation in the icon at the top left corner of the screen
	 */
	private void playSprite() {
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
}
