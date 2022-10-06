package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;
import java.util.ArrayList;

// This is the class for a generic menu screen.
public abstract class AbstractMenuScreen extends Screen {
    public static abstract class Option {
        // these variables are used by the parent class
        protected SpriteFont spriteFont;

        public abstract String getText();
        public abstract void select(AbstractMenuScreen parent);
    }

    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected ArrayList<Option> options = new ArrayList<>();
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();

    protected static final Color COLOR_SELECTED = new Color(49, 207, 240);
    protected static final Color COLOR_UNSELECTED = new Color(255, 215, 0);

    public AbstractMenuScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    // add all the Options to this.options
    public abstract void addOptions();

    public int getNumItems() {
        return this.options.size();
    }

    //if another button needs to be added change the Y-value by 50 and the X-value by
    @Override
    public void initialize() {
        this.addOptions();

        int minY = 505 - this.getNumItems() * 50;

        for (int i = 0; i < this.getNumItems(); i++) {
            Option o = this.options.get(i);
            o.spriteFont = new SpriteFont(
                o.getText(),
                40,
                minY + 50 * i,
                "Comic Sans",
                30,
                COLOR_UNSELECTED
            );
            o.spriteFont.setOutlineColor(Color.black);
            o.spriteFont.setOutlineThickness(3);
        }

        keyTimer.setWaitTime(200);
        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.DOWN) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.UP) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered--;
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentMenuItemHovered >= this.getNumItems()) {
            currentMenuItemHovered = 0;
        } else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = this.getNumItems() - 1;
        }

        for (int i = 0; i < this.getNumItems(); i++) {
            if (currentMenuItemHovered == i) {
                this.options.get(i).spriteFont.setColor(COLOR_SELECTED);
            } else {
                this.options.get(i).spriteFont.setColor(COLOR_UNSELECTED);
            }
        }

        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        pointerLocationX = 10;
        pointerLocationY = 585 - 50 * this.getNumItems() + 50 * currentMenuItemHovered;

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.SPACE)) {
            keyLocker.unlockKey(Key.SPACE);
        }

        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            menuItemSelected = currentMenuItemHovered;
            this.options.get(menuItemSelected).select(this);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        for (int i = 0; i < this.getNumItems(); i++) {
            this.options.get(i).spriteFont.draw(graphicsHandler);
        }

        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, COLOR_SELECTED, Color.black, 2);
    }

    public int getMenuItemSelected() {
        return menuItemSelected;
    }
}
