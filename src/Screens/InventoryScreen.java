package Screens;

import Engine.*;
import Level.PlayerInventory;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.util.ArrayList;

// This class is for the win level screen
public class InventoryScreen extends Screen {
	protected ArrayList<String> itemNames;
	protected ArrayList<Image> itemImages;
	protected ArrayList<String> itemDescriptions;
	protected PlayLevelScreen playLevelScreen;
	protected KeyLocker keyLocker = new KeyLocker();
	private GraphicsHandler graphicsHandler;
	private PlayerInventory playerInventory;

	protected Key Inventory_Key = Key.I;
	protected boolean inventoryIsOpen = false;

	public InventoryScreen(PlayLevelScreen playLevelScreen, PlayerInventory playerInventory) {
		this.playLevelScreen = playLevelScreen;
		this.playerInventory = playerInventory;
		this.itemNames = new ArrayList<String>();
		this.itemDescriptions = new ArrayList<String>();
		this.itemImages = new ArrayList<Image>();
		initialize();
	}

	@Override
	public void initialize() {

		// START ITEM NAMES
		this.itemNames.add("Empty Slot");// index 0
		this.itemNames.add("Cowboy Hat");// index 1
		this.itemNames.add("Yoshi Coin");// index 2
		// END ITEM NAMES

		// -------------------------------------------

		// START ITEM IMAGES

		// HOW TO USE: getSubimage(x axis, y axis, image width, image height, Increase
		// or decrease x and y axis by increments of 17 to get to the square you drew
		// your image on, if anyone is less lazy than me and wants to recode this so we
		// only need to increase/decrease by 1 per square, that would also be cool
		Image emptySlot = ImageLoader.load("InventoryTileset.png").getSubimage(17, 17, 16, 16).getScaledInstance(48, 48,
				Image.SCALE_SMOOTH);
		this.itemImages.add(emptySlot);// index 0
		Image cowboyHat = ImageLoader.load("InventoryTileset.png").getSubimage(68, 0, 16, 16).getScaledInstance(48, 48,
				Image.SCALE_SMOOTH);
		this.itemImages.add(cowboyHat);// index 1
		Image yoshiCoin = ImageLoader.load("InventoryTileset.png").getSubimage(85, 0, 16, 16).getScaledInstance(48, 48,
				Image.SCALE_SMOOTH);
		this.itemImages.add(yoshiCoin);// index 2

		// END ITEM IMAGES

		// -------------------------------------------

		// START ITEM DESCRIPTIONS
		this.itemDescriptions.add("Just a plain old empty slot!"); // index 0
		this.itemDescriptions.add("Ain't 'nuff room in this here valley for the two of us, partner...");// index 1
		this.itemDescriptions.add("A trademarked coin that we used anyways");// index 2
		// END ITEM DECRIPTIONS

	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
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
		graphicsHandler.drawInventory(itemImages, playerInventory.getInventoryArray());
	}
}