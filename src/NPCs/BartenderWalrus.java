package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Screens.PlayLevelScreen;
import Utils.Point;

import java.awt.Color;
import java.util.HashMap;

// This class is for the walrus NPC
public class BartenderWalrus extends NPC {
	
	

    public BartenderWalrus(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("BartenderWalrus.png"), 24, 24), "STAND_LEFT");
        
    }

    public void update(Player player) {

        super.update(player);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
        	int idlespeed = 500;
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0),idlespeed)
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1),idlespeed)
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build(),
                            
                    new FrameBuilder(spriteSheet.getSprite(1, 0),idlespeed)
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1),idlespeed)
                            .withScale(3)
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
                            
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0),idlespeed)
                           .withScale(3)
                           .withBounds(7, 13, 11, 7)
                           .build(),
                   new FrameBuilder(spriteSheet.getSprite(1, 1),idlespeed)
                           .withScale(3)
                           .withBounds(7, 13, 11, 7)
                           .build(),
                  new FrameBuilder(spriteSheet.getSprite(1, 0),idlespeed)
                           .withScale(3)
                           .withBounds(7, 13, 11, 7)
                           .build(),
                   new FrameBuilder(spriteSheet.getSprite(1, 1),idlespeed)
                           .withScale(3)
                           .withBounds(7, 13, 11, 7)
                           .build()
           });
           
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
      
    }
    

    
  
}
