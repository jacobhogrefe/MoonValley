package Level;
/*
 * launched by a constructor for screencoordinator. To modify the player
 * inventory, methods must be called by the PlayLevelScreen (or whatever other
 * screens we might add that manage the main game).
 */

public class PlayerInventory {

	private int[] inventoryArray = new int[55];
	private int currentFilledSlots;
	private int currentEmptySlots = 55 - currentFilledSlots;
	private int firstEmptySlot;

	public PlayerInventory() {
		
		this.inventoryArray = inventoryArray;
		for (int i = 0; i < 55; i++) {
			inventoryArray[i] = 0;
		}

		this.currentEmptySlots = 54;
		this.firstEmptySlot = 0;
		

	}

	public int getFirstEmptySlot() {
		return firstEmptySlot;
	}

	public void setFirstEmptySlot(int firstEmptySlot) {
		this.firstEmptySlot = firstEmptySlot;
	}

	public int[] getInventoryArray() {
		return inventoryArray;
	}

	public void setInventoryArray(int[] inventoryArray) {
		this.inventoryArray = inventoryArray;
	}

	public int getCurrentFilledSlots() {
		return currentFilledSlots;
	}

	public void setCurrentFilledSlots(int currentFilledSlots) {
		this.currentFilledSlots = currentFilledSlots;
	}

	public int getCurrentEmptySlots() {
		return currentEmptySlots;
	}

// add an item, checks to make sure inventory is item, otherwise does nothing which prevents breaking game
	public void addItem(int itemNumber) {

		if (currentEmptySlots != 0) {
			inventoryArray[firstEmptySlot] = itemNumber;
			currentFilledSlots++;
			newFirstEmptySlot();
		} else {
		}
	}

//removes item from inventory
	public void removeItem(int slotNumber) {

		inventoryArray[slotNumber] = 0;
		currentFilledSlots--;
		newFirstEmptySlot();

	}

	// swaps the location of two items. For the sake of the game logic, an empty
	// slot is also considered an item
	public void moveItem(int fromSlot, int toSlot) {

		int startingSlot = inventoryArray[fromSlot];
		int finalSlot = inventoryArray[toSlot];

		inventoryArray[toSlot] = inventoryArray[startingSlot];
		inventoryArray[fromSlot] = inventoryArray[finalSlot];
		newFirstEmptySlot();
	}

	// searches the inventory for a specified item and returns true if found
	public boolean containsItem(int itemNumber) {

		boolean foundItem = false;

		for (int i = 0; i < 55; i++) {
			if (inventoryArray[i] == itemNumber) {
				foundItem = true;
			}
		}

		return foundItem;

	}

	// finds the first empty slot in inventory and sets firstEmptySlot - call this
	// after adding/removing/moving items
	public void newFirstEmptySlot() {
		boolean foundSlot = false;
		int i = 0;
		while (!foundSlot) {
			if (inventoryArray[i] == 0) {
				firstEmptySlot = i;
				foundSlot = true;
			} else {
				i++;
			}
		}

	}

}