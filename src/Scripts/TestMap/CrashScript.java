package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;
import Level.Trigger;

public class CrashScript extends Script<Trigger> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("*CRASH*");
		addTextToTextboxQueue("Woah, what was that?");
		addTextToTextboxQueue("Walrus is nearby, I should probably go see if he's okay.");

	}

	@Override
	protected void cleanup() {
		setFlag("hasCrash");
    	System.out.println("Setting flag: hasCrash");
		hideTextbox();
		unlockPlayer();

	}

	// troubleshooter method
//	protected void reportFlags() {
//		System.out.println("hasCrash: " + isFlagSet("hasCrash"));
//	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasCrash")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}
