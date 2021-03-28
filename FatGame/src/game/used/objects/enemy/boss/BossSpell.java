package game.used.objects.enemy.boss;

import city.cs.engine.*;
import game.used.objects.enemy.boss.BossAttacks;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *  Basic attack of the Boss
 * @see game.used.eventListeners.otherLevels.EnemyAttacks
 * @see Boss
 */

public class BossSpell extends BossAttacks implements Serializable {
    /**
     * @param spell shape of the object
     */
    private static final Shape spell = new PolygonShape(
            1.351f,0.051f, 0.023f,0.814f, -1.042f,-0.327f, -0.035f,-0.397f);
    /**
     * @param seconds timer's seconds int
     */
    private int seconds = 0;
    /**
     * @param image holds BodyImage of the object
     */
    private static final BodyImage image = ExceptionHandling.catchError("data/spellStar1.png", "" +
            "Boss basic spell", 2f );

    public BossSpell(World w) {
        super(w, spell);
        addImage(image);
        this.setBullet(true);
        attackTask();
        this.setGravityScale(0);
    }


    /**
     * timer destroys the object after 6s
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


