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
import Scripts.TestMap.ExitHouseScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Level.Map;
import Tilesets.HouseTileset;

public class DinoMap extends Map {

    public DinoMap() {
        super("dino_house_map.txt", new HouseTileset());
        this.playerStartPosition = getMapTile(12, 10).getLocation();
    }  
    
    @Override
    public void loadScripts() { 
        getMapTile(8, 11).setInteractScript(new ExitHouseScript());
    }
}