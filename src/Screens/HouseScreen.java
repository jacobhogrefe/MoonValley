package Screens;

import java.awt.event.KeyListener;
import java.util.Stack;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.ScreenCoordinator;
import Level.*;
import Maps.TestMap;
import Players.Cat;
import Utils.Direction;
import Utils.Point;
import Level.PlayerInventory;

// This class is for when the RPG game is actually being played
public class HouseScreen extends Screen {
	protected ScreenCoordinator screenCoordinator;
	protected Map map;
	protected Player player;
	protected PlayLevelScreenState playLevelScreenState;
	protected WinScreen winScreen;
	protected InventoryScreen inventoryScreen;
	protected FlagManager flagManager;
	protected KeyLocker keyLocker = new KeyLocker();
	protected boolean isInventoryOpen = false;
	protected PlayerInventory playerInventory = new PlayerInventory();
	

	protected Key Inventory_Key = Key.I;

	public HouseScreen(ScreenCoordinator screenCoordinator) {
		this.screenCoordinator = screenCoordinator;
	}

	public void initialize() {
		// setup state
		flagManager = new FlagManager();
//		flagManager.addFlag("hasLostBall", false);
//		flagManager.addFlag("hasTalkedToWalrus", false);
//		flagManager.addFlag("hasTalkedToDinosaur", false);
//		flagManager.addFlag("hasFoundBall", false);
//		flagManager.addFlag("itemCollected", false);
		

		// define/setup map
		this.map = new TestMap();
		map.reset();
		map.setFlagManager(flagManager);

		// setup player
		this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
		this.player.setMap(map);
		Point playerStartPosition = map.getPlayerStartPosition();
		this.player.setLocation(playerStartPosition.x, playerStartPosition.y);
		this.playLevelScreenState = PlayLevelScreenState.RUNNING;
		this.player.setFacingDirection(Direction.LEFT);

		// let pieces of map know which button to listen for as the "interact" button
		map.getTextbox().setInteractKey(player.getInteractKey());

		// setup map scripts to have references to the map and player
//		for (MapTile mapTile : map.getMapTiles()) {
//			if (mapTile.getInteractScript() != null) {
//				mapTile.getInteractScript().setMap(map);
//				mapTile.getInteractScript().setPlayer(player);
//			}
//		}
//		for (NPC npc : map.getNPCs()) {
//			if (npc.getInteractScript() != null) {
//				npc.getInteractScript().setMap(map);
//				npc.getInteractScript().setPlayer(player);
//			}
//		}
//		for (EnhancedMapTile enhancedMapTile : map.getEnhancedMapTiles()) {
//			if (enhancedMapTile.getInteractScript() != null) {
//				enhancedMapTile.getInteractScript().setMap(map);
//				enhancedMapTile.getInteractScript().setPlayer(player);
//			}
//		}
//		for (Trigger trigger : map.getTriggers()) {
//			if (trigger.getTriggerScript() != null) {
//				trigger.getTriggerScript().setMap(map);
//				trigger.getTriggerScript().setPlayer(player);
//			}
//		}
//		for (Collectible collectibles : map.getCollectables()) {
//            if (collectibles.getInteractScript() != null) {
//                collectibles.getInteractScript().setMap(map);
//                collectibles.getInteractScript().setPlayer(player);
//            }
//        }
//		
//		winScreen = new WinScreen(this);
//		inventoryScreen = new InventoryScreen(this, playerInventory);
	}



	public void update() {
		// based on screen state, perform specific actions
		switch (playLevelScreenState) {
		// if level is "running" update player and map to keep game logic for the
		// platformer level going
		case RUNNING:
			player.update();
			map.update(player);
			break;
		// if level has been completed, bring up level cleared screen
		case LEVEL_COMPLETED:
			winScreen.update();
			break;
		case INVENTORY_OPEN:
			inventoryScreen.update();
			break;
		}

		// if flag is set at any point during gameplay, game is "won"
		if (map.getFlagManager().isFlagSet("hasFoundBall")) {
			playLevelScreenState = PlayLevelScreenState.LEVEL_COMPLETED;
		}

		if (Keyboard.isKeyDown(Inventory_Key) && !keyLocker.isKeyLocked(Inventory_Key)) {
			playLevelScreenState = PlayLevelScreenState.INVENTORY_OPEN;
		}
		if(map.getFlagManager().isFlagSet("itemCollected")) {
			Stack<Integer> itemsReceived = new Stack<Integer>();
			
			itemsReceived = map.takeItems();
			
			while(!itemsReceived.empty()) {
				playerInventory.addItem(itemsReceived.pop());
			}
			
			inventoryScreen.setPlayerInventory(playerInventory);
			map.getFlagManager().unsetFlag("itemCollected");
			
		}


	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}

	public void draw(GraphicsHandler graphicsHandler) {
		// based on screen state, draw appropriate graphics
		switch (playLevelScreenState) {
		case RUNNING:
			playerInventory = inventoryScreen.getPlayerInventory();
			map.draw(player, graphicsHandler);
			break;
		case LEVEL_COMPLETED:
			winScreen.draw(graphicsHandler);
			break;
		case INVENTORY_OPEN:
			inventoryScreen.draw(graphicsHandler);
			break;
		}
	}

	public PlayLevelScreenState getPlayLevelScreenState() {
		return playLevelScreenState;
	}
	public boolean inventoryIsOpen(){
		if (isInventoryOpen) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void closeInventory() {
		isInventoryOpen = false;
	}
	
	public void resumeLevel() {
		playLevelScreenState = PlayLevelScreenState.RUNNING;
	}

	public void resetLevel() {
		initialize();
	}

	// This enum represents the different states this screen can be in
	private enum PlayLevelScreenState {
		RUNNING, LEVEL_COMPLETED, INVENTORY_OPEN
	}
}