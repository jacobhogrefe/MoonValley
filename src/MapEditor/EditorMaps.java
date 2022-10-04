package MapEditor;

import Level.Map;
import Maps.HouseMap;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.moonValleyTitle;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("moonValleyTitle");
            add("HouseMap");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "moonValleyTitle":
            	return new moonValleyTitle();
            case "HouseMap":
            		return new HouseMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
