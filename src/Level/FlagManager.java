package Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import Game.Game;
import Screens.PlayLevelScreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
//import Level.Player;

/**
 * FlagManager stores a list of flags - Strings which are either present or not.
 * 
 * For example, one might set a flag called "walrusGone" when the walrus is no
 * longer on the map. Then, when the map is loaded, "walrusGone" is checked,
 * and if the flag is there, we don't spawn the walrus. This persists across
 * loads and saves.
 */
public class FlagManager {
    protected HashMap<String, Boolean> flags = new HashMap<>();
    

    public void addFlag(String flagName) {
        flags.put(flagName, false);
    }

    public void addFlag(String flagName, boolean startingValue) {
        flags.put(flagName, startingValue);
    }
 

    public void setFlag(String flagName) {
        if (flags.containsKey(flagName)) {
            flags.put(flagName, true);
        }
    }

    public void unsetFlag(String flagName) {
        if (flags.containsKey(flagName)) {
            flags.put(flagName, false);
        }
    }

    public void reset() {
        for (Entry<String, Boolean> entry : flags.entrySet()) {
            entry.setValue(false);
        }
    }

    public boolean isFlagSet(String flagName) {
        if (flags.containsKey(flagName)) {
            return flags.get(flagName);
        }
        return false;
    }

    //clears the current list of set flags and sets new ones from an ArrayList
    public static void overwriteFlags(ArrayList<String> flagsToClear, HashMap<String, Boolean> flags) {
        flags.clear();
        for (int i = 0; i < flagsToClear.size(); i++) {
            String[] tempString = flagsToClear.get(i).split(",");
            flags.put(tempString[0], Boolean.parseBoolean(tempString[1]));
        }
    }

    //gets the current flags set and converts them into string representations
    public static ArrayList<String> flagsToString(HashMap<String, Boolean> flags) {
        ArrayList<String> flagsToLoad = new ArrayList<>();
        flags.forEach(
            (key, value) -> flagsToLoad.add(key + "," + value));
        return flagsToLoad;
    }

    /**
     * Anything that isn't a flag but needs to be saved should go in here.
     * 
     * See updateFrom and updateTo.
     */
    public static class ExtraSaveData {
        // The player's x position on the current map
        public float x;
        // The player's y position on the current map
        public float y;
        // The player's inventory
        public int[] inventory;
        // The map the player was in
        public int map;
    }

    public ExtraSaveData extraSaveData = new ExtraSaveData();

    /**
     * This method took me far too long to understood why certain items we're being printed numerous times and not 
     * every unique item. Turns out it was just me putting i instead of j in all the for loops. Fucking hell.
     * 
     * @param i Save slot number
     * @author higgins!
     */
    public void betterSave(int i) throws FileNotFoundException {
        //creates/overwrites save file
        PrintWriter saveFile = new PrintWriter(new File("save" + i + ".txt"));
        //prints the mapID, playerX, and playerY in that format
        saveFile.println(this.extraSaveData.map + "," + this.extraSaveData.x + "," + this.extraSaveData.y);
        //turns the inventory array into a string and prints
        for (int j = 0; j < this.extraSaveData.inventory.length; j++) {
            if (j != this.extraSaveData.inventory.length - 1) {
                saveFile.print(this.extraSaveData.inventory[j] + ",");
            } else {
                saveFile.print(this.extraSaveData.inventory[j] + "\n");
            }
        }
        //gets the current flags and turns them into strings and prints
        ArrayList<String> flagsToSave = FlagManager.flagsToString(this.flags);
        //loops over previously aquired strings and prints
        for (int j = 0; j < flagsToSave.size(); j++) {
            saveFile.println(flagsToSave.get(j));
        }
        //label for load feature to know when to stop looping over flags (unknown size)
        saveFile.println("FURNITURE_INFO");
        //gets the current furniture arrangements from each map and turns them into strings
        ArrayList<String> furnitureToSave = Player.MapEntityManager.getFurniture();
        //loops over previously aquired strings and prints
        for (int j = 0; j < furnitureToSave.size(); j++) {
            saveFile.println(furnitureToSave.get(j));
        }
        //closes the printWriter
        saveFile.close();
    }
    /*
     * load method:
     * search for NUM_SAVE.txt that corresponds to that save slot
     * read in the file with a while (file.hasNextLine()) {} loop
     * read PLAYER LOCATION tag: use stringObject.split(",")) to get an array and set the corresponding values
     * read PLAYER INVENTORY tag: set the slots with the corresponding values (use stringObject.split(",")) to get an array)
     * read FLAGS: create arrayList of Strings containing flags (format: key,value) use overWrite flags
     * read FURNITURE INFO: if the line has one integer, obtain the map it's from, and set furniture based on id and x,y
     */

