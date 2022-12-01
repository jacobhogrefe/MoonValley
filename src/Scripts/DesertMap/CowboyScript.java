package Scripts.DesertMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Screens.PlayLevelScreen;

// script for talking to walrus npc
public class CowboyScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
      if(!isFlagSet("bucketFound")) {
            addTextToTextboxQueue( "Bleerrghh...");
            addTextToTextboxQueue( "*snore*");
        }
      if(isFlagSet("bucketFound")&&!isFlagSet("lassoFound")) {
    	  addTextToTextboxQueue( "WHAHAHAGHH!!");
    	  addTextToTextboxQueue( "...ughh...wife left...dog died....blehhhhgggggh");
    	  addTextToTextboxQueue( "*Drops Lasso*");
    	  PlayLevelScreen.ShouldGiveLasso = true;
    	 
    	  
      }
      else {
    	  addTextToTextboxQueue( "*snore*");
      }

    }

    

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        
        if(isFlagSet("needsFindBucket") && isFlagSet("bucketFound")) {
        	
        	setFlag("lassoFound");
        }
        else {
        	
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