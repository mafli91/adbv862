package game.used.levels;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.used.objects.collectable.Collectable;
import game.used.objects.enemy.Enemy;
import game.used.objects.hero.Attacks;
import game.used.objects.collectable.FairyDust;
import game.used.objects.enemy.Dog;
import game.used.objects.enemy.Puppy;
import game.used.objects.other.WalkChecks;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * Level 1, playable
 * @see GameLevels
 */
public class Lvl1 extends GameLevels implements Serializable {

    private Enemy pup;
    private Enemy pup2;
    private Enemy dog;
    private Enemy dog2;
    private Collectable burger1;
    private Collectable burger2;
    private Collectable burger3;
    private Collectable burger4;




    public Lvl1(Game game) {
        super(game);

        //sound
         try {
            gameMusic = new SoundClip("data/sound/something.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }


    Shape groundShape = new BoxShape(40, 0.3f);
    StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -25f));
    StaticBody leftWall = new StaticBody(this, groundShape);
        leftWall.setPosition(new Vec2(-40, 0));
        leftWall.setAngleDegrees(90);
    StaticBody rightWall = new StaticBody(this, groundShape);
        rightWall.setPosition(new Vec2(40, 0));
        rightWall.setAngleDegrees(90);

    //add other platforms for dogs and puppies- platforms
    Shape platformShape = new BoxShape(15, 0.3f);
    StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-25, -14f));
    StaticBody platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(20, -5f));
    StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-25, 4f));
    StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(20, 13f));


    //checkers for enemies
    WalkChecks w1 = new WalkChecks(this);
        w1.setPosition(new Vec2(-38, -25));
    WalkChecks w2 = new WalkChecks(this);
        w2.setPosition(new Vec2(38, -25));
    WalkChecks w3 = new WalkChecks(this);
        w3.setPosition(new Vec2(-38, -14));
    WalkChecks w4 = new WalkChecks(this);
        w4.setPosition(new Vec2(-13, -14));
    WalkChecks w5 = new WalkChecks(this);
        w5.setPosition(new Vec2(8, -5));
    WalkChecks w6 = new WalkChecks(this);
        w6.setPosition(new Vec2(36, -5));
    WalkChecks w7 = new WalkChecks(this);
        w7.setPosition(new Vec2(-38, 4));
    WalkChecks w8 = new WalkChecks(this);
        w8.setPosition(new Vec2(-13, 4));
    WalkChecks w9 = new WalkChecks(this);
        w9.setPosition(new Vec2(8, 13));
    WalkChecks w10 = new WalkChecks(this);
        w10.setPosition(new Vec2(36, 13));





}
    public void populate(Game game){
        super.populate(game);

        // other bodies

        //fat lady
        getFatLady().setPosition(new Vec2(7, -12));


        // puppies
        pup = new Puppy(this, game, this);
        pup.setPosition(new Vec2(-14, (float) -10));
        //COLLISIONS ARE IMPLEMENTED DIRECTLY IN THE CLASS
        //NOT IN ENEMY TO EASILY ADD AND REMOVE IF NEEDED
        pup2 = new Puppy(this, game, this);
        pup2.setPosition(new Vec2(-14, (float) 5));


        //dogs
        dog = new Dog(this, game, this);
        dog.setPosition(new Vec2(15, (float) -2));
        dog2 = new Dog(this, game, this);
        dog2.setPosition(new Vec2(15, (float) 15));

        // burgers
        burger1 = new FairyDust(this);
        burger1.setPosition(new Vec2(-27, (float) -4));
        burger2 = new FairyDust(this);
        burger2.setPosition(new Vec2(-27, (float) 13));
        burger3 = new FairyDust(this);
        burger3.setPosition(new Vec2(32, (float) 6));
        burger4 = new FairyDust(this);
        burger4.setPosition(new Vec2(32, (float) 25));
    }


    @Override
    public boolean isComplete() {
        if (getFatLady().getBurgerCount() >= 4)
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
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));
        label.setText("<html>" +
                "<body width='170'><h2>Game Tips:</h2>\n" +
                "<p>\n" +
                "For now you can only use A,S,D,Q,W,E keys and SHIFT to dash.\n" +
                "Collect all fairy dust then press N to move on.\n" +
                "</html>");
        return label;
    }

    @Override
    public String getLevelName() {
        return "L1";
    }


}
