package Scripts.DesertMap;

import Game.Game;
import Level.Script;
import Level.ScriptState;
import Maps.Biomes.BiomeDesert;



public class ExitSaloonScript extends Script {
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
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(new BiomeDesert(), 400, 400);
		return ScriptState.COMPLETED;
	}
}