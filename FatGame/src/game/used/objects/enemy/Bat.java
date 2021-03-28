package game.used.objects.enemy;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.AttackEnemy;
import game.used.eventListeners.otherLevels.EnemyAttacks;
import game.used.eventListeners.otherLevels.EnemyWalk;
import game.used.levels.GameLevels;
import game.used.objects.collectable.FairyDust;
import game.used.objects.collectable.Collectable;
import game.used.objects.hero.FatFairy;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;

/**
 * Class creating object Bat which is a flying eyeball made out of poor Creecher
 * @see game.used.objects.other.ComicStrip0
 */
public class Bat extends Enemy implements Serializable{

    private Game game;
    private GameLevels level;
    /**
     * @param batShape object's shape
     */
    private static final Shape batShape = new PolygonShape(
            -0.701f,-0.435f, 0.303f,-0.455f, 0.866f,0.576f, -1.128f,0.638f);
    /**
     * @param bat object's body image
     */
    private static final BodyImage bat = ExceptionHandling.catchError("data/bat.png", "" +
            "Eyeball with wings", 2.5f );
    /**
     * @param killit soundclip played upon object being hit
     */
    private static SoundClip killit;
    static {
        try {
            killit = new SoundClip("data/sound/killit.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(killit, "attacking flying eye");
        }}

    /**
     * @param flip sound played upon object's destruction
     */
    private static SoundClip flip;
    static {
        try {
            flip = new SoundClip("data/sound/flippity.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(flip, "killing flying eye");
        }}
        private static SoundClip flip2;
    static {
        try {
            flip2 = new SoundClip("data/sound/omg.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(flip2, "killing flying eye");
        }}

    /**
     * @param s timer's int value
     */
    private int s = 0; // timer
    /**
     * @param position object's position
     */
    private Vec2 position;

    /**
     * @param life life count
     */
    private int life = 7;
    /**
     * @param speed bat's 'walking' speed
     */
    private int speed = (int )(Math.random() * 30 + 21);
    /**
     * random number
     */
    private int a; // random factor for burger steal

    // CONSTRUCTOR

    public Bat(World world, Game game, GameLevels level) {
        super(world, batShape);
        this.addImage(bat);
        this.game = game;
        this.level = level;
        this.setGravityScale(0);
        this.itWalks();
        this.collisionz();

    }

    // GETTERS

    /**
     * returns life count
     * @return life
     */
    public int getLife() {
        return life;
    }

    /**
     * returns and store's current position
     * @return position
     */
    public Vec2 getPos() {
        position = this.getPosition();
        return position;
    }

    /**
     * returns current speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    // SETTERS

    @Override
    public void turned(boolean b) {
        //
    }

    /**
     * changes life of the object by provided value
     * plays killit sound
     * @param life int to decrement life
     */
    public void setLife(int life) {
        this.life = this.life - life;
        killit.play();
        }

    /**
     * changes object's speed
     * @param speed value to be set as a new speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLollipopCount(int i) {
    }

    // METHODS AND OVERRIDES

    /**
     * plays sound flip upon destruction, has 25% chance of dropping fairy dust loot
     */
    @Override
    public void destroy() {
        super.destroy();
        if(level.getFatLady() instanceof FatFairy)
            flip.play();
        else
            flip2.play();
        /** There is 25% chance bat will drop a burger upon death*/
        a = (int) (Math.random()*100);
        if (a>74) {
            getPos();
            Collectable burger = new FairyDust(getWorld());
            burger.setPosition(position);
            burger.setLinearVelocity(new Vec2(3f,3f));
            game.appendLog("Little thief dropped his loot!");
        }
    }

    // makes the bat fly around seemingly random

    /**
     * set's random speed at random time intervals of the object
     */
    public void itWalks() {
        this.startWalking(speed);
        javax.swing.Timer battimer = new javax.swing.Timer( (int )(Math.random() * 2000 + 1500) , e -> {
            s++;
            stopWalking();
            a = (int) (Math.random()*100);
            if (a>50) { speed = speed + 8;}
            else {speed = speed -8;}
            setSpeed(-1*speed);
            startWalking(speed);
        });
        battimer.setRepeats( true );
        battimer.start();

    }


    /** Collision listeners directly in the class */
    public void collisionz(){
        this.addCollisionListener(new AttackEnemy(game, level, level.getFatLady(), this));
        this.addCollisionListener(new EnemyWalk(game, level, this));
        this.addCollisionListener(new EnemyAttacks(game, level, this, level.getFatLady()));
    }

    /**
     * There is 10% chance bat will steal your burger
     */
    @Override
    public void attack1() {
        super.attack1();
        a = (int) (Math.random()*100);
        if (a>89) {
            getPos();
            Collectable burger = new FairyDust(getWorld());
            burger.setPosition(position);
            burger.setLinearVelocity(new Vec2(3f,3f));
        }
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

}
