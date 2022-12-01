package Scripts.DesertMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

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
            addTextToTextboxQueue( "Another Walrus west of here? That is strange\n..I have never seen another walrus over there.");
        }
      if(isFlagSet("firstBartenderTalk")&& isFlagSet("needsFindBucket") && !isFlagSet("bucketFound")) {
    	  addTextToTextboxQueue( "The cowboy on the floor?\nThat is Buck, he comes here a lot...");
    	  addTextToTextboxQueue( "You need to talk to him? Here,\ntry dumping this bucket of water on his face.");
    	  PlayLevelScreen.ShouldGiveWaterBucket = true;
    	 
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
