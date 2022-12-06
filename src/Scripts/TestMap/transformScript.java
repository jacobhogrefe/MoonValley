package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;
import Level.Trigger;
import Screens.PlayLevelScreen;

public class transformScript extends Script<Trigger> {

	@Override
	protected void setup() {

		
		if(isFlagSet("computerScriptActive") && !PlayLevelScreen.transformcomplete) {
			lockPlayer();
			showTextbox();
		addTextToTextboxQueue("Initiating ToHuman.scala....");
		
		PlayLevelScreen.transformcomplete = true;
		}
		else {
			
		}

	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();

	}

	@Override
	protected ScriptState execute() {
		start();
		if (!isTextboxQueueEmpty()) {
			return ScriptState.RUNNING;
		}
		end();
		return ScriptState.COMPLETED;
	}

}
