package Screens;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Engine.ScreenManager;
import Game.GameState;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;
import java.awt.*;

public class PauseScreen extends Screen {

    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
    protected SpriteFont pause;
    protected SpriteFont resume;
    protected SpriteFont controls;
    protected SpriteFont saveAndQuit;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();

    public PauseScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        pause = new SpriteFont("PAUSE", 40, 455, "Comic Sans", 30, Color.white);
        pause.setOutlineColor(Color.black);
        pause.setOutlineThickness(3);
        resume = new SpriteFont("RESUME", 40, 455, "Comic Sans", 30, new Color(49, 207, 240));
        resume.setOutlineColor(Color.black);
        resume.setOutlineThickness(3);
        controls = new SpriteFont("CONTROLS", 40, 505, "Comic Sans", 30, new Color(49, 207, 240));
        controls.setOutlineColor(Color.black);
        controls.setOutlineThickness(3);
        saveAndQuit = new SpriteFont("SAVE AND QUIT", 40, 555, "Comic Sans", 30, new Color(49, 207, 240));
        saveAndQuit.setOutlineColor(Color.black);
        saveAndQuit.setOutlineThickness(3);
        keyTimer.setWaitTime(200);
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyDown(Key.DOWN) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.UP) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered--;
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentMenuItemHovered > 2) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 2;
        }

        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        //if another button needs to be added, increase the Y location of the pointer by 50
        if (currentMenuItemHovered == 0) {
            resume.setColor(new Color(255, 215, 0));
            controls.setColor(new Color(49, 207, 240));
            saveAndQuit.setColor(new Color(49, 207, 240));
            pointerLocationX = 10;
            pointerLocationY = 435;
        } else if (currentMenuItemHovered == 1) {
            resume.setColor(new Color(49, 207, 240));
            controls.setColor(new Color(255, 215, 0));
            saveAndQuit.setColor(new Color(49, 207, 240));
            pointerLocationX = 10;
            pointerLocationY = 485;
        } else if (currentMenuItemHovered == 2) {
            resume.setColor(new Color(49, 207, 240));
            controls.setColor(new Color(49, 207, 240));
            saveAndQuit.setColor(new Color(255, 215, 0));
            pointerLocationX = 10;
            pointerLocationY = 535;
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.LEVEL);
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.CONTROLS);
            } else if (menuItemSelected == 2) {
                //SAVE LOGIC GOES HERE
                screenCoordinator.setGameState(GameState.MENU);
            }
        }
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 200));
        pause.draw(graphicsHandler);
        resume.draw(graphicsHandler);
        controls.draw(graphicsHandler);
        saveAndQuit.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }

    public int getMenuItemSelected() {
        return menuItemSelected;
    }
}
