package Level;

import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import GameObject.Furniture;
import GameObject.GameObject;
import GameObject.Rectangle;
import GameObject.SpriteSheet;
import HouseCustomization.FurnitureRegistry;
import Utils.Direction;
import java.util.ArrayList;
import java.util.Arrays;
import Utils.Sound;
import Maps.Biomes.*;
import Maps.*;

public abstract class Player extends GameObject {
    // values that affect player movement
    // these should be set in a subclass
    protected float walkSpeed = 0;
    protected int interactionRange = 5;
    protected Direction currentWalkingXDirection;
    protected Direction currentWalkingYDirection;
    protected Direction lastWalkingXDirection;
    protected Direction lastWalkingYDirection;

    // values used to handle player movement
    protected float moveAmountX, moveAmountY;
    protected float lastAmountMovedX, lastAmountMovedY;

    // values used to keep track of player's current state
    protected PlayerState playerState;
    protected PlayerState previousPlayerState;
    protected Direction facingDirection;
    protected Direction lastMovementDirection;

    // classes that listen to player events can be added to this list
    protected ArrayList<PlayerListener> listeners = new ArrayList<>();

    // define keys
    protected KeyLocker keyLocker = new KeyLocker();
    protected Key MOVE_LEFT_KEY = Key.LEFT;
    protected Key MOVE_LEFT_KEY_ALT = Key.A;
    protected Key MOVE_RIGHT_KEY = Key.RIGHT;
    protected Key MOVE_RIGHT_KEY_ALT = Key.D;
    protected Key MOVE_UP_KEY = Key.UP;
    protected Key MOVE_UP_KEY_ALT = Key.W;
    protected Key MOVE_DOWN_KEY = Key.DOWN;
    protected Key MOVE_DOWN_KEY_ALT = Key.S;
    protected Key INTERACT_KEY = Key.SPACE;

    //Sound that plays for a player walking
    protected Sound walkingSound;

