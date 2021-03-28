package game.used.objects.enemy.boss;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.used.eventListeners.otherLevels.AttackEnemy;
import game.used.eventListeners.otherLevels.AttacksHitWall;
import game.used.eventListeners.otherLevels.BossAttacking;
import game.used.eventListeners.otherLevels.EnemyAttacks;
import game.used.levels.GameLevels;
import game.used.levels.Lvl11;
import game.used.objects.enemy.Enemy;
import game.used.objects.hero.Hero;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.Serializable;

/**
 * Class to make the Boss Lady
 *
 * @see Enemy
 * @see BossEye
 */

public class Boss extends Enemy implements Serializable {

    // private lady parts aka looks
    /**
     * @param barrierShape  barrier shape
     */
    private static final Shape barrierShape = new CircleShape(11f);
    //boss shape
    /**
     * @param ladyShape polgon shape of the boss
     */
    private static final Shape ladyShape = new PolygonShape(
            -1.2f,-3.8f, 0.74f,-3.84f, 1.44f,1.76f, -0.44f,4.3f, -2.08f,2.0f);
    // image for level 9
    /**
     * @param staying body image of boss in level 9
     */
    private static final BodyImage staying = ExceptionHandling.catchError("data/boss_angry.png", "" +
            "Boss angry", 10f );
    // image for level 11
    /**
     * @param eyey body imaged of boss in level 11
     */
    private static final BodyImage eyey = ExceptionHandling.catchError("data/boss_with_eyes.png", "" +
            "Boss a bit rotten", 8f );
    //barrier image
    /**
     * @param barrier  body image of the barrier
     */
    private static final BodyImage barrier = ExceptionHandling.catchError("data/circle.png", "" +
            "Boss barrier", 14f );

    // attached images
    /**
     * @param stay  attached image for the boss
     */
    private AttachedImage stay;
    /**
     * @param barr  attached image for the barrier
     */
    private AttachedImage barr;
    // Boss' position
    /**
     * @param position  current position
     */
    private Vec2 position;

    //timers
    /**
     * @param seconds and s1-7 for timers to count seconds
     */
    private int seconds = 0;
    private int s1 = 0;
    private int s2 = 0;
    private int s3 = 0;
    private int s4 = 0;
    private int s5 = 0;
    private int s6 = 0;
    private int s7 = 0;
    /**
     * @param lives  live count
     */
    private int lives = 66;

    /**
     * @param immune  gives immunity while in barrier
     */
    private boolean immune = false;
    private Hero chub;
    //position of where bullet created appears
    /**
     * @param bulletStart  position where bullet shot by boss will appear
     */
    private Vec2 bulletStart;
    /**
     * @param alfa  angle between boss and hero
     */
    private double alfa;
    private BossAttacks heel;
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
    private Game game;
    private GameLevels level;

    /**
     * @param speed   movement speed of th Boss object
     */
    private int speed = (int )(Math.random() * 35 + 10);
    /**
     * @param a   random factor
     */
    private int a;

    /**
     * @param eyeCount  counts amount of eyes destroyed in Lvl11
     */
    private int eyeCount = 0;


    //BOSS CONSTRUCTOR
    public Boss(World world, GameLevels level, Game game, Hero chub) {
        super(world, ladyShape);
        this.chub = chub;
        this.game = game;
        this.level = level;
        this.doThings();
        this.addCollisionListener(new EnemyAttacks(game, level, this, chub));
        this.addCollisionListener(new AttackEnemy(game, level, chub, this));
        this.wonBoss();

    }


    // GETTERS

    /**
     * returns lives of the boss
     * @return lives count
     */
    public int getLife() {
        return lives;
    }

    /**
     * returns if boss is curently immune to attacks
     * @return boolean immune
     */
    public boolean isImmune() {
        return immune;
    }

    /**
     * gets current position of the boss
     * @return Vec2 position
     */
    public Vec2 getPos(){
        position = this.getPosition();
        return position;
    }

    /**
     * returns current eyecount
     * @return eyecount amount of eyes destroyed in level 11
     */
    public int getEyeCount(){ return eyeCount; }


    //SETTERS

    /**
     * sets eyecount during the fight in level 11 calls wonBoss if satisfied
     * @param e
     */
    public void setEyeCount(int e){
        this.eyeCount = eyeCount + e;
        if (eyeCount>=12)
            wonBoss();
    }

    @Override
    public void turned(boolean b) {  }

    /**
     * calls gotHit method
     * @param l integer used in gotHit
     */
    public void setLife(int l) {
        gotHit(l);
    }

    /**
     * sets boss' immunity
     * @param immune boolean changes immune
     */
    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    /**
     * changes speed of the movement of the boss
     * @param speed speed to be set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }


    // METHODS

    /**
     * collective method of all methods to be done depending on which level boss is in
     * also changes body image, set's constant immunity in level 11 and changes gravity scale
     */
    public void doThings(){
        if(level instanceof Lvl11){
            // don't fight
            setImmune(true);
            removeAllImages();
            stay = new AttachedImage(this, eyey, 1.5f, 0, new Vec2(0,0));
            setGravityScale(20);
        } else{
            // fight with hero
            this.shootBarrier();
            this.shootCurse();
            this.shootHeel();
            this.shootSpell();
            this.itWalks();
            removeAllImages();
            stay = new AttachedImage(this, staying, 1, 0, new Vec2(0,0));
        }
    }

