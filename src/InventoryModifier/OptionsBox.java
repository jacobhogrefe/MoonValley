package InventoryModifier;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import Engine.GraphicsHandler;
import Registry.ItemRegistry;

//Takes in itemNumber and draws a box containing the item info/options

public class OptionsBox {

	int boxHeight = 150;
	int boxWidth = 300;
	int itemNumber;
	int slotNumber;
	Image itemImage;
	String itemDescription;
	// If the item description is over 40 charatcers, the optionsbox breaks it in
	// to substrings and graphicshandler will ask for those instead to draw differently
	String half1;

	String half2;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	String itemName;
	// corner of box is at 240,410 (set in graphicshandler)

	public OptionsBox(int itemNumber, int slotNumber) {
		this.itemNumber = itemNumber;
		this.slotNumber = slotNumber;
		itemImage = ItemRegistry.singleton.items.get(itemNumber).texture;

		if (ItemRegistry.singleton.items.get(itemNumber).description.length() > 45) {
			String tempString = ItemRegistry.singleton.items.get(itemNumber).description;

			String half1 = (String)tempString.subSequence(0, 40);
			String half2 = tempString.substring(40, tempString.length());
			
			
			this.half1 = half1;
			this.half2 = half2;
			itemDescription = tempString;

		} else {
			itemDescription = ItemRegistry.singleton.items.get(itemNumber).description;
		}
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
	public String getHalf1() {
		return half1;
	}

	public void setHalf1(String half1) {
		this.half1 = half1;
	}

	public String getHalf2() {
		return half2;
	}

	public void setHalf2(String half2) {
		this.half2 = half2;
	}


}