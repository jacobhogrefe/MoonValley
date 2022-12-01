package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class WalrusScript extends Script<NPC> {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		if (!isFlagSet("hasTalkedToWalrus")) {
			addTextToTextboxQueue("Am I okay? No! I cannot see \nanything and I keep bumping into things.");
			addTextToTextboxQueue("My name? …..I have no idea! \nI cannot remember a thing!");
		} else if (isFlagSet("desertDone") && !isFlagSet("desertDialogue")) {
			addTextToTextboxQueue("Cat you're back!");
			addTextToTextboxQueue("Please tell me you have found something\nto make out this faded inscription...");
			addTextToTextboxQueue("YOU DID?!?!");
			addTextToTextboxQueue("A magnifying glass? \nThat is perfect!");
			addTextToTextboxQueue("Here, take my glasses and try to make out the \ninscription. I'll try not to fall.");
			addTextToTextboxQueue("...J.B.? Two letters? That doesn't help at all.\nHow will I remember what happened?");
			addTextToTextboxQueue("Thank you for your help Cat. While you were gone\nI found a grappling hook.");
			addTextToTextboxQueue("I noticed some mountains northeast of here\nmaybe you could put it to use");
			addTextToTextboxQueue("You may even find more hints for me to remember\n who I am.");
		} else if (isFlagSet("foundCanteen")) {
			addTextToTextboxQueue("Let me know if you find anything!");
		} else if (isFlagSet("hasTalkedToWalrus") && !isFlagSet("foundGlasses")) {
			addTextToTextboxQueue("Oh, what am I going to do!?!\nWhy can't I see?");
		} else if (isFlagSet("foundGlasses")) {
			addTextToTextboxQueue("I..I… I can see! These must be my glasses…");
			addTextToTextboxQueue("There is an inscription on the side but \nI can’t quite make it out… ");
			addTextToTextboxQueue("I still can’t remember a thing though... \nwould you do me a favor?");
			addTextToTextboxQueue("Maybe the inscription on the side of my \nglasses will help me remember who I am.");
			addTextToTextboxQueue(
					"If you come across anything that might help \nme remember, would you bring it here for me?");
			addTextToTextboxQueue("You will? I don’t know what I would \nhave done if you did not show up.");
			addTextToTextboxQueue(
					"Thank you so much… I don’t know what I can do to \nrepay you, but I think this is my house.");
			addTextToTextboxQueue("This Canteen on the couch must be mine. \nPlease, take it!");
			addTextToTextboxQueue("I wish there was something more I could give you.");
		}
		
		

		entity.facePlayer(player);
	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();
		if (!isFlagSet("hasTalkedToWalrus")) {
			setFlag("hasTalkedToWalrus");
			unsetFlag("searchForGlasses");
		} else if (isFlagSet("foundGlasses")) {
			unsetFlag("searchForCanteen");
			setFlag("removeItem2");
			unsetFlag("foundGlasses");
		}
		
		if (isFlagSet("desertDone")) {
			setFlag("desertDialogue");
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
