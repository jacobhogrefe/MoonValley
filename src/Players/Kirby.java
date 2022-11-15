package Players;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.CatWardrobe;
import Level.Player;
import java.util.HashMap;

public class Kirby extends Player {

    public Kirby(float x, float y) {
        super(new SpriteSheet(ImageLoader.load("kirby.png"), 21, 19), x, y, "STAND_RIGHT");
        walkSpeed = 2.3f;
    }
    
    public void update() {
        super.update();
    }

    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        // drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
    }

    @Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 3500)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 100)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build()
            });

            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 3500)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 7)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 100)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 7)
                            .build()
            });

            put("WALK_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 5), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 6), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 7), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 8), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 9), 75)
                            .withScale(2)
                            .withBounds(5, 5, 12, 12)
                            .build()
            });

            put("WALK_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(1, 0), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 1), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 2), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 3), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 4), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 5), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 6), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 7), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 8), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build(),
                    new FrameBuilder(spriteSheet.getSprite(1, 9), 75)
                            .withScale(2)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .withBounds(5, 5, 12, 12)
                            .build()
            });
        }};
    }
}