package game.used.objects.enemy.boss;

import city.cs.engine.*;
import game.used.objects.enemy.Enemy;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *  Creates an attack object Curse that deals damage upon 4s delay
 * @see game.used.eventListeners.otherLevels.EnemyAttacks
 * @see Boss
 * @see BossEye
 */

public class Curse extends StaticBody implements Serializable {
    /**
     * @param curse shape of the curse object
     */
        private static final Shape curse = new CircleShape(7);
    /**
     * @param seconds timer's int value
     */
    private int seconds = 0;
    /**
     * @param image holds body image of the object
     */
        private static final BodyImage image = ExceptionHandling.catchError("data/cross.png", "" +
            "Curse; circle with a cross", 10f );


        public Curse(World w) {
            super(w, curse);
            addImage(image);
            //this.setBullet(true);
            attackTask();
            //this.setGravityScale(0);
        }

    /**
     * destroys the object after 2s
     */
        public void attackTask() {
            javax.swing.Timer spelltimer = new javax.swing.Timer( 2000 , e -> {
                seconds++;
                this.destroy();
            });
            spelltimer.setRepeats( false );
            spelltimer.start();
        }
    }


