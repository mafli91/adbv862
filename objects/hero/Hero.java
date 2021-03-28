package game.used.objects.hero;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Hero abstract class, most methods are described in FatFairy and BlueFairy.
 * Here see getBarrier() .
 * @see BlueFairy
 * @see FatFairy
 */
public abstract class Hero extends Walker implements Serializable {

    private static final BodyImage barrier = ExceptionHandling.catchError("data/barrier.png", "" +
            "circle of tiny stars", 10.4f );
    private AttachedImage barr;

    // counts how many burgers eaten
    private int burgerCount = 0;
    // timer
    private int seconds = 0;
    // check if on moving platform
    public boolean isOnPlatform = false;


    public Hero(World world, Shape shape) {
        super(world, shape);
    }




    //GETTERS

    public BodyImage getBodyImage (){
        return barrier;
    }

    public abstract void getStay();

    public abstract boolean isImmune();

    public abstract void getLeft();

    public abstract void getRight();

    public abstract int getLollipopCount();

    public abstract int getFat();

    public abstract int getLayers();

    public abstract int getBurgerCount();

    //SETTERS

    public abstract void setBurgerCount(int b);

    public abstract void setFat( int fat);

    public abstract void setLayers(int layers);

    public abstract void setImmune(boolean immune);

    public void setOnPlatform(boolean onPlatform) {
        isOnPlatform = onPlatform;
    }

    public abstract void setLollipopCount( int lollipopCount);

    // METHODS

    //increases fat count, every 4 fat counts increase layers
    public abstract void getFatter();

    //increase lollipop count
    public abstract void lollipopEaten();

    // decreases fat lady's lives
    public abstract void skinny(int s);

    // check if gravity works fine
    // public void printGravity() { System.out.println("Gravity " + this.getGravityScale()); }

    /** barrier image internal method
    * for complimentary method look in FatControl
     */
    public AttachedImage getBarrier() {
        barr = new AttachedImage(this, barrier, 1, 0, new Vec2(0,0) );
        Timer barrierTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                removeAttachedImage(barr);
            }
        };
        barrierTimer.schedule(task, 7000);
        return barr;
    }



}
