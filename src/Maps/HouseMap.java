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
        this.playerStartPosition = getMapTile(12, 10).getLocation();
    }
}


//    @Override
//    public void loadScripts() {
//        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));
//
//        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));
//
//        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));
//
//        getMapTile(2, 6).setInteractScript(new TreeScript());
//        
//        //added house entering scripts
//        getMapTile(17, 19).setInteractScript(new SimpleTextScript("Would you like to enter Cat's house?"));
//       
//        getMapTile(4, 26).setInteractScript(new SimpleTextScript("Would you like to enter Walrus's house?"));
//        
//        getMapTile(17, 4).setInteractScript(new SimpleTextScript("Would you like to enter Dino's house?"));
//    }


