package Scripts.MushroomMap;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import GameObject.Frame;
import Level.*;
import Utils.Direction;
import Utils.Point;

// script for talking to mushroom man npc
// the script is segmented -- it has multiple setups, cleanups, and executions based on its current action
public class MushroomManScript extends Script<NPC> {

	private int sequence = 0;
	private int amountMoved = 0;

	@Override
	protected void setup() {
//		lockPlayer();
//		
//		if (sequence == 0) {
//			showTextbox();
//			addTextToTextboxQueue("Sup, want a house tour?");
//			addTextToTextboxQueue("Well you're getting one.");
//		} else if (sequence == 2) {
//			entity.stand(Direction.RIGHT);
//			amountMoved = 0;
//		}
	}

	@Override
	protected void cleanup() {
//		if (sequence == 0) {
//			hideTextbox();
//			sequence++;
//		} else if (sequence == 1) {
//			sequence++;
//		}
		
	}

	@Override
	protected ScriptState execute() {
//		//tells u youre getting a house tour
//		if (sequence == 0) {
//			start();
//			if (isTextboxQueueEmpty()) {
//				end();
//			}
//		} 
//		// walk right
//		else if (sequence == 1) {
//			start();
//			entity.walk(Direction.RIGHT, 2);
//			amountMoved += 2;
//			if (amountMoved == 196) {
//				end();
//			}
//		}
//		return ScriptState.RUNNING;
        return ScriptState.COMPLETED;
	}
}