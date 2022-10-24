package Maps;

import Level.Map;
import Level.MusicState;
import Tilesets.MushroomHomeTileset;

// Represents a test map to be used in a level
public class MushroomHomeMap extends Map {

    public MushroomHomeMap() {
        super("mushroom_home_map.txt", new MushroomHomeTileset());
        this.playerStartPosition = getMapTile(5, 5).getLocation();
    }
    
    @Override
    public void loadScripts() {  
    } 
    @Override
    public MusicState getMusicState() {
        return MusicState.MUSHROOM_HOME;
    }
}
