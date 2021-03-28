package game.used.levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.objects.enemy.boss.Boss;
import game.used.objects.other.ComicStrip0;
import game.used.objects.other.ComicStrip10;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * Level with a comic strip story
 * @see game.used.objects.other.ComicStrip10
 */
public class Lvl10 extends GameLevels implements Serializable {
    public Lvl10(Game game) {
        super(game);
        //sound
        try {
            gameMusic = new SoundClip("data/sound/boss2.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }


        Shape groundShape = new BoxShape(40, 0.3f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -35f));
        StaticBody leftWall = new StaticBody(this, groundShape);
        leftWall.setPosition(new Vec2(-40, -10));
        leftWall.setAngleDegrees(90);
        StaticBody rightWall = new StaticBody(this, groundShape);
        rightWall.setPosition(new Vec2(40, -10));
        rightWall.setAngleDegrees(90);





    }

    public void populate(Game game){
        super.populate(game);
        comic10 = new ComicStrip10(this, game);

        //fat lady
        getFatLady().setPosition(new Vec2(7, -12));
    }

    @Override
    public boolean isComplete() {
        if (getFatLady().getBurgerCount() >= 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean offPlatform() {
        return false;
    }

    @Override
    public Image paintBackground() {
        Image background = new ImageIcon("data/lvl1.jpg").getImage();
        return background;
    }

    @Override
    public boolean onPlatform() {
        return true;
    }

    @Override
    public JLabel playerTips(){
        label = new JLabel("My label");

        label.setText("<html>" +
                "<body width='150'><h2>To see next strip press ENTER</h2>\n" +
                "</html>");
        return label;
    }

    @Override
    public String getLevelName() {
        return "L10";
    }


}
