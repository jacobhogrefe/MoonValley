package Level;

import Utils.Sound;

/**
 * A class designed to manage all the sounds within the game.
 * @author higgins!
 */
public class MusicManager {

    protected Player player;
    protected MusicState musicState, previousMusicState;
    protected Sound previousSound, currentSound, previousWalkingSound, walkingSound;

    //All sounds the different biomes
    protected Sound start = new Sound("biomeStart.wav", true);
    protected Sound startHome = new Sound("ariaMath.wav", true);
    protected Sound desert = new Sound("GhostRiders.wav", true);
    protected Sound desertHome = new Sound(null, true);
    protected Sound spooky = new Sound("BiomeSpookymusic.wav", true);
    protected Sound spookyHome = new Sound(null, true);
    protected Sound toxic = new Sound(null, true);
    protected Sound toxicHome = new Sound(null, true);
    protected Sound mushroom = new Sound("mushroom.wav", true);
    protected Sound mushroomHome = new Sound("mushroomHome.wav", true);
    protected Sound mountains = new Sound("mountainsBiome.wav", true);
    protected Sound mountainsHome = new Sound("steamGardens.wav", true);
    protected Sound saloon = new Sound("HippiesAndCowboys.wav",true);

    //If each biome would like a different walking sound add them here, and set the walking sound in the appropriate switch statement
    protected Sound grassWalking = new Sound("walkingGrass.wav", true);
    protected Sound stoneWalking = new Sound("walkingStone.wav", true);
    protected Sound woodWalking = new Sound("walkingWood.wav", true);
    protected Sound sandWalking = new Sound("sandWalking.wav", true);

    /**
     * MusicManager manages the current player walking sound and current music playing in each map. 
     * Sets the previous and current sounds to the same thing on creation (this makes it easier to 
     * check when the music state has changed).
     * @author higgins!
     */
    public MusicManager() {
        previousMusicState = MusicState.START_HOME;
        musicState = MusicState.START_HOME;
        previousSound = startHome;
        currentSound = startHome;
        previousWalkingSound = woodWalking;
        walkingSound = woodWalking;
    }

    /**
     * Checks if the current music state is different from the previous music state, 
     * play the appropriate music depending on the case, and will pause and restart the previous music.
     * This method also changes the player's walking sound.
     * @author higgins!
     */
    public void updateMusic() {
        if (previousMusicState != musicState) {
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
                case TOXIC:
                    currentSound = toxic;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case TOXIC_HOME:
                    currentSound = toxicHome;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case SALOON:
                	currentSound = saloon;
                    walkingSound = woodWalking;
                default:
                    break;
            }
            previousSound.stop();
            currentSound.play();
            player.getWalkingSound().stop();
            player.setWalkingSound(walkingSound);
            previousWalkingSound = walkingSound;
            previousSound = currentSound;
            previousMusicState = musicState;
        }
    }

    /**
     * Sets the {@code MusicState} to determine if the state has changed.
     * @author higgins!
     */
    public void setMusicState(MusicState musicState) {
        this.musicState = musicState;
    }

    /**
     * Gets the current sound playing. Used in the collectible script to pause map music.
     * @author higgins!
     */
    public Sound getCurrentSound() {
        return currentSound;
    }

    /**
     * Sets the player to the {@code MusicManager} in order to change walking sounds.
     * @author higgins!
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the current walking sound.
     * @author higgins!
     */
    public Sound getWalkingSound() {
        return walkingSound;
    }
}
