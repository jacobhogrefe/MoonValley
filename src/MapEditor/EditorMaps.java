package MapEditor;

import Level.Map;
import Maps.HouseMap;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.moonValleyTitle;
import Maps.Biomes.BiomeDesert;
import Maps.Biomes.BiomeFallout;
import Maps.Biomes.BiomeMountains;
import Maps.Biomes.BiomeShrooms;
import Maps.Biomes.BiomeSpooky;
import Maps.Biomes.BiomeStart;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("moonValleyTitle");
            add("HouseMap");
            add("BiomeDesert");
            add("BiomeFallout");
            add("BiomeMountains");
            add("BiomeShrooms");
            add("BiomeSpooky");
            add("BiomeStart");
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
            case "BiomeDesert":
                return new BiomeDesert();
            case "BiomeFallout":
                return new BiomeFallout();
            case "BiomeMountains":
                return new BiomeMountains();
            case "BiomeShrooms":
                return new BiomeShrooms();
            case "BiomeSpooky":
                return new BiomeSpooky();
            case "BiomeStart":
                return new BiomeStart();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
