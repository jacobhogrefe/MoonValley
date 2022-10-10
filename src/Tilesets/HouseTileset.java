package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a interior tileset of standard tiles defined in the HouseTileset.png file
public class HouseTileset extends Tileset {

    public HouseTileset() {
        super(ImageLoader.load("HouseTileset.png"), 16, 16, 3);
    }
    
    //down across
    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // floor
        Frame floorFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder floorTile = new MapTileBuilder(floorFrame);

        mapTiles.add(floorTile);

        
        // wall
        Frame wallFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder wallTile = new MapTileBuilder(wallFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wallTile);

        
        // wall w baseboard
        Frame baseBoardFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder baseBoardTile = new MapTileBuilder(baseBoardFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(baseBoardTile);

        
        // window
        Frame windowFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder windowTile = new MapTileBuilder(windowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(windowTile);

        
        // log wall
        Frame logWallFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder logWallTile = new MapTileBuilder(logWallFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(logWallTile);
        
        
     // outside wall
        Frame outsideWallFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideWallTile = new MapTileBuilder(outsideWallFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(outsideWallTile);
        
        
        //rug
        Frame rugFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder rugTile = new MapTileBuilder(rugFrame);

        mapTiles.add(rugTile);
        
        
        //door
        Frame doorFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder doorTile = new MapTileBuilder(doorFrame)
        		.withTileType(TileType.NOT_PASSABLE);;

        mapTiles.add(doorTile);

      
        return mapTiles;
    }
}
