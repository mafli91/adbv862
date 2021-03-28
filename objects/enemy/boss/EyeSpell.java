package game.used.objects.enemy.boss;

import city.cs.engine.*;
import game.used.objects.enemy.boss.BossAttacks;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *  Basic attack of BossEye
 * @see BossEye
 * @see game.used.eventListeners.otherLevels.EnemyAttacks
 */

public class EyeSpell extends BossAttacks implements Serializable {
    /**
     * @param spell object's shape
     */
    private static final Shape spell = new CircleShape(2.5f);
    /**
     * @param seconds timer's int value
     */
    private int seconds = 0;
    /**
     * @param image body image of an object
     */
    private static final BodyImage image = ExceptionHandling.catchError("data/cross2.png", "" +
            "BossEye attack; colourful cross", 3.5f );

    public EyeSpell(World w) {
        super(w, spell);
        addImage(image);
        this.setBullet(true);
        attackTask();
        this.setGravityScale(0);
        this.setAngularVelocity(7);
    }


    /**
     * destroys the object after 6s delay
     */
    public void attackTask() {

        javax.swing.Timer spelltimer = new javax.swing.Timer( 6000 , e -> {
            seconds++;
            this.destroy();
        });
        spelltimer.setRepeats( false );
        spelltimer.start();
    }
}


