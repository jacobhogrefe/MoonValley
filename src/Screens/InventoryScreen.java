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
    	this.itemNames.add("Empty Slot");
		this.itemNames.add("Cowboy Hat");
		// END ITEM NAMES

		// -------------------------------------------

		// START ITEM IMAGES
		Image emptySlot = ImageLoader.load("InventoryTileset.png").getSubimage(17, 17, 16, 16).getScaledInstance(48, 48,
				Image.SCALE_SMOOTH);
		this.itemImages.add(emptySlot);
		Image cowboyHat = ImageLoader.load("InventoryTileset.png").getSubimage(68, 0, 16, 16).getScaledInstance(48, 48,
				Image.SCALE_SMOOTH);
		this.itemImages.add(cowboyHat);

		// END ITEM IMAGES

		// -------------------------------------------

		// START ITEM DESCRIPTIONS
		this.itemDescriptions.add("Just a plain old empty slot!");
		this.itemDescriptions.add("Ain't 'nuff room in this here valley for the two of us, partner...");
		// END ITEM DECRIPTIONS
		
	
		
		
		
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