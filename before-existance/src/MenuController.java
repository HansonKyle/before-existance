import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class MenuController extends Controller {
	
	private final Game game;
	private final Scene menuScene = new Scene(super.getLoader().getRoot());

	@FXML
	private Button playButton;
	
	public MenuController(Game game) {
		super(game, "Menu.fxml");
		this.game = game;
	}
	
	@FXML
	public void playGame(ActionEvent event) {
		game.start();
	}
	
	public Scene getMenuScene() {
		return menuScene;
	}
}