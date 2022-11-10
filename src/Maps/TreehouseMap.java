package Maps;

import Level.Map;
import Level.MusicState;
import Scripts.BiomeMountains.ExitTreehouseScript;
import Tilesets.TreehouseTileset;

public class TreehouseMap extends Map {

    public TreehouseMap() {
        super("mountains_home_map.txt", new TreehouseTileset());
    }
    
    @Override
    public void loadScripts() {
        getMapTile(2,8).setInteractScript(new ExitTreehouseScript());
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.MOUNTAINS_HOME;
    }
}
