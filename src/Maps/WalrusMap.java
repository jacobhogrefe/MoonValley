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

public class WalrusMap extends Map {

    public WalrusMap() {
        super("walrus_house_map.txt", new HouseTileset());
        this.playerStartPosition = getMapTile(12, 10).getLocation();
    }
}
