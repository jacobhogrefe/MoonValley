package Scripts.BiomeMountains;

import Game.Game;
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
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(new BiomeMountains(), 208, 144);
		return ScriptState.COMPLETED;
    }
    
}
