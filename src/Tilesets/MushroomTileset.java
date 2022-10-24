package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a interior tileset of standard tiles defined in the MushroomTileset.png file
public class MushroomTileset extends Tileset {

    public MushroomTileset() {
        super(ImageLoader.load("MushroomTileset.png"), 16, 16, 3);
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
        
        //floor 2
        Frame floorFrame2 = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder floorTile2 = new MapTileBuilder(floorFrame2);

        mapTiles.add(floorTile2);
        
        //floor 3
        Frame floorFrame3 = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder floorTile3 = new MapTileBuilder(floorFrame3);

        mapTiles.add(floorTile3);
        
        //floor mushroom
        Frame mushroomFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTile = new MapTileBuilder(mushroomFrame);

        mapTiles.add(mushroomTile);
        
        // big mushroom base
        Frame mushroomBaseFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomBaseTile = new MapTileBuilder(mushroomBaseFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(mushroomBaseTile);
        
        //mushroom stem 1
        Frame mushroomStem1Frame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomStem1Tile = new MapTileBuilder(mushroomStem1Frame);

        mapTiles.add(mushroomStem1Tile);
        
        //mushroom stem 2
        Frame mushroomStem2Frame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomStem2Tile = new MapTileBuilder(mushroomStem2Frame);

        mapTiles.add(mushroomStem2Tile);
        
        //mushroom stem 3
        Frame mushroomStem3Frame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomStem3Tile = new MapTileBuilder(mushroomStem3Frame);

        mapTiles.add(mushroomStem3Tile);
        
        //branch 1
        Frame branch1Frame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder branch1Tile = new MapTileBuilder(branch1Frame);

        mapTiles.add(branch1Tile);
        
        //branch 2
        Frame branch2Frame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder branch2Tile = new MapTileBuilder(branch2Frame);

        mapTiles.add(branch2Tile);
        
        //mushroom top 1
        Frame mushroomTop1Frame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTop1Tile = new MapTileBuilder(mushroomTop1Frame);

        mapTiles.add(mushroomTop1Tile);
        
        //mushroom top 2
        Frame mushroomTop2Frame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTop2Tile = new MapTileBuilder(mushroomTop2Frame);

        mapTiles.add(mushroomTop2Tile);
        
        //mushroom top 3
        Frame mushroomTop3Frame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTop3Tile = new MapTileBuilder(mushroomTop3Frame);

        mapTiles.add(mushroomTop3Tile);
        
        //mushroom top 4
        Frame mushroomTop4Frame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTop4Tile = new MapTileBuilder(mushroomTop4Frame);

        mapTiles.add(mushroomTop4Tile);
        
        //mushroom top 5
        Frame mushroomTop5Frame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTop5Tile = new MapTileBuilder(mushroomTop5Frame);

        mapTiles.add(mushroomTop5Tile);
        
        //mushroom top 6
        Frame mushroomTop6Frame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder mushroomTop6Tile = new MapTileBuilder(mushroomTop6Frame);

        mapTiles.add(mushroomTop6Tile);
        
        return mapTiles;
    }
}
