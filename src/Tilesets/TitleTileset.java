package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// Tileset for constructing the games title page based off the common tileset code
public class TitleTileset extends Tileset {

	public TitleTileset() {
		super(ImageLoader.load("TitleTiles.png"), 16, 16, 3);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

		// Letter M
		Frame letterMFrame = new FrameBuilder(getSubImage(0, 0)).withScale(tileScale).build();

		MapTileBuilder letterM = new MapTileBuilder(letterMFrame);

		mapTiles.add(letterM);

		// moon part 8 (I started doing these in this confusing order because its the
		// order the coordinates were done in the common file
		// that was my reference. maybe Ill put these in a more logical order when I'm
		// done, but it is much more likely that I will not.
		// Furthermore, if Star Wars can start on episode 4, I can start coding my moon
		// tiles at 8.
		Frame moon8Frame = new FrameBuilder(getSubImage(3, 0)).withScale(tileScale).build();

		MapTileBuilder moon8Tile = new MapTileBuilder(moon8Frame);

		mapTiles.add(moon8Tile);

		// moon part 1

		Frame moon1Frame = new FrameBuilder(getSubImage(1, 3)).withScale(tileScale).build();

		MapTileBuilder moon1Tile = new MapTileBuilder(moon1Frame);

		mapTiles.add(moon1Tile);

//moon part 2

		Frame moon2Frame = new FrameBuilder(getSubImage(1, 4)).withScale(tileScale).build();

		MapTileBuilder moon2Tile = new MapTileBuilder(moon2Frame);

		mapTiles.add(moon2Tile);

//moon part 3

		Frame moon3Frame = new FrameBuilder(getSubImage(2, 0)).withScale(tileScale).build();

		MapTileBuilder moon3Tile = new MapTileBuilder(moon3Frame);

		mapTiles.add(moon3Tile);

//moon part 4

		Frame moon4Frame = new FrameBuilder(getSubImage(2, 1)).withScale(tileScale).build();

		MapTileBuilder moon4Tile = new MapTileBuilder(moon4Frame);

		mapTiles.add(moon4Tile);

//moon part 5

		Frame moon5Frame = new FrameBuilder(getSubImage(2, 2)).withScale(tileScale).build();

		MapTileBuilder moon5Tile = new MapTileBuilder(moon5Frame);

		mapTiles.add(moon5Tile);

//moon part 6

		Frame moon6Frame = new FrameBuilder(getSubImage(2, 3)).withScale(tileScale).build();

		MapTileBuilder moon6Tile = new MapTileBuilder(moon6Frame);

		mapTiles.add(moon6Tile);

//moon part 7

		Frame moon7Frame = new FrameBuilder(getSubImage(2, 4)).withScale(tileScale).build();

		MapTileBuilder moon7Tile = new MapTileBuilder(moon7Frame);

		mapTiles.add(moon7Tile);

		// Letter O
		Frame letterOFrame = new FrameBuilder(getSubImage(0, 1)).withScale(tileScale).build();

		MapTileBuilder letterO = new MapTileBuilder(letterOFrame);

		mapTiles.add(letterO);

		// Letter N

		Frame letterNFrame = new FrameBuilder(getSubImage(0, 2)).withScale(tileScale).build();

		MapTileBuilder letterN = new MapTileBuilder(letterNFrame);

		mapTiles.add(letterN);

		// Letter V

		Frame letterVFrame = new FrameBuilder(getSubImage(0, 3)).withScale(tileScale).build();

		MapTileBuilder letterV = new MapTileBuilder(letterVFrame);

		mapTiles.add(letterV);

		// Letter A

		Frame letterAFrame = new FrameBuilder(getSubImage(0, 4)).withScale(tileScale).build();

		MapTileBuilder letterA = new MapTileBuilder(letterAFrame);

		mapTiles.add(letterA);

		// Letter L

		Frame letterLFrame = new FrameBuilder(getSubImage(1, 0)).withScale(tileScale).build();

		MapTileBuilder letterL = new MapTileBuilder(letterLFrame);

		mapTiles.add(letterL);

		// Letter E

		Frame letterEFrame = new FrameBuilder(getSubImage(1, 1)).withScale(tileScale).build();

		MapTileBuilder letterE = new MapTileBuilder(letterEFrame);

		mapTiles.add(letterE);

		// Letter Y

		Frame letterYFrame = new FrameBuilder(getSubImage(1, 2)).withScale(tileScale).build();

		MapTileBuilder letterY = new MapTileBuilder(letterYFrame);

		mapTiles.add(letterY);

		// New Grass

		Frame newGrassFrame = new FrameBuilder(getSubImage(3, 1)).withScale(tileScale).build();

		MapTileBuilder newGrass = new MapTileBuilder(newGrassFrame);

		mapTiles.add(newGrass);

		// Pine Tree

		Frame pineTreeFrame = new FrameBuilder(getSubImage(3, 2)).withScale(tileScale).build();

		MapTileBuilder pineTree = new MapTileBuilder(pineTreeFrame);

		mapTiles.add(pineTree);

		// Pine Tree

		Frame jackOFrame = new FrameBuilder(getSubImage(3, 3)).withScale(tileScale).build();

		MapTileBuilder jackO = new MapTileBuilder(jackOFrame);

		mapTiles.add(jackO);

		// big ole red mushroom

		Frame bigShroomFrame = new FrameBuilder(getSubImage(3, 4)).withScale(tileScale).build();

		MapTileBuilder bigShroom = new MapTileBuilder(bigShroomFrame);

		mapTiles.add(bigShroom);

		// Night sky 1 (different star placement than night sky 2 to give sky more
		// realistic look when use din combination)

		Frame nightSky1Frame = new FrameBuilder(getSubImage(4, 0)).withScale(tileScale).build();

		MapTileBuilder nightSky1 = new MapTileBuilder(nightSky1Frame);

		mapTiles.add(nightSky1);

		// Night sky 2 (different star placement than night sky 1 to give sky more
		// realistic look when use din combination)

		Frame nightSky2Frame = new FrameBuilder(getSubImage(4, 1)).withScale(tileScale).build();

		MapTileBuilder nightSky2 = new MapTileBuilder(nightSky2Frame);

		mapTiles.add(nightSky2);

		// Twinkling star/planet?

		// I wanted to make it so these don't all blink at the same time. I'm sure there
		// is a better way to do it than creating a new frame for every star I place,
		// but I couldn't figure it out so I went with this lazy solution.

		Frame[] twinkleStarFrame = new Frame[] {

				new FrameBuilder(getSubImage(4, 2), (int) 300).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(4, 3), (int) 200).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(4, 4), (int) 200).withScale(tileScale).build(),

		};

		MapTileBuilder twinkleStarTile = new MapTileBuilder(twinkleStarFrame);

		mapTiles.add(twinkleStarTile);

		// Twinkling star/planet?

		// I wanted to make it so these don't all blink at the same time. I'm sure there
		// is a better way to do it than creating a new frame for every star I place,
		// but I couldn't figure it out so I went with this lazy solution.

		Frame[] twinkleStarFrame2 = new Frame[] {

				new FrameBuilder(getSubImage(4, 2), (int) 200).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(4, 3), (int) 200).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(4, 4), (int) 200).withScale(tileScale).build(),

		};

		MapTileBuilder twinkleStarTile2 = new MapTileBuilder(twinkleStarFrame2);

		mapTiles.add(twinkleStarTile2);

		// Twinkling star/planet?

		// I wanted to make it so these don't all blink at the same time. I'm sure there
		// is a better way to do it than creating a new frame for every star I place,
		// but I couldn't figure it out so I went with this lazy solution.

		Frame[] twinkleStarFrame3 = new Frame[] {

				new FrameBuilder(getSubImage(4, 2), (int) 400).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(4, 3), (int) 200).withScale(tileScale).build(),
				new FrameBuilder(getSubImage(4, 4), (int) 200).withScale(tileScale).build(),

		};

		MapTileBuilder twinkleStarTile3 = new MapTileBuilder(twinkleStarFrame3);

		mapTiles.add(twinkleStarTile3);

		return mapTiles;
	}
}