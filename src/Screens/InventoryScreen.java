package Screens;

import Engine.*;
import InventoryModifier.InventoryGrid;
import Level.PlayerInventory;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

// This class is for the win level screen
@SuppressWarnings("serial")
public class InventoryScreen extends JPanel {
	protected PlayLevelScreen playLevelScreen;
	protected KeyLocker keyLocker = new KeyLocker();
	private PlayerInventory playerInventory;
	private InventoryGrid inventoryGrid = new InventoryGrid();

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

	public void initialize() {
		
	}
	
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
		inventoryGrid.draw(graphicsHandler);
	}
}