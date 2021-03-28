package game.used.objects.hero;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Attack object class Puff
 * @see Attacks
 */

public class Puff extends Attacks implements Serializable {
    private Hero lady;
    // size of object
    private static  float puffSize = 1.5f;
    //shape
    private static final Shape spell = new CircleShape(puffSize);
    //timer values
    private int seconds = 0;
    /**
     *     lifespan of puff object
     */
    private int time = 1600;
    //body image
    private static final BodyImage image = ExceptionHandling.catchError("data/smoke.png", "" +
            "Puff of pink smoke", puffSize + 0.4f );

    public Puff(World w, Hero lady) {
        super(w, spell);
        this.lady = lady;
        addImage(image);
        this.setBullet(true);
        attackTask();
        setPuffSize();
        this.setGravityScale(0);
    }

    /**
     * if Uuma has over 3 lollipops her puffs triple in size and live twice as long
     */
    private void setPuffSize(){
        if (lady.getLollipopCount()>3){
            puffSize = puffSize *3;
            time = time *2;
        }
    }

    /**
     * destroy puff after value time
     */
    public void attackTask() {
        javax.swing.Timer puffTimer = new javax.swing.Timer( time , e -> {
            seconds++;
            this.destroy();
        });
        puffTimer.setRepeats( false );
        puffTimer.start();
    }
}
