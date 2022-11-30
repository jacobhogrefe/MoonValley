package Maps;

import Level.Map;
import Level.MusicState;
import Level.Tileset;
import Scripts.BiomeSpooky.ExitHalloweenHome;
import Tilesets.BiomeSpookyHomeTilesets;
import Tilesets.BiomeSpookyTilesets;

public class BiomeSpookyHome extends Map {

	public BiomeSpookyHome() {
        super("castle.txt", new BiomeSpookyHomeTilesets(),10);
		this.playerStartPosition = getMapTile(8, 10).getLocation();
    }
    
    @Override
    public void loadScripts() {
        getMapTile(8,10).setInteractScript(new ExitHalloweenHome());
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.SPOOKY_HOME;
    }
}