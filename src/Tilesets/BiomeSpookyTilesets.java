package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;
import java.util.ArrayList;

public class BiomeSpookyTilesets extends Tileset {

    public BiomeSpookyTilesets() {
        super(ImageLoader.load("BiomeSpooky2.png"), 16, 16, 3);
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
        Frame grassfloortile1Frame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassfloortile1 = new MapTileBuilder(grassfloortile1Frame);

        mapTiles.add(grassfloortile1);
        
        //grass floor tile 2
        Frame grassfloortile2Frame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder grassfloortile2 = new MapTileBuilder(grassfloortile2Frame)
        		.withTileType(TileType.NOT_PASSABLE);
        

        mapTiles.add(grassfloortile2);
                
        // Tree stem base 1 
        Frame treestem1Frame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder treestem1Tile = new MapTileBuilder(treestem1Frame)
                .withTopLayer(treestem1Frame)
        		.withTileType(TileType.NOT_PASSABLE);

        mapTiles.add(treestem1Tile);
        
     // Castle plain
        Frame CastleplainFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder CastleplainTile = new MapTileBuilder(CastleplainFrame)
                .withTopLayer(CastleplainFrame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(CastleplainTile);
        
        //Pumpkin left top corner 
        
        Frame PumpkinlefttopFrame = new FrameBuilder(getSubImage(1, 0))
              .withScale(tileScale)
              .build();

      MapTileBuilder PumpkinlefttopTile = new MapTileBuilder(PumpkinlefttopFrame)
      		.withTopLayer(PumpkinlefttopFrame)
      		.withTileType(TileType.NOT_PASSABLE);

      mapTiles.add(PumpkinlefttopTile);
        
    //Pumpkin stem1 top  
      
      Frame Pumpkinstem1Frame = new FrameBuilder(getSubImage(1, 1))
            .withScale(tileScale)
            .build();

    MapTileBuilder Pumpkinstem1Tile = new MapTileBuilder(Pumpkinstem1Frame)
    		.withTopLayer(Pumpkinstem1Frame)
    		.withTileType(TileType.NOT_PASSABLE);

    mapTiles.add(Pumpkinstem1Tile);
    
  //Pumpkin stem2 top  
    
    Frame Pumpkinstem2Frame = new FrameBuilder(getSubImage(1, 2))
          .withScale(tileScale)
          .build();

  MapTileBuilder Pumpkinstem2Tile = new MapTileBuilder(Pumpkinstem2Frame)
  		.withTopLayer(Pumpkinstem2Frame)
  		.withTileType(TileType.NOT_PASSABLE);

  mapTiles.add(Pumpkinstem2Tile);
  
//Pumpkin right top corner 
  
  Frame PumpkinrighttopFrame = new FrameBuilder(getSubImage(1, 3))
        .withScale(tileScale)
        .build();

MapTileBuilder PumpkinrighttopTile = new MapTileBuilder(PumpkinrighttopFrame)
		.withTopLayer(PumpkinrighttopFrame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(PumpkinrighttopTile);


//Pumpkin left side  

Frame PumpkinrleftsideFrame = new FrameBuilder(getSubImage(2, 0))
      .withScale(tileScale)
      .build();

MapTileBuilder PumpkinleftsideTile = new MapTileBuilder(PumpkinrleftsideFrame)
		.withTopLayer(PumpkinrleftsideFrame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(PumpkinleftsideTile);


//Pumpkin left center  

Frame PumpkinrleftcenterFrame = new FrameBuilder(getSubImage(2, 1))
    .withScale(tileScale)
    .build();

MapTileBuilder PumpkinleftcenterTile = new MapTileBuilder(PumpkinrleftcenterFrame)
		.withTopLayer(PumpkinrleftcenterFrame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(PumpkinleftcenterTile);

//Pumpkin right center  

Frame PumpkinrrightcenterFrame = new FrameBuilder(getSubImage(2, 2))
  .withScale(tileScale)
  .build();

MapTileBuilder PumpkinrightcenterTile = new MapTileBuilder(PumpkinrrightcenterFrame)
		.withTopLayer(PumpkinrrightcenterFrame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(PumpkinrightcenterTile);

//Pumpkin right side  

Frame PumpkinrightsideFrame = new FrameBuilder(getSubImage(2, 3))
    .withScale(tileScale)
    .build();

MapTileBuilder PumpkinrightsideTile = new MapTileBuilder(PumpkinrightsideFrame)
		.withTopLayer(PumpkinrightsideFrame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(PumpkinrightsideTile);

//Pumpkin bottom left  

Frame PumpkinbottomleftFrame = new FrameBuilder(getSubImage(3, 0))
  .withScale(tileScale)
  .build();

MapTileBuilder PumpkinbottomleftTile = new MapTileBuilder(PumpkinbottomleftFrame)
		.withTopLayer(PumpkinbottomleftFrame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(PumpkinbottomleftTile);

//Pumpkin bottom left2  

Frame Pumpkinbottomleft2Frame = new FrameBuilder(getSubImage(3, 1))
.withScale(tileScale)
.build();

MapTileBuilder Pumpkinbottomleft2Tile = new MapTileBuilder(Pumpkinbottomleft2Frame)
		.withTopLayer(Pumpkinbottomleft2Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Pumpkinbottomleft2Tile);

//Pumpkin bottom right  

Frame PumpkinbottomrightFrame = new FrameBuilder(getSubImage(3, 2))
.withScale(tileScale)
.build();

MapTileBuilder PumpkinbottomrightTile = new MapTileBuilder(PumpkinbottomrightFrame)
		.withTopLayer(PumpkinbottomrightFrame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(PumpkinbottomrightTile);
        
//Pumpkin bottom right2  

Frame Pumpkinbottomright2Frame = new FrameBuilder(getSubImage(3, 3))
.withScale(tileScale)
.build();

MapTileBuilder Pumpkinbottomright2Tile = new MapTileBuilder(Pumpkinbottomright2Frame)
		.withTopLayer(Pumpkinbottomright2Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Pumpkinbottomright2Tile);

//Castle1 

Frame Castle1Frame = new FrameBuilder(getSubImage(4, 0))
.withScale(tileScale)
.build();

MapTileBuilder Castle1Tile = new MapTileBuilder(Castle1Frame)
		.withTopLayer(Castle1Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Castle1Tile);


//Castle2 

Frame Castle2Frame = new FrameBuilder(getSubImage(4, 1))
.withScale(tileScale)
.build();

MapTileBuilder Castle2Tile = new MapTileBuilder(Castle2Frame)
		.withTopLayer(Castle2Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Castle2Tile);

//Castle3 

Frame Castle3Frame = new FrameBuilder(getSubImage(4, 2))
.withScale(tileScale)
.build();

MapTileBuilder Castle3Tile = new MapTileBuilder(Castle3Frame)
		.withTopLayer(Castle3Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Castle3Tile);


//Castle4 

Frame Castle4Frame = new FrameBuilder(getSubImage(4, 3))
.withScale(tileScale)
.build();

MapTileBuilder Castle4Tile = new MapTileBuilder(Castle4Frame)
		.withTopLayer(Castle4Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Castle4Tile);

//Castle5

Frame Castle5Frame = new FrameBuilder(getSubImage(4, 4))
.withScale(tileScale)
.build();

MapTileBuilder Castle5Tile = new MapTileBuilder(Castle5Frame)
		.withTopLayer(Castle5Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Castle5Tile);
        

//Castle6 

Frame Castle6Frame = new FrameBuilder(getSubImage(0, 4))
.withScale(tileScale)
.build();

MapTileBuilder Castle6Tile = new MapTileBuilder(Castle6Frame)
		.withTopLayer(Castle6Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Castle6Tile);

//Castle7

Frame Castle7Frame = new FrameBuilder(getSubImage(1, 4))
.withScale(tileScale)
.build();

MapTileBuilder Castle7Tile = new MapTileBuilder(Castle7Frame)
		.withTopLayer(Castle7Frame)
		.withTileType(TileType.PASSABLE);

mapTiles.add(Castle7Tile);
      
//Castle8

Frame Castle8Frame = new FrameBuilder(getSubImage(2, 4))
.withScale(tileScale)
.build();

MapTileBuilder Castle8Tile = new MapTileBuilder(Castle8Frame)
		.withBottomLayer(Castle8Frame)
		.withTileType(TileType.PASSABLE);

mapTiles.add(Castle8Tile);

//Castle9

Frame Castle9Frame = new FrameBuilder(getSubImage(3, 4))
.withScale(tileScale)
.build();

MapTileBuilder Castle9Tile = new MapTileBuilder(Castle9Frame)
		.withBottomLayer(Castle9Frame)
		.withTileType(TileType.PASSABLE);
mapTiles.add(Castle9Tile);

//Castle10

Frame Castle10Frame = new FrameBuilder(getSubImage(4, 4))
.withScale(tileScale)
.build();

MapTileBuilder Castle10Tile = new MapTileBuilder(Castle10Frame)
		.withBottomLayer(Castle10Frame)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(Castle10Tile);
//0,5
Frame gravelFrame = new FrameBuilder(getSubImage(0, 5))
.withScale(tileScale)
.build();

MapTileBuilder gravelTile = new MapTileBuilder(gravelFrame)
.withBottomLayer(gravelFrame)
.withTileType(TileType.PASSABLE);
mapTiles.add(gravelTile);


Frame treeleafFrame = new FrameBuilder(getSubImage(1, 5))
.withScale(tileScale)
.build();

MapTileBuilder treeleafTile = new MapTileBuilder(treeleafFrame)
		.withTopLayer(treeleafFrame)
		.withTileType(TileType.PASSABLE);

mapTiles.add(treeleafTile);


Frame treeJawn = new FrameBuilder(getSubImage(1, 4))
.withScale(tileScale)
.build();

MapTileBuilder treeJawn2 = new MapTileBuilder(treeJawn)
		.withTopLayer(treeJawn)
		.withTileType(TileType.NOT_PASSABLE);

mapTiles.add(treeJawn2);

        return mapTiles;
    }
}
