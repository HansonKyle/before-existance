import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class Controller {
	
	private final FXMLLoader loader;

	public Controller(Game game, String fxmlPath) {
		this.loader = new FXMLLoader(getClass().getResource(fxmlPath));
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FXMLLoader getLoader() {
		return loader;
	}
}