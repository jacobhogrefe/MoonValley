package InventoryModifier;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import Engine.GraphicsHandler;
import Registry.ItemRegistry;


//Takes in itemNumber and draws a box containing the item info/options

public class OptionsBox{
	
	int boxHeight = 150;
	int boxWidth = 300;
	int itemNumber;
	int slotNumber;
	Image itemImage;
	String itemDescription;
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	String itemName;
	//corner of box is at 240,410 (set in graphicshandler)
	
	public OptionsBox(int itemNumber, int slotNumber) {
		this.itemNumber = itemNumber;
		this.slotNumber = slotNumber;
		itemImage = ItemRegistry.singleton.items.get(itemNumber).texture;
		itemDescription = ItemRegistry.singleton.items.get(itemNumber).description;
		itemName = ItemRegistry.singleton.items.get(itemNumber).name;
		
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Image getItemImage() {
		return itemImage;
	}

	public void setItemImage(Image itemImage) {
		this.itemImage = itemImage;
	}

	public int getBoxHeight() {
		return boxHeight;
	}

	public void setBoxHeight(int boxHeight) {
		this.boxHeight = boxHeight;
	}

	public int getBoxWidth() {
		return boxWidth;
	}

	public void setBoxWidth(int boxWidth) {
		this.boxWidth = boxWidth;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	

}