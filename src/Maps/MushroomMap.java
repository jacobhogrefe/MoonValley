package Maps;

import Level.Map;
import Level.MusicState;
import Scripts.TestMap.ExitHouseScript;
import Tilesets.MushroomTileset;

// Represents a test map to be used in a level
public class MushroomMap extends Map {

    public MushroomMap() {
        super("mushroom_map.txt", new MushroomTileset());
        this.playerStartPosition = getMapTile(2, 2).getLocation();
    }
    
    @Override
    public void loadScripts() {  
//        getMapTile(8, 11).setInteractScript(new ExitHouseScript()); 
    } 
    @Override
    public MusicState getMusicState() {
        return MusicState.MUSHROOM;
    }
}

