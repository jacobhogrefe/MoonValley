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
		addTextToTextboxQueue("I should probably go check that out.");

	}

	@Override
	protected void cleanup() {
		setFlag("hasCrash");
		hideTextbox();
		unlockPlayer();

	}

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
