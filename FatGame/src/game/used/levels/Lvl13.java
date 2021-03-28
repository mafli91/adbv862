package game.used.levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.objects.enemy.boss.Boss;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * Level displaying credits using timers in the MyView
 * @see Game
 * @see game.used.world.MyView
 */
public class Lvl13 extends GameLevels implements Serializable {

    private int s1 = 0;
    private int s2 = 0;
    private int s3 = 0;
    private int s4 = 0;
    private int s5 = 0;
    private int s6 = 0;
    private int s7 = 0;
    private int s8 = 0;



    public Lvl13(Game game) {
        super(game);
        //sound
        try {
            gameMusic = new SoundClip("data/sound/BONES-UK-Fat.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }


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

        credits(game);
        credits2(game);
        credits3(game);
        credits4(game);
        credits5(game);
        credits6(game);
        credits7(game);
        credits8(game);
        credits9(game);
        credits10(game);
        credits11(game);

    }

    /**
     * Displays credits at position specified in methods from MyView
     *  taking a string for a output value
     * @param game current game
     */
    private void credits(Game game){
        javax.swing.Timer c1 = new javax.swing.Timer( 1000 , e -> {
            s1++;
            game.getView().writeForeground("Author:       Marek Flis");        });
        c1.setRepeats( false );
        c1.start();
    }
    private void credits2(Game game){
        javax.swing.Timer c2 = new javax.swing.Timer( 2000 , e -> {
            s1++;
            game.getView().writeCredits("THANKS FOR JOINING THE STORY");        });
        c2.setRepeats( false );
        c2.start();
    }
    private void credits3(Game game){
        javax.swing.Timer c3 = new javax.swing.Timer( 4000 , e -> {
            s1++;
            game.getView().writeCredits2("I KNOW YOU LOVED IT");        });
        c3.setRepeats( false );
        c3.start();
    }
    private void credits4(Game game){
        javax.swing.Timer c4 = new javax.swing.Timer( 8000 , e -> {
            s1++;
            game.getView().writeCredits("WOULDN'T HAVE DONE IT WITHOUT YOU");        });
        c4.setRepeats( false );
        c4.start();
    }
    private void credits5(Game game){
        javax.swing.Timer c5 = new javax.swing.Timer( 10000 , e -> {
            s1++;
            game.getView().writeCredits2("KIDDING!");        });
        c5.setRepeats( false );
        c5.start();
    }
    private void credits6(Game game){
        javax.swing.Timer c6 = new javax.swing.Timer( 14000 , e -> {
            s1++;
            game.getView().writeCredits("CREDITS ALSO GO TO CUL J-Team: THANKS GUYS!");        });
        c6.setRepeats( false );
        c6.start();
    }
    private void credits7(Game game){
        javax.swing.Timer c7 = new javax.swing.Timer( 16000 , e -> {
            s1++;
            game.getView().writeCredits2("ALSO TO EVERYONE WHO PATIENTLY STOOD BY");        });
        c7.setRepeats( false );
        c7.start();
    }
    private void credits8(Game game){
        javax.swing.Timer c8 = new javax.swing.Timer( 20000 , e -> {
            s1++;
            game.getView().writeCredits("WHILE THE FAIRIES WERE BEING MADE");        });
        c8.setRepeats( false );
        c8.start();
    }
    private void credits9(Game game){
        javax.swing.Timer c9 = new javax.swing.Timer( 26000 , e -> {
            s1++;
            game.getView().writeCredits2("A.C.,J.K.R.,A.B.,B.B.C.," +
                    "P.S.R.,T.O.,A.D.O.P.,K.F. & others");        });
        c9.setRepeats( false );
        c9.start();
    }
    private void credits10(Game game){
        javax.swing.Timer c10 = new javax.swing.Timer( 26000 , e -> {
            s1++;
            game.getView().writeForeground("Before you go- Uuma asked for your number...");        });
        c10.setRepeats( false );
        c10.start();
    }
    private void credits11(Game game){
        javax.swing.Timer c11 = new javax.swing.Timer( 32000 , e -> {
            s1++;
            game.getView().writeForeground(" ");
            game.getView().writeCredits(" ");
            game.getView().writeCredits2(" ");
            game.goToZero();        });
        c11.setRepeats( false );
        c11.start();
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
        return null;
    }

    @Override
    public String getLevelName() {
        return "L13";
    }

    @Override
    public JLabel playerTips(){
        label = new JLabel("My label");

        label.setText("<html>" +
                "<body width='150'><h2> THANKS! </h2>\n" +
                "</html>");
        return label;
    }
}