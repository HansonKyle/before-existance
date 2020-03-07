import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FirstSceneController extends Controller {
	
	@FXML
	private Button firstButton;

	public FirstSceneController(GameGUI gameGui) {
		super(gameGui, "/firstScene.fxml");
	}
	
	@FXML
	void viewSecondScene() {
		gameGui.setScene(gameGui.getSecondController());
	}
}