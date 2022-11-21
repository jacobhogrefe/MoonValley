package Maps;

import Level.Map;
import Level.MusicState;
import Scripts.TestMap.ExitDinoHouseScript;
import Tilesets.HouseTileset;

public class DinoMap extends Map {

    public DinoMap() {
        super("dino_house_map.txt", new HouseTileset(),6);
        this.playerStartPosition = getMapTile(12, 10).getLocation();
    }  
    
    @Override
    public void loadScripts() { 
        getMapTile(8, 11).setInteractScript(new ExitDinoHouseScript());
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.START_HOME;
    }
}
