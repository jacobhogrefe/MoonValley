package Maps;

import Level.Map;
import Tilesets.HouseTileset;

// Represents a test map to be used in a level
public class HouseMap extends Map {

    public HouseMap() {
        super("house_map.txt", new HouseTileset(), null);
        this.playerStartPosition = getMapTile(5, 9).getLocation();
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
}
