package game.used.objects.enemy.boss;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.AttackEnemy;
import game.used.eventListeners.otherLevels.AttacksHitWall;
import game.used.eventListeners.otherLevels.BossAttacking;
import game.used.eventListeners.otherLevels.EnemyAttacks;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Enemy;
import game.used.objects.hero.Hero;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.Serializable;


/**
 *  Class to generate an instance of a Boss Eye
 *  uses most of the same methods as Boss
 * @see Boss
 * @see Enemy
 *
 */


public class BossEye extends Enemy implements Serializable {

    private Game game;
    private GameLevels level;
    private Hero chub;
    private Boss boss;
    /**
     * @param bulletStart Vec2 position of bullet spawning
     * @see Boss
     */
    private Vec2 bulletStart;
    /**
     * @param alfa angle between boss and hero
     * @see Boss
     */
    private double alfa;//angle between boss and hero
    private BossAttacks spell;
    private BossAttacks curse;
    /**
     * @param x  used in positioning vector X
     */
    private float x;
    /**
     * @param y  used in positioning vector Y
     */
    private float y;
    /**
     * @param initialPosition keeps initial position of the BossEye object
     */
    private Vec2 initialPosition;
    /**
     * @param position keeps current position of the BossEye object
     */
    private Vec2 position;
    /**
     * @param s1 s1-s5 time's seconds to count
     */
    private int s1 = 0;
    private int s2 = 0;
    private int s3 = 0;
    private int s4 = 0;
    private int s5 = 0;
    /**
     * @param lives stores lives count
     */
    private int lives = 50;
    /**
     * @param a stores random double
     */
    private double a;
    /**
     * @param repositioning boolean setting timer's keeping BossEye in the same position to repeat
     */
    private boolean repositioning = true;
    /**
     * @param image body image of BossEye
     */
    private static final BodyImage image = ExceptionHandling.catchError("data/BossEye.png", "" +
            "Big floating eye with needles", 10f );
    /**
     * @param shape shape of the BossEye
     */
    private static final Shape shape = new PolygonShape(-0.25f,-2.4f,
            1.6f,-1.49f, 2.56f,0.6f, 1.87f,2.72f, -0.63f,3.71f, -2.83f,2.41f, -3.44f,0.41f, -2.53f,-1.71f);

    public BossEye(World world, GameLevels level, Game game, Hero chub) {
        super(world, shape);
        addImage(image);
        this.game = game;
        this.level = level;
        this.chub = chub;
        this.collisionz();
        this.setGravityScale(0);
        this.initialisePosition();
        this.correctPosition();
        this.attack1();
        this.attack2();
        this.itLooks();
        this.addCollisionListener(new EnemyAttacks(game, level, this, chub));
        this.addCollisionListener(new AttackEnemy(game, level, chub, this));
    }

    /**
     * stores collision listeners for the BossEye
     */
    public void collisionz(){
        this.addCollisionListener(new AttackEnemy(game, level, level.getFatLady(), this));
        this.addCollisionListener(new EnemyAttacks(game, level, this, level.getFatLady()));
    }

    /**
     * checks and saves inital position of the BossEye for further reference
     */
    private void initialisePosition(){
        javax.swing.Timer posTimer = new javax.swing.Timer( 0 , e -> {
            s1++;
            initialPosition = this.getPosition();
        });
        posTimer.setRepeats( false );
        posTimer.start();
    }

    /**
     * uses timer to every 0.1s correct position of the BossEye back to it's initial position
     */
    private void correctPosition(){

            javax.swing.Timer posTimer = new javax.swing.Timer(100, e -> {
                s2++;
                if(lives>10) {
                    position = this.getPosition();
                    if (position != initialPosition)
                        this.setPosition(initialPosition);
                } else
                    repositioning = false;
            });
            posTimer.setRepeats(repositioning);
            posTimer.start();
        }


    // allows aiming at the hero
    /**
     * takes floats x and y of boss' current position, calculates an angle between boss
     * and current position of Hero and generates spawning point for the bullet shot at the Hero
     * direction
     */
    private void positioning() {

        x = this.getPosition().x;
        y = this.getPosition().y;
        if (chub.getPosition().x-x >0 )
            alfa = Math.atan((chub.getPosition().y-y)/(chub.getPosition().x-x));
        else
            alfa = Math.atan((chub.getPosition().y-y)/(chub.getPosition().x-x)) - Math.PI;

        bulletStart = new Vec2((float) (6 * Math.cos(alfa)) + x,
                (float) (6 * Math.sin(alfa)) + y);

    }

    @Override
    public void turned(boolean b) {

    }

    /**
     * set's life, under 6 changes gravity scale
     * @param i value to change the live count by
     */
    @Override
    public void setLife(int i) {
        this.lives = lives - i;
        if (lives < 6)
            this.setGravityScale(3);
    }

    @Override
    public int getLife() {
        return lives;
    }

    @Override
    public Vec2 getPos() {
        return super.getPos();
    }

    /**
     * makes the BossEye follow the player, uses alfa
     */
    public void itLooks(){
        javax.swing.Timer lookingtimer = new javax.swing.Timer( 400 , e -> {
            s3++;
            positioning();
            this.setAngle((float) alfa);
        });
        lookingtimer.setRepeats( true );
        lookingtimer.start();
    }

    /**
     * spawns CurseCast at current Hero position every 14-34s
     * @see CurseCast
     */
    @Override
    public void attack1() {
        super.attack1();
        // spawns a curse
        javax.swing.Timer cursetimer = new javax.swing.Timer( (int )(Math.random() * 20000 + 14000) , e -> {
            s4++;
            a = Math.random()*100;
            if (a<30) { // 30% chance to cast a curse
                curse = new CurseCast(this.getWorld(), game, level);
                curse.setPosition(chub.getPosition());
            }
        });
        cursetimer.setRepeats( true );
        cursetimer.start();

    }

    /**
     * shoots EyeSpell at Hero using positioning(); timer every 6-24s
     */
    @Override
    public void attack2() {
        super.attack2();
        javax.swing.Timer eyespell = new javax.swing.Timer( (int )(Math.random() * 18000 + 6000) , e -> {
            s5++;
            positioning();
            spell = new EyeSpell(this.getWorld());
            spell.setPosition(bulletStart);
            spell.setAngle((float) alfa);
            // normalise bullet speed based on spawn distance
            spell.setLinearVelocity(new Vec2((float) (27 * Math.cos(alfa)),
                    (float) (27 * Math.sin(alfa))));
            spell.addCollisionListener(new AttacksHitWall(game, level));
            spell.addCollisionListener(new BossAttacking(game, level, level.getFatLady()));
        });
        eyespell.setRepeats( true );
        eyespell.start();
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
    public void setLollipopCount(int i) {

    }


    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void setGravityScale(float g) {
        super.setGravityScale(g);
    }
}
