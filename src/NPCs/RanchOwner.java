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

// bears a striking resemblance to Doug Dimidome, owner of the Dimsdale Dimidome
public class RanchOwner extends NPC {
	
	

    public RanchOwner(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("RanchOwner.png"), 33, 41), "STAND_LEFT");
        
    }

    public void update(Player player) {

        super.update(player);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(8, 10, 8, 25)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(2)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .withBounds(8, 10, 8, 25)
                           .build()
           });

           
        }};
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
      
    }
    

    
  
}
