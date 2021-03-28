package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.used.levels.GameLevels;
import game.used.objects.hero.Attacks;
import game.used.objects.hero.FatFairy;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;

/**
 *  Listener makes it possible to destroy sth when attacked,
 *  used on walls to make 'breakable walls' using live count int=4
 *  and plays sound clip upon destruction
 *
 * @see city.cs.engine.StaticBody
 */

public class WallCrunch implements CollisionListener, Serializable {

    private GameLevels level;
    private Game game;
    private static SoundClip wall;
    private static SoundClip wall2;
    private int lives = 4;
    static {
        try {
            wall = new SoundClip("data/sound/wall.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(wall, "wall sound");
        }}
    static {
        try {
            wall2 = new SoundClip("data/sound/wall.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(wall2, "wall sound");
        }}



    public WallCrunch(Game game, GameLevels level) {

        this.game = game;
        this.level = level;

    }


    @Override
    public void collide(CollisionEvent hit) {
        if (hit.getOtherBody() instanceof Attacks) {
            this.lives--;
            if (lives == 0) {
                if(level.getFatLady() instanceof FatFairy)
                    wall.play();
                else
                    wall2.play();
                hit.getReportingBody().destroy();
            }
        }
    }
}
