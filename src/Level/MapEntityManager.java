package Level;

import java.awt.Point;
import java.util.ArrayList;

import Maps.DinoMap;
import Maps.HouseMap;
import Maps.MushroomHomeMap;
import Maps.SaloonMap;

import Maps.TitleScreenMap;
import Maps.TreehouseMap;
import Maps.WalrusMap;
import Maps.moonValleyTitle;
import Maps.Biomes.BiomeDesert;
import Maps.Biomes.BiomeFallout;
import Maps.Biomes.BiomeMountains;
import Maps.Biomes.BiomeShrooms;
import Maps.Biomes.BiomeSpooky;
import Maps.Biomes.BiomeStart;
import Registry.ItemRegistry;



/* Map IDS:
 * Desert: 0
 * Wasteland; 1
 * Mountains: 2
 * Mushroom: 3
 * Halloween: 4
 * Start: 5
 * DinoHouse: 6
 * StartHouse: 7
 * Title: 8
 * MushroomHouse: 9
 * Saloon: 10
 * Title (There are 2 for some reason): 11
 * MountainHome (treehouse): 12
 * WalrusHome; 13
 */

public class MapEntityManager {
	
	public static MapEntityManager entitymanager = new MapEntityManager();
	
	protected ArrayList<Map> savedMaps = new ArrayList<Map>();
	protected ArrayList<Boolean> initiatedMaps;
	
	MapEntityManager(){
		
		savedMaps.add(new BiomeDesert());
		savedMaps.add(new BiomeFallout());
		savedMaps.add(new BiomeMountains());
		savedMaps.add(new BiomeShrooms());
		savedMaps.add(new BiomeSpooky());
		savedMaps.add(new BiomeStart());
		savedMaps.add(new DinoMap());
		savedMaps.add(new HouseMap());
		savedMaps.add(new TitleScreenMap());
		savedMaps.add(new MushroomHomeMap());
		savedMaps.add(new SaloonMap());
		savedMaps.add(new moonValleyTitle());
		savedMaps.add(new TreehouseMap());
		savedMaps.add(new WalrusMap());

		
	}
	
	public ArrayList<Boolean> getInitiatedMaps() {
		return initiatedMaps;
	}


	public ArrayList<Map> getSavedMaps() {
		return savedMaps;
	}
	
	public Map getSavedMap(int mapID) {
		return savedMaps.get(mapID);
	}

	public void setSavedMaps(ArrayList<Map> savedMaps) {
		this.savedMaps = savedMaps;
	}


}