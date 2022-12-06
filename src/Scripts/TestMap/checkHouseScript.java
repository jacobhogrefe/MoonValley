package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;
import Level.Trigger;

public class checkHouseScript extends Script<Trigger> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("I think its coming from the house over that way, \nI didn’t know anyone lived there!");
		addTextToTextboxQueue("Maybe I should go make sure whoever is inside \nis okay.");

	}

	@Override
	protected void cleanup() {
		setFlag("wentOutside");
		hideTextbox();
		unlockPlayer();

	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("wentOutside")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}
