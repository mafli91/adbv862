package game.used.objects.hero;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;

/**
 * HedgeSpike object created upon destruction of Hedgehog
 * @see Hedgehog
 * @see Attacks
 */
public class HedgeSpike extends Attacks implements Serializable {
    private static final Shape spell = new PolygonShape(-0.735f,
            -0.695f, 0.616f,-0.695f, -0.06f,0.75f);
    private int seconds = 0;
    private static final BodyImage image = ExceptionHandling.catchError("data/triangle.png", "" +
            "triangle", 1.9f );


    public HedgeSpike(World w) {
        super(w, spell);
        addImage(image);
        this.setBullet(true);
        this.setGravityScale(0);
        attackTask1();

    }

    /**
     * spikes have lifespan 1.5s
     */
    public void attackTask1() {
        javax.swing.Timer destroytimer = new javax.swing.Timer( 1500 , e -> {
            seconds++;
            this.destroy();
        });
        destroytimer.setRepeats( false );
        destroytimer.start();
    }
}