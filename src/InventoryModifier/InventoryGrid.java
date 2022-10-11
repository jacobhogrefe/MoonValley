package InventoryModifier;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Level.PlayerInventory;

//A grid that returns the corner of square taken up on the screen for each inventory slot on the screen

public class InventoryGrid {

	private Point[] slotNumberCorner = new Point[55];
	private Point frameCorner = new Point(624, 337);
	private int lastClickedSlot = 0;
	private int selectedSlot;
	private int selectedItem;
	private PlayerInventory playerInventory;
	//private boolean reported = false; //uncomment for testing (along with other commented things below)

	public InventoryGrid(PlayerInventory playerInventory) {
		// assigning corner points to slots
		this.playerInventory = playerInventory;
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 11; k++) {
				slotNumberCorner[(j * 11) + k] = new Point((128 + (k * 48)), (168 + (j * 48)));
			}
		}

	}
	
	//a constructor without an inventory, used by the graphicshandler to utilize the slot corner information within this class
	public InventoryGrid() {
		// assigning corner points to slots
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 11; k++) {
				slotNumberCorner[(j * 11) + k] = new Point((128 + (k * 48)), (168 + (j * 48)));
			}
		}

	}
	//Returns slot corner which was found by the nested for statements in the constructor, images are drawn from this point at 48x48 pixels
	public Point getSlotCorner(int slot) {
		return slotNumberCorner[slot];
	}

	/*
	 * This method felt like a challenge problem on an exam...It works by checking
	 * if both the x and y of the clicked point (lastClick) are within the bounds of
	 * the x and y axis of a given point on the screen. TL;DR: Finds what slot got
	 * clicked (if any). I would get partial credit because a more efficient
	 * algorithm certainly does exist.
	 */
	public void assignLastClickSlot(Point lastClick) {

		int clickedSlot;

		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 11; k++) {

				int index = ((j * 11) + k);
				int clickedX = (int) lastClick.getX();
				int clickedY = (int) lastClick.getY();
				int xLowerBound = (int) slotNumberCorner[index].getX();
				int xUpperBound = (int) slotNumberCorner[index].getX() + 48;
				int yLowerBound = ((int) slotNumberCorner[index].getY());
				int yUpperBound = (int) slotNumberCorner[index].getY() + 48;

				if (clickedX > xLowerBound && clickedX < xUpperBound && clickedY > yLowerBound
						&& clickedY < yUpperBound) {
					clickedSlot = ((j * 11) + k);
					selectedSlot = clickedSlot;
					selectedItem = playerInventory.getItemInSlot(clickedSlot);
					System.out.println("You clicked slot: " + index);
					System.out.println("Slot position: " + (int) slotNumberCorner[index].getX() + ","
							+ (int) slotNumberCorner[index].getY());
					System.out.println("Click Position: " + lastClick.getX() + "," + lastClick.getY());
				//	reported = false;	//uncomment for troubleshooting

				} else {
					System.out.println("You clicked a non-inventory slot");
				}
			}
		}
	}

	public void draw(GraphicsHandler graphicsHandler) {
		if (GamePanel.clickToProcess) {
			assignLastClickSlot(GamePanel.lastClick);
			GamePanel.clickToProcess = false;
			
		}
		OptionsBox optionsBox = new OptionsBox(selectedItem,selectedSlot);
		graphicsHandler.highlightSlot(selectedSlot);
		graphicsHandler.drawOptionsBox(optionsBox);
		
		
	//	if(reported == false) {
	//	System.out.println(selectedSlot); //uncomment for troubleshooting
	//	reported = true;
	//	}
	}

}
