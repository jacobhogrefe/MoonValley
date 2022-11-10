package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class DinoScript2 extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		if (!isFlagSet("hasTalkedToDino")) {
			addTextToTextboxQueue("Hi Cat!");
		} else if (isFlagSet("finishGlasses")) {
			addTextToTextboxQueue("Oh! You are looking for a magnifying\n glass?");
			addTextToTextboxQueue("You can try checking my garden!");
		}

	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();

		setFlag("hasTalkedToDino");
		System.out.println("Setting flag: hasTalkedToDino");
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
