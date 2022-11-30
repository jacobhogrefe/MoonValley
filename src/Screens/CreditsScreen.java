package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.moonValleyTitle;
import SpriteFont.SpriteFont;

import java.awt.*;

// This class is for the credits screen
public class CreditsScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected Map background;
    protected SpriteFont creditsLabel;
    protected SpriteFont createdByLabel;
    protected SpriteFont returnInstructionsLabel;

    public CreditsScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        // setup graphics on screen (background map, spritefont text)
        background = new moonValleyTitle();
        background.setAdjustCamera(false);
        creditsLabel = new SpriteFont("Credits", 15, 35, "Times New Roman", 30, Color.white);
        createdByLabel = new SpriteFont("Created by Alex Thimineur", 130, 140, "Times New Roman", 20, Color.white);
        returnInstructionsLabel = new SpriteFont("Press Space to return to the menu", 20, 560, "Times New Roman", 30, Color.white);
    }

    public void update() {
        background.update(null);

        GlobalKeyCooldown.Keys.SPACE.cancelIfUp();

        // if space is pressed, go back to main menu
        if (GlobalKeyCooldown.Keys.SPACE.onceDown()) {
            screenCoordinator.pop(this);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        creditsLabel.draw(graphicsHandler);
        createdByLabel.drawWithParsedNewLines(graphicsHandler);
        returnInstructionsLabel.draw(graphicsHandler);
    }
}
