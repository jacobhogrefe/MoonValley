package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;
import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.MenuScreen;
import Screens.PlayLevelScreen;
import Screens.SaveSlotScreen;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();
	public PlayLevelScreen playLevelScreen;
	protected MenuScreen mainMenuScreen;

	@Override
	public void initialize() {
		// start game off with Menu Screen
		mainMenuScreen = new MenuScreen(this);
		mainMenuScreen.initialize();
		this.currentScreen = mainMenuScreen;

		//checks if save data is present and sets the appropiate boolean value
		try {
			Scanner save = new Scanner(new File("save0.txt"));
			SaveSlotScreen.saveSlot = true;
			save.close();
		} catch (FileNotFoundException e) {}

		try {
			Scanner save1 = new Scanner(new File("save1.txt"));
			SaveSlotScreen.saveSlot1 = true;
			save1.close();
		} catch (FileNotFoundException e) {}

		try {
			Scanner save2 = new Scanner(new File("save2.txt"));
			SaveSlotScreen.saveSlot2 = true;
			save2.close();
		} catch (FileNotFoundException e) {}
	}

	@Override
	public void update() {
		if(currentScreen ==playLevelScreen) {
			MenuScreen.MenuSound.pause();
		}
		currentScreen.update();
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}

	public PlayLevelScreen getPlayLevelScreen() {
		return playLevelScreen;
	}

	/* RECURSIVE FUNCTIONALITY BELOW @author hle0 */
	
    protected ArrayDeque<Screen> stack = new ArrayDeque<>();

	/**
	 * "Enter" a new screen from a starting screen, with the ability to resume the old one later.
	 * @param screen the new screen to enter
	 */
    public void push(Screen screen) {
        this.stack.addLast(this.currentScreen);

        this.currentScreen = screen;
		this.currentScreen.initialize();

		if (this.currentScreen instanceof PlayLevelScreen) {
			this.playLevelScreen = (PlayLevelScreen) this.currentScreen;
		}

		this.debugPrintStack("push");
    }

	/**
	 * Drop down one frame.
	 * Be careful.
	 */
    protected void drop() {
        this.currentScreen = this.stack.removeLast();
    }

	/**
	 * Descend down the stack until reaching the desired Screen.
	 * e.g., goes from the controls menu to the pause menu to the playlevel.
	 */
	public void dropUntil(Screen screen) {
		while (this.currentScreen != screen) {
			this.drop();
		}

		this.debugPrintStack("dropUntil");
	}

	/**
	 * Exit a screen, going to the one before it. Warns if it is dropping more than one level (should not happen)
	 * @param screen the screen to get rid of.
	 */
    public void pop(Screen screen) {
        if (this.currentScreen != screen) {
            System.err.println("Warning; tried to pop a screen that wasn't the top screen.");
            this.dropUntil(screen);
        }
        
        this.drop();

		this.debugPrintStack("pop");
    }

	public void resumeLevel() {
		this.dropUntil(this.playLevelScreen);
	}

	public void exitToMenu() {
		this.dropUntil(this.mainMenuScreen);
	}

	private void debugPrintStack(String s) {
		boolean debug = false;

		if (!debug) { // debug output disabled
			return;
		}

		System.out.println(s);

		this.debugPrintStack();
	}

	private void debugPrintStack() {
		Object[] screens = this.stack.toArray();

		System.out.println("Screen stack contents:");

		for (int i = 0; i < this.stack.size(); i++) {
			System.out.printf("[%d] %s\n", i, screens[i].getClass().getName());
		}

		System.out.printf("[!!] %s\n", this.currentScreen.getClass().getName());
	}
}