package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;
import java.util.ArrayList;

public class BiomeSpookyHomeTilesets extends Tileset {
	
	public BiomeSpookyHomeTilesets() {
        super(ImageLoader.load("BiomeSpookyHome.png"), 16, 16, 3);
    }
	
	@Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
              
        
      //back wall 1
        Frame backwall1Frame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder backwall1tile = new MapTileBuilder(backwall1Frame)
        		.withTileType(TileType.NOT_PASSABLE);


        mapTiles.add(backwall1tile);
        
        // back wall with window
        Frame backwindowFrame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder backwindowtile = new MapTileBuilder(backwindowFrame)
		.withTileType(TileType.NOT_PASSABLE);


        mapTiles.add(backwindowtile);
        
        //Front carpet
        Frame frontcarpetFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder frontcarpettile = new MapTileBuilder(frontcarpetFrame);

        mapTiles.add(frontcarpettile);
        
        //ground 1
        Frame ground1Frame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder ground1tile = new MapTileBuilder(ground1Frame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(ground1tile);
        
        //ground 2
        Frame ground2Frame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder ground2tile = new MapTileBuilder(ground2Frame)
        		.withTileType(TileType.PASSABLE);

        mapTiles.add(ground2tile);
        
        //side wall 
        Frame sidewallFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder sidewalltile = new MapTileBuilder(sidewallFrame)
        		.withTileType(TileType.NOT_PASSABLE);


        mapTiles.add(sidewalltile);
        
        //door 
        Frame doorFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder doortile = new MapTileBuilder(doorFrame)
        		.withTileType(TileType.NOT_PASSABLE);


        mapTiles.add(doortile);
        
        //front wall
        Frame frontwallFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder frontwalltile = new MapTileBuilder(frontwallFrame)
        		.withTileType(TileType.NOT_PASSABLE);


        mapTiles.add(frontwalltile);
        
        //candy dish
        Frame candydishFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder candydishtile = new MapTileBuilder(candydishFrame)
        		.withTileType(TileType.NOT_PASSABLE);
        

        mapTiles.add(candydishtile);
        
        
        return mapTiles;
	
	}
}