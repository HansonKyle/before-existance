import javafx.stage.Stage;

public class Game {
	
	private final Stage stage;
	private final GameState gameState;
	private final MenuController menuController;

	public Game(Stage stage) {
		this.stage = stage;
		this.menuController = new MenuController(this);
		this.gameState = new GameState(this);
		
		stage.setTitle("Dungeon Crawler");
		stage.setResizable(false);
		stage.show();
		
		viewMenu();
	}
	
	public void start() {
		stage.setScene(gameState.getGameScene());
	}
	
	public void viewMenu() {
		stage.setScene(menuController.getMenuScene());
	}
	
	public Stage getStage() {
		return stage;
	}
}