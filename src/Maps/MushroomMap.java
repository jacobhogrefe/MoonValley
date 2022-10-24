package Maps;

import Level.Map;
import Level.MusicState;
import Tilesets.MushroomTileset;

// Represents a test map to be used in a level
public class MushroomMap extends Map {

    public MushroomMap() {
        super("mushroom_map.txt", new MushroomTileset());
        this.playerStartPosition = getMapTile(2, 2).getLocation();
    }
    
    @Override
    public void loadScripts() {  
    } 
    @Override
    public MusicState getMusicState() {
        return MusicState.MUSHROOM;
    }
}

