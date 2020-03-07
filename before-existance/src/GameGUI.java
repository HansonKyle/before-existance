import javafx.application.Application;
import javafx.stage.Stage;

public class GameGUI extends Application {
	
	private Stage stage;
	// All controllers are listed and initialized in this class
	private FirstSceneController firstController = new FirstSceneController(this);
	private SecondSceneController secondController = new SecondSceneController(this);

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		
		stage.setTitle("Scene switching demo");
		// Start with first scene by default
		setScene(firstController);
		stage.show();
	}
	
	public void setScene(Controller controller) {
		// Retrieve and set the scene to the scene of the given controller
		stage.setScene(controller.getScene());
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public FirstSceneController getFirstController() {
		return firstController;
	}

	public SecondSceneController getSecondController() {
		return secondController;
	}
	
	// Launches the GUI-based version of the program
	public static void main(String[] args) {
		launch(args);
	}
}