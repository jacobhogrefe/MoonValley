package Maps;

import java.awt.Color;
import java.util.ArrayList;

import Engine.Config;
import Engine.GraphicsHandler;
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
     
        return furniture;
    }
	@Override
	public MusicState getMusicState() {
		return MusicState.START_HOME;
	}
	
	public void Dayinhouse(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawFilledRectangle(0, 0, Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT, new Color(0, 0, 0, 0));	
	}

}
