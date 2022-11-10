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

        //wall w baseboard dino
        Frame dinoBaseBoardFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder dinoBaseBoardTile = new MapTileBuilder(dinoBaseBoardFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dinoBaseBoardTile);
        
        //bed 1
        Frame bed1Frame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed1Tile = new MapTileBuilder(bed1Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed1Tile);
        
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
        
        //dino wall
        Frame dinoWallFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder dinoWallTile = new MapTileBuilder(dinoWallFrame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(dinoWallTile);
        
        //bed 2
        Frame bed2Frame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed2Tile = new MapTileBuilder(bed2Frame)
                .withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(bed2Tile);
        
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
        
        //filler
        Frame fillerFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder fillerTile = new MapTileBuilder(fillerFrame)
        		.withTileType(TileType.NOT_PASSABLE);;

        mapTiles.add(fillerTile);
        
        //walrus wall w baseboard
        Frame walrusBaseBoardFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder walrusBaseBoardTile = new MapTileBuilder(walrusBaseBoardFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(walrusBaseBoardTile);
        
        //walrus wall
        Frame walrusWallFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder walrusWallTile = new MapTileBuilder(walrusWallFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(walrusWallTile);
        
        //chair
        Frame chairFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder chairTile = new MapTileBuilder(chairFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(chairTile);
        
        //sofa 1
        Frame sofa1Frame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder sofa1Tile = new MapTileBuilder(sofa1Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(sofa1Tile);
        
        //sofa 2
        Frame sofa2Frame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder sofa2Tile = new MapTileBuilder(sofa2Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(sofa2Tile);
        
        //computer
        Frame computerFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder computerTile = new MapTileBuilder(computerFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(computerTile);
        
        //desk top
        Frame deskTopFrame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder deskTopTile = new MapTileBuilder(floorFrame)
        		.withTopLayer(deskTopFrame);

        mapTiles.add(deskTopTile);
        
        //desk bottom
        Frame deskBottomFrame = new FrameBuilder(getSubImage(4, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder deskBottomTile = new MapTileBuilder(floorFrame)
        		.withTopLayer(deskBottomFrame);

        mapTiles.add(deskBottomTile);
        
        //desk bottom w foot
        Frame deskBottomFootFrame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder deskBottomFootTile = new MapTileBuilder(floorFrame)
        		.withTileType(TileType.NOT_PASSABLE)
        		.withTopLayer(deskBottomFootFrame);

        mapTiles.add(deskBottomFootTile);
        
        //^ flipped
        Frame deskBottomFoot2Frame = new FrameBuilder(getSubImage(4, 3))
                .withScale(tileScale)
                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                .build();

        MapTileBuilder deskBottomFoot2Tile = new MapTileBuilder(floorFrame)
        		.withTileType(TileType.NOT_PASSABLE)
        		.withTopLayer(deskBottomFoot2Frame);

        mapTiles.add(deskBottomFoot2Tile);
        
        //swirly
        Frame swirlyFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder swirlyTile = new MapTileBuilder(swirlyFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(swirlyTile);
        
        //swirly 2
        Frame swirly2Frame = new FrameBuilder(getSubImage(5, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder swirly2Tile = new MapTileBuilder(swirly2Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(swirly2Tile);
        
        //swirly lol
        Frame swirly3Frame = new FrameBuilder(getSubImage(4, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder swirly3Tile = new MapTileBuilder(floorFrame)
        		.withTopLayer(swirly3Frame);

        mapTiles.add(swirly3Tile);
        
        //HAHAHAHHA
        Frame HAHAFrame = new FrameBuilder(getSubImage(4, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder HAHATile = new MapTileBuilder(HAHAFrame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(HAHATile);
        
        return mapTiles;
    }
}
