package HouseCustomization;

import java.util.ArrayList;

import GameObject.Furniture;

//Similar to ItemRegistry for inventory.
//Contains all INTERIOR decorations (not limited to literal furniture)

public class FurnitureRegistry {
	
    public static final FurnitureRegistry furnitureRegistry = new FurnitureRegistry();
    
    private ArrayList<Furniture> catalog = new ArrayList<Furniture>();
    
    Furniture retroJukebox = new Furniture("RetroJukebox.png", , "Retro Jukebox", 0);
    
    
    
    
}