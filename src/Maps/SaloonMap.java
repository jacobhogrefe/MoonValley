package Maps;

import java.util.ArrayList;

import GameObject.Furniture;
import HouseCustomization.FurnitureRegistry;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import NPCs.BartenderWalrus;
import NPCs.Cowboy;
import Scripts.DesertMap.BartenderWalrusScript;
import Scripts.DesertMap.CowboyScript;
import Scripts.DesertMap.ExitSaloonScript;
import Tilesets.SaloonTileset;

// Represents a test map to be used in a level
public class SaloonMap extends Map {
	


    public SaloonMap() {
        super("saloon_map.txt", new SaloonTileset(),10);
        this.playerStartPosition = getMapTile(5, 5).getLocation();
    }
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();
        
        Cowboy cowboy = new Cowboy(6, getMapTile(4, 7).getLocation());
        cowboy.setInteractScript(new CowboyScript());
        npcs.add(cowboy);
        
        BartenderWalrus bwalrus = new BartenderWalrus(5,getMapTile(4, 3).getLocation());
        bwalrus.setInteractScript(new BartenderWalrusScript());
        
        npcs.add(bwalrus);



        return npcs;
    }
    
    @Override
    public ArrayList<Furniture> loadFurniture() {
        ArrayList<Furniture> furniture = new ArrayList<>();   
        
        furniture.add(FurnitureRegistry.catalog.get(0));
        furniture.get(0).setX(600);
        furniture.get(0).setY(150);
        
        return furniture;
    }
    
    @Override
    public void loadScripts() { 
    	 getMapTile(7, 11).setInteractScript(new ExitSaloonScript());
    	 getMapTile(8, 11).setInteractScript(new ExitSaloonScript());
    	 System.out.println("Setting");
    } 
    @Override
    public MusicState getMusicState() {
        return MusicState.SALOON;
    }
}