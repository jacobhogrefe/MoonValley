package Level;

public class HouseEntry {
	protected int x, y;
	protected Tileset tileset;
	protected String mapFileName;
	
	public HouseEntry(int x, int y, String mapFileName, Tileset tileset) {
		this.x = x;
		this.y = y;
		this.mapFileName = mapFileName;
		this.tileset = tileset;
//		Map newMap = new Map(mapFileName, tileset);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Tileset getTileset() {
		return tileset;
	}

	public void setTileset(Tileset tileset) {
		this.tileset = tileset;
	}

	public void setMapFileName(String mapFileName) {
		this.mapFileName = mapFileName;
	}
}
