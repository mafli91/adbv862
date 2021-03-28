package game.used.objects.hero;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class creating Butterfly attack
 * @see Attacks
 */
public class Butterfly extends Attacks implements Serializable {
    /**
     * @param spell shape of the spell attack
     */
    private static final Shape spell = new CircleShape((float) 1.1);
    /**
     * @param seconds timer's int value
     */
    private int seconds = 0;
    /**
     * @param fly boolean controlling timers repetition
     */
    private boolean fly = true;
    /**
     * @param image body image
     */
    private static final BodyImage image =
            new BodyImage("data/butterfly.png", 1.9f);
    /**
     * @param butter soundclip for butterfly
     */
    private static SoundClip butter;
    static {
        try {
            butter = new SoundClip("data/sound/go-insect.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(butter, "Butterfly sound");
        }}

    public Butterfly(World w) {
        super(w, spell);
        addImage(image);
        this.setBullet(true);
        this.setGravityScale(-3);
        attackTask1();
        attackTask2();
        butter.play();
    }

    /**
     * taks constructed of timers changing gravity scale so that released
     * butterfly fly up and down
     */
    public void attackTask1() {
        javax.swing.Timer flyDownTimer = new javax.swing.Timer(500, e -> {
            seconds++;
            this.setGravityScale(7);
        });
        flyDownTimer.setRepeats(false);
        flyDownTimer.start();
        javax.swing.Timer flyUpTimer = new javax.swing.Timer(1000, e -> {
            seconds++;
            this.setGravityScale(-7);
            flyDownTimer.start();
        });
        flyUpTimer.setRepeats(fly);
        flyUpTimer.start();

    }

    /**
     * destroys butterfly after 2.5s and sets timer's repetition false via fly
     */
    public void attackTask2() {
        javax.swing.Timer destroytimer = new javax.swing.Timer( 2500 , e -> {
            seconds++;
            fly = false;
            this.destroy();
        });
        destroytimer.setRepeats( false );
        destroytimer.start();
    }
}
