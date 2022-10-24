package Maps;

import Level.Map;
import Level.MusicState;
import Scripts.TestMap.ExitHouseScript;
import Tilesets.HouseTileset;

// Represents a test map to be used in a level
public class HouseMap extends Map {

	public HouseMap() {
		super("house_map.txt", new HouseTileset());
		this.playerStartPosition = getMapTile(12, 10).getLocation();
	}

	@Override
	public void loadScripts() {
		getMapTile(8, 11).setInteractScript(new ExitHouseScript());
	}

	@Override
	public MusicState getMusicState() {
		return MusicState.START_HOME;
	}

}
