package Screens;

import Engine.*;
import InventoryModifier.InventoryGrid;
import Level.PlayerInventory;
import javax.swing.JPanel;

// This class is for the win level screen
//@SuppressWarnings("serial")
public class InventoryScreen extends JPanel {
	protected PlayLevelScreen playLevelScreen;
	protected KeyLocker keyLocker = new KeyLocker();
	public static boolean ItemWasPlaced = false;
	public static int SlotToEmpty = 0;
	private PlayerInventory playerInventory;
	private InventoryGrid inventoryGrid;
	protected Key Inventory_Key = Key.I;
	protected boolean inventoryIsOpen = false;
	public static boolean inventoryOpen = false; //The boolean above is used for the keylocker, this one talks to the gamepanel

	public InventoryScreen(PlayLevelScreen playLevelScreen, PlayerInventory playerInventory) {
		this.playLevelScreen = playLevelScreen;
		this.playerInventory = playerInventory;
		this.inventoryGrid = new InventoryGrid(playerInventory);
		initialize();
	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}

	public void initialize() {
		inventoryOpen = true;
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
			inventoryOpen = false;
			playerInventory = inventoryGrid.getPlayerInventory();
			playLevelScreen.resumeLevel();
		}
		if(GamePanel.clickToProcess) {
			
		}
		if(ItemWasPlaced) {
			
			playerInventory.removeItem(SlotToEmpty);
			ItemWasPlaced = false;
			inventoryOpen = false;
			inventoryIsOpen = false;
			playerInventory = inventoryGrid.getPlayerInventory();
			playLevelScreen.resumeLevel();	
			
		}

	}

	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawInventory(playerInventory.getInventoryArray());
//		graphicsHandler.highlightSlot(10);
		inventoryGrid.draw(graphicsHandler);
	}
}