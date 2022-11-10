package Scripts.TestMap;

import Game.Game;
import Level.Script;
import Level.ScriptState;
import Maps.TestMap;
import Maps.Biomes.BiomeStart;
import Screens.PlayLevelScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class ExitDinoHouseScript extends Script {
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
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(new BiomeStart(), 800, 220);
		return ScriptState.COMPLETED;
	}
}