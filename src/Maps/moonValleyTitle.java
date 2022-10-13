package Maps;

import java.util.function.Supplier;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.ImageEffect;
import GameObject.Sprite;
import Level.Map;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Tilesets.TitleTileset;
import Utils.Colors;
import Utils.Point;
import Utils.Side;

// Represents the map that is used as a background for the main menu and credits menu screen
public class moonValleyTitle extends AbstractLoopingMap {

	 private Sprite cat;

    public moonValleyTitle() {
        super("moon_screen_map.txt", new TitleTileset());
        Point catLocation = getMapTile(8, 5).getLocation().subtractX(6).subtractY(7);
        cat = new Sprite(ImageLoader.loadSubImage("Cat.png", Colors.MAGENTA, 0, 0, 24, 24));
        cat.setScale(3);
        cat.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        cat.setLocation(catLocation.x, catLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
   
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        // Loop to the same map
        return () -> new TestMap();
    }

    @Override
    public Item getRequiredItem(Side edge) {
        return ItemRegistry.singleton.YOSHI_COIN;
    }
}