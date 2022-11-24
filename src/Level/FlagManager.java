package Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import Game.Game;
import Screens.PlayLevelScreen;
import Screens.SaveSlotScreen;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

    /**
     * Takes in a previously saved representation of all the flags and loads them in as the current flags.
     * The current flags are cleared and the new ones are parsed into the HashMap.
     * @param flagsToClear takes in the String representations of flags
     * @author higgins!
     */
    public void overwriteFlags(ArrayList<String> flagsToClear) {
        //clears the flags currently set in the FlagManager
        flags.clear();
        //loops over the list to extract the correct data
        for (int i = 0; i < flagsToClear.size(); i++) {
            //splits at the comma to differentiate between the key and value
            String[] tempString = flagsToClear.get(i).split(",");
            //adds the parsed flag and boolean value to the FlagManager
            flags.put(tempString[0], Boolean.parseBoolean(tempString[1]));
        }
    }

    /**
     * Gets the current flags set and converts them into string representations in {@code key,value} format.
     * @return The list of flags as Strings
     * @author higgins!
     */
    public ArrayList<String> flagsToString() {
        //list of strings the flags will be represented as
        ArrayList<String> flagsToLoad = new ArrayList<>();
        //for each flag, it'll set add a string containing the key,value
        flags.forEach(
            (key, value) -> flagsToLoad.add(key + "," + value));
        //returns the list of strings
        return flagsToLoad;
    }

    /**
     * Save data being read in is temporarily stored in this class. Stored information is the
     * playerX, playerY, inventory, and the mapID the player was in.
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
     * The save method to save relevant data to a text file to be read in at another point. 
     * 
     * @param i Save slot number
     * @author higgins!
     */
    public void betterSave(int i) {
        //sets the saveSlot in SaveSlotScreen to true if save data was saved to that slot
        if (i == 0) {
            SaveSlotScreen.saveSlot = true;
        } else if (i == 1) {
            SaveSlotScreen.saveSlot1 = true;
        } else if (i == 2) {
            SaveSlotScreen.saveSlot2 = true;
        }
        try {
            // creates/overwrites save file
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
            ArrayList<String> flagsToSave = flagsToString();
            //loops over previously aquired strings and prints
            for (int j = 0; j < flagsToSave.size(); j++) {
                saveFile.println(flagsToSave.get(j));
            }
            //label for load feature to know when to stop looping over flags (unknown size)
            saveFile.println("FURNITURE_INFO");
            //gets the current furniture arrangements from each map and turns them into strings
            ArrayList<String> furnitureToSave = Player.MapEntityManager.getFurnitureToSave();
            //loops over previously aquired strings and prints
            for (int j = 0; j < furnitureToSave.size(); j++) {
                saveFile.println(furnitureToSave.get(j));
            }
            //label for load feature to know when to stop looping over npc data (unknown size)
            saveFile.println("NPC_INFO");
            //gets the current specific NPC arrangements from each map and turns them into strings
            ArrayList<String> npcsToSave = Player.MapEntityManager.getNPCsToSave();
            //loops over previously acquired strings and prints
            for (int j = 0; j < npcsToSave.size(); j++) {
                saveFile.println(npcsToSave.get(j));
            }
            //closes the printWriter
            saveFile.close();
        } catch (FileNotFoundException e) {}
    }

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
            this.extraSaveData.inventory = newInventory;
            //reads in the flags and adds them to an ArrayList in key,value format
            ArrayList<String> loadedFlags = new ArrayList<>();
            //loops until a specified label is reached
            boolean noMoreFlags = false;
            while (!noMoreFlags) {
                String tempLine = scanner.nextLine();
                if (tempLine.equalsIgnoreCase("FURNITURE_INFO")) {
                    noMoreFlags = true;
                } else {
                    loadedFlags.add(tempLine);
                }
            }
            overwriteFlags(loadedFlags);
            //reads in the furniture information with mapID,furnitureID,furnitureX,furnitureY format
            ArrayList<String> furnitureInfo = new ArrayList<>();
            //loops until a specified label is reached
            boolean noMoreFurniture = false;
            while (!noMoreFurniture) {
                String tempLine = scanner.nextLine();
                if (tempLine.equalsIgnoreCase("NPC_INFO")) {
                    noMoreFurniture = true;
                } else {
                    furnitureInfo.add(tempLine);
                }
            }
            Player.MapEntityManager.loadSavedFurniture(furnitureInfo);
            //reads in the furniture information with mapID,furnitureID,furnitureX,furnitureY format
            ArrayList<String> npcInfo = new ArrayList<>();
            while (scanner.hasNextLine()) {
                npcInfo.add(scanner.nextLine());
            }
            Player.MapEntityManager.loadSavedNPCs(npcInfo);
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
            this.extraSaveData.map == 8 || 
            this.extraSaveData.map == 10 || 
            this.extraSaveData.map == 11) {
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
