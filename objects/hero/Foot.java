package game.used.objects.hero;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class to make the foot object
 * @see Attacks
 */

public class Foot extends Attacks implements Serializable {

    private Hero lady;
    private static final Shape footShape = new PolygonShape(
            -0.26f,-2.39f, 0.45f,-2.38f, 0.93f,1.92f, -0.89f,1.93f);

    private static final BodyImage left = ExceptionHandling.catchError("data/footL.png", "" +
            "left foot", 5f );


    private static final BodyImage right = ExceptionHandling.catchError("data/footR.png", "" +
            "right foot", 5f );


    int seconds = 0; //timer



    public Foot(World world, Hero lady) {
        super(world, footShape);
        this.lady = lady;
        attackTask();
    }

    /**
     * gets destroyed after 0,75s
     */
    public void attackTask() {
         javax.swing.Timer footTimer = new javax.swing.Timer( 750 , e -> {
            seconds++;
            this.destroy();
        });
        footTimer.setRepeats( false );
        footTimer.start();
    }

    //returns left attached body image
    public static BodyImage getLeft() {
        return left;
    }

    //returns right attached body image
    public static BodyImage getRight() {
        return right;
    }
    }