    /**
     * takes value from set life and changes lives by that value
     * if lives under 0 calls for wonBoss if else displays a message
     * checks if immunity is applied and ignores the damage if it is
     * @param q value taken from setLives
     */
    // decreases boss's lives
    public void gotHit(int q) {
        if (!immune) {
            if (getLife() < 0) {
                game.appendLog("You wrecked her. It's over...");
                wonBoss();
            } else {
                game.appendLog("You hit her!");
                game.appendLog("She has " + getLife() + " life left!");
                this.lives = lives - q;
            }
        }
        else if (immune)
            game.appendLog("Sorry, she's immune");

    }

    // barrier image internal method

    /**
     * creates a solid fixture in barriershape with barrier image that lasts 10s and then destroys it
     * increments boss' life count in the process, removes immunity while destroying barirer;
     * method is called by shootBarrier method
     */
    public void barrier() {

        SolidFixture bar = new SolidFixture(this, barrierShape, 100);
        barr = new AttachedImage(this, barrier, 1, 0, new Vec2(0,0) );
        bar.setFriction(50);
        bar.setRestitution(0.9f);
        this.lives= lives + 4;

        javax.swing.Timer bosstimer3 = new javax.swing.Timer( 10500 , e -> {
            s1++;
            bar.destroy();
            removeAttachedImage(barr);
            this.setImmune(false);
        });
        bosstimer3.setRepeats( false );
        bosstimer3.start();

    }

    // barrier spawn method

    /**
     * controls calling method barrier() in intervals of 11,5-15,5s, applies immunity
     */
    public void shootBarrier(){
        javax.swing.Timer bosstimer2 = new javax.swing.Timer( (int )(Math.random() * 3000 + 11500) , e -> {
            s2++;
            barrier();
            this.setImmune(true);
        });
        bosstimer2.setRepeats( true );
        bosstimer2.start();
    }

    // spawns a curse

    /**
     * controls spawning instances of CurseCast positioned at the current position of the Hero
     * uses timer and randomised times 11-15s
     */
    public void shootCurse(){

            javax.swing.Timer bosstimer6 = new javax.swing.Timer((int) (Math.random() * 4000 + 11000), e -> {
                s6++;
                curse = new CurseCast(this.getWorld(), game, level);
                curse.setPosition(chub.getPosition());
            });
            bosstimer6.setRepeats(true);
            bosstimer6.start();

    }

    // spawns a heel attack

    /**
     * controls spawning Heel attacks at the Hero using positioning() method
     * uses timer at random intervals 2-3,5 s
     */
    public void shootHeel(){

            javax.swing.Timer bosstimer5 = new javax.swing.Timer((int) (Math.random() * 1500 + 2000), e -> {
                s5++;
                positioning();
                heel = new Heel(this.getWorld());
                heel.setPosition(bulletStart);
                heel.setAngle((float) alfa);
                // normalise bullet speed based on spawn distance
                heel.setLinearVelocity(new Vec2((float) (10 * Math.cos(alfa)),
                        (float) (10 * Math.sin(alfa))));
                heel.addCollisionListener(new AttacksHitWall(game, level));
                heel.addCollisionListener(new BossAttacking(game, level, level.getFatLady()));
                heel.applyTorque(7);
            });
            bosstimer5.setRepeats(true);
            bosstimer5.start();

    }

    // spawns a spell attack directly by player's position

    /**
     * like shootHeel() shoots BossSpell attacks at hero using positioning() method every 1-2,9s
     */
    public void shootSpell(){
            javax.swing.Timer bosstimer4 = new javax.swing.Timer((int) (Math.random() * 1900 + 1000), e -> {
                s4++;
                positioning();
                spell = new BossSpell(this.getWorld());
                spell.setPosition(bulletStart);
                spell.setAngle((float) alfa);
                // normalise bullet speed based on spawn distance
                spell.setLinearVelocity(new Vec2((float) (27 * Math.cos(alfa)),
                        (float) (27 * Math.sin(alfa))));
                spell.addCollisionListener(new AttacksHitWall(game, level));
                spell.addCollisionListener(new BossAttacking(game, level, level.getFatLady()));
            });
            bosstimer4.setRepeats(true);
            bosstimer4.start();

    }

    // makes the boss move around the map

    /**
     * randomises boss' movement changing speed, gravity scale and applying jump; each change is controlled by
     * random number generator and timer. Has no constraints as to what is the maximum or minimum speed.
     */
    public void itWalks(){
            this.startWalking(speed);
            javax.swing.Timer bosstimer = new javax.swing.Timer((int) (Math.random() * 2000 + 1500), e -> {
                s3++;
                stopWalking();
                a = (int) (Math.random() * 100);
                if (a > 50) {
                    speed = speed + 8;
                    this.setGravityScale(5);
                } else {
                    speed = speed - 8;
                    this.setGravityScale(-1);
                    this.jump(speed / 4);

                }
                setSpeed(-1 * speed);
                startWalking(speed);
                if (a > 80)
                    this.jump(speed * 2);
            });
            bosstimer.setRepeats(true);
            bosstimer.start();

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


    // when you beat the boss

    /**
     * method controls moving to the next level upon winning the fight
     * @see game
     * @see GameLevels
     */
    public void wonBoss(){
        if (this.lives<1) {
            speed = 0;
            game.appendLog("YOU FINISHED THE SKINNY BOSS");
            game.appendLog("YOU WILL RULE THIS LAND NOW");
            game.appendLog("WELL DONE?...");
            game.goToNextLevel();
        } else if (eyeCount >=12) {
            game.appendLog("YOU'VE DONE IT");
            game.appendLog("YOU WILL RULE THIS LAND AGAIN");
            game.appendLog("NO BUTs");
            game.goToNextLevel();
        }

    }


    @Override
    public void setLollipopCount(int i) {

    }
}


