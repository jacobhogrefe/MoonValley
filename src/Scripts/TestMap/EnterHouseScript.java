package Scripts.TestMap;

import Game.GameState;
import Game.ScreenCoordinator;
import Level.Script;
import Level.ScriptState;

// trigger script at beginning of game to set that heavy emotional plot
public class EnterHouseScript extends Script {
    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue("Entering house...");
    }

    @Override
    protected void cleanup() {
    	hideTextbox();
//		screenCoordinator.setGameState(GameState.HOUSE);
        unlockPlayer();
    }

    @Override
    public ScriptState execute() {
        if (!isFlagSet("hasLostBall")) {
            start();
            if (!isTextboxQueueEmpty()) {
                return ScriptState.RUNNING;
            }
            end();
        }
        return ScriptState.COMPLETED;
    }
}