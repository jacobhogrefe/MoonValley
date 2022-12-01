package Maps;

import java.util.ArrayList;
import Level.Collectible;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import Level.Trigger;
import NPCs.Walrus;
import Scripts.TestMap.ExitWalrusHouseScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.transformScript;
import Tilesets.HouseTileset;

public class WalrusMap extends Map {

	private boolean isInHouse;

	public WalrusMap() {
		super("walrus_house_map.txt", new HouseTileset(),11);
		this.playerStartPosition = getMapTile(12, 10).getLocation();
		isInHouse = true;
	}

	@Override
	public void loadScripts() {
		getMapTile(8, 11).setInteractScript(new ExitWalrusHouseScript());
	}

	@Override
	public ArrayList<Collectible> loadCollectibles() {
		ArrayList<Collectible> collectibles = new ArrayList<>();
       
		Collectible glasses = new Collectible("Glasses.png", getMapTile(4, 10).getLocation(), "Glasses", 18, false);
        glasses.setExistenceFlag("searchForGlasses");
        collectibles.add(glasses);
        
        Collectible canteen = new Collectible("Canteen.png", getMapTile(5, 3).getLocation(), "Canteen", 3, false);
        canteen.setExistenceFlag("searchForCanteen");
        collectibles.add(canteen);

		return collectibles;
	}
	
	@Override
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = super.loadTriggers();
		Trigger computer = new Trigger(192, 384, 48, 48, new transformScript());
		computer.setExistenceFlag("cantUseComputer");
		triggers.add(computer);
		return triggers;
	}

	
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(10, 4).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        return npcs;
    }

	@Override
	public MusicState getMusicState() {
		return MusicState.START_HOME;
	}

	public boolean getIsInHouse() {
		return isInHouse;
	}
}
