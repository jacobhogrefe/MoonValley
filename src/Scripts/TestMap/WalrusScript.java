package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class WalrusScript extends Script<NPC> {
	private int sequence = 0;

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		
		if (!isFlagSet("hasTalkedToWalrus")) {
			addTextToTextboxQueue("Hi Cat!");
			addTextToTextboxQueue("The crash? Oh! I can't see very well, I lost my glasses.");
			addTextToTextboxQueue("I have been using a magnifying glass to get \naround since.");
			addTextToTextboxQueue("The issue is...");
			addTextToTextboxQueue("I lost that as well.");
			addTextToTextboxQueue("I fell trying to find it, is there any chance you\n could help me?");
			addTextToTextboxQueue("I believe it's in my house somewhere...");
		} else if (isFlagSet("hasGlasses") && isFlagSet("hasTalkedToWalrus")) {
			addTextToTextboxQueue("Woah! You found my glasses instead!\n Thank you!");
			addTextToTextboxQueue("I still want to find the magnifying glass though.\nMaybe dino has seen it.");
		} else if (isFlagSet("hasTalkedToWalrus") && isFlagSet("hasMagnifying") && !isFlagSet("noMore"))  {
			addTextToTextboxQueue("You found it! With this, you are able\n to travel to a new biome.");
			addTextToTextboxQueue("Try walking to the left!");
		}
		else {
			addTextToTextboxQueue("something doesn't feel right...");
		}
		entity.facePlayer(player);
	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();

		// set flag so that if walrus is talked to again after the first time, what he
		// says changes
		setFlag("hasTalkedToWalrus");
		System.out.println("Setting flag: hasTalkedToWalrus");
		if (isFlagSet("hasGlasses")) {
			unsetFlag("hasGlasses");
			setFlag("finishGlasses");
		} 
		if (isFlagSet("hasTalkedToWalrus") && isFlagSet("hasMagnifying") && !isFlagSet("noMore")) {
			setFlag("noMore");
		}
	}

	@Override
	public ScriptState execute() {
		start();
		if (!isTextboxQueueEmpty()) {
			return ScriptState.RUNNING;
		}
		end();
		return ScriptState.COMPLETED;
	}
}
