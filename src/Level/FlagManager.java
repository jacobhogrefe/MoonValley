package Level;

import java.util.HashMap;
import java.util.Map.Entry;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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

    public static class ExtraSaveData implements Serializable {
        public float x;
        public float y;
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

    public void updateFrom(Player player) {
        this.extraSaveData.x = player.getX();
        this.extraSaveData.y = player.getY();
    }

    public void updateTo(Player player) {
        player.setX(this.extraSaveData.x);
        player.setY(this.extraSaveData.y);
    }
}
