package InventoryModifier;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Engine.GraphicsHandler;

//A grid that returns the corner of square taken up on the screen for each inventory slot on the screen

public class InventoryGrid {

	private Point[] slotNumberCorner = new Point[55];
	private Point frameCorner = new Point(624, 337);
	private int hoveredSlot = 0;

	public InventoryGrid() {
		// assigning corner points to slots
		
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 11; k++) {
					slotNumberCorner[(j*10)+k] = new Point((128 - (k * 48)), (168 + (j * 48)));
				}
			}
		

	}

	public Point getSlotCorner(int slot) {
		return slotNumberCorner[slot];
	}
	
	public int getHoveredSlot() {
		return hoveredSlot;
	}

	public void setHoveredSlot(int hoveredSlot) {
		this.hoveredSlot = hoveredSlot;
	}

	public void draw(GraphicsHandler graphicsHandler) {
		
		graphicsHandler.highlightSlot(hoveredSlot);
	}




}
