package HouseCustomization;

import java.util.ArrayList;

import GameObject.Furniture;
import Utils.Point;

//Similar to ItemRegistry for inventory.
//Contains all decorations (not limited to literal furniture)
//Furniture must be added here AND the itemReigstry which will hold its inventory representation. 
//The itemNumber is held here within the furniture class to associate the furniture with its inventory counterpart

public class FurnitureRegistry {

	public static final FurnitureRegistry furnitureregistry = new FurnitureRegistry();

	public ArrayList<Furniture> catalog = new ArrayList<Furniture>();

	public FurnitureRegistry() {

		Point defaultPoint = new Point(375, 250); // center of house (approximately)

		catalog.add(new Furniture("RetroJukeBox.png", defaultPoint, "Retro Jukebox", true, false, 9)); // index 0

	}

	// retroJukeBox = new Furniture()
	// catalog.add(retroJukeBox);

}