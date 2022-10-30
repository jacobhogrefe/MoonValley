package Scripts.MushroomMap;

import Game.Game;
import Level.Script;
import Level.ScriptState;
import Maps.MushroomHomeMap;
import Screens.PlayLevelScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class EnterMushroomHouseScript extends Script {
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
		PlayLevelScreen.isInHouse = true;
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(new MushroomHomeMap(), 208, 144);
		return ScriptState.COMPLETED;
	}
}