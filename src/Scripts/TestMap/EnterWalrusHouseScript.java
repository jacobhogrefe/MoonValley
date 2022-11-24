package Scripts.TestMap;

import Game.Game;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Maps.WalrusMap;
import Screens.PlayLevelScreen;

// trigger script at beginning of game to set that heavy emotional plot
public class EnterWalrusHouseScript extends Script {
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
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(11), 350, 450);
		return ScriptState.COMPLETED;
	}
}