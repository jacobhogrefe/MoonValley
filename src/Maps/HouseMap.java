package Maps;
import java.util.ArrayList;

import EnhancedMapTiles.Rock;
import Level.Collectible;
import Level.EnhancedMapTile;
import Level.HouseEntry;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Walrus;
import Screens.PlayLevelScreen;
import Scripts.SimpleTextScript;
import Scripts.TestMap.CollectibleScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Level.Map;
import Tilesets.HouseTileset;

// Represents a test map to be used in a level
public class HouseMap extends Map {

    public HouseMap() {
        super("house_map.txt", new HouseTileset());
        this.playerStartPosition = getMapTile(5, 9).getLocation();
    }

    @Override
    public ArrayList<HouseEntry> loadHouseEntries() {
    	ArrayList<HouseEntry> entries = new ArrayList<>();
//    	entries.add(new HouseEntry(5, 9, house_map.txt, HouseTileset));
    	return entries;
    }
}
