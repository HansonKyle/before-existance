import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GameState {
	
	private final Pane root = new Pane();
	private final Scene gameScene = new Scene(root, 800, 800);
	private final Label cruddyLabel = new Label("this is the game. have fun playing lol");
	private final Button returnToMenu = new Button("f go back");

	public GameState(Game game) {
		root.getChildren().add(cruddyLabel);
		root.getChildren().add(returnToMenu);
		
		returnToMenu.setLayoutY(100);
		returnToMenu.setOnAction(event -> game.viewMenu());
	}
	
	public Scene getGameScene() {
		return gameScene;
	}
}