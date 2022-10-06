// The graphic representation of every item in the game will be added to this tileset.
//The inventory screen will rewrite squares on a map based on what items a player has
//in their inventory.

package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.Tileset;

import java.util.ArrayList;


public class InventoryTileset extends Tileset {

	public InventoryTileset() {
		super(ImageLoader.load("InventoryTileset.png"), 16, 16, 3);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
		
		//The next 9 "Inventory" frames make up the border of the inventory system and unoccupied spaces
		
		Frame Inventory1Frame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder Inventory1Tile = new MapTileBuilder(Inventory1Frame);

		mapTiles.add(Inventory1Tile);
		
		Frame Inventory2Frame = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder Inventory2Tile = new MapTileBuilder(Inventory2Frame);

		mapTiles.add(Inventory2Tile);
		
		Frame Inventory3Frame = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder Inventory3Tile = new MapTileBuilder(Inventory3Frame);

		mapTiles.add(Inventory3Tile);
		
		Frame Inventory4Frame = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder Inventory4Tile = new MapTileBuilder(Inventory4Frame);

		mapTiles.add(Inventory4Tile);
		
		Frame Inventory5Frame = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder Inventory5Tile = new MapTileBuilder(Inventory5Frame);

		mapTiles.add(Inventory5Tile);
		
		Frame Inventory6Frame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder Inventory6Tile = new MapTileBuilder(Inventory6Frame);

		mapTiles.add(Inventory6Tile);
		
		Frame Inventory7Frame = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder Inventory7Tile = new MapTileBuilder(Inventory7Frame);

		mapTiles.add(Inventory7Tile);
		
		Frame Inventory8Frame = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder Inventory8Tile = new MapTileBuilder(Inventory8Frame);

		mapTiles.add(Inventory8Tile);
		
		Frame Inventory9Frame = new FrameBuilder(getSubImage(1, 4)).withScale(tileScale).build();

		MapTileBuilder Inventory9Tile = new MapTileBuilder(Inventory9Frame);

		mapTiles.add(Inventory9Tile);

	

		return mapTiles;
	}
}