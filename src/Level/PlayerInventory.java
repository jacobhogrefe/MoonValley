package Level;
/*
 * launched by a constructor for screencoordinator. To modify the player
 * inventory, methods must be called by the PlayLevelScreen (or whatever other
 * screens we might add that manage the main game).
 */

import java.util.Arrays;

import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;

public class PlayerInventory {

	private int[] inventoryArray = new int[55];

	public PlayerInventory() {
		for (int i = 0; i < 55; i++) {
			inventoryArray[i] = 0;
		}
	}

	public int getFirstEmptySlot() {
		for (int i = 0; i < this.inventoryArray.length; i++) {
			if (this.inventoryArray[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	public int[] getInventoryArray() {
		return inventoryArray;
	}

	public void setInventoryArray(int[] inventoryArray) {
		this.inventoryArray = inventoryArray;
	}

	public int getCurrentFilledSlots() {
		return (int) Arrays.stream(this.inventoryArray).filter(i -> i != 0).count();
	}

	public int getCurrentEmptySlots() {
		return (int) Arrays.stream(this.inventoryArray).filter(i -> i == 0).count();
	}

	/**
	 * add an item.
	 * returns true if it was added, false if the inventory was full.
	 */
	public boolean addItem(int itemNumber) {
		if (this.getCurrentEmptySlots() == 0) {
			return false;
		} else {
			inventoryArray[this.getFirstEmptySlot()] = itemNumber;
			return true;
		}
	}
	
	public int getItemInSlot(int slotNumber) {
		return inventoryArray[slotNumber];
	}

	/**
	 * add an item.
	 * returns true if it was added, false if the inventory was full.
	 */
	public boolean addItem(Item item) {
		return this.addItem(item.getItemNumber());
	}

	//removes item from inventory
	public void removeItem(int slotNumber) {
		inventoryArray[slotNumber] = 0;
	}

	// swaps the location of two items. For the sake of the game logic, an empty
	// slot is also considered an item
	public void moveItem(int slotA, int slotB) {
		// https://en.wikipedia.org/wiki/XOR_swap_algorithm
		inventoryArray[slotA] ^= inventoryArray[slotB];
		inventoryArray[slotB] ^= inventoryArray[slotA];
		inventoryArray[slotA] ^= inventoryArray[slotB];
	}

	// searches the inventory for a specified item and returns true if found
	public boolean containsItem(int itemNumber) {
		return Arrays.stream(this.inventoryArray).filter(i -> i == itemNumber).findAny().isPresent();
	}

	// searches the inventory for a specified item and returns true if found
	public boolean containsItem(Item item) {
		return this.containsItem(item.getItemNumber());
	}
}