     /**
      * The load method for setting all the right data in the right places from a text file.
      * @param i Load slot number
      * @author higgins!
      */
    public void betterLoad(int i) {
        try {
            //reads in the file
            Scanner scanner = new Scanner(new File("save" + i + ".txt"));
            //gets the mapID, player x, and player y and sets them accordingly
            String[] playerLocation = scanner.nextLine().split(",");
            this.extraSaveData.map = Integer.parseInt(playerLocation[0]);
            this.extraSaveData.x = Float.parseFloat(playerLocation[1]);
            this.extraSaveData.y = Float.parseFloat(playerLocation[2]);
            //reads in the inventory array and parses the ints from the split string
            String[] inventoryData = scanner.nextLine().split(",");
            //creates an empty int array to fill from data in inventoryData
            int[] newInventory = new int[inventoryData.length];
            //loops through inventoryData and parses ints into newInventory
            for (int j = 0; j < inventoryData.length; j++) {
                newInventory[j] = Integer.parseInt(inventoryData[j]);
            }
            //sets the inventory of the saveData to newInventory
            this.extraSaveData.inventory = newInventory;
            //reads in the flags and adds them to an ArrayList in key,value format
            ArrayList<String> loadedFlags = new ArrayList<>();
            while (!scanner.nextLine().equalsIgnoreCase("FURNITURE_INFO")) {
                loadedFlags.add(scanner.nextLine());
            }
            FlagManager.overwriteFlags(loadedFlags, this.flags);
            //reads in the furniture information with mapID:furnitureID(furnitureX,furnitureY) format
            ArrayList<String> furnitureInfo = new ArrayList<>();
            while (scanner.hasNextLine()) {
                furnitureInfo.add(scanner.nextLine());
            }
            Player.MapEntityManager.setFurniture(furnitureInfo);
            //closes the scanner
            scanner.close();
        } catch (Exception e) {}
    }
    /**
     * Load the ExtraSaveData structure with the data that will need to be saved.
     * 
     * For example, this updates this.extraSaveData with player position and inventory.
     * 
     * @param player the player object
     */
    public void updateFrom(Player player) {
        this.extraSaveData.x = player.getX();
        this.extraSaveData.y = player.getY();
        this.extraSaveData.inventory = Game.getRunningInstance()
            .getScreenCoordinator()
            .getPlayLevelScreen()
            .getPlayerInventory()
            .getInventoryArray();
        this.extraSaveData.map = player.getMap().getMapID();
    }

    /**
     * Update the player with the extra save data in this.extraSaveData.
     * 
     * For example, this updates the player position and inventory.
     * 
     * @param player the player object
     */
    public void updateTo(Player player) {
        //sets player inventory from save data
        Game.getRunningInstance()
            .getScreenCoordinator()
            .getPlayLevelScreen()
            .getPlayerInventory()
            .setInventoryArray(this.extraSaveData.inventory);
        //if the mapID from the sava data corresponds to a house, sets isInHouse to true
        if (this.extraSaveData.map == 6 || 
            this.extraSaveData.map == 7 || 
            this.extraSaveData.map == 9 || 
            this.extraSaveData.map == 12 || 
            this.extraSaveData.map == 13) {
            PlayLevelScreen.isInHouse = true;
        }
        //sets player to map from save data
        Game.getRunningInstance()
            .getScreenCoordinator()
            .getPlayLevelScreen()
            .teleport(
                Player.MapEntityManager.getSavedMap(this.extraSaveData.map),
                this.extraSaveData.x,
                this.extraSaveData.y
            );
    }
}
