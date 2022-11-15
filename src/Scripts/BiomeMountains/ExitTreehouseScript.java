package Scripts.BiomeMountains;

import Game.Game;
import Level.MapEntityManager;
import Level.Script;
import Level.ScriptState;
import Maps.Biomes.BiomeMountains;
import Screens.PlayLevelScreen;

public class ExitTreehouseScript extends Script {

    @Override
    protected void setup() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void cleanup() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected ScriptState execute() {
        PlayLevelScreen.isInHouse = true;
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(MapEntityManager.entitymanager.getSavedMap(2), 240, 1152);
		return ScriptState.COMPLETED;
    }
    
}
