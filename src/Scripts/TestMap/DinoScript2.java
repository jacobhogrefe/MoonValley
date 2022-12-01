package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class DinoScript2 extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("Hi Cat!");
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
