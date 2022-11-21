package Level;
/*
 * launched by a constructor for screencoordinator. To modify the player
 * inventory, methods must be called by the PlayLevelScreen (or whatever other
 * screens we might add that manage the main game).
 */


import Registry.ItemRegistry.Item;

public class PlayerInventory {
	public static boolean isInventoryFull = false;
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

		// no empty slot
		return -1;
	}

	public int[] getInventoryArray() {
		return inventoryArray;
	}

	public void setInventoryArray(int[] inventoryArray) {
		this.inventoryArray = inventoryArray;
	}

	public int getCurrentFilledSlots() {
		int filled = 0;

		for (int i = 0; i < this.inventoryArray.length; i++) {
			if (this.inventoryArray[i] != 0) {
				filled = filled + 1;
			}
		}

		return filled;
	}

	public int getCurrentEmptySlots() {
		int empty = 0;

		for (int i = 0; i < this.inventoryArray.length; i++) {
			if (this.inventoryArray[i] == 0) {
				empty = empty + 1;
			}
		}

		return empty;
	}

	/**
	 * add an item. returns true if it was added, false if the inventory was full.
	 */
	public boolean addItem(int itemNumber) {
		if (this.getCurrentEmptySlots() == 0) {
			isInventoryFull = true;

			return false;
		} else {
			inventoryArray[this.getFirstEmptySlot()] = itemNumber;

			if (this.getCurrentEmptySlots() == 0) {
				isInventoryFull = true;
			}
			
			return true;
		}
	}

	public int getItemInSlot(int slotNumber) {
		return inventoryArray[slotNumber];
	}

	/**
	 * add an item. returns true if it was added, false if the inventory was full.
	 */
	public boolean addItem(Item item) {
		return this.addItem(item.getItemNumber());
	}

	// removes item from inventory
	public void removeItem(int itemNumber) {
		isInventoryFull = false;
		inventoryArray[itemNumber] = 0;
	}

	// swaps the location of two items. For the sake of the game logic, an empty
	// slot is also considered an item. The if else structure prevents items from
	// being deleted if a non-inventory slot is clicked during move
	public void moveItem(int slotA, int slotB) {
		if (slotA != slotB) {
			int itemA = inventoryArray[slotA];
			int itemB = inventoryArray[slotB];

			inventoryArray[slotA] = itemB;
			inventoryArray[slotB] = itemA;
		} else {
			// do nothing
		}
	}

	// searches the inventory for a specified item and returns true if found
	public boolean containsItem(int itemNumber) {
		for (int i = 0; i < this.inventoryArray.length; i++) {
			if (this.inventoryArray[i] == itemNumber) {
				return true;
			}
		}
		return false;
	}

	//Gets the index of where a perticular itemNumber is in the inventory
	public int getItemSlotNumber(int itemNumber) {
		for (int i = 0; i < this.inventoryArray.length; i++) {
			if (this.inventoryArray[i] == itemNumber) {
				return i;
			}
		}
		return 0;
	}

	// searches the inventory for a specified item and returns true if found
	public boolean containsItem(Item item) {
		return this.containsItem(item.getItemNumber());
	}
}