package game.deprecated;

import city.cs.engine.*;
import game.used.objects.hero.Attacks;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Attack object class
 * NOT IN USE
 * @deprecated
 */

public class StarBullet extends Attacks implements Serializable {

    private int seconds = 0;
    private static Shape dot = new CircleShape((float) 0.5);
    private static final BodyImage image =
            new BodyImage("data/star.png", 1.2f);

    public StarBullet(World w)  {
        super(w, dot);
        attackTask();
        addImage(image);

    }


    public void attackTask() {
        Timer freezeTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                seconds++;
                destroy();
            }
        };
        freezeTimer.schedule(task, 2500);
    }

}

