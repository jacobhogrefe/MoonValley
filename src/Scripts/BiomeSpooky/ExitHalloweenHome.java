package Scripts.BiomeSpooky;

import Game.Game;

import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;



public class ExitHalloweenHome extends Script<Trigger> {
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
	}

	@Override
	public ScriptState execute() {
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(4), 384, 480);
		return ScriptState.COMPLETED;
	}
}