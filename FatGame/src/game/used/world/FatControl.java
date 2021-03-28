package game.used.world;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.AttacksHitWall;
import game.used.levels.*;
import game.used.objects.hero.FatFairy;
import game.used.objects.hero.Foot;
import game.used.objects.hero.Hedgehog;
import game.used.objects.hero.Hero;
import game.used.world.GUI.Cheat;
import game.used.world.GUI.CheatLolly;
import game.used.world.GUI.ExceptionHandling;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class to make controls for Hero using Keyboard
 * @see FatFairy
 * @see game.used.objects.hero.BlueFairy
 * @see Foot
 * @see Hedgehog
 * @see Cheat
 * @see CheatLolly
 */


public class FatControl implements KeyListener, Serializable {

    /**
     * @param WALKING_SPEED Hero's walking speed */
    private static final float WALKING_SPEED = 9;
    /** @param JUMPING_SPEED  Hero's  jumping speed */
    private static final float JUMPING_SPEED = 17;

    private Hero fatLady;
    private int jumpingCount;
    private boolean jumpingAllowed;
    private Foot foot;
    private Hedgehog hedge;
    private float x;
    private float y;
    private WorldView view;
    private GameLevels level;
    private Game game;
    private int s1 = 0; //seconds
    private int s2 = 0; //
    private int footRelease = 0;
    private boolean dash;
    private boolean dashCount;
    private boolean cheat;

    private static final Shape barrierShape = new CircleShape(5.2f);

