package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a interior tileset of standard tiles defined in the HouseTileset.png file
public class MushroomHomeTileset extends Tileset {

    public MushroomHomeTileset() {
        super(ImageLoader.load("MushroomHomeTileset.png"), 16, 16, 3);
    }
    
    //down across
    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // floor
        Frame floorFrame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder floorTile = new MapTileBuilder(floorFrame);

        mapTiles.add(floorTile);

        
        // wall
        Frame wallFrame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder wallTile = new MapTileBuilder(wallFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(wallTile);
        
        // window
        Frame windowFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder windowTile = new MapTileBuilder(windowFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(windowTile);
        
        // door
        Frame doorFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder doorTile = new MapTileBuilder(doorFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(doorTile);
        
        // barrier
        Frame barrierFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder barrierTile = new MapTileBuilder(barrierFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(barrierTile);
        
        //outside wall
        Frame outsideFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder outsideTile = new MapTileBuilder(outsideFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(outsideTile);
        
        //outside wall2
        Frame outside2Frame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder outside2Tile = new MapTileBuilder(outside2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(outside2Tile);
        
        //outside wall 2 flipped
        Frame outside2flippedFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();

        MapTileBuilder outside2flippedTile = new MapTileBuilder(outside2flippedFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(outside2flippedTile);
        
        //outside wall3
        Frame outside3Frame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder outside3Tile = new MapTileBuilder(outside3Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(outside3Tile);
        
        //outside wall 3 flipped
        Frame outside3flippedFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_VERTICAL)
                .build();

        MapTileBuilder outside3flippedTile = new MapTileBuilder(outside3flippedFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(outside3flippedTile);
        
        //side wall
        Frame sideWallFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder sideWallTile = new MapTileBuilder(sideWallFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(sideWallTile);

        //dresser 1
        Frame dresser1Frame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder dresser1Tile = new MapTileBuilder(dresser1Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dresser1Tile);
        
        //dresser 2
        Frame dresser2Frame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder dresser2Tile = new MapTileBuilder(dresser2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dresser2Tile);
        
        //dresser 3
        Frame dresser3Frame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder dresser3Tile = new MapTileBuilder(dresser3Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dresser3Tile);
        
        //dresser 4
        Frame dresser4Frame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder dresser4Tile = new MapTileBuilder(dresser4Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dresser4Tile);
        
        //bed 1
        Frame bed1Frame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed1Tile = new MapTileBuilder(bed1Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed1Tile);
        
        //bed 2
        Frame bed2Frame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed2Tile = new MapTileBuilder(bed2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed2Tile);
        
        //bed 3
        Frame bed3Frame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed3Tile = new MapTileBuilder(bed3Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed3Tile);
        
        //bed 4
        Frame bed4Frame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed4Tile = new MapTileBuilder(bed4Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed4Tile);
        
        //bed 5
        Frame bed5Frame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed5Tile = new MapTileBuilder(bed5Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed5Tile);
        
        //bed 6
        Frame bed6Frame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed6Tile = new MapTileBuilder(bed6Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed6Tile);
       
        
        return mapTiles;
    }
}
