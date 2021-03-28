package game.used.objects.other;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Moving platforms object class
 @see MovPlatSup
 @see game.used.eventListeners.otherLevels.MovingPDown
 @see game.used.eventListeners.otherLevels.MovingPUp
 @see game.used.eventListeners.otherLevels.MovingPHor
 */

public class MovPlat extends Walker implements Serializable {

    private static float y = -8; // walking speed
    private int s = 0; // timer's int value
    private Vec2 position; // current position
    private boolean walking = true; // checks if it's moving
    private static Shape moving = new BoxShape(6, 1f);

    public MovPlat(World w) {
        super(w, moving);
        this.setBullet(true);
        this.setGravityScale(2);
    }


    // GETTERS AND SETTERS
    /**
     * get speed
     */

    public static float getY() {
        return y;
    }

    /**set speed
     * @param y new speed
     */
    public void setY(float y) {
        MovPlat.y = y;
    }

    /**
     * stores and returns position
     * @return position
     */
    public Vec2 getPos() {
        position = this.getPosition();
        return position;
    }

    /**
     * checks if platform is moving
     *
     * @return boolean walking
     */
    public boolean getWalking(){return walking;}

    // METHODS

    /**
     * allows for making the platforms move sies if they get stuck with collisions
     * */
    public void correction(){

        javax.swing.Timer cTimer = new javax.swing.Timer( (int )(Math.random() * 2000 + 12500) , e -> {
            s++;
            getPos();
            stopWalking();
            jump(getLinearVelocity().x*(-1/2));
            setY(getY()*(-1));
            startWalking(getY());
        });
        cTimer.setRepeats( true );
        cTimer.start();

    }

    /**
     *     makes platform start moving sideways
     */
    public void moveSides() {
        this.startWalking(y);
    }



}

