package game.used.objects.enemy.boss;

import city.cs.engine.*;
import game.used.objects.enemy.boss.BossAttacks;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;


/**
 *  Basic attack object class of Boss
 * @see game.used.eventListeners.otherLevels.EnemyAttacks
 * @see Boss
 */

public class Heel extends BossAttacks implements Serializable {
    /**
     * @param heel object's shape
     */
    private static final Shape heel = new PolygonShape(
            -1.1f,-1.31f, 1.33f,-1.0f, -1.1f,1.1f);
    /**
     * @param seconds timer's int value
     */
    private int seconds = 0;
    /**
     * @param image body image of the object
     */
    private static final BodyImage image = ExceptionHandling.catchError("data/heel.png", "" +
            "High heel shoe", 3f );

    public Heel(World w) {
        super(w, heel);
        addImage(image);
        this.setBullet(true);
        attackTask();
        this.setGravityScale(0);
        this.applyTorque(10);
    }


    /**
     * destroys the object after 5s
     */
    public void attackTask() {
        javax.swing.Timer spelltimer = new javax.swing.Timer( 5000 , e -> {
            seconds++;
            this.destroy();
        });
        spelltimer.setRepeats( false );
        spelltimer.start();
    }
}


