import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Controller {
	
	protected final GameGUI gameGui;
	
	private final FXMLLoader loader;
	private final Scene scene;

	public Controller(GameGUI gameGui, String fxmlPath) {
		this.gameGui = gameGui;
		this.loader = new FXMLLoader(getClass().getResource(fxmlPath));
		
		if (loader.getController() == null) {
			loader.setController(this);
		}
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.scene = new Scene(loader.getRoot());
	}
	
	public FXMLLoader getLoader() {
		return loader;
	}
	
	public Scene getScene() {
		return scene;
	}
}