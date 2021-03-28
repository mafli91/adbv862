package game.used.objects.collectable;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class to create a dust baggie to be collected
 * @see Collectable
 */

public class FairyDust extends Collectable implements Serializable {


    private int s = 0; // timer's seconds field
    private int torque = 3; //torque's value
    // shape of the object
    private static final Shape burgerShape = new PolygonShape(
            -0.26f,1.2f, 0.72f,0.59f, -0.06f,-0.77f, -1.21f,-0.04f);
    // object's image
    private static final BodyImage image = ExceptionHandling.catchError("data/dust.png", "" +
            "fairy dust", 3.5f );

    public FairyDust(World world) {
        super(world, burgerShape);
        addImage(image);
        foodTorque();
        setGravityScale(0);
    }

    @Override
    public void foodTorque(){
        Timer foodTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                s++;
                applyTorque(-torque);
            }
        };
        foodTimer.scheduleAtFixedRate(task, 2000,1500);
    }

}




