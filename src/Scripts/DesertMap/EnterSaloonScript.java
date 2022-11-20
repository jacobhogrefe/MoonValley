package Scripts.DesertMap;

import Game.Game;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Maps.MushroomHomeMap;
import Maps.SaloonMap;
import Screens.PlayLevelScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class EnterSaloonScript extends Script {
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
		PlayLevelScreen.isInHouse = false;
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(10),350,450);
		return ScriptState.COMPLETED;
	}
}