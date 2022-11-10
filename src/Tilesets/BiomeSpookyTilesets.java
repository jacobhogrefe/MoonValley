package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a interior tileset of standard tiles defined in the MushroomTileset.png file
public class BiomeSpookyTilesets extends Tileset {

    public BiomeSpookyTilesets() {
        super(ImageLoader.load("BiomeSpooky.png"), 16, 16, 3);
    }
    
    //down across
    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // floor 1
        Frame floorFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder floorTile = new MapTileBuilder(floorFrame);

        mapTiles.add(floorTile);
        
        //grass floor tile 1
        Frame grassfloortile1Frame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassfloortile1 = new MapTileBuilder(grassfloortile1Frame);

        mapTiles.add(grassfloortile1);
        
        //grass floor tile 2
        Frame grassfloortile2Frame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassfloortile2 = new MapTileBuilder(grassfloortile2Frame);

        mapTiles.add(grassfloortile2);
                
        // Tree stem base 1 
        Frame treestem1Frame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder treestem1Tile = new MapTileBuilder(treestem1Frame)
                .withTopLayer(treestem1Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treestem1Tile);
        
     // Tree stem base 2 
        Frame treestem2Frame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder treestem2Tile = new MapTileBuilder(treestem2Frame)
                .withTopLayer(treestem2Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treestem1Tile);
        
        
        
        
//        //mushroom stem 1
//        Frame mushroomStem1Frame = new FrameBuilder(getSubImage(2, 2))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomStem1Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomStem1Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomStem1Tile);
//        
//        //mushroom stem 2
//        Frame mushroomStem2Frame = new FrameBuilder(getSubImage(2, 1))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomStem2Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomStem2Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomStem2Tile);
//        
//        //mushroom stem 3
//        Frame mushroomStem3Frame = new FrameBuilder(getSubImage(3, 1))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomStem3Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomStem3Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomStem3Tile);
//        
//        //branch 1
//        Frame branch1Frame = new FrameBuilder(getSubImage(2, 0))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder branch1Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(branch1Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(branch1Tile);
//        
//        //branch 2
//        Frame branch2Frame = new FrameBuilder(getSubImage(3, 2))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder branch2Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(branch2Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(branch2Tile);
//        
//        //mushroom top 1
//        Frame mushroomTop1Frame = new FrameBuilder(getSubImage(0, 2))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomTop1Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomTop1Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomTop1Tile);
//        
//        //mushroom top 2
//        Frame mushroomTop2Frame = new FrameBuilder(getSubImage(0, 3))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomTop2Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomTop2Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomTop2Tile);
//        
//        //mushroom top 3
//        Frame mushroomTop3Frame = new FrameBuilder(getSubImage(0, 4))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomTop3Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomTop3Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomTop3Tile);
//        
//        //mushroom top 4
//        Frame mushroomTop4Frame = new FrameBuilder(getSubImage(1, 2))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomTop4Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomTop4Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomTop4Tile);
//        
//        //mushroom top 5
//        Frame mushroomTop5Frame = new FrameBuilder(getSubImage(1, 3))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomTop5Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomTop5Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomTop5Tile);
//        
//        //mushroom top 6
//        Frame mushroomTop6Frame = new FrameBuilder(getSubImage(1, 4))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomTop6Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomTop6Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomTop6Tile); 
//        
//        //mushroom roof 1
//        Frame mushroomRoof1Frame = new FrameBuilder(getSubImage(4, 0))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof1Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof1Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof1Tile);
//        
//        //mushroom roof 2
//        Frame mushroomRoof2Frame = new FrameBuilder(getSubImage(5, 0))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof2Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof2Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof2Tile);
//        
//        //mushroom roof 3
//        Frame mushroomRoof3Frame = new FrameBuilder(getSubImage(6, 0))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof3Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof3Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof3Tile);
//        
//        //mushroom roof 4
//        Frame mushroomRoof4Frame = new FrameBuilder(getSubImage(4, 1))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof4Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof4Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof4Tile);
//        
//        //mushroom roof 5
//        Frame mushroomRoof5Frame = new FrameBuilder(getSubImage(5, 1))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof5Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof5Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof5Tile);
//        
//        //mushroom roof 6
//        Frame mushroomRoof6Frame = new FrameBuilder(getSubImage(6, 1))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof6Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof6Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof6Tile);
//        
//        //mushroom roof 7
//        Frame mushroomRoof7Frame = new FrameBuilder(getSubImage(4, 2))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof7Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof7Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof7Tile);
//        
//        //mushroom roof 8
//        Frame mushroomRoof8Frame = new FrameBuilder(getSubImage(5, 2))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof8Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof8Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof8Tile);
//        
//        //mushroom roof 9
//        Frame mushroomRoof9Frame = new FrameBuilder(getSubImage(6, 2))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof9Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof9Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof9Tile);
//        
//        //mushroom roof 10
//        Frame mushroomRoof10Frame = new FrameBuilder(getSubImage(4, 3))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof10Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof10Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof10Tile);
//        
//        //mushroom roof 11
//        Frame mushroomRoof11Frame = new FrameBuilder(getSubImage(5, 3))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof11Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof11Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof11Tile);
//        
//        //mushroom roof 12
//        Frame mushroomRoof12Frame = new FrameBuilder(getSubImage(6, 3))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof12Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof12Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof12Tile);
//        
//        //mushroom roof 13
//        Frame mushroomRoof13Frame = new FrameBuilder(getSubImage(4, 4))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof13Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof13Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof13Tile);
//        
//        //mushroom roof 14
//        Frame mushroomRoof14Frame = new FrameBuilder(getSubImage(5, 4))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof14Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof14Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof14Tile);
//        
//        //mushroom roof 15
//        Frame mushroomRoof15Frame = new FrameBuilder(getSubImage(6, 4))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomRoof15Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(mushroomRoof15Frame)
//        		.withTileType(TileType.PASSABLE);
//
//        mapTiles.add(mushroomRoof15Tile);
//        
//        //mushroom house stem
//        Frame mushroomHouseFrame = new FrameBuilder(getSubImage(2, 3))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomHouseTile = new MapTileBuilder(mushroomHouseFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(mushroomHouseTile);
//        
//        //mushroom house door
//        Frame mushroomDoorFrame = new FrameBuilder(getSubImage(3, 3))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder mushroomDoorTile = new MapTileBuilder(mushroomDoorFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(mushroomDoorTile);
//        
//        //window
//        Frame windowFrame = new FrameBuilder(getSubImage(3, 4))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder windowTile = new MapTileBuilder(windowFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(windowTile);
//        
//        //house side 1
//        Frame houseSide1Frame = new FrameBuilder(getSubImage(2, 4))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder houseSide1Tile = new MapTileBuilder(houseSide1Frame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(houseSide1Tile);
//        
//        //house side 2
//        Frame houseSide2Frame = new FrameBuilder(getSubImage(2, 4))
//                .withScale(tileScale)
//                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
//                .build();
//
//        MapTileBuilder houseSide2Tile = new MapTileBuilder(houseSide2Frame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(houseSide2Tile);
//        
//        //rock wall
//        Frame rockWallFrame = new FrameBuilder(getSubImage(0, 5))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder rockWallTile = new MapTileBuilder(rockWallFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(rockWallTile);
//        
//        //rock wall top
//        Frame rockTopFrame = new FrameBuilder(getSubImage(1, 5))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder rockTopTile = new MapTileBuilder(rockTopFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(rockTopTile);
//        
//        //rock wall bottom
//        Frame rockBottomFrame = new FrameBuilder(getSubImage(2, 5))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder rockBottomTile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(rockBottomFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(rockBottomTile);
//        
//        //top
//        Frame topFrame = new FrameBuilder(getSubImage(3, 5))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder topTile = new MapTileBuilder(topFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(topTile);
//        
//        //side rock wall
//        Frame sideRockFrame = new FrameBuilder(getSubImage(4, 5))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder sideRockTile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(sideRockFrame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(sideRockTile);
//        
//        //flipped side rock wall
//        Frame sideRock2Frame = new FrameBuilder(getSubImage(4, 5))
//                .withScale(tileScale)
//                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
//                .build();
//
//        MapTileBuilder sideRock2Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(sideRock2Frame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(sideRock2Tile);
//        
//        //flipped upside down rock wall
//        Frame sideRock3Frame = new FrameBuilder(getSubImage(4, 5))
//                .withScale(tileScale)
//                .withImageEffect(ImageEffect.FLIP_VERTICAL)
//                .build();
//
//        MapTileBuilder sideRock3Tile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(sideRock3Frame)
//                .withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(sideRock3Tile);
//        
//        //transition to fallout
//        Frame floorFrame4 = new FrameBuilder(getSubImage(0, 6))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder floorTile4 = new MapTileBuilder(floorFrame4);
//
//        mapTiles.add(floorTile4);
//        
//        //rocks
//        Frame rockFrame = new FrameBuilder(getSubImage(1, 6))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder rockTile = new MapTileBuilder(rockFrame);
//
//        mapTiles.add(rockTile);
//        
//        //lighting bugs
//        Frame[] bugJarFrames = new Frame[] {
//                new FrameBuilder(getSubImage(5, 5), 500)
//                    .withScale(tileScale)
//                    .build(),
//                new FrameBuilder(getSubImage(6, 5), 500)
//                        .withScale(tileScale)
//                        .build()
//        };
//
//        MapTileBuilder bugJarTile = new MapTileBuilder(floorFrame)
//        		.withTopLayer(bugJarFrames)
//                .withTileType(TileType.PASSABLE);
//
//        mapTiles.add(bugJarTile);
//        
//      //soil 
//        Frame soilFrame = new FrameBuilder(getSubImage(1, 6))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder soilTile = new MapTileBuilder(soilFrame);
//
//        mapTiles.add(soilTile);
//        
//        //purple soil 
//        Frame soil1Frame = new FrameBuilder(getSubImage(2, 7))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder soil1Tile = new MapTileBuilder(soil1Frame);
//
//        mapTiles.add(soil1Tile);
//        
//        //spinny soil 1
//        Frame spinnySoil1Frame = new FrameBuilder(getSubImage(2, 6))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder spinnySoil1Tile = new MapTileBuilder(spinnySoil1Frame);
//
//        mapTiles.add(spinnySoil1Tile);
//        
//        //spinny soil 2
//        Frame spinnySoil2Frame = new FrameBuilder(getSubImage(2, 6))
//                .withScale(tileScale)
//                .withImageEffect(ImageEffect.FLIP_H_AND_V)
//                .build();
//
//        MapTileBuilder spinnySoil2Tile = new MapTileBuilder(spinnySoil2Frame);
//
//        mapTiles.add(spinnySoil2Tile);
//        
//        //spinny soil 3
//        Frame spinnySoil3Frame = new FrameBuilder(getSubImage(2, 6))
//                .withScale(tileScale)
//                .withImageEffect(ImageEffect.FLIP_VERTICAL)
//                .build();
//
//        MapTileBuilder spinnySoil3Tile = new MapTileBuilder(spinnySoil3Frame);
//
//        mapTiles.add(spinnySoil3Tile);
//        
//        //spinny soil 4
//        Frame spinnySoil4Frame = new FrameBuilder(getSubImage(2, 6))
//                .withScale(tileScale)
//                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
//                .build();
//
//        MapTileBuilder spinnySoil4Tile = new MapTileBuilder(spinnySoil4Frame);
//
//        mapTiles.add(spinnySoil4Tile);
//        
//        //dancing mushrooms
//        Frame[] danceFrame = new Frame[] {
//                new FrameBuilder(getSubImage(3, 6), 500)
//                    .withScale(tileScale)
//                    .build(),
//                new FrameBuilder(getSubImage(4, 6), 500)
//                        .withScale(tileScale)
//                        .build(),
//                new FrameBuilder(getSubImage(0, 7), 500)
//                        .withScale(tileScale)
//                        .build()
//        };
//
//        MapTileBuilder danceTile = new MapTileBuilder(danceFrame);
//
//        mapTiles.add(danceTile);
//        
//        //sign
//        Frame signFrame = new FrameBuilder(getSubImage(3, 7))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder signTile = new MapTileBuilder(signFrame)
//        		.withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(signTile);
//        
//        //fence
//        Frame fenceFrame = new FrameBuilder(getSubImage(4, 7))
//                .withScale(tileScale)
//                .build();
//
//        MapTileBuilder fenceTile = new MapTileBuilder(fenceFrame)
//        		.withTileType(TileType.NOT_PASSABLE);
//
//        mapTiles.add(fenceTile);
//        
        return mapTiles;
    }
}
