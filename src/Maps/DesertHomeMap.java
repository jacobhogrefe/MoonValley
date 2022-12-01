package Maps;

import java.awt.Color;
import java.util.ArrayList;

import Engine.Config;
import Engine.GraphicsHandler;
import GameObject.Furniture;
import Level.Map;
import Level.MusicState;
import Level.Trigger;
import Scripts.DesertMap.ExitDesertHomeScript;
import Tilesets.HouseTileset;

// Represents a test map to be used in a level
public class DesertHomeMap extends Map {

	public DesertHomeMap() {
		super("house_map.txt", new HouseTileset(),13);
		this.playerStartPosition = getMapTile(11, 3).getLocation();
	}

	@Override
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = super.loadTriggers();

		return triggers;
	}

	@Override
	public void loadScripts() {
		getMapTile(8, 11).setInteractScript(new ExitDesertHomeScript());
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
		graphicsHandler.drawFilledRectangle(0, 0, Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT,
				new Color(0, 0, 0, 0));
	}

}