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
		lockPlayer();
		if (!isFlagSet("hasTalkedToShittake")) {
			if (sequence == 0) {
				showTextbox();
				addTextToTextboxQueue("Sup dawg. It's house tour time.");
			} else if (sequence == 1) {
				entity.stand(Direction.RIGHT);
				amountMoved = 0;
			} else if (sequence == 2) {
				entity.facePlayer(player);
				amountMoved = 0;
			} else if (sequence == 3) {
				entity.facePlayer(player);
				showTextbox();
				addTextToTextboxQueue("This is my bed. I sleep here sometimes.");
				addTextToTextboxQueue("So does my pet, speaking of the brat...\nWhere is he?");
				addTextToTextboxQueue("Actually whatever.");
			} else if (sequence == 4) {
				entity.stand(Direction.LEFT);
				amountMoved = 0;
			} else if (sequence == 5) {
				entity.stand(Direction.LEFT);
				amountMoved = 0;
			} else if (sequence == 6) {
				showTextbox();
				addTextToTextboxQueue("This is my dresser.");
				addTextToTextboxQueue("Yo actually where is my pet? Any chance you\n could hunt him down?");
				addTextToTextboxQueue("He's like a foot tall and blue if that helps.");
				addTextToTextboxQueue("Thanks dawg");
			}
		}
	}

	@Override
	protected void cleanup() {
		if (!isFlagSet("hasTalkedToShittake")) {
			if (sequence == 0) {
				hideTextbox();
				sequence++;
			} else if (sequence == 1) {
				sequence++;
			} else if (sequence == 2) {
				sequence++;
			} else if (sequence == 3) {
				hideTextbox();
				sequence++;
			} else if (sequence == 4) {
				sequence++;
			} else if (sequence == 5) {
				sequence++;
			} else if (sequence == 6) {
				hideTextbox();
				sequence++;
				unlockPlayer();
				setFlag("hasTalkedToShittake");
			}
		}
	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasTalkedToShittake")) {
			// talks
			if (sequence == 0) {
				start();
				if (isTextboxQueueEmpty()) {
					end();
				}
			}
			// walks right
			else if (sequence == 1) {
				start();
				entity.walk(Direction.RIGHT, 1);
				amountMoved += 2;
				if (amountMoved == 200) {
					end();
				}
			}
			// walks up
			else if (sequence == 2) {
				start();
				entity.walk(Direction.UP, 1);
				amountMoved += 2;
				if (amountMoved == 120) {
					end();
				}
			}
			// talks
			else if (sequence == 3) {
				start();
				if (isTextboxQueueEmpty()) {
					end();
				}
			}
			// walk left
			else if (sequence == 4) {
				start();
				entity.walk(Direction.LEFT, 1);
				amountMoved += 2;
				if (amountMoved == 240) {
					end();
				}
			}
			//walk up
			else if (sequence == 5) {
				start();
				entity.walk(Direction.UP, 1);
				amountMoved += 2;
				if (amountMoved == 140) {
					end();
				}
			}
			//talks
			else if (sequence == 6) {
				start();
				if (isTextboxQueueEmpty()) {
					end();
				}
			}
			return ScriptState.RUNNING;
		}
		return ScriptState.COMPLETED;
	}
}