import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecondSceneController extends Controller {
	
	@FXML
	private Button secondButton;

	public SecondSceneController(GameGUI gameGUI) {
		super(gameGUI, "/secondScene.fxml");
	}
	
	@FXML
	void viewFirstScene() {
		gameGui.setScene(gameGui.getFirstController());
	}
}