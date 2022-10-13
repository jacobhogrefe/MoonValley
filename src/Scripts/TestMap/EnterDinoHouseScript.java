package Scripts.TestMap;

import Game.Game;
import Level.Script;
import Level.ScriptState;
import Maps.DinoMap;

// trigger script at beginning of game to set that heavy emotional plot
public class EnterDinoHouseScript extends Script {
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("Entering house...");
	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
	}

	@Override
	public ScriptState execute() {
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(new DinoMap(), 350, 450);
		return ScriptState.COMPLETED;
	}
	
	
}
