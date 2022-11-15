package Scripts.BiomeMountains;

import Game.Game;
import Level.MapEntityManager;
import Level.Script;
import Level.ScriptState;
import Maps.TreehouseMap;
import Screens.PlayLevelScreen;

public class EnterTreehouseScript extends Script {

    @Override
    protected void setup() {}

    @Override
    protected void cleanup() {}

    @Override
    protected ScriptState execute() {
        PlayLevelScreen.isInHouse = true;
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(MapEntityManager.entitymanager.getSavedMap(12), 144, 432);
		return ScriptState.COMPLETED;
    }
    
}
