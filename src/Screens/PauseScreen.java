package Screens;

import Engine.GraphicsHandler;
import Engine.ScreenManager;
import Game.ScreenCoordinator;
import Level.Player;
import Screens.SaveSlotScreen.SlotType;
import SpriteFont.SpriteFont;
import java.awt.*;

public class PauseScreen extends AbstractMenuScreen {

    protected ScreenCoordinator screenCoordinator;
    protected PlayLevelScreen playLevelScreen;
    protected ControlsScreen controlsScreen;
    protected int currentMenuItemHovered = 0;
    protected int menuItemSelected = -1;
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
            Player.MapEntityManager.clearAllFurniture();
            parent.screenCoordinator.exitToMenu();
        }
    }
    
    public PauseScreen(PlayLevelScreen playLevelScreen, ScreenCoordinator screenCoordinator) {
        super(screenCoordinator);
        this.playLevelScreen = playLevelScreen;
        initialize();
    }

    @Override
    public String getTitle() {
        return "PAUSED";
    }

    @Override
    public void addOptions() {
        this.options.add(new ResumeOption());
        this.options.add(new ControlsOption());
        this.options.add(new SaveOption());
        if (SaveSlotScreen.saveSlot || SaveSlotScreen.saveSlot1 || SaveSlotScreen.saveSlot2) {
            this.options.add(new LoadOption());
        }
        this.options.add(new QuitOption());
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), new Color(0, 0, 0, 200));
        super.draw(graphicsHandler);
    }
}
