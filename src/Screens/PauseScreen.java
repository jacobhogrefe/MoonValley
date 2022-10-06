package Screens;

import Engine.GraphicsHandler;
import Engine.ScreenManager;
import Game.ScreenCoordinator;
import Screens.SaveSlotScreen.SlotType;
import SpriteFont.SpriteFont;
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
    protected int pointerLocationX, pointerLocationY;
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
            parent.screenCoordinator.push(new ControlsScreen(parent.screenCoordinator));
        }
    }

    public static class SaveOption extends Option {
        @Override
        public String getText() {
            return "SAVE";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.push(new SaveSlotScreen(parent.screenCoordinator, SlotType.SAVE));
        }
    }

    public static class LoadOption extends Option {
        @Override
        public String getText() {
            return "LOAD";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.push(new SaveSlotScreen(parent.screenCoordinator, SlotType.LOAD));
        }
    }

    public static class QuitOption extends Option {
        @Override
        public String getText() {
            return "QUIT";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.exitToMenu();
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
        this.options.add(new SaveOption());
        this.options.add(new LoadOption());
        this.options.add(new QuitOption());
    }

    @Override
    public void initialize() {
        super.initialize();
        pause = new SpriteFont("PAUSED", 10, 305, "Comic Sans", 30, Color.white);
        pause.setOutlineColor(Color.black);
        pause.setOutlineThickness(3);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 200));
        pause.draw(graphicsHandler);
        super.draw(graphicsHandler);
    }
}
