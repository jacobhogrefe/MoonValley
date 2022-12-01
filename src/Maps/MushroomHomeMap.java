package Maps;

import java.util.ArrayList;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import NPCs.MushroomMan;
import Scripts.MushroomMap.ExitMushroomHouseScript;
import Scripts.MushroomMap.MushroomManScript;
import Tilesets.MushroomHomeTileset;

// Represents a test map to be used in a level
public class MushroomHomeMap extends Map {

    public MushroomHomeMap() {
        super("mushroom_home_map.txt", new MushroomHomeTileset(),8);
        this.playerStartPosition = getMapTile(5, 5).getLocation();
    }
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        MushroomMan mushroomMan = new MushroomMan(1, getMapTile(8, 7).getLocation().subtractY(40));
        mushroomMan.setInteractScript(new MushroomManScript());
        npcs.add(mushroomMan);

        return npcs;
    }
    
    @Override
    public void loadScripts() { 
    	 getMapTile(4, 2).setInteractScript(new ExitMushroomHouseScript());
    } 
    @Override
    public MusicState getMusicState() {
        return MusicState.MUSHROOM_HOME;
    }
}
