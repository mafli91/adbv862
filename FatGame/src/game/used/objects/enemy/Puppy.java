package game.used.objects.enemy;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.AttackEnemy;
import game.used.eventListeners.otherLevels.EnemyWalk;
import game.used.eventListeners.otherLevels.EnemyAttacks;
import game.used.levels.GameLevels;
import game.used.levels.Lvl1;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;

/**
 * Class to make the puppy - small roundy, spikey blob
 * @see Enemy
 */


public class Puppy extends Enemy implements Serializable {

    private GameLevels level;
    private Game game;
    /**
     * @param puppyShape object's shape
     */
    private static final Shape puppyShape = new PolygonShape(
            -0.74f,-1.22f, 0.89f,-1.22f, 1.57f,0.49f, 0.2f,1.63f, -1.23f,0.49f);
    /**
     * @param left body image facing left
     */
    private static final BodyImage left = ExceptionHandling.catchError("data/puppyL.png", "" +
            "spikey ball facing left", 4.5f );

    /**
     * @param right body image facing right
     */
    private static final BodyImage right = ExceptionHandling.catchError("data/puppyR.png", "" +
            "spikey ball facing left", 4.5f );

    /**
     * @param lefting with righting are attached body images
     */
    private AttachedImage lefting;
    private AttachedImage righting;
    /**
     * @param s with s1 are timer's int values
     */
    private int s =0; // timer
    private int s1 = 0;
    /**
     * @param position current position of the pup
     */
    private Vec2 position;
    /**
     * @param papi sound played upon destruction
     */
    private static SoundClip papi;
    static {
        try {
            papi = new SoundClip("data/sound/poorpapi.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(papi, "small monster death");
        }}

    /**
     * @param puppyhealth object's life count
     */
    private int puppyhealth = 14;
    /**
     * @param speed object's walking speed
     */
    private int speed = 5;


    // CONSTRUCTOR
    public Puppy(World world, Game game, GameLevels level) {
        super(world, puppyShape);
        this.game = game;
        this.level = level;
        this.setGravityScale(1);
        this.itWalks();
        this.itWalksCorrection();
        this.mutation();
        this.collisionz();
    }


    // GETTERS

    /**
     * returns life count
     * @return puppyhealth
     */
    public int getLife() {
        return puppyhealth;
    }

    /**
     * returns walking speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * stores and returns current position
     * @return position
     */
    public Vec2 getPos() {
        this.position = this.getPosition();
                    return position;    }

    // SETTERS

    @Override
    public void setLollipopCount(int i) {}

    /**
     * used together with EnemyWalks
      * @param b boolean checking if enemy changed reversed speed
     */
    @Override
    public void turned(boolean b) {
        turned = b;
    }

    /**
     * changes life count
     * @param a value to change the life by
     */
    public void setLife(int a) {
        puppyhealth = puppyhealth - a;
    }

    /**
     * changes the walking speed
     * @param speed new speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // METHODS AND OVERRIDES

    /**
     * changes attached images depending on the walking direction
     */
    public void itWalks() {
        this.startWalking(speed);
            if (speed > 0) {
                this.removeAllImages();
                righting = new AttachedImage(this, right, 1, 0, new Vec2(0, 0));
            } else if (speed < 0) {
                this.removeAllImages();
                lefting = new AttachedImage(this, left, 1, 0, new Vec2(0, 0));
            }
    }

    /**
     * changes walking direction every 4s, also makes a little jump
     */
    private void itWalksCorrection(){
        javax.swing.Timer puptimer = new javax.swing.Timer( 4000  , e -> {
            s++;
            stopWalking();
            setSpeed(-speed);
            jump(speed);
            startWalking(speed);
        });
        puptimer.setRepeats( true );
        puptimer.start();
    }

    /**
     * destroys the object, saves it's position and in it's place creates Dog object every 30-130s
     */
   public void mutation (){
    // after LVL1 makes pup evolve into a dog
        if (level instanceof Lvl1) {}
        //do nothing
        else{
            javax.swing.Timer dogtimer = new javax.swing.Timer( (int )(Math.random()*100000+30000) , e -> {
                s1++;
                removeAllImages();
                getPos();
                destroy();
                Dog dog = new Dog(getWorld(), game, level);
                dog.setPosition(position);
            });
            dogtimer.setRepeats( false );
            dogtimer.start();

        }
    }


    // collisions directly in the class

    /**
     * collisions added directly in the class
     */
    public void collisionz(){
        this.addCollisionListener(new AttackEnemy(game, level, level.getFatLady(), this));
        this.addCollisionListener(new EnemyWalk(game, level, this));
        this.addCollisionListener(new EnemyAttacks(game, level, this, level.getFatLady()));
    }

    @Override
    public void attack1() {
        super.attack1();
    }

    @Override
    public void attack2() {
        super.attack2();
    }

    @Override
    public void attack3() {
        super.attack3();
    }

    @Override
    public void attack4() {
        super.attack4();
    }

    @Override
    public void isShot() {
        super.isShot();
    }

    @Override
    public void destroy(){
        super.destroy();
        papi.play();
    }

}
