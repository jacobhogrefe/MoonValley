package HouseCustomization;

import java.util.ArrayList;
import java.util.Arrays;

import GameObject.Furniture;
import Utils.Point;

//Similar to ItemRegistry for inventory.
//Contains all decorations (not limited to literal furniture)
//Furniture must be added here AND the itemReigstry which will hold its inventory representation. 
//The itemNumber is held here within the furniture class to associate the furniture with its inventory counterpart

public class FurnitureRegistry {
	//To add a new furniture item, just add a new one to the catalog with format below:
	// Furniture( IMAGE_FILE, defaultPoint (always the same), NAME, Placeable_indoors, Placeable_outdoors, itemNumber (must match what is in ItemRegistry))
	protected static Point defaultPoint = new Point(375, 250);
	public static ArrayList<Furniture> catalog = new ArrayList<Furniture>(Arrays.asList(
		new Furniture("RetroJukeBox.png", defaultPoint, "Retro Jukebox", true, false, 9), // index 0
		new Furniture("RoseBush.png", defaultPoint, "Rose Bush", false, true, 10),		   // index 1
		new Furniture("tvStand.png", defaultPoint, "TV Stand", true, false, 14),
		new Furniture("futon.png", defaultPoint, "Futon", true, false, 15),
		new Furniture("desk.png", defaultPoint, "Desk", true, false, 16)
	));

	public FurnitureRegistry() {}

	//Returns the furniture item of a certain ID
	public static Furniture getFurnitureFromID(int id) {
		for (Furniture furniture : catalog) {
			if (furniture.getItemNumber() == id) {
				return furniture;
			} 
		}
		return null;
	}
}