package Level;

import java.util.HashMap;
import java.util.Map.Entry;

import Game.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
     * Anything that isn't a flag but needs to be saved should go in here.
     * 
     * See updateFrom and updateTo.
     */
    public static class ExtraSaveData implements Serializable {
        // The player's x position on the current map
        public float x;
        // The player's y position on the current map
        public float y;
        // The player's inventory
        public int[] inventory;
        // The class name for the Map
        public String map;

        /**
         * Store the class of Map the player is in.
         * 
         * This doesn't store any actual Map data; you'll have to save it yourself.
         * 
         * This uses reflection, which you probably haven't learned yet;
         * in simple terms, this gets the name of the class, e.g. Maps.Biomes.BiomeStart,
         * and stores it in this.map.
         * 
         * @param map An instance of the Map class to store.
         */
        public void storeMap(Map map) {
            Class<? extends Map> clazz = map.getClass();

            this.map = clazz.getName();
        }

        /**
         * Create a new instance of the Map class saved in this.map.
         * 
         * This doesn't load any actual Map data; you'll have to load it yourself.
         * 
         * This uses reflection, which you probably haven't learned yet;
         * in simple terms, this uses the name of the class, e.g. Maps.Biomes.BiomeStart,
         * to make a new instance of that Map. This doesn't work if your Map has
         * constructor parameters.
         * 
         * @return a new instance of the saved Map class
         */
        public Map createMap() {
            ClassLoader loader = getClass().getClassLoader();

            try {
                Class<?> clazz = loader.loadClass(this.map);

                return (Map) clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }
        }
    }

    public ExtraSaveData extraSaveData = new ExtraSaveData();

    public void load(FileInputStream stream) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(stream)) {
            this.flags = (HashMap<String, Boolean>) ois.readObject();
            this.extraSaveData = (ExtraSaveData) ois.readObject();
        }
    }

    public void save(FileOutputStream stream) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(stream)) {
            oos.writeObject(this.flags);
            oos.writeObject(this.extraSaveData);
        }
    }

    public void loadFromSlot(int i) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (FileInputStream stream = new FileInputStream(String.format("%d.save", i))) {
            this.load(stream);
        }
    }

    public void saveToSlot(int i) throws FileNotFoundException, IOException {
        try (FileOutputStream stream = new FileOutputStream(String.format("%d.save", i))) {
            this.save(stream);
        }
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
        this.extraSaveData.storeMap(player.getMap());
    }

    /**
     * Update the player with the extra save data in this.extraSaveData.
     * 
     * For example, this updates the player position and inventory.
     * 
     * @param player the player object
     */
    public void updateTo(Player player) {
        Game.getRunningInstance()
            .getScreenCoordinator()
            .getPlayLevelScreen()
            .getPlayerInventory()
            .setInventoryArray(this.extraSaveData.inventory);
        Game.getRunningInstance()
            .getScreenCoordinator()
            .getPlayLevelScreen()
            .teleport(
                this.extraSaveData.createMap(),
                this.extraSaveData.x,
                this.extraSaveData.y
            );
    }
}
