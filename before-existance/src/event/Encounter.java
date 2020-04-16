package event;

import core.Game;
import entity.Player;
import entity.Enemy;
import core.Database;

// The enemy of the encountered and the description of the event is given.
// It calls the choices of the CombatEvent class to be called
public class Encounter extends Event {
	private Enemy enemy = Database.GOBLIN;
	
	public Encounter(Game game, Enemy enemy) {
		super(game, "Enemy Encounter", enemy.getDescription());
		Player player = game.getPlayer();
		CombatEvent round = new CombatEvent(game, enemy);
		round.displayChoices();
		round.requestChoice();
	}
}
