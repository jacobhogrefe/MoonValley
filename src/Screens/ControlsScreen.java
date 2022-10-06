package Screens;

import Engine.*;
import Game.*;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

public class ControlsScreen extends Screen {

    protected ScreenCoordinator screenCoordinator;
    protected Screen previousScreen;
    protected PlayLevelScreen playLevelScreen;
    protected Map background;
    protected SpriteFont[] controls = new SpriteFont[9];

    public ControlsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
        this.playLevelScreen = screenCoordinator.getPlayLevelScreen();
        initialize();
    }

    public ControlsScreen(PlayLevelScreen playLevelScreen) {
        this.playLevelScreen = playLevelScreen;
        this.screenCoordinator = playLevelScreen.screenCoordinator;
        initialize();
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
        controls[8] = new SpriteFont("Press Space to go back", 20, 560, "Comic Sans", 30, Color.white);
        for (int i = 0; i < controls.length; i++) {
            controls[i].setOutlineColor(Color.black);
            controls[i].setOutlineThickness(3);
        }
    }

    @Override
    public void update() {
        background.update(null);

        //Checks whether or not playLevelScreen is null to go back to the proper screen
        //locking the key and checking if the spaceTimer is finished prevent the controls and pause menu from continually swapping between each other
        if (GlobalKeyCooldown.Keys.SPACE.onceDown()) {
            screenCoordinator.pop(this);
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        if (playLevelScreen != null) {
            graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 200));
        } else {
            background.draw(graphicsHandler);
        }
        for (int i = 0; i < controls.length; i++) {
            controls[i].draw(graphicsHandler);
        } 
    }  
}
