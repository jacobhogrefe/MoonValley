package Maps;

import Level.Map;
import Level.MusicState;
import Scripts.BiomeMountains.ExitTreehouseScript;
import Tilesets.TreehouseTileset;

public class TreehouseMap extends Map {

    public TreehouseMap() {
        super("mountains_home_map.txt", new TreehouseTileset(),10);
    }
    
    @Override
    public void loadScripts() {
        getMapTile(3,10).setInteractScript(new ExitTreehouseScript());
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.MOUNTAINS_HOME;
    }
}
