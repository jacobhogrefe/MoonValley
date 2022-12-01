package Scripts.TestMap;

import Level.MusicManager;
import Level.MusicState;
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
//		} else if (isFlagSet("thisIsDoneNow") && (!isFlagSet("cantUseComputer"))) {
//			addTextToTextboxQueue("Quick! To the computer!");
		}
		if (isFlagSet("hasHeadphones") && !isFlagSet("thisIsDoneNow")) {
			addTextToTextboxQueue("Hello again, what have you found now?");
			addTextToTextboxQueue("A tape? What could be on it?\nCould this explain everything?");
			addTextToTextboxQueue("Well let's start it up");
//			MusicManager.updateMusic(MusicState.TAPE);
		} else if (isFlagSet("hasBrush")) {
			addTextToTextboxQueue("Oh Cat! Back again!");
			addTextToTextboxQueue("You found... a beard brush inscribed\nJ.B.?");
			addTextToTextboxQueue("But... Im a walrus, I can't grow\n a beard.");
			addTextToTextboxQueue("This is a very interesting development...\nWhat could it mean?");
			addTextToTextboxQueue("Well, in other news,\nI have a surprise for you.");
			addTextToTextboxQueue(
					"Do you know that Halloween town north of here?\n They don't let anyone in without a costume.");
			addTextToTextboxQueue("I made this spooky ghost costume!\nTry it on?");
			addTextToTextboxQueue("You can access the town if you have this with you.");
			addTextToTextboxQueue("Maybe there are more clues up there!");
		} else if (isFlagSet("haveHawaiian")) {
			addTextToTextboxQueue("Oh Cat, you are back! \nWhat have you found?");
			addTextToTextboxQueue(
					"Hm…a Hawaiian shirt? It seems to be just my size too, \nAND it inscribed J.B? Well, I guess it must be mine.");
			addTextToTextboxQueue(
					"I’m not entirely sure what this means, but I \nguess I am someone with a snazzy sense of style.");
			addTextToTextboxQueue(
					"Oh, I almost forgot! I found something else \naround the house, check out this gas mask!");
			addTextToTextboxQueue("I noticed the area west of here is filled with mushrooms.");
			addTextToTextboxQueue(
					"Maybe this would help you breath over there\n with all the fungi in the air and such.");
			addTextToTextboxQueue("Do you mind checking for more clues over there?");
		} else if (isFlagSet("desertDone") && !isFlagSet("desertDialogue")) {
			addTextToTextboxQueue("Cat you're back!");
			addTextToTextboxQueue("Please tell me you have found something\nto make out this faded inscription...");
			addTextToTextboxQueue("YOU DID?!?!");
			addTextToTextboxQueue("A magnifying glass? \nThat is perfect!");
			addTextToTextboxQueue("Here, take my glasses and try to make out the \ninscription. I'll try not to fall.");
			addTextToTextboxQueue(
					"...J.B.? Two letters? That doesn't help at all.\nHow will I remember what happened?");
			addTextToTextboxQueue("Thank you for your help Cat. While you were gone\nI found a grappling hook.");
			addTextToTextboxQueue("I noticed some mountains northeast of here\nmaybe you could put it to use");
			addTextToTextboxQueue("You may even find more hints for me to remember\n who I am.");
		} else if (isFlagSet("thisIsDoneNow")) {
			addTextToTextboxQueue("Quick to the computer!");
		}
		else if (isFlagSet("foundCanteen")) {
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
		if (isFlagSet("hasHeadphones") && !isFlagSet("thisIsDoneNow")) {
			MusicManager.updateMusic(MusicState.TAPE);
			setFlag("removeItem5");
			unsetFlag("cantUseComputer");
			unsetFlag("hasHeadphones");
			setFlag("thisIsDoneNow");
		}
		if (isFlagSet("hasBrush")) {
			setFlag("removeItem4");
		}
		if (isFlagSet("desertDone")) {
			setFlag("desertDialogue");
		}

		if (isFlagSet("haveHawaiian")) {
			setFlag("removeItem3");
//			unsetFlag("haveHawaiian");
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
