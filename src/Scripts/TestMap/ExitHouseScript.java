package Scripts.TestMap;

import Game.Game;
import Level.Script;
import Level.ScriptState;
import Maps.TestMap;

// trigger script at beginning of game to set that heavy emotional plot
public class ExitHouseScript extends Script {
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
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(new TestMap(), 550, 1000);
		return ScriptState.COMPLETED;
	}
}