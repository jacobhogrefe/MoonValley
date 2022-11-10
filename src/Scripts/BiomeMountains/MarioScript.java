package Scripts.BiomeMountains;

import Level.Collectible;
import Level.NPC;
import Level.Script;
import Level.ScriptState;

public class MarioScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        if (!isFlagSet("firstTalkToMario")) {
            addTextToTextboxQueue("It's-a me, Mario! I've lost some things around this area.");
            addTextToTextboxQueue("Do you think you can help me find them? I'll reward\nyou too!");
            addTextToTextboxQueue("One thing I remember losing is my Nintendo Switch.");
            addTextToTextboxQueue("It should be somewhere on one of the mountains.");
        } else if (isFlagSet("firstTalkToMario") && isFlagSet("searchForSwitch")) {
            addTextToTextboxQueue("One thing I remember losing is my Nintendo Switch.");
            addTextToTextboxQueue("It should be somewhere on one of the mountains.");
        } else if (isFlagSet("searchForSwitch") && isFlagSet("foundSwitch")) {
            addTextToTextboxQueue("Thank you! Now I can play Super Mario Odyssey!");
            addTextToTextboxQueue("Here is an entertainment center for your home!");
            addTextToTextboxQueue("Any instant food up here is a necessity.");
            addTextToTextboxQueue("Do you think you can bring me some ramen?");
            addTextToTextboxQueue("I think I left it somewhere around here.");
        } else if (isFlagSet("foundSwitch") && isFlagSet("searchForRamen")) {
            addTextToTextboxQueue("Any instant food up here is a necessity.");
            addTextToTextboxQueue("Do you think you can bring me some ramen?");
            addTextToTextboxQueue("I think I left it somewhere around here.");
        } else if (isFlagSet("searchForRamen") && isFlagSet("foundRamen")) {
            addTextToTextboxQueue("Oooo yummy! I know this is a\nstaple in a college student's diet!");
            addTextToTextboxQueue("I think this dorm furniture\nwill do you well!");
            addTextToTextboxQueue("Being made up of 1's and 0's really\ndoes give you an existential crisis.");
            addTextToTextboxQueue("But, I want to make my own\n1's and 0's!");
            addTextToTextboxQueue("Can you bring me a terminal?\nI believe it's lower on the ground.");
        } else if (isFlagSet("foundRamen") && isFlagSet("searchForTerminal")) {
            addTextToTextboxQueue("Being made up of 1's and 0's really\ndoes give you an existential crisis.");
            addTextToTextboxQueue("But, I want to make my own\n1's and 0's!");
            addTextToTextboxQueue("Can you bring me a terminal?\nI believe it's lower on the ground.");
        } else if (isFlagSet("searchForTerminal") && isFlagSet("foundTerminal")) {
            addTextToTextboxQueue("Thank you so much! Now I can\n make my own game!");
            addTextToTextboxQueue("Since you look like a computer\nscience student, here is a desk!");
            addTextToTextboxQueue("I have one more item hidden around here,\nit's a coin from the 90s.");
            addTextToTextboxQueue("I'm not sure where I last saw it, but\nit is pretty valuable.");
        } else if (isFlagSet("foundTerminal") && isFlagSet("searchForYoshiCoin")) {
            addTextToTextboxQueue("I have one more item hidden around here,\nit's a coin from the 90s.");
            addTextToTextboxQueue("I'm not sure where I last saw it, but\nit is pretty valuable.");
        } else if (isFlagSet("searchForYoshiCoin") && isFlagSet("foundYoshiCoin")) {
            addTextToTextboxQueue("Perfect! This was exactly what I was looking for!");
            addTextToTextboxQueue("Here are a pair of headphones for a certain blue\nfella. Tell him Mario says hi!");
        } else {
            addTextToTextboxQueue("It's pretty chilly up here, maybe you\nshould invest in a jacket.");
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        if (isFlagSet("searchForSwitch")) {
            setFlag("firstTalkToMario");
            unsetFlag("searchForSwitch");
        } else if (!isFlagSet("searchForSwitch") && isFlagSet("foundSwitch")) {
            unsetFlag("searchForRamen");
            setFlag("removeItem");
        } else if (!isFlagSet("searchForRamen") && isFlagSet("foundRamen")) {
            unsetFlag("searchForTerminal");
            setFlag("removeItem");
        } else if (!isFlagSet("searchForTerminal") && isFlagSet("foundTerminal")) {
            unsetFlag("searchForYoshiCoin");
            setFlag("removeItem");
        } else if (!isFlagSet("searchForYoshiCoin") && isFlagSet("foundYoshiCoin")) {
            setFlag("removeItem");
        }
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
