package Scripts.BiomeMountains;

import Game.Game;
import Level.Player;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

public class EnterTreehouseScript extends Script {

    @Override
    protected void setup() {}

    @Override
    protected void cleanup() {}

    @Override
    protected ScriptState execute() {
        PlayLevelScreen.isInHouse = true;
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(10), 144, 432);
		return ScriptState.COMPLETED;
    }
    
}
