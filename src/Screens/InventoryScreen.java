package Screens;

import Engine.*;
import Level.PlayerInventory;

import java.awt.*;
import java.util.ArrayList;

// This class is for the win level screen
public class InventoryScreen extends Screen {
	protected PlayLevelScreen playLevelScreen;
	protected KeyLocker keyLocker = new KeyLocker();
	private PlayerInventory playerInventory;

	protected Key Inventory_Key = Key.I;
	protected boolean inventoryIsOpen = false;

	public InventoryScreen(PlayLevelScreen playLevelScreen, PlayerInventory playerInventory) {
		this.playLevelScreen = playLevelScreen;
		this.playerInventory = playerInventory;
		initialize();
	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}

	@Override
	public void initialize() {
		
	}
	
	@Override
	public void update() {
		if (Keyboard.isKeyDown(Inventory_Key) && !keyLocker.isKeyLocked(Inventory_Key)) {
			keyLocker.lockKey(Inventory_Key);
			inventoryIsOpen = !inventoryIsOpen;
		}

		if (Keyboard.isKeyUp(Inventory_Key)) {
			keyLocker.unlockKey(Inventory_Key);
		}

		if (!inventoryIsOpen) {
			playLevelScreen.resumeLevel();
		}

	}

	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawInventory(playerInventory.getInventoryArray());
	}
}