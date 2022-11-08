package Scripts.DesertMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class OwnerScript extends Script<NPC> {

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
      if(!isFlagSet("needsFindBucket")) {
            addTextToTextboxQueue( "Gush durnit! This mail-order cowboy \nain't nothin' but a dang ol' shanny! ");
            addTextToTextboxQueue( "...oh, hello there...");
            addTextToTextboxQueue( "Pardon me, barking at a knot, but my \nfinest steer has gone loose again! ");
            addTextToTextboxQueue( "And where might my cowboy be? No where to \nbe found I tell ya! Takin' a French leave!");
            addTextToTextboxQueue( "If you come across that chucklehead, tell him \nhe best be back here in a twinklin' of a bed post!");
        }
      else {
    	  addTextToTextboxQueue( "Where is that dang ol' cowboy?!");
      }
      entity.facePlayer(player);
    }

    

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        System.out.println("Setting flag: needsFindBucket");
        setFlag("needsFindBucket");
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
