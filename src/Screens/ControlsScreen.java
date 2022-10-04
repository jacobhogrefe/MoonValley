package Screens;

import Engine.*;
import Game.*;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import java.awt.*;

public class ControlsScreen extends Screen {

    protected ScreenCoordinator screenCoordinator;
    protected Screen previousScreen;
    protected Map background;
    protected KeyLocker keyLocker = new KeyLocker();
    protected GameState previousGameState;
    protected SpriteFont[] controls = new SpriteFont[9];

    public ControlsScreen(ScreenCoordinator screenCoordinator, GameState previousGameState) {
        this.screenCoordinator = screenCoordinator;
        this.previousGameState = previousGameState;
    }

    @Override
    public void initialize() {
        background = new TitleScreenMap();
        background.setAdjustCamera(false);

        controls[0] = new SpriteFont("Controls", 20, 50, "Comic Sans", 30, Color.white);
        controls[1] = new SpriteFont("W/Up arrow: Move player up", 50, 90, "Comic Sans", 30, Color.white);
        controls[2] = new SpriteFont("A/Left arrow: Move player left", 50, 130, "Comic Sans", 30, Color.white);
        controls[3] = new SpriteFont("D/Right arrow: Move player right", 50, 170, "Comic Sans", 30, Color.white);
        controls[4] = new SpriteFont("S/Down arrow: Move player down", 50, 210, "Comic Sans", 30, Color.white);
        controls[5] = new SpriteFont("Space: Interact with NPCs/search for collectibles", 50, 250, "Comic Sans", 30, Color.white);
        controls[6] = new SpriteFont("I: Access the Inventory", 50, 290, "Comic Sans", 30, Color.white);
        controls[7] = new SpriteFont("P: Pause game", 50, 330, "Comic Sans", 30, Color.white);
        controls[8] = new SpriteFont("Press Space to return to the menu", 20, 560, "Comic Sans", 30, Color.white);

        for (int i = 0; i < controls.length; i++) {
            controls[i].setOutlineColor(Color.black);
            controls[i].setOutlineThickness(3);
        }

        keyLocker.lockKey(Key.SPACE);
    }

    @Override
    public void update() {
        background.update(null);

        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(previousGameState);
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        for (int i = 0; i < controls.length; i++) {
            controls[i].draw(graphicsHandler);
        } 
    }  
}
