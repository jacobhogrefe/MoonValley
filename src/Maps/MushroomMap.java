package Maps;

import Level.Map;
import Level.MusicState;
import Scripts.MushroomMap.EnterMushroomHouseScript;
import Scripts.TestMap.EnterHouseScript;
import Tilesets.MushroomTileset;

//Mushroom Biome map
public class MushroomMap extends Map {

    public MushroomMap() {
        super("mushroom_map.txt", new MushroomTileset());
//        this.playerStartPosition = getMapTile(2, 2).getLocation();
    }
    
    @Override
    public void loadScripts() {  
        getMapTile(15, 7).setInteractScript(new EnterMushroomHouseScript());
    } 
    @Override
    public MusicState getMusicState() {
        return MusicState.MUSHROOM;
    }
}

