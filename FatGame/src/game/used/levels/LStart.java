package game.used.levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.objects.enemy.boss.Wig;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Starting level in the game
 */
public class LStart extends GameLevels{
    public LStart(Game game) {
        super(game);
        //sound
        try {
            gameMusic = new SoundClip("data/sound/gamegirl.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }

        Wig wig = new Wig(this, this);
        Shape groundShape = new BoxShape(6, 0.3f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -6f));
        StaticBody leftWall = new StaticBody(this, groundShape);
        leftWall.setPosition(new Vec2(-6, 0));
        leftWall.setAngleDegrees(90);
        StaticBody rightWall = new StaticBody(this, groundShape);
        rightWall.setPosition(new Vec2(6, 0));
        rightWall.setAngleDegrees(90);
        StaticBody ceiling = new StaticBody(this, groundShape);
        ceiling.setPosition(new Vec2(0,6));
    }

    @Override
    public boolean isComplete() {
            return true;
    }

    @Override
    public boolean onPlatform() {
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
    public String getLevelName() {
        return "L0";
    }

    @Override
    public JLabel playerTips(){
        label = new JLabel("My label");

        label.setText("<html>" +
                "<body width='150'><h2> ..Press N.. </h2>\n" +
                "</html>");
        return label;
    }
}
