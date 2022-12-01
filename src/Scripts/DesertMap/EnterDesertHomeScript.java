package Scripts.DesertMap;

import Game.Game;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;
import Screens.PlayLevelScreen;


public class EnterDesertHomeScript extends Script<Trigger> {
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
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(13),350,450);
		return ScriptState.COMPLETED;
	}
}