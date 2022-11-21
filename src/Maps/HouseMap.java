package Maps;

import java.awt.Color;
import java.util.ArrayList;

import Engine.Config;
import Engine.GraphicsHandler;
import GameObject.Furniture;
import Level.Map;
import Level.MusicState;
import Level.Trigger;
import Scripts.TestMap.CrashScript;
import Scripts.TestMap.ExitHouseScript;
import Tilesets.HouseTileset;

// Represents a test map to be used in a level
public class HouseMap extends Map {

	public HouseMap() {
		super("house_map.txt", new HouseTileset(),7);
		this.playerStartPosition = getMapTile(11, 3).getLocation();
	}

	@Override
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = super.loadTriggers();
//        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
//        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));

		triggers.add(new Trigger(500, 130, 100, 100, new CrashScript(), "hasCrash"));
		return triggers;
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
		graphicsHandler.drawFilledRectangle(0, 0, Config.GAME_WINDOW_WIDTH, Config.GAME_WINDOW_HEIGHT,
				new Color(0, 0, 0, 0));
	}

}
