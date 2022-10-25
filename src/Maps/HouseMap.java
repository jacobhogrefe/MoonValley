package Maps;

import java.util.ArrayList;

import GameObject.Furniture;
import HouseCustomization.FurnitureRegistry;
import Level.Collectible;
import Level.Map;
import Level.MusicState;
import Scripts.TestMap.ExitHouseScript;
import Tilesets.HouseTileset;

// Represents a test map to be used in a level
public class HouseMap extends Map {

	public HouseMap() {
		super("house_map.txt", new HouseTileset());
		this.playerStartPosition = getMapTile(12, 10).getLocation();
	}

	@Override
	public void loadScripts() {
		getMapTile(8, 11).setInteractScript(new ExitHouseScript());
	}
	
    public ArrayList<Furniture> loadFurniture() {
        ArrayList<Furniture> furniture = new ArrayList<>();
  //      furniture.add(FurnitureRegistry.furnitureregistry.catalog.get(0));
      
      //  furniture.add(new Furniture("RetroJukeBox.png", getMapTile(5,5).getLocation(), "Retro Jukebox", 0));
      //  furniture.add(new Furniture("RetroJukeBox.png", getMapTile(5,6).getLocation(), "Retro Jukebox", 0));
     
        return furniture;
    }
	@Override
	public MusicState getMusicState() {
		return MusicState.START_HOME;
	}

}
