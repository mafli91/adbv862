package game.used.objects.hero;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Attack object class Spell
 * @see Attacks
 */

public class Spell extends Attacks implements Serializable {
    private static final Shape spell = new CircleShape((float) 0.5);
    private int seconds = 0; // timer's int
    private static final BodyImage image = ExceptionHandling.catchError("data/spellStar.png", "" +
            "Basic Hero spell, fat star", 1.2f );

    public Spell(World w) {
        super(w, spell);
        addImage(image);
        this.setBullet(true);
        attackTask();
        this.setGravityScale(0);
        this.applyTorque(10);
    }

    /**
     * spell destroyed after 4s
     */
    public void attackTask() {
        Timer spellTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                destroy();
            }};
        spellTimer.schedule(task,4000);
    }
    }


