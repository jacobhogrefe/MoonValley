package Scripts.TestMap;

import Game.Game;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;
import Screens.PlayLevelScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class ExitWalrusHouseScript extends Script<Trigger> {
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
		PlayLevelScreen.isInHouse = false;
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(5), 200, 1300);
		return ScriptState.COMPLETED;
	}
}