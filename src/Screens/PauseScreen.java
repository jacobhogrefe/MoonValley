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

public class PauseScreen extends AbstractMenuScreen {

    protected ScreenCoordinator screenCoordinator;
    protected PlayLevelScreen playLevelScreen;
    protected ControlsScreen controlsScreen;
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
    protected SpriteFont pause;
    protected SpriteFont resume;
    protected SpriteFont controls;
    protected SpriteFont saveAndQuit;
    protected Stopwatch keyTimer = new Stopwatch();
    protected Stopwatch spaceTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    protected boolean isControlsOpen = false;

    public static class ResumeOption extends Option {
        @Override
        public String getText() {
            return "RESUME";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            ((PauseScreen) parent).playLevelScreen.resumeLevel();
        }
    }

    public static class ControlsOption extends Option {
        @Override
        public String getText() {
            return "CONTROLS";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            //locking the key and checking if the spaceTimer is finished prevent the controls and pause menu from continually swapping between each other
            if (!((PauseScreen) parent).spaceTimer.isTimeUp()) {
                parent.menuItemSelected = -1;
                return;
            }

            parent.keyLocker.lockKey(Key.SPACE);
            ((PauseScreen) parent).playLevelScreen.controls();
        }
    }

    public static class SaveAndQuitOption extends Option {
        @Override
        public String getText() {
            return "SAVE AND QUIT";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            // SAVE LOGIC GOES HERE
            parent.screenCoordinator.setGameState(GameState.MENU);
        }
    }
    
    public PauseScreen(PlayLevelScreen playLevelScreen, ScreenCoordinator screenCoordinator) {
        super(screenCoordinator);
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public void addOptions() {
        this.options.add(new ResumeOption());
        this.options.add(new ControlsOption());
        this.options.add(new SaveAndQuitOption());
    }

    @Override
    public void initialize() {
        super.initialize();
        pause = new SpriteFont("PAUSED", 10, 405, "Comic Sans", 30, Color.white);
        pause.setOutlineColor(Color.black);
        pause.setOutlineThickness(3);
        spaceTimer.setWaitTime(50);
    }

    @Override
    public void update() {
        if (Keyboard.isKeyUp(Key.SPACE) && spaceTimer.isTimeUp()) {
            spaceTimer.reset();
            keyLocker.unlockKey(Key.SPACE);
        }

        super.update();
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 200));
        pause.draw(graphicsHandler);
        super.draw(graphicsHandler);
    }
}
