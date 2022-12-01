package Scripts.MushroomMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class woof extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if (isFlagSet("dogsPresent")) {
			addTextToTextboxQueue("Go away I'm busy ruining the garden");
		} else {
			addTextToTextboxQueue("Woof.");
			addTextToTextboxQueue("Nah, I'm playing I can talk.");
			addTextToTextboxQueue("Tell Shittake ill be home for dinner. \nAlso look what I dug up.");
			addTextToTextboxQueue("It's a beard comb?\nI dunno bro you can have it.");
		}

	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
		setFlag("dogsPresent");
		setFlag("talkedToDog");

	}

	@Override
	protected ScriptState execute() {
		{
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}
}
