
package Level;

import Utils.Sound;

/**
 * A class designed to manage all the sounds within the game.
 * @author higgins!
 */
public class MusicManager {

    protected static Player thePlayer;

    //All sounds the different biomes
    protected static Sound start = new Sound("biomeStart.wav", true);
    protected static Sound startHome = new Sound("ariaMath.wav", true);
    protected static Sound desert = new Sound("GhostRiders.wav", true);
    protected static Sound desertHome = new Sound(null, true);
    protected static Sound spooky = new Sound("BiomeSpookymusic.wav", true);
    protected static Sound spookyHome = new Sound(null, true);
    protected static Sound mushroom = new Sound("mushroom.wav", true);
    protected static Sound mushroomHome = new Sound("mushroomHome.wav", true);
    protected static Sound mountains = new Sound("mountainsBiome.wav", true);
    protected static Sound mountainsHome = new Sound("steamGardens.wav", true);
    protected static Sound saloon = new Sound("HippiesAndCowboys.wav",true);
    protected static Sound tape = new Sound("BlakeAudio.wav", false);

    //If each biome would like a different walking sound add them here, and set the walking sound in the appropriate switch statement
    protected static Sound grassWalking = new Sound("walkingGrass.wav", true);
    protected static Sound stoneWalking = new Sound("walkingStone.wav", true);
    protected static Sound woodWalking = new Sound("walkingWood.wav", true);
    protected static Sound sandWalking = new Sound("sandWalking.wav", true);

    //Collectible sound effects are managed in here
    protected static Sound keyCollectible = new Sound("keyCollectible.wav", false);
    protected static Sound collectible = new Sound("collectible.wav", false);

    //Sounds set when class is initiated
    protected static Sound previousSound = startHome;
    protected static Sound currentSound = startHome;
    protected static Sound previousWalkingSound = woodWalking;
    protected static Sound walkingSound = woodWalking;

    /**
     * Updates the current music playing with the new musicState and then plays the appropriate music depending on the case. 
     * Pauses and restarts the previous music, and changes the player's walking sound.
     * @param musicState the musicState that the musicManager gets set to
     * @author higgins!
     */
    public static void updateMusic(MusicState musicState) {
        previousSound.stop();
        thePlayer.getWalkingSound().stop();
        switch (musicState) {
            case DESERT:
                currentSound = desert;
                walkingSound = sandWalking;
                break;
            case DESERT_HOME:
                currentSound = desertHome;
                walkingSound = woodWalking;
                break;
            case MOUNTAINS:
                currentSound = mountains;
                walkingSound = stoneWalking;
                break;
            case MOUNTAINS_HOME:
                currentSound = mountainsHome;
                walkingSound = woodWalking;
                break;
            case MUSHROOM:
                currentSound = mushroom;
                walkingSound = grassWalking;
                break;
            case MUSHROOM_HOME:
                currentSound = mushroomHome;
                walkingSound = woodWalking;
                break;
            case SPOOKY:
                currentSound = spooky;
                walkingSound = grassWalking;
                break;
            case SPOOKY_HOME:
                currentSound = spookyHome;
                walkingSound = stoneWalking;
                break;
            case START:
                currentSound = start;
                walkingSound = grassWalking;
                break;
            case START_HOME:
                currentSound = startHome;
                walkingSound = woodWalking;
                break;
            case SALOON:
                currentSound = saloon;
                walkingSound = woodWalking;
                break;
            case TAPE:
            	currentSound = tape;
            default:
                break;
        }
        currentSound.play();
        thePlayer.setWalkingSound(walkingSound);
        previousWalkingSound = walkingSound;
        previousSound = currentSound;
    }

    /**
     * Gets the current sound playing. Used in the collectible script to pause map music.
     * @author higgins!
     */
    public static Sound getCurrentSound() {
        return currentSound;
    }

    /**
     * Sets the player to the {@code MusicManager} in order to change walking sounds.
     * @author higgins!
     */
    public static void setPlayer(Player player) {
        thePlayer = player;
    }

    /**
     * Gets the current walking sound.
     * @author higgins!
     */
    public static Sound getWalkingSound() {
        return walkingSound;
    }

    /**
     * Gets the collectible sound in this class and sets it in the collectible script class.
     * @param isKeyCollectible Whether or not the collectible is important
     * @return Correct collectible sound
     * @author higgins!
     */
    public static Sound getCollectibleSound(boolean isKeyCollectible) {
        return (isKeyCollectible) ? keyCollectible : collectible;
    }
}
