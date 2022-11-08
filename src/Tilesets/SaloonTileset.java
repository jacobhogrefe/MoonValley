package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

/* I "wrote" this code in the laziest way possible, may god have 
 * mercy on anybody else that tries to edit the saloon tileset, 
 * it is not readable because it is just the desert tileset with a copied and edited image file.
 * Everything beyond this point is a lie.
  */
 
public class SaloonTileset extends Tileset {

	public SaloonTileset() {
		super(ImageLoader.load("SaloonTileset.png"), 16, 16, 3);
	}

	// down across
	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

		// floor 1
		Frame floorFrame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder floorTile = new MapTileBuilder(floorFrame);

		mapTiles.add(floorTile);

		// cactus stem 1
		Frame cactusStem1Frame = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).build();

		MapTileBuilder cactusStem1Tile = new MapTileBuilder(cactusStem1Frame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(cactusStem1Tile);

		// cactus stem 2
		Frame cactusStem2Frame = new FrameBuilder(getSubImage(2, 2)).withScale(tileScale).build();

		MapTileBuilder cactusStem2Tile = new MapTileBuilder(floorFrame).withTopLayer(cactusStem2Frame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(cactusStem2Tile);

		// live vegetation
		Frame liveVegatationFrame = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder liveVegatationTile = new MapTileBuilder(liveVegatationFrame)

				.withTileType(TileType.PASSABLE);

		mapTiles.add(liveVegatationTile);

		// dead vegetation
		Frame deadVegatationFrame = new FrameBuilder(getSubImage(2, 3)).withScale(tileScale).build();

		MapTileBuilder deadVegatationTile = new MapTileBuilder(deadVegatationFrame)

				.withTileType(TileType.PASSABLE);

		mapTiles.add(deadVegatationTile);

		// Fence horizontal

		Frame fenceHFrame = new FrameBuilder(getSubImage(4, 2)).withScale(tileScale).build();

		MapTileBuilder fenceHTile = new MapTileBuilder(floorFrame).withTopLayer(fenceHFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(fenceHTile);

		// fence upper left corner

		Frame fenceUpLFrame = new FrameBuilder(getSubImage(4, 1)).withScale(tileScale).build();

		MapTileBuilder fenceUpLTile = new MapTileBuilder(floorFrame).withTopLayer(fenceUpLFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(fenceUpLTile);

		// fence upper right corner

		Frame fenceUpRFrame = new FrameBuilder(getSubImage(4, 1)).withImageEffect(ImageEffect.FLIP_HORIZONTAL)
				.withScale(tileScale).build();

		MapTileBuilder fenceUpRTile = new MapTileBuilder(floorFrame).withTopLayer(fenceUpRFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(fenceUpRTile);

		// fence bottom left corner

		Frame fenceBotLFrame = new FrameBuilder(getSubImage(4, 0)).withScale(tileScale).build();

		MapTileBuilder fenceBotLTile = new MapTileBuilder(floorFrame).withTopLayer(fenceBotLFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(fenceBotLTile);

		// fence bottom right corner

		Frame fenceBotRFrame = new FrameBuilder(getSubImage(4, 0)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

		MapTileBuilder fenceBotRTile = new MapTileBuilder(floorFrame).withTopLayer(fenceBotRFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(fenceBotRTile);

		// fence vertical

		Frame fenceVFrame = new FrameBuilder(getSubImage(3, 3)).withScale(tileScale).build();

		MapTileBuilder fenceVTile = new MapTileBuilder(floorFrame).withTopLayer(fenceVFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(fenceVTile);

		// cactus with branch
		Frame branchFrame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder branchTile = new MapTileBuilder(floorFrame).withTopLayer(branchFrame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(branchTile);

		// cactus with branch 2
		Frame branch2Frame = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder branch2Tile = new MapTileBuilder(floorFrame).withTopLayer(branch2Frame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(branch2Tile);

		// branch left
		Frame branchLeftFrame = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder branchLeftTile = new MapTileBuilder(floorFrame).withTopLayer(branchLeftFrame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(branchLeftTile);

		// branch right
		Frame branchRightFrame = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder branchRightTile = new MapTileBuilder(floorFrame).withTopLayer(branchRightFrame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(branchRightTile);

		// cactus top 1
		Frame cactusTop1Frame = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder cactusTop1Tile = new MapTileBuilder(floorFrame).withTopLayer(cactusTop1Frame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(cactusTop1Tile);

		// cactus top 2
		Frame cactusTop2Frame = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).build();

		MapTileBuilder cactusTop2Tile = new MapTileBuilder(floorFrame).withTopLayer(cactusTop2Frame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(cactusTop2Tile);

		// aloe
		Frame aloeFrame = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder aloeTile = new MapTileBuilder(aloeFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(aloeTile);

		// hill 1
		Frame hill1Frame = new FrameBuilder(getSubImage(3, 0)).withScale(tileScale).build();

		MapTileBuilder hill1Tile = new MapTileBuilder(hill1Frame);

		mapTiles.add(hill1Tile);

		// hill 2
		Frame hill2Frame = new FrameBuilder(getSubImage(3, 1)).withScale(tileScale).build();

		MapTileBuilder hill2Tile = new MapTileBuilder(hill2Frame);

		mapTiles.add(hill2Tile);

		// Saloon Wall

		Frame saloonWallFrame = new FrameBuilder(getSubImage(5, 1)).withScale(tileScale).build();

		MapTileBuilder saloonWallTile = new MapTileBuilder(floorFrame).withTopLayer(saloonWallFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonWallTile);

		// Saloon upper left corner

		Frame saloonUpLFrame = new FrameBuilder(getSubImage(6, 1)).withScale(tileScale).build();

		MapTileBuilder saloonUpLTile = new MapTileBuilder(floorFrame).withTopLayer(saloonUpLFrame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(saloonUpLTile);

		// Saloon upper left corner

		Frame saloonUpRFrame = new FrameBuilder(getSubImage(6, 1)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

		MapTileBuilder saloonUpRTile = new MapTileBuilder(floorFrame).withTopLayer(saloonUpRFrame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(saloonUpRTile);

		// Saloon door right

		Frame saloonDoorRFrame = new FrameBuilder(getSubImage(5, 2)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();

		MapTileBuilder saloonDoorRTile = new MapTileBuilder(saloonDoorRFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonDoorRTile);

		// Saloon door left

		Frame saloonDoorLFrame = new FrameBuilder(getSubImage(5, 2)).withScale(tileScale).build();

		MapTileBuilder saloonDoorLTile = new MapTileBuilder(saloonDoorLFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonDoorLTile);

		// Saloon sign left

		Frame saloonSignLFrame = new FrameBuilder(getSubImage(6, 2)).withScale(tileScale).build();

		MapTileBuilder saloonSignLTile = new MapTileBuilder(floorFrame).withTopLayer(saloonSignLFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonSignLTile);

		// Saloon sign right

		Frame saloonSignRFrame = new FrameBuilder(getSubImage(6, 3)).withScale(tileScale).build();

		MapTileBuilder saloonSignRTile = new MapTileBuilder(floorFrame).withTopLayer(saloonSignRFrame)
				.withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonSignRTile);

		// Saloon top

		Frame saloonUpFrame = new FrameBuilder(getSubImage(7, 1)).withScale(tileScale).build();
		MapTileBuilder saloonUpTile = new MapTileBuilder(floorFrame).withTopLayer(saloonUpFrame)
				.withTileType(TileType.PASSABLE);

		mapTiles.add(saloonUpTile);

		// Saloon side left

		Frame saloonSideLFrame = new FrameBuilder(getSubImage(5, 0)).withScale(tileScale).build();
		MapTileBuilder saloonSideLTile = new MapTileBuilder(saloonSideLFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonSideLTile);

		// Saloon side right

		Frame saloonSideRFrame = new FrameBuilder(getSubImage(5, 0)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();
		MapTileBuilder saloonSideRTile = new MapTileBuilder(saloonSideRFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonSideRTile);

		// Saloon bottom

		Frame saloonBotFrame = new FrameBuilder(getSubImage(5, 3)).withScale(tileScale)
				.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build();
		MapTileBuilder saloonBotTile = new MapTileBuilder(saloonBotFrame).withTileType(TileType.NOT_PASSABLE);

		mapTiles.add(saloonBotTile);

		return mapTiles;
	}
}
