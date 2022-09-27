//Contains all information about the items in the game. Each item will have an int as a "serial number" you can turn into the catalog to
//retrieve things like its inventory image or description.

package InventorySystem;

import java.awt.Image;
import Level.Player;
import java.util.ArrayList;
import InventorySystem.PlayerInventory;


import Engine.ImageLoader;

public class ItemCatalog {

	public int totalItemsInGame = 1;


	public ItemCatalog() {

	}

	public ArrayList<String> loadItemNames() {
		ArrayList<String> itemNames = new ArrayList<>();
		itemNames.set(1, "Cowboy Hat");
		return itemNames;

	}

	public ArrayList<String> loadItemDescriptions() {
		ArrayList<String> itemDescriptions = new ArrayList<>();
		itemDescriptions.set(1, "Ain't 'nuff room in this here valley for the two of us, partner...");
		return itemDescriptions;

	}

	public ArrayList<Image> loadItemImages() {
		ArrayList<Image> itemImages = new ArrayList<>();

		Image cowboyHat = ImageLoader.load("InventoryTileset.png").getSubimage(68, 0, 16, 16).getScaledInstance(48, 48,
				Image.SCALE_SMOOTH);
		itemImages.set(1, cowboyHat);

		return itemImages;
	}

	public ArrayList<Boolean> loadPlayerHas() {

		ArrayList<Boolean> playerHas = new ArrayList<>();
		
		PlayerInventory playerInventory = new PlayerInventory();


		for (int i = 0; i <= totalItemsInGame; i++) {
			if (playerInventory.loadPlayerInventory().contains(i)) {
				playerHas.set(i, true);
			} else {
				playerHas.set(i, false);
			}

		}
		return playerHas;

	}

}