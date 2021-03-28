package game.deprecated;

import city.cs.engine.*;
import game.used.objects.enemy.Enemy;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;

/**
 @deprecated
 */
public class CrunchyWall extends Enemy implements Serializable {

    private int life = 4;
    private static SoundClip wall;
    static {
        try {
            wall = new SoundClip("data/sound/wall.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }}


    public CrunchyWall(World w) {
        super(w, moving);

    }

    @Override
    public void turned(boolean b) {

    }

    public void setLife(int a) {
        life = life - a;
    }

    private static Shape moving = new BoxShape(6, 0.6f);

    @Override
    public void destroy(){
        super.destroy();
        wall.play();
    }

    @Override
    public void setLollipopCount(int i) {

    }

}
