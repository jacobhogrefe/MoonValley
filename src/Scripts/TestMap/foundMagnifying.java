package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class foundMagnifying extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("I found the magnifying glass!");
		addTextToTextboxQueue("I should take this back to Walrus.");

	}

	@Override
	protected void cleanup() {
		setFlag("hasMagnifying");
		setFlag("finesse");
    	System.out.println("Setting flag: hasMagnifying");
		hideTextbox();
		unlockPlayer();

	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasMagnifying")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}
