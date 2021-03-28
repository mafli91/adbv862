package game.used.objects.hero;

import city.cs.engine.*;
import game.used.levels.GameLevels;
import game.used.world.GUI.ExceptionHandling;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * One of the Heroines to pick from in the game. Instance of Hero.
 * Has similar methods to FatFairy.
 * Her name is Booma.
 * @see Hero
 * @see FatFairy
 * @see game.used.world.FatControl
 */
public class BlueFairy extends Hero implements Serializable {


    // private lady parts aka looks
    /**
     * @param ladyShape shape of Booma
     */
    private static final Shape ladyShape = new PolygonShape(
            -0.23f,-4.16f, 0.92f,-0.25f, -0.12f,3.06f, -1.31f,-0.24f);

    /**
     * @param staying body image for when static
     */
    private static final BodyImage staying = ExceptionHandling.catchError("data/blue.png", "" +
            "Blue fairy standing still", 8.5f );


    /**
     * @param lefting body image for when walking left
     */
    private static final BodyImage lefting = ExceptionHandling.catchError("data/blueL.png", "" +
            "Blue fairy facing left", 8.5f );

    /**
     * @param righting body image for when walking right
     */
    private static final BodyImage righting = ExceptionHandling.catchError("data/blueR.png", "" +
            "Blue fairy facing right", 8.5f );


    /**
     * @param stay attached body images to swap when moving with right and left
     */
    private AttachedImage stay;
    private AttachedImage right;
    private AttachedImage left;

    /**
     * @param fat increases when collected fairy dust
     */
    private int fat = 0;

    /**
     * @param layers life count of Booma
      */
    private int layers = 25;

    /**
     * @param burgerCount checks how many fairy dusts have been collected to check with levelComplete()
     * @see GameLevels
      */
    private int burgerCount = 0;

    /**
     * @param immune sets immunity
      */
    private boolean immune;

    /**
     * @param lollipopCount stores lollipops collected
      */
    private int lollipopCount = 0;

    /**
     * @param isOnPlatform checks if Booma is on a MovPlat
     * @see game.used.objects.other.MovPlat
      */
    public boolean isOnPlatform = false;
    /**
     * @param booma soundclip for Booma
     */
    private static SoundClip booma;
    static {
        try {
            booma = new SoundClip("data/sound/booma.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(booma, "Booma introduction");
        }}



    //FAT LADY CONSTRUCTOR
    public BlueFairy(World world) {
        super(world, ladyShape);
        //addImage(image);  //not in use since pic changes
        this.setGravityScale(1);
        this.getStay();
        booma.play();
    }


    // GETTERS

    /**
     * get burgercount
     * @return burgercount
     */
    public int getBurgerCount(){
        return this.burgerCount;
    }

    /**
     * set's attached body image to stay
     */
    public void getStay() {
        this.removeAttachedImage(right);
        this.removeAttachedImage(left);
        stay = new AttachedImage(this, staying, 1, 0, new Vec2(0,0));
    }

    /**
     * set's attached body image to right
     */
    public void getRight() {
        this.removeAttachedImage(stay);
        this.removeAttachedImage(left);
        right = new AttachedImage(this, righting, 1, 0, new Vec2(0,0));
    }

    /**
     * set's attached body image to left
     */
    public void getLeft() {
        this.removeAttachedImage(right);
        this.removeAttachedImage(stay);
        left = new AttachedImage(this, lefting, 1, 0, new Vec2(0,0));
    }

    /**
     * returns life count
     * @return layers
     */
    public int getLayers() {
        return layers;
    }

    /**
     * returns fat count
     * @return fat
     */
    public int getFat() {
        return fat;
    }

    /**
     * returns boolean immune
     * @return immune
     */
    public boolean isImmune() {
        return immune;
    }

    /**
     * returns lollipop count
     * @return lollipopCount
     */
    public int getLollipopCount() {
        return lollipopCount;
    }



    //SETTERS

    /**
     * set's burgerCount to value of b
     * @param b new value of burgerCount
     */
    public void setBurgerCount(int b){
        this.burgerCount = b;
    }

    /**
     * set's fat to a new value
     * @param fat new value of fat
     */
    public void setFat(int fat) {
        this.fat = fat;
    }

    /**
     * set's layers value
     * @param layers new value of layers
     */
    public void setLayers(int layers) {
        this.layers = layers;
    }

    /**
     * sets immune to new value
     * @param immune new value of boolean immune
     */
    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    /**
     * sets new lollipopCount values
     * @param lollipopCount new lollipopCount value
     */
    public void setLollipopCount(int lollipopCount) {
        this.lollipopCount = lollipopCount;
    }

    // METHODS


    /**
     * increases fat count, every 4 fat counts increase layers
     */
    public void getFatter() {
        this.burgerCount = burgerCount + 1;
        if (getFat() > 3) {
            setFat(0);
            setLayers(getLayers() + 1);

        } else {
            setFat(getFat() + 1);
        }
    }

    /**
     * increase lollipop count
     */
    public void lollipopEaten() {
        lollipopCount++;
    }

    /**
     * decreases fat lady's lives, checks for immunity
     * @param s value to change life count by
     */
    public void skinny(int s) {
        if (!immune) {
            if (getLayers() < 0) {
                System.out.println("You are FAMISHED. It's over...");
                this.destroy();

            } else {
                System.out.println("You've been attacked!");
                setLayers(getLayers() - s);
            }
        }
    }

    // check if gravity works fine
    // public void printGravity() { System.out.println("Gravity " + this.getGravityScale()); }

}
