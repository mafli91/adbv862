package game.used.objects.collectable;

import city.cs.engine.*;
import game.used.levels.GameLevels;
import game.used.objects.hero.FatFairy;
import game.used.world.GUI.ExceptionHandling;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class to create a lollipop
 * @see Collectable
 */

public class Lolly extends Collectable implements Serializable {
    // timer's seconds
    private int s = 0;
    // torque value
    private int torque = 6;
    // object's shape
    private static final Shape lollyShape = new PolygonShape(
            -0.95f,1.17f, 0.39f,1.34f, 0.65f,0.26f, -0.1f,-1.03f, -1.06f,0.27f);
    // object's image
    private static final BodyImage image = ExceptionHandling.catchError("data/lolly.png", "" +
            "lollypop", 4f );

    // sound used when collected
    private static SoundClip lolly;
    static {
        try {
            lolly = new SoundClip("data/sound/lolly.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(lolly, "lolly collection");
        }}
    private static SoundClip lolly2;
    static {
        try {
            lolly2 = new SoundClip("data/sound/lollypop.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(lolly2, "lolly collection");
        }}

        private boolean playLolly;

    public Lolly(World w) {
        super(w, lollyShape);
        addImage(image);
        this.setGravityScale(0);
        this.foodTorque();
        if(((GameLevels)w).getFatLady() instanceof FatFairy)
            playLolly = true;
        else
            playLolly = false;

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
        foodTimer.scheduleAtFixedRate(task, 2000,1200);
    }

    @Override
    public void destroy(){
        super.destroy();
        if (playLolly == true)
            lolly.play(); // plays sound upon destruction
        else
            lolly2.play();
    }

}
