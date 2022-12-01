package Scripts.DesertMap;

import Game.Game;

import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;



public class ExitDesertHomeScript extends Script<Trigger> {
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
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(0), 150, 1285);
		return ScriptState.COMPLETED;
	}
}