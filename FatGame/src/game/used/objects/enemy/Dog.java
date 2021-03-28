package game.used.objects.enemy;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.AttackEnemy;
import game.used.eventListeners.otherLevels.EnemyWalk;
import game.used.eventListeners.otherLevels.EnemyAttacks;
import game.used.levels.*;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
//import java.util.Timer;
//import java.util.TimerTask;


/**
 * Class creates a dog which is a middle sized blob
 * @see Enemy
 */

public class Dog extends Enemy implements Serializable {

    private GameLevels level;
    private Game game;
    /**
     * @param dogShape dog's shape
     */
    private static final Shape dogShape = new PolygonShape(
            -1.42f,-3.69f, 1.49f,-3.74f, 1.07f,2.03f, -0.89f,2.0f);
    /**
     * @param left dog's left profile (body image)
     */
    private static BodyImage left= ExceptionHandling.catchError("data/dogL.png", "" +
            "tall brown blob facing left", 9.5f );
    /**
     * @param right dog's right profile
      */
    private static final BodyImage right = ExceptionHandling.catchError("data/dogR.png", "" +
            "tall brown blob facing Right", 9.5f );
    /**
     * @param lefting body's attached image with righting
     */
    private AttachedImage lefting;
    private AttachedImage righting;
    /**
     * @param s with s1 are timer's int values
     */
    private int s = 0; // timer
    private int s1 = 0;
    /**
     * @param position dog's current position
     */
    private Vec2 position;

    /**
     * @param dogGhost dog's spirit around his body- useless since version 2 but author liked the idea
     */
    private final Sensor dogGhost = new Sensor(this, new CircleShape((float) 4.5));
    /**
     * @param life dog's life
      */
    private int life = 20;
    /**
     * @param speed dog's speed
     */
        private int speed = 10;
    /**
     * @param bad soundclip played upon destruction
     */
    private static SoundClip bad;
    static {
        try {
            bad = new SoundClip("data/sound/badboy.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(bad, "killing monster");
        }}


        // CONSTRUCTOR

    public Dog(World world, Game game, GameLevels level) {
        super(world, dogShape);
        this.setGravityScale(1);
        this.itWalks();
        this.itWalkzCorrection();
        this.game = game;
        this.level = level;
        this.collisionz();
        this.mutation();
    }


    // GETTERS

    /**
     * get life's count
     * @return life
     */
    public int getLife() {
        return life;
    }

    /**
     * updates and returns current position
     * @return
     */
    public Vec2 getPos() {
        position = this.getPosition();
        return position;
    }

    /**
     * returns speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    // SETTERS

    /**
     * used to change movement direction with listeners
     * @param b checks if turned
     * @see EnemyWalk
     */
    @Override
    public void turned(boolean b) {
        turned = b;
    }

    /**
     * update's life and calls for method attack1()
     * @param life value to change life count by
     */
    public void setLife(int life) {
        this.life = this.life - life;
        this.attack1();
    }

    @Override
    public void setLollipopCount(int i) {   }

    /**
     * set's dog's speed
     * @param speed new speed value
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // METHODS AND OVVERRIDES

    /**
     * makes dog walk and change it's attached images based on direction
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
     * makes dog turn direction and jump randomly at 1,5-7,5 s
     */
    private void itWalkzCorrection(){
        Timer timer = new Timer( (int )(Math.random() * 6000 + 1500) , e -> {
            s++;
            getPos();
            stopWalking();
            jump(position.normalize()/12);
            setSpeed(-1*speed);
            startWalking(speed);
        });
        timer.setRepeats( true );
        timer.start();
    }

    /**
     * makes the dog change into Wolf after 1-3 minutes
     * @see Wolf
     */
    private void mutation (){
        if (level instanceof Lvl1||level instanceof Lvl2 ||level instanceof Lvl3) {}
        //do nothing
        else if (level instanceof Lvl4) {
            //makes the dog 'change' into wolf
            Timer dogtimer = new Timer( (int )(Math.random()*120000+60000) , e -> {
                s1++;
                removeAllImages();
                getPos();
                destroy();
                Wolf wolf = new Wolf(getWorld(), game, level);
                wolf.setPosition(position);
            });
            dogtimer.setRepeats( false );
            dogtimer.start();

        }
    }

    /**
     * collisions are implemented in the class
      */
    public void collisionz(){
        this.addCollisionListener(new AttackEnemy(game, level, level.getFatLady(), this));
        this.addCollisionListener(new EnemyWalk(game, level, this));
        this.addCollisionListener(new EnemyAttacks(game, level, this, level.getFatLady()));
    }

    /**
     *dog will walk in the direction of Hero if attacked, called by setLife()
     */
    @Override
    public void attack1() {
        super.attack1();
        if (level.getFatLady().getPosition().x >0 && this.getSpeed()<0)
                this.speed = -speed;
        else if (level.getFatLady().getPosition().x<0 && this.getSpeed()>0)
                this.speed = -speed;
        if (level.getFatLady().getPosition().y>this.getPos().y+10)
                this.jump(15);
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
        bad.play();
    }
}