	public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
        super(spriteSheet, x, y, startingAnimationName);
        facingDirection = Direction.RIGHT;
        playerState = PlayerState.STANDING;
        previousPlayerState = playerState;
        this.affectedByTriggers = true;
    }

    public void update() {
        moveAmountX = 0;
        moveAmountY = 0;

        // if player is currently playing through level (has not won or lost)
        // update player's state and current actions, which includes things like determining how much it should move each frame and if its walking or jumping
        do {
            previousPlayerState = playerState;
            handlePlayerState();
        } while (previousPlayerState != playerState);

        // move player with respect to map collisions based on how much player needs to move this frame
        if (playerState != PlayerState.INTERACTING) {
            lastAmountMovedY = super.moveYHandleCollision(moveAmountY);
            lastAmountMovedX = super.moveXHandleCollision(moveAmountX);
        }

        handlePlayerAnimation();

        updateLockedKeys();

        // update player's animation
        super.update();
    }

    // based on player's current state, call appropriate player state handling method
    protected void handlePlayerState() {
        switch (playerState) {
            case STANDING:
                playerStanding();
                walkingSound.pause();
                break;
            case WALKING:
                playerWalking();
                walkingSound.play();
                break;
            case INTERACTING:
                playerInteracting();
                walkingSound.pause();
                break;
        }
    }

    // player STANDING state logic
    protected void playerStanding() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if a walk key is pressed, player enters WALKING state
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_LEFT_KEY_ALT)|| Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY_ALT) || Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY_ALT) || Keyboard.isKeyDown(MOVE_DOWN_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY_ALT)) {
            playerState = PlayerState.WALKING;
        }
    }

    // player WALKING state logic
    protected void playerWalking() {
        if (!keyLocker.isKeyLocked(INTERACT_KEY) && Keyboard.isKeyDown(INTERACT_KEY)) {
            keyLocker.lockKey(INTERACT_KEY);
            map.entityInteract(this);
        }

        // if walk left key is pressed, move player to the left
        if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_LEFT_KEY_ALT)) {
            moveAmountX -= walkSpeed;
            facingDirection = Direction.LEFT;
            currentWalkingXDirection = Direction.LEFT;
            lastWalkingXDirection = Direction.LEFT;
        }

        // if walk right key is pressed, move player to the right
        else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY_ALT)) {
            moveAmountX += walkSpeed;
            facingDirection = Direction.RIGHT;
            currentWalkingXDirection = Direction.RIGHT;
            lastWalkingXDirection = Direction.RIGHT;
        }
        else {
            currentWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyDown(MOVE_UP_KEY) || Keyboard.isKeyDown(MOVE_UP_KEY_ALT)) {
            moveAmountY -= walkSpeed;
            currentWalkingYDirection = Direction.UP;
            lastWalkingYDirection = Direction.UP;
        }
        else if (Keyboard.isKeyDown(MOVE_DOWN_KEY) || Keyboard.isKeyDown(MOVE_DOWN_KEY_ALT)) {
            moveAmountY += walkSpeed;
            currentWalkingYDirection = Direction.DOWN;
            lastWalkingYDirection = Direction.DOWN;
        }
        else {
            currentWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingXDirection == Direction.RIGHT || currentWalkingXDirection == Direction.LEFT) && currentWalkingYDirection == Direction.NONE) {
            lastWalkingYDirection = Direction.NONE;
        }

        if ((currentWalkingYDirection == Direction.UP || currentWalkingYDirection == Direction.DOWN) && currentWalkingXDirection == Direction.NONE) {
            lastWalkingXDirection = Direction.NONE;
        }

        if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_LEFT_KEY_ALT) && Keyboard.isKeyUp(MOVE_RIGHT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY_ALT) && Keyboard.isKeyUp(MOVE_UP_KEY) && Keyboard.isKeyUp(MOVE_UP_KEY_ALT) && Keyboard.isKeyUp(MOVE_DOWN_KEY) && Keyboard.isKeyUp(MOVE_DOWN_KEY_ALT)) {
            playerState = PlayerState.STANDING;
        }
    }

    // player INTERACTING state logic -- intentionally does nothing so player is locked in place while a script is running
    protected void playerInteracting() { }

    protected void updateLockedKeys() {
        if (Keyboard.isKeyUp(INTERACT_KEY) && playerState != PlayerState.INTERACTING) {
            keyLocker.unlockKey(INTERACT_KEY);
        }
    }

    // anything extra the player should do based on interactions can be handled here
    protected void handlePlayerAnimation() {
        if (playerState == PlayerState.STANDING) {
            // sets animation to a STAND animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
        else if (playerState == PlayerState.WALKING) {
            // sets animation to a WALK animation based on which way player is facing
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "WALK_RIGHT" : "WALK_LEFT";
        }
        else if (playerState == PlayerState.INTERACTING) {
            // sets animation to STAND when player is interacting
            // player can be told to stand or walk during Script by using the "stand" and "walk" methods
            this.currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";
        }
    }
    // can be overridden in subclass
    public void reloadAnimations() {
    	
    }

    @Override
    public void onEndCollisionCheckX(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) { }

    @Override
    public void onEndCollisionCheckY(boolean hasCollided, Direction direction, MapEntity entityCollidedWith) { }

    // other entities can call this method to hurt the player
    public void hurtPlayer(MapEntity mapEntity) {

    }

    public Sound getPlayerSound() {return walkingSound;}

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void addListener(PlayerListener listener) {
        listeners.add(listener);
    }

    public void setWalkingSound(Sound walkingSound) {
        this.walkingSound = walkingSound;
    }

    public Sound getWalkingSound() {
        return walkingSound;
    }

    public Rectangle getInteractionRange() {
        return new Rectangle(
                getBounds().getX1() - interactionRange,
                getBounds().getY1() - interactionRange,
                getBounds().getWidth() + (interactionRange * 2),
                getBounds().getHeight() + (interactionRange * 2));
    }

    public Key getInteractKey() { return INTERACT_KEY; }
    public Direction getCurrentWalkingXDirection() { return currentWalkingXDirection; }
    public Direction getCurrentWalkingYDirection() { return currentWalkingYDirection; }
    public Direction getLastWalkingXDirection() { return lastWalkingXDirection; }
    public Direction getLastWalkingYDirection() { return lastWalkingYDirection; }

    public void stand(Direction direction) {
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "STAND_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "STAND_LEFT";
        }
    }

    public void walk(Direction direction, float speed) {
        facingDirection = direction;
        if (direction == Direction.RIGHT) {
            this.currentAnimationName = "WALK_RIGHT";
        }
        else if (direction == Direction.LEFT) {
            this.currentAnimationName = "WALK_LEFT";
        }
        else {
            if (this.currentAnimationName.contains("RIGHT")) {
                this.currentAnimationName = "WALK_RIGHT";
            }
            else {
                this.currentAnimationName = "WALK_LEFT";
            }
        }
        if (direction == Direction.UP) {
            moveY(-speed);
        }
        else if (direction == Direction.DOWN) {
            moveY(speed);
        }
        else if (direction == Direction.LEFT) {
            moveX(-speed);
        }
        else if (direction == Direction.RIGHT) {
            moveX(speed);
        }
    }
    /**
     * Class that contains all of the intiated maps that will appear within the game.
     * @author Matt Zingarella
     * @author higgins!
     */
    public static class MapEntityManager {
        /* Map IDS:
        * Desert: 0
        * Wasteland; 1
        * Mountains: 2
        * Mushroom: 3
        * Halloween: 4
        * Start: 5
        * DinoHouse: 6
        * StartHouse: 7
        * Title: 8
        * MushroomHouse: 9
        * Saloon: 10
        * MountainHome (treehouse): 12
        * WalrusHome; 13
        */
        protected static ArrayList<Map> savedMaps = new ArrayList<> (Arrays.asList(
            new BiomeDesert(),
            new BiomeFallout(),
            new BiomeMountains(),
            new BiomeShrooms(),
            new BiomeSpooky(),
            new BiomeStart(),
            new DinoMap(),
            new HouseMap(),
            new TitleScreenMap(),
            new MushroomHomeMap(),
            new SaloonMap(),
            new moonValleyTitle(),
            new TreehouseMap(),
            new WalrusMap()
        ));

        /**
         * Gets the arrayList of all the maps that are in the game.
         * @author Matt Zingarella
         */
        public static ArrayList<Map> getSavedMaps() {
            return savedMaps;
        }

        /**
         * Gets a specific map from the arrayList of all maps in the game.
         * @param mapID ID of the map needed
         * @return specified map from ID
         * @author Matt Zingarella
         */
        public static Map getSavedMap(int mapID) {
            return savedMaps.get(mapID);
        }

        /**
         * Sets all the saved maps to a new arrayList of maps.
         * @param newSavedMaps
         * @author Matt Zingarella
         */
        public static void setSavedMaps(ArrayList<Map> newSavedMaps) {
            savedMaps = newSavedMaps;
        }

        /**
         * Gets the furniture location, ID, and map in which the furniture was placed.
         * Each string is formatted as mapID,furnitureID,furnitureX,furnitureY.
         * @return String representations of all the  furniture within all the maps
         * @author higgins!
         */
        public static ArrayList<String> getFurniture() {
            ArrayList<String> furnitureLocation = new ArrayList<>();
            for (Map map : savedMaps) {
                if (map.hasFurniture()) {
                    for (int i = 0; i < map.getFurniture().size(); i++) {
                        furnitureLocation.add(
                            Integer.toString(map.getMapID()) + "," + 
                            map.getFurniture().get(i).getItemNumber() + "," + 
                            map.getFurniture().get(i).getX() + "," + 
                            map.getFurniture().get(i).getY());
                    }
                }
            }
            return furnitureLocation;
        }

        /**
         * Parses through each string to obtain the necessary information of where the current furniture in the maps is located.
         * Each string is formatted as mapID,furnitureID,furnitureX,furnitureY.
         * @param furnitureToSet String representations of all the furniture from a previous save
         * @author higgins!
         */
        public static void setFurniture(ArrayList<String> furnitureToSet) {
            for (String lineOfSave : furnitureToSet) {
                String[] tempLine = lineOfSave.split(",");
                int currentMapNumber = Integer.parseInt(tempLine[0]);
                int furnitureID = Integer.parseInt(tempLine[1]);
                float x = Float.parseFloat(tempLine[2]);
                float y = Float.parseFloat(tempLine[3]);
                if (!getSavedMap(currentMapNumber).getFurniture().contains(FurnitureRegistry.getFurnitureFromID(furnitureID))) {
                    Furniture furnitureToAdd = FurnitureRegistry.getFurnitureFromID(furnitureID);
                    furnitureToAdd.setX(x);
                    furnitureToAdd.setY(y);
                    getSavedMap(currentMapNumber).addFurniture(furnitureToAdd);
                }
            }
        } 
    }
}
