package Maps;

import java.util.ArrayList;

import Level.Collectible;
import Level.Map;
import Level.MusicState;
import Scripts.TestMap.ExitWalrusHouseScript;
import Tilesets.HouseTileset;

public class WalrusMap extends Map {

	private boolean isInHouse;

	public WalrusMap() {
		super("walrus_house_map.txt", new HouseTileset(),14);
		this.playerStartPosition = getMapTile(12, 10).getLocation();
		isInHouse = true;
	}

	@Override
	public void loadScripts() {
		getMapTile(8, 11).setInteractScript(new ExitWalrusHouseScript());
	}

	@Override
	public ArrayList<Collectible> loadCollectables() {
		ArrayList<Collectible> collectibles = new ArrayList<>();
        collectibles.add(new Collectible("Glasses.png", getMapTile(6, 6).getLocation(), "Glasses", 18, false));

		return collectibles;
	}

	@Override
	public MusicState getMusicState() {
		return MusicState.START_HOME;
	}

	public boolean getIsInHouse() {
		return isInHouse;
	}
}
