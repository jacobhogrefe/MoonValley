package NPCs;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;

import java.util.HashMap;

// This class is for the dinosaur NPC
public class Cattle extends NPC {
	
	protected boolean isTethered = false;
	

    public Cattle(int id, Point location) {
        super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Cattle2.png"), 29, 29), "STAND_RIGHT");
        this.setTetherable(true);
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(4)
                            .withBounds(4, 5, 25, 25)
                            .build()
            });
            put("STAND_LEFT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(4)
                           .withBounds(4, 5, 25, 25)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build()
           });

            put("WALK_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 200)
                            .withScale(4)
                            .withBounds(4, 5, 25, 25)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 200)
                            .withScale(4)
                            .withBounds(4, 5, 25, 25)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 200)
                            .withScale(4)
                            .withBounds(4, 5, 25, 25)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 200)
                            .withScale(4)
                            .withBounds(4, 5, 25, 25)
                            .build()
                            
            });

            put("WALK_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 200)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(4, 5, 25, 25)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 200)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(4, 5, 25, 25)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 200)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(4, 5, 25, 25)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 200)
                    .withScale(4)
                    .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                    .withBounds(4, 5, 25, 25)
                    .build()
            });
            
            put("EAT_GRASS", new Frame[]{
            		
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 200)
                    .withScale(4)
                    .withBounds(4, 5, 25, 25)
                    .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 2), 200)
                    .withScale(4)
                    .withBounds(4, 5, 25, 25)
                    .build()
      
            });
            
        }};
    }
    
    @Override
	public boolean isTethered() {
		return isTethered;
	}

    @Override
	public void setTether(boolean isTethered, Player player) {
		if (isTethered) {
			this.isTethered = true;
		}

		if (!isTethered) {
			this.isTethered = false;
		}
	}

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
}
