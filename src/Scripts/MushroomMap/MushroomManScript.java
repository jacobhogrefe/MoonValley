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
	}

	@Override
	protected void cleanup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ScriptState execute() {
		// TODO Auto-generated method stub
		return null;
	}
}