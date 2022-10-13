package InventoryModifier;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Engine.GamePanel;
import Engine.GraphicsHandler;
import Level.PlayerInventory;
import Utils.Stopwatch;

//A grid that interprets mouse clicks to determine selected inventory slots, moved items etc. 
//Draw method contains the draw order for inventory components and inventory logic is executed based on clicks

public class InventoryGrid {

	// variables used for selecting slot, prior to the move item logic being
	// initiated

	private Point[] slotNumberCorner = new Point[55];
	private Point frameCorner = new Point(624, 337);
	private int previousSelectedSlot = 0;
	private int selectedSlot;
	private int selectedItem;
	private PlayerInventory playerInventory;

	// start variables for moving items
	private int arrowSlot;
	private int targetSlot;

	// end variables for moving items

	// To keep all the graphicshandler stuff in the draw method, I modify these
	// booleans in the assignLastClickSlot() method and then check them in the draw
	// method
	private boolean shouldHighlightMove = false;
	private boolean shouldHighlightRemove = false;
	private boolean itemIsBeingMoved;
	private boolean goodClick = false;

	// private boolean reported = false; //uncomment for testing (along with other
	// commented things below)

	public InventoryGrid(PlayerInventory playerInventory) {
		// assigning corner points to slots
		this.playerInventory = playerInventory;
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 11; k++) {
				slotNumberCorner[(j * 11) + k] = new Point((128 + (k * 48)), (168 + (j * 48)));
			}
		}

	}

	// a constructor without an inventory, used by the graphicshandler to utilize
	// the slot corner information within this class
	public InventoryGrid() {
		// assigning corner points to slots
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 11; k++) {
				slotNumberCorner[(j * 11) + k] = new Point((128 + (k * 48)), (168 + (j * 48)));
			}
		}

	}

	// Returns slot corner which was found by the nested for statements in the
	// constructor, images are drawn from this point at 48x48 pixels
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
	public void assignLastClickSlot(Point lastClick) { // Doesn't just check slots, checks buttons too

		int clickedSlot;
		int clickedX = (int) lastClick.getX();
		int clickedY = (int) lastClick.getY();

		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 11; k++) {

				int index = ((j * 11) + k);
				int xLowerBound = (int) slotNumberCorner[index].getX();
				int xUpperBound = (int) slotNumberCorner[index].getX() + 48;
				int yLowerBound = ((int) slotNumberCorner[index].getY());
				int yUpperBound = (int) slotNumberCorner[index].getY() + 48;

				// checking if a slot was clicked
				if (clickedX > xLowerBound && clickedX < xUpperBound && clickedY > yLowerBound
						&& clickedY < yUpperBound) {
					clickedSlot = ((j * 11) + k);
					previousSelectedSlot = selectedSlot;
					selectedSlot = clickedSlot;
					goodClick = true;

					// if an item move is not underway, updates selected item
					if (!shouldHighlightMove && !itemIsBeingMoved) {
						selectedItem = playerInventory.getItemInSlot(clickedSlot);

					}

				}

				else {
					goodClick = false;
					shouldHighlightMove = false;
					itemIsBeingMoved = false;
				}
			}

		}

		// reported = false; //uncomment for troubleshooting

		// If an item is in the currently selected slot, checks if the MOVE button has
		// been clicked
		// button X (lowerBound,upperBound) = (250,310)
		// button Y (lowerBound, upperBound) = (520, 608)
		if (!shouldHighlightMove && selectedItem != 0 && clickedX > 250 && clickedX < 310 && clickedY > 530
				&& clickedY < 618) {
			shouldHighlightMove = true;
			itemIsBeingMoved = true;
			goodClick = true;

		}




		// If an item is in the currently selected slot, checks if the REMOVE button has
		// been clicked
		// button X (lowerBound,upperBound) = (325,413)
		// button Y (lowerBound, upperBound) = (520, 608)
		if (!shouldHighlightMove && selectedItem != 0 && clickedX > 325 && clickedX < 413 && clickedY > 530
				&& clickedY < 618) {
			shouldHighlightRemove = true;
		}
	

	}
	
	public void troubleshoot() {
		System.out.println("Selected slot: "+selectedSlot);
		System.out.println("arrow slot: "+arrowSlot);
		System.out.println("target slot: "+targetSlot);
		System.out.println("goodClick: "+ goodClick);
		System.out.println("itemIsBeingMoved: "+ itemIsBeingMoved);
		System.out.println("shouldHighlightMove "+shouldHighlightMove);
		System.out.println("shouldHighlightRemove "+shouldHighlightRemove);
		System.out.println(" ");
		System.out.println(" ");
		
	}


	// Really a lot more than a draw method, does most of the work
	// calling the right methods to execute item moves after clicks are interpreted
	// So it is not purely a draw method, but it is far easier to update the
	// inventory logic at the same time as the graphics, and hopefully easier to
	// read
	public void draw(GraphicsHandler graphicsHandler) {

		if (GamePanel.clickToProcess && !shouldHighlightMove) {
			assignLastClickSlot(GamePanel.lastClick);
			GamePanel.clickToProcess = false;
		//	goodClick = false;
		}

		graphicsHandler.highlightSlot(selectedSlot);
		OptionsBox optionsBox = new OptionsBox(selectedItem, selectedSlot);
		graphicsHandler.drawOptionsBox(optionsBox);

		// if there is an item in the slot, draw the move and remove buttons
		if (selectedItem != 0) {
			graphicsHandler.drawOptionsBoxButtons(optionsBox);
		}

		// if the move button has been clicked (assignClick logic only flags
		// shouldHighlightMove true if an item is in slot)
		if (shouldHighlightMove) {
			graphicsHandler.highlightMove();
			arrowSlot = selectedSlot;
			itemIsBeingMoved = true;
		//	goodClick = false;
		}

		// This one speaks for itself
		if (shouldHighlightRemove) {
			graphicsHandler.highlightRemoveButton();
			playerInventory.removeItem(selectedSlot);
			graphicsHandler.unhighlightRemoveButton();
			shouldHighlightRemove = false;
			goodClick = false;

		}

		// if another click has occurred, and booleans indicate a move is taking place,
		// move item
		if (GamePanel.clickToProcess && itemIsBeingMoved && shouldHighlightMove) {
			
			troubleshoot();

			if (goodClick) {
				assignLastClickSlot(GamePanel.lastClick);
				targetSlot = selectedSlot; // unnecessary variable but more readable
				playerInventory.moveItem(arrowSlot, targetSlot);
				System.out.println("Move Excuted. Arrow: "+arrowSlot+"Target: "+targetSlot);
				shouldHighlightMove = false;
				itemIsBeingMoved = false;
				GamePanel.clickToProcess = false;
				goodClick = false;
			}

			else {
				shouldHighlightMove = false;
				itemIsBeingMoved = false;
			}
		}
		
		//goodClick = false;

		// if(reported == false) {
		// System.out.println(selectedSlot); //uncomment for troubleshooting
		// reported = true;
		// }
	}

	public PlayerInventory getPlayerInventory() {
		return playerInventory;
	}

	public void setPlayerInventory(PlayerInventory playerInventory) {
		this.playerInventory = playerInventory;
	}

}
