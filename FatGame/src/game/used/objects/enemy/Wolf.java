package game.used.objects.enemy;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.AttackEnemy;
import game.used.eventListeners.otherLevels.EnemyWalk;
import game.used.eventListeners.otherLevels.EnemyAttacks;
import game.used.levels.GameLevels;
import game.used.objects.hero.FatFairy;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;

/**
 * creates Wolf object which is the biggest purple blob in the game
 * @see Enemy
 */

public class Wolf extends Enemy implements Serializable {

    private GameLevels level;
    private Game game;
    /**
     * @param wolfShape wolf's shape
     */
    private static final Shape wolfShape = new PolygonShape(
            -3.02f,-2.63f, 3.96f,-2.68f, 4.75f,2.37f, 0.92f,4.35f, -3.54f,2.47f);
    /**
     * @param left body image for walking left
     */
    private static final BodyImage left = ExceptionHandling.catchError("data/wolfL.png", "" +
            "tall purple blob facing left", 9f );

    /**
     * @param right body image for when walking right
     */
    private static final BodyImage right = ExceptionHandling.catchError("data/wolfR.png", "" +
            "tall purple blob facing right", 9f );

    /**
     * @param lefting attached body image for when walking left
     */
    private AttachedImage lefting;
    /**
     * @param righting attached body image for when walking right
     */
    private AttachedImage righting;
    /**
     * @param s with s1 & s2 are timer's int values
     */
    private int s = 0; // timer
    private int s1 = 0;
    private int s2 =0;
    /**
     * @param position stores object's position
     */
    private Vec2 position;
    /**
     * @param poodle soundclip to play upon destruction
     */
    private static SoundClip poodle;
    static {
        try {
            poodle = new SoundClip("data/sound/poodle.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(poodle, "big monster death");
        }}
    /**
     * @param boom soundclip for Booma
     */
    private static SoundClip boom;
    static {
        try {
            boom = new SoundClip("data/sound/look-dont-touch.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(boom, "Booma killing purple blob");
        }}


    /**
     * @param life life count
      */
    private int life = 28;
    /**
     * @param speed walking speed of the wolf
      */
    private int speed = 16;
    /**
     * @param lollipopCount stores value of lollipops stolen by the wolf from the Hero
     */
    private int lollipopCount = 0;
    /**
     * @param feral boolean checking if wolf is feral for further attack methods
     */
    private boolean feral = false;

    // CONSTRUCTOR
    public Wolf(World world, Game game, GameLevels level) {
        super(world, wolfShape);
        this.setGravityScale(3);
        this.itWalks();
        this.itWalksCorrection();
        this.feral();
        this.game = game;
        this.level = level;
        this.collisionz();

    }

    // GETTERS

    /**
     * get current life
     * @return life
     */
    public int getLife() {
        return life;
    }

    /**
     * get speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * stores and returns curent position
     * @return position
     */
    public Vec2 getPos() {
        position = this.getPosition();
        return position;
    }

    // SETTERS

    /**
     * allows changing wolf's speed
     * @param speed new speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * used with EnemyWalks to track if enemy changes direction upon collision with
     * WalkingChecks
     *
     * @param b boolean if turned
     * @see game.used.objects.other.WalkChecks
     * @see EnemyWalk
     */
    @Override
    public void turned(boolean b) {
        turned = b;
    }

    /**
     * changes wolf's life by int life
     * @param life value to decrement life by
     */
    public void setLife(int life) {
        this.life = this.life - life;
    }

    /**
     * set's lollipop count to a given value
     * @param i new value of lollipopCount
     */
    public void setLollipopCount(int i){
        this.lollipopCount = i;
    }


    // METHODS AND OVERRIDES
    // makes the wolf walk

    /**
     * makes the wolf walk and changes it's attached body images based on direction
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
     * every 2.5-7.5 s wolf changes it's direction; set's feral to false
     */
    private void itWalksCorrection(){
        javax.swing.Timer dogtimer = new javax.swing.Timer( (int )(Math.random() * 5000 + 2500) , e -> {
            s++;
            getPos();
            stopWalking();
            jump(position.normalize()/10);
            setSpeed(-1*speed);
            startWalking(speed);
            feral = false;
        });
        dogtimer.setRepeats( true );
        dogtimer.start();
    }

    /**
     * from time to time dog jumps and get's into feral state which affects
     * it's further attacks, the lower the life the more often feral it is
     */

    private void feral() {
        javax.swing.Timer feraltimer = new javax.swing.Timer( (int )(Math.random()*2000 + life*500) , e -> {
            s1++;
            feral = true;
            jump(20);
        });
        feraltimer.setRepeats( true );
        feraltimer.start();
    }

    // uses a lollipop stolen to spawn a puppy if not feral

    /**
     * if not feral and has a lollipop wolf will spawn a new faster puppy, give it extra 2 life,
     * decrement it's own life by 5 and use up lollipops in the process
     */
    public void attack1(){
        if (lollipopCount>0 && !feral){
            getPos();
            Puppy pup = new Puppy(getWorld(), game, level);
            pup.setPosition(position);
            pup.setSpeed(pup.getSpeed()+2);
            setLife(getLife()-5);
            pup.setLife((getLife()+2));
            jump(8);
            setLollipopCount(0);
        }
        else this.jump(getSpeed());
    }

    /**
     * collision listeners directly in the class
      */
    public void collisionz(){
        this.addCollisionListener(new AttackEnemy(game, level, level.getFatLady(), this));
        this.addCollisionListener(new EnemyWalk(game, level, this));
        this.addCollisionListener(new EnemyAttacks(game, level, this, level.getFatLady()));
    }


    /**
     * if feral and no lollipops wolf will spawn a Bat object
     */
    @Override
    public void attack2() {
        super.attack2();
        if (feral && lollipopCount == 0){
            getPos();
            Bat bat = new Bat(getWorld(), game, level);
            bat.setPosition(position);
        }
    }

    /**
     * if feral and has a lollipop wolf will spawn a dog with double life, decrement its own life
     * and make the dog be faster. This will use up lollipops.
      */
    @Override
    public void attack3() {
        super.attack3();
        if (lollipopCount > 0 && feral) {
            getPos();
            Dog dog = new Dog(getWorld(), game, level);
            dog.setPosition(position);
            dog.setSpeed(dog.getSpeed() + 2);
            setLife(getLife() - 5);
            dog.setLife(getLife()*2);
            jump(8);
            setLollipopCount(0);
        }
    }

    @Override
    public void attack4() {
        super.attack4();
    }

    @Override
    public void isShot() {
        super.isShot();
    }

    /**
     * plays poodle soundclip upon destruction
     */
    @Override
    public void destroy(){
        super.destroy();
        if (level.getFatLady() instanceof FatFairy)
            poodle.play();
        else
            boom.play();
    }
}
