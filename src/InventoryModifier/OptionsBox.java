package InventoryModifier;

import java.awt.Color;
import java.awt.Point;
import Engine.GraphicsHandler;


//Takes in itemNumber and draws a box containing the item info/options

public class OptionsBox{
	
	int boxHeight = 150;
	int boxWidth = 300;
	int itemNumber;
	//corner of box is at 240,410 (set in graphicshandler)
	
	public OptionsBox(int itemNumber) {
		
		this.itemNumber = itemNumber;
		
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