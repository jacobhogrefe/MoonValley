package MapEditor;

import Level.Map;
import Maps.HouseMap;
import Maps.MushroomHomeMap;
import Maps.SaloonMap;
import Maps.TreehouseMap;
import Maps.moonValleyTitle;
import Maps.Biomes.BiomeDesert;
import Maps.Biomes.BiomeMountains;
import Maps.Biomes.BiomeShrooms;
import Maps.Biomes.BiomeSpooky;
import Maps.Biomes.BiomeStart;
import Maps.BiomeSpookyHome;
import Maps.DinoMap;
import Maps.WalrusMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("moonValleyTitle");
            add("HouseMap");
            add("BiomeDesert");
            add("BiomeMountains");
            add("BiomeShrooms");
            add("BiomeSpooky");
            add("BiomeStart");
            add("WalrusMap");
            add("DinoMap");
            add("MushroomHomeMap");
            add("Treehouse");
            add("SaloonMap");
            add("BiomeSpookyHome");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "moonValleyTitle":
            	return new moonValleyTitle();
            case "HouseMap":
                return new HouseMap();
            case "BiomeDesert":
                return new BiomeDesert();
            case "BiomeMountains":
                return new BiomeMountains();
            case "BiomeShrooms":
                return new BiomeShrooms();
            case "BiomeSpooky":
                return new BiomeSpooky();
            case "BiomeStart":
                return new BiomeStart();
            case "WalrusMap":
            	return new WalrusMap();
            case "DinoMap":
            	return new DinoMap(); 
            case "MushroomHomeMap":
            	return new MushroomHomeMap();
            case "Treehouse":
                return new TreehouseMap();
            case "SaloonMap":
            	return new SaloonMap();
            case "BiomeSpookyHome" :
            	return new BiomeSpookyHome();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
