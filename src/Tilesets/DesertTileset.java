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
public class DesertTileset extends Tileset {

    public DesertTileset() {
        super(ImageLoader.load("DesertTileset.png"), 16, 16, 3);
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
        
        
       //cactus stem 1
        Frame cactusStem1Frame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder cactusStem1Tile = new MapTileBuilder(cactusStem1Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(cactusStem1Tile);
        
      
        //cactus stem 2
        Frame cactusStem2Frame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder cactusStem2Tile = new MapTileBuilder(floorFrame)
        		.withTopLayer(cactusStem2Frame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(cactusStem2Tile);
        
        //cactus with branch
        Frame branchFrame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder branchTile = new MapTileBuilder(floorFrame)
        		.withTopLayer(branchFrame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(branchTile);
        
        //cactus with branch 2
        Frame branch2Frame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder branch2Tile = new MapTileBuilder(floorFrame)
        		.withTopLayer(branch2Frame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(branch2Tile);
        
        //branch left
        Frame branchLeftFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder branchLeftTile = new MapTileBuilder(floorFrame)
        		.withTopLayer(branchLeftFrame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(branchLeftTile);
        
        //branch right
        Frame branchRightFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder branchRightTile = new MapTileBuilder(floorFrame)
        		.withTopLayer(branchRightFrame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(branchRightTile);
        
        //cactus top 1
        Frame cactusTop1Frame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder cactusTop1Tile = new MapTileBuilder(floorFrame)
        		.withTopLayer(cactusTop1Frame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(cactusTop1Tile);
        
        //cactus top 2
        Frame cactusTop2Frame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder cactusTop2Tile = new MapTileBuilder(floorFrame)
        		.withTopLayer(cactusTop2Frame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(cactusTop2Tile);
        
        //aloe
        Frame aloeFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder aloeTile = new MapTileBuilder(aloeFrame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(aloeTile);
        
        //hill 1
        Frame hill1Frame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder hill1Tile = new MapTileBuilder(hill1Frame);

        mapTiles.add(hill1Tile);
        
        //hill 2
        Frame hill2Frame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder hill2Tile = new MapTileBuilder(hill2Frame);

        mapTiles.add(hill2Tile);
        
        
        return mapTiles;
    }
}
