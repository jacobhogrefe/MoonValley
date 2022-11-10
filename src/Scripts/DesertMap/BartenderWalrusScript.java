package Scripts.DesertMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class BartenderWalrusScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
      if(!isFlagSet("firstBartenderTalk")) {
            addTextToTextboxQueue( "Hello! Would you like a drink?");
            addTextToTextboxQueue( "Met before? No, I don't think we have.");
            addTextToTextboxQueue( "You may have met my cousin, he lives west of here");
            addTextToTextboxQueue( "I moved out to the desert because Dinosaur\nwas always kicking my things into the forest");
            addTextToTextboxQueue( "It's nice out here.\nMaybe one day you can live here too!");
        }
      if(isFlagSet("firstBartenderTalk")&& isFlagSet("needsFindBucket") && !isFlagSet("bucketFound")) {
    	  addTextToTextboxQueue( "The cowboy on the floor?\nThat is Buck, he comes here a lot...");
    	  addTextToTextboxQueue( "You need to talk to him? Here,\ntry dumping this bucket of water on his face.");
      }
      else {
    	  addTextToTextboxQueue( "The desert sure is beautiful.\nI do wish we had more water, though.");
    //	  reportFlags();
      }
      entity.facePlayer(player);
    }

    

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        
        if(isFlagSet("firstBartenderTalk")&& isFlagSet("needsFindBucket")&&!isFlagSet("bucketFound")) {
        	System.out.println("Setting flag: bucketFound");
        	setFlag("bucketFound");
        }
        
        if (!isFlagSet("firstBartenderTalk")){
        	setFlag("firstBartenderTalk");
        	System.out.println("Setting flag: firstBartenderTalk");
        }
    }
    
    //troubleshooter method
    protected void reportFlags() {
    	System.out.println("needsFindBucket: " + isFlagSet("needsFindBucket"));
    	System.out.println("firstBartenderTalk: " + isFlagSet("firstBartenderTalk"));
    	System.out.println("bucketFound: " + isFlagSet("bucketFound"));
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
