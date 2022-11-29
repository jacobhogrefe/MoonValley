package Scripts.BiomeMountains;

import Game.Game;

import Level.Player;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;
import Screens.PlayLevelScreen;

public class ExitTreehouseScript extends Script<Trigger> {

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
        PlayLevelScreen.isInHouse = false;
		Game.getRunningInstance().getScreenCoordinator().getPlayLevelScreen().teleport(Player.MapEntityManager.getSavedMap(2), 240, 1152);
		return ScriptState.COMPLETED;
    }
    
}
