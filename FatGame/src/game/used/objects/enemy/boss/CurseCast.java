package game.used.objects.enemy.boss;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.BossAttacking;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Enemy;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *  Creates an object that warns a player where a curse attack will land
 */

public class CurseCast extends BossAttacks implements Serializable {
    /**
     * @param seconds timer's int value
     */
    private int seconds = 0;
    /**
     * @param curze object's shape
     */
    private static final Shape curze = new CircleShape(0.00001f);
    /**
     * @param image object's body image
     */
    private static final BodyImage image = ExceptionHandling.catchError("data/cross.png", "" +
            "Curse; circle with a cross", 10f );

    private Curse curse;
    /**
     * @param position stores current position of the object
     */
    private Vec2 position;
    private Game game;
    private GameLevels level;


    public CurseCast(World w, Game game, GameLevels level) {
        super(w, curze);
        this.game = game;
        this.level = level;
        addImage(image);
        attackTask();
        this.setGravityScale(0);
        this.setAngularVelocity(16);
    }

    /**
     * gets current position of the object
     * @return position
     */
    public Vec2 getPos(){
        position = this.getPosition();
        return position;
    }

    /**
     * after 4s delay destroys object and in it's place spawns Curse object
     * with it's collision listener
     * @see Curse
     */
    public void attackTask() {

        javax.swing.Timer spelltimer = new javax.swing.Timer( 4000 , e -> {
            seconds++;
            this.getPos();
            curse = new Curse(getWorld());
            curse.setPosition(position);
            curse.addCollisionListener(new BossAttacking(game, level, level.getFatLady()));
            this.destroy();
        });
        spelltimer.setRepeats( false );
        spelltimer.start();
    }
}


