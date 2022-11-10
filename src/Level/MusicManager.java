package Level;

import Utils.Sound;

public class MusicManager {

    protected Player player;
    protected MusicState musicState, previousMusicState;
    protected Sound previousSound, currentSound, previousWalkingSound, walkingSound;

    //All sounds the different biomes
    protected Sound start = new Sound("biomeStart.wav", true);
    protected Sound startHome = new Sound("ariaMath.wav", true);
    protected Sound desert = new Sound("GhostRiders.wav", true);
    protected Sound desertHome = new Sound(null, true);
    protected Sound spooky = new Sound(null, true);
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

    //sets the previous and current sounds to the same thing on creation (this makes it easier to check when the music state has changed)
    public MusicManager() {
        previousMusicState = MusicState.START;
        musicState = MusicState.START;
        previousSound = start;
        currentSound = start;
        previousWalkingSound = grassWalking;
        walkingSound = grassWalking;
    }

    //checks if the current music state is different from the previous music state
    //will play the appropriate music depending on the case, and will pause and restart the previous music 
    //if desired, will change the player's walking sound depending on the location
    public void updateMusic() {
        if (previousMusicState != musicState) {
            switch (musicState) {
                case DESERT:
                    currentSound = desert;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case DESERT_HOME:
                    currentSound = desertHome;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case MOUNTAINS:
                    currentSound = mountains;
                    walkingSound = stoneWalking;
                    break;
                case MOUNTAINS_HOME:
                    currentSound = mountainsHome;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case MUSHROOM:
                    currentSound = mushroom;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case MUSHROOM_HOME:
                    currentSound = mushroomHome;
                    walkingSound = stoneWalking;
                    break;
                case SPOOKY:
                    currentSound = spooky;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case SPOOKY_HOME:
                    currentSound = spookyHome;
                    //walkingSound = PREFERRED_WALKING_SOUND;
                    break;
                case START:
                    currentSound = start;
                    walkingSound = grassWalking;
                    break;
                case START_HOME:
                    currentSound = startHome;
                    //walkingSound = PREFERRED_WALKING_SOUND;
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

    //sets the music state to change the music
    public void setMusicState(MusicState musicState) {
        this.musicState = musicState;
    }

    //pauses the current music
    public Sound getCurrentSound() {
        return currentSound;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Sound getWalkingSound() {
        return walkingSound;
    }
}