    private static SoundClip footRR;
    static {
        try {
            footRR = new SoundClip("data/sound/laczek.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(footRR, "Uuma kick");
        }}
    private static SoundClip footLL;
    static {
        try {
            footLL = new SoundClip("data/sound/smellit.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(footLL, "Uuma kick");
        }}
    private static SoundClip wii;
    static {
        try {
            wii = new SoundClip("data/sound/wiii.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(wii, "Jump");
        }}
    private static SoundClip wings;
    static {
        try {
            wings = new SoundClip("data/sound/tinywings.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(wings, "Double jump Uuma");
        }}
    private static SoundClip wings2;
    static {
        try {
            wings2 = new SoundClip("data/sound/doublejump.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(wings2, "Double jump Booma");
        }}

    // CONSTRUCTOR
    public FatControl(Hero s, WorldView view, GameLevels level, Game game) {
        this.fatLady = s;
        this.view = view;
        this.level = level;
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        /** DOUBLE JUMP LOGIC */
        Vec2 v = fatLady.getLinearVelocity();
        if (Math.abs(v.y) < 0.04f || fatLady.isOnPlatform) {
            jumpingCount = 0;
        }
        if (jumpingCount == 0 || fatLady.isOnPlatform){
            jumpingAllowed = true;
        } else jumpingAllowed = false;
        //test double jump
        //System.out.println("Jumping count: " + jumpingCount +  " " + jumpingAllowed);


        /** KEY A walk left */
        if (code == KeyEvent.VK_A) {
            fatLady.removeAllImages();
            fatLady.getLeft();
            if (fatLady.isImmune()){
                fatLady.getBarrier();
            }
            fatLady.startWalking(dash ? -WALKING_SPEED-8 : -WALKING_SPEED );
        }

        /** KEY D walk right */
        else if (code == KeyEvent.VK_D) {
            fatLady.removeAllImages();
            fatLady.getRight();
            if (fatLady.isImmune()){
                fatLady.getBarrier();
            }
            fatLady.startWalking(dash ? WALKING_SPEED + 8 : WALKING_SPEED);
        }

        /** KEY W jump */
        else if (code == KeyEvent.VK_W) {
            if (jumpingAllowed ){
                fatLady.jump(JUMPING_SPEED);
                wii.play();
                wii.setVolume(0.5);
                jumpingCount++;
                fatLady.setOnPlatform(false);
            }
            else {
                if (level instanceof Lvl1 || level instanceof Lvl2) {
                }
                //do nothing
                else if (!jumpingAllowed && jumpingCount < 2) {
                    fatLady.setLinearVelocity(new Vec2(v.x, JUMPING_SPEED + 2));
                    if (fatLady instanceof FatFairy)
                        wings.play();
                    else
                        wings2.play();
                    jumpingCount++;
                }
            }
        }

        /**  KEY ESC exit the game */
        else if (code == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        /** KEY Q kicks left */
        else if (code == KeyEvent.VK_Q) {
            if (fatLady instanceof FatFairy) {
                footRelease();
                if (footRelease < 2) {
                    foot = new Foot(fatLady.getWorld(), fatLady);
                    AttachedImage footL = new AttachedImage(foot, foot.getLeft(), 1, 0, new Vec2(0, 0));
                    fatLady.stopWalking();
                    foot.setPosition(new Vec2(fatLady.getPosition().x - 3,
                            fatLady.getPosition().y));
                    foot.setLinearVelocity(new Vec2(-16, 0));
                    footLL.play();
                    foot.addCollisionListener(new AttacksHitWall(game, level));
                } else// warn about limits
                    game.appendLog("You have only two legs!");
            } else {
                hedge = new Hedgehog(fatLady.getWorld(), fatLady, game, level);
                AttachedImage hedgeL = new AttachedImage(hedge, hedge.getLeft(), 1, 0, new Vec2(0, 0));
                hedge.setPosition(new Vec2(fatLady.getPosition().x - 2, fatLady.getPosition().y - 1.5f));
                hedge.setLinearVelocity(new Vec2(-11, 0));

            }
        }

        /** KEY E kicks right*/
        else if (code == KeyEvent.VK_E) {
            if (fatLady instanceof FatFairy) {
                footRelease();
                if (footRelease < 2) {
                    foot = new Foot(fatLady.getWorld(), fatLady);
                    AttachedImage footR = new AttachedImage(foot, foot.getRight(), 1, 0, new Vec2(0, 0));
                    fatLady.stopWalking();
                    foot.setPosition(new Vec2(fatLady.getPosition().x + 3,
                            fatLady.getPosition().y));
                    foot.setLinearVelocity(new Vec2(16, 0));
                    footRR.play();
                    foot.addCollisionListener(new AttacksHitWall(game, level));
                } else
                    game.appendLog("You have only two legs!");
            } else{
                hedge = new Hedgehog(fatLady.getWorld(), fatLady, game, level);
                AttachedImage hedgeR = new AttachedImage(hedge, hedge.getRight(), 1, 0, new Vec2(0,0));
                hedge.setPosition(new Vec2(fatLady.getPosition().x+2, fatLady.getPosition().y-1.5f));
                hedge.setLinearVelocity(new Vec2(11, 0));

            }

        }

        /** KEY S gets downwards momentum */
        else if (code == KeyEvent.VK_S) {
            fatLady.getStay();
            fatLady.setLinearVelocity(new Vec2(v.x, -30));
        }

            /** KEY SHIFT enable dash */
        else if (code == KeyEvent.VK_SHIFT) {
            this.dash = true;
            }

        /** KEY SPACE BAR  creates a barrier that makes you immune
         * @see Hero
         * */
        else if (code == KeyEvent.VK_SPACE) {
            if (level instanceof Lvl1||level instanceof Lvl2 ||level instanceof Lvl3) {}
            //do nothing
            else {
                if (fatLady.getLollipopCount() > 0) {
                    fatLady.setImmune(true);
                    fatLady.setLollipopCount(fatLady.getLollipopCount() - 1);
                    SolidFixture bar = new SolidFixture(fatLady, barrierShape, 100);
                    bar.setFriction(50);
                    bar.setRestitution(0.9f);
                    fatLady.getBarrier();
                    Timer barrierTimer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            s1++;
                            bar.destroy();
                            fatLady.setImmune(false);
                            if (s1 > 180000)
                                s1=0;
                        }
                    };
                    barrierTimer.schedule(task, 7000);
                }
            }
        }

        /**  KEY N LETs YOU MOVE TO NEXT LEVEL in LVL 1-4
         * @see GameLevels
         * @see Game
         * */
        else if (code == KeyEvent.VK_N){
            if (level instanceof Lvl1 || level instanceof Lvl2 || level instanceof Lvl3 ||
                    level instanceof Lvl4 || level instanceof LStart  ) {
                if (level.isComplete())
                    game.goToNextLevel();
                else
                    game.appendLog("You're not powdered enough");
            }
        }

        /** ENTER BRINGs NEXT COMIC STRIP
        * and comine with C or L to START CHEATING
         * @see game.used.objects.other.ComicStrip
         * */
        else if (code == KeyEvent.VK_ENTER){
            this.cheat = true;
            if (level instanceof Lvl0){
                if (level.getComicStrip0().getSwapCount()>10) {
                    game.appendLog("LET'S PLAY");
                    game.goToNextLevel();
                }
                else {
                    level.getComicStrip0().setSwapCount(1);
                    level.getComicStrip0().swapPic();
                    game.appendLog(String.valueOf(level.getComicStrip0().getSwapCount()));
                }
            } else if (level instanceof Lvl8){
                if (level.getComicStrip8().getSwapCount()>12) {
                    game.appendLog("LET'S PLAY");
                    game.goToNextLevel();
                }
                else {
                    level.getComicStrip8().setSwapCount(1);
                    level.getComicStrip8().swapPic();
                    game.appendLog(String.valueOf(level.getComicStrip8().getSwapCount()));
                }
            }else if (level instanceof Lvl10){
                if (level.getComicStrip10().getSwapCount()>3) {
                    game.appendLog("LET'S PLAY");
                    game.goToNextLevel();
                }
                else {
                    level.getComicStrip10().setSwapCount(1);
                    level.getComicStrip10().swapPic();
                    game.appendLog(String.valueOf(level.getComicStrip10().getSwapCount()));
                }
            }else if (level instanceof Lvl12){
                if (level.getComicStrip12().getSwapCount()>11) {
                    game.appendLog("LET'S PLAY");
                    game.goToNextLevel();
                }
                else {
                    level.getComicStrip12().setSwapCount(1);
                    level.getComicStrip12().swapPic();
                    game.appendLog(String.valueOf(level.getComicStrip12().getSwapCount()));
                }
            }
        }


        /** open cheat window to unlock levels
         * @see Cheat
         * */
        else if (code== KeyEvent.VK_C){
            if(cheat){
                Cheat c = new Cheat(game, level);
                cheat = false;
            }
        }
        /** open cheat window to set lolly count to 20
         * @see CheatLolly
         * */
        else if (code== KeyEvent.VK_L){
            if(cheat){
                CheatLolly c = new CheatLolly(game, level);
                cheat = false;
            }
        }

        }

    /** increase count of feet produced */
    private void footRelease() {
        footRelease++;
    }


    /**
     * KEY RELEASED ACTIONS
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        /** KEY A */
        if (code == KeyEvent.VK_A) {
            fatLady.removeAllImages();
            fatLady.getStay();
            fatLady.stopWalking();
            if (fatLady.isImmune()){
                fatLady.getBarrier();
            }
        }

        /** KEY D */
        else if (code == KeyEvent.VK_D) {
            fatLady.removeAllImages();
            fatLady.getStay();
            fatLady.stopWalking();
            if (fatLady.isImmune()){
                fatLady.getBarrier();
            }
        }

        /** KEY Q */
        else if (code == KeyEvent.VK_Q){
            footRelease = 0;
        }

        /** KEY E */
        else if (code == KeyEvent.VK_E){
            footRelease = 0;
        }

        /** KEY SHIFT */
        else if (code == KeyEvent.VK_SHIFT){
            dash = false;
        }

        /** ENTER */
        else if (code == KeyEvent.VK_ENTER){
            this.cheat = false;
        }


    }


        // UPDATE HERO FOR LEVEL

    /**
     * UPDATE HERO
     * @param fatLady new hero value
     */
    public void updateHero (Hero fatLady) {this.fatLady = fatLady; }

    /**
     * UPDATE LEVEL
     * @param l new level value
     */
    public void updateLevel ( GameLevels l){
        this.level = l;
    }


}
