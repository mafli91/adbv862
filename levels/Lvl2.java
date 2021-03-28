package game.used.levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.eventListeners.otherLevels.IsOnPlatform;
import game.used.eventListeners.otherLevels.MovingPDown;
import game.used.eventListeners.otherLevels.MovingPHor;
import game.used.eventListeners.otherLevels.MovingPUp;
import game.used.objects.collectable.FairyDust;
import game.used.objects.collectable.Collectable;
import game.used.objects.enemy.Dog;
import game.used.objects.enemy.Enemy;
import game.used.objects.enemy.Puppy;
import game.used.objects.other.MovPlat;
import game.used.objects.other.MovPlatSup;
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
 * Level 2, playable
 * @see GameLevels
 */
public class Lvl2 extends GameLevels implements Serializable {
;
    private Enemy dog;
    private Enemy dog2;
    private Enemy dog3;
    private Enemy dog4;
    private Enemy dog5;
    private Enemy dog6;
    private Enemy dog7;
    private Enemy dog8;
    private Enemy dog9;
    private Enemy pup5;
    private Enemy pup;
    private Enemy pup2;
    private Enemy pup3;
    private Enemy pup4;
    private Collectable burger1;
    private Collectable burger2;
    private Collectable burger3;
    private Collectable burger4;
    private Collectable burger5;
    private Collectable burger6;
    private Collectable burger7;
    private Collectable burger8;
    private int seconds = 0;

    public Lvl2(Game game) {
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
        ground.setPosition(new Vec2(0, -25f));


        //container
        Shape x1 = new BoxShape(117, 0.3f);
        StaticBody w1 = new StaticBody(this, x1);
        w1.setPosition(new Vec2(-104, 0f));
        w1.rotateDegrees(90);
        Shape x2 = new BoxShape(117, 0.3f);
        StaticBody w2 = new StaticBody(this, x2);
        w2.setPosition(new Vec2(104, 0f));
        w2.rotateDegrees(90);
        Shape x3 = new BoxShape(104, 0.3f);
        StaticBody w3 = new StaticBody(this, x3);
        w3.setPosition(new Vec2(0, -117f));
        Shape x4 = new BoxShape(104, 0.3f);
        StaticBody w4 = new StaticBody(this, x4);
        w4.setPosition(new Vec2(0, 130f));
        Shape x5 = new BoxShape(104, 0.3f);
        StaticBody w5 = new StaticBody(this, x5);
        w5.setPosition(new Vec2(0, -117f));

        //platforms in top to bottom order

        MovPlat xm = new MovPlat(this);
        xm.setPosition(new Vec2(-63, 91f));
        xm.setGravityScale(1);
        xm.moveSides();
        xm.correction();
        //xm.addCollisionListener(new OnMovingP(game, this, getFatLady()));
        for (int i =0; i<4; i++){
            MovPlatSup xms = new MovPlatSup(this);
            xms.setPosition(new Vec2 ((float) (-75 + 12*i), 90f)); }
        MovPlatSup xmr1 = new MovPlatSup(this);//add collision
        xmr1.setPosition(new Vec2(-33,91f));
        xmr1.addCollisionListener(new MovingPHor(game, this, xm));
        MovPlatSup xml1 = new MovPlatSup(this);//add collision
        xml1.setPosition(new Vec2(-77,91f));
        xml1.addCollisionListener(new MovingPHor(game, this, xm));



        Shape x7 = new BoxShape(39, 0.3f);
        StaticBody w7 = new StaticBody(this, x7);
        w7.setPosition(new Vec2(13, 104f));

        MovPlat xm2 = new MovPlat(this);
        xm2.setPosition(new Vec2(-91, 60f));
        getFatLady().addCollisionListener(new IsOnPlatform(getFatLady()));
        xm2.addCollisionListener(new MovingPUp(game, this, xm2));
        MovPlatSup xmu1 = new MovPlatSup(this);//add collision
        xmu1.setPosition(new Vec2(-94,79f));
        MovPlatSup xmt1 = new MovPlatSup(this);//add collision
        xmt1.setPosition(new Vec2(-92,-69f));
        xmu1.addCollisionListener(new MovingPDown(game, getFatLady(), xm2));
        Shape tunnel = new BoxShape(66, 0.3f);
        StaticBody tunnelTile = new StaticBody(this, tunnel);
        tunnelTile.setPosition(new Vec2(-82, 14f));
        tunnelTile.setAngleDegrees(90);


        Shape x9 = new BoxShape(39, 0.3f);
        StaticBody w9 = new StaticBody(this, x9);
        w9.setPosition(new Vec2(-13, 52f));


        MovPlat xm3 = new MovPlat(this);
         xm3.setPosition(new Vec2(70, 13f));
         xm3.setGravityScale(1);
         xm3.moveSides();
         xm3.correction();
         for (int i =0; i<14; i++){
         MovPlatSup xms = new MovPlatSup(this);
         xms.setPosition(new Vec2 ((float) (-76 + 12*i), 12f)); }
         MovPlatSup xmr2 = new MovPlatSup(this);//add collision
         xmr2.setPosition(new Vec2(-75,13f));
         xmr2.addCollisionListener(new MovingPHor(game, this, xm3));
         MovPlatSup xml2 = new MovPlatSup(this);//add collision
         xml2.setPosition(new Vec2(78,13f));
         xml2.addCollisionListener(new MovingPHor(game, this, xm3));

        Shape x11 = new BoxShape(26, 0.3f);
        StaticBody w11 = new StaticBody(this, x11);
        w11.setPosition(new Vec2(65, 0f));
        Shape x12 = new BoxShape(18, 0.3f);
        StaticBody w12 = new StaticBody(this, x12);
        w12.setPosition(new Vec2(-65, -78f));
        Shape x13 = new BoxShape(9, 0.3f);
        StaticBody w13 = new StaticBody(this, x13);
        w13.setPosition(new Vec2(-28, -91f));
        Shape x14 = new BoxShape(20, 0.3f);
        StaticBody w14 = new StaticBody(this, x14);
        w14.setPosition(new Vec2(7, -104f));

        //checkers for enemies
        WalkChecks q1 = new WalkChecks(this);
        q1.setPosition(new Vec2(41, 0));
        WalkChecks q2 = new WalkChecks(this);
        q2.setPosition(new Vec2(87, 0));
        WalkChecks q3 = new WalkChecks(this);
        q3.setPosition(new Vec2(36, -25));
        WalkChecks q4 = new WalkChecks(this);
        q4.setPosition(new Vec2(1, -25));
        WalkChecks q5 = new WalkChecks(this);
        q5.setPosition(new Vec2(-37, -25));
        WalkChecks q6 = new WalkChecks(this);
        q6.setPosition(new Vec2(-49, -78));
        WalkChecks q7 = new WalkChecks(this);
        q7.setPosition(new Vec2(-80, -78));
        WalkChecks q8 = new WalkChecks(this);
        q8.setPosition(new Vec2(-30, -117));
        WalkChecks q9 = new WalkChecks(this);
        q9.setPosition(new Vec2(-10, -104));
        WalkChecks q10 = new WalkChecks(this);
        q10.setPosition(new Vec2(24, -104));
        WalkChecks q11 = new WalkChecks(this);
        q11.setPosition(new Vec2(-100, -117));
        WalkChecks q12 = new WalkChecks(this);
        q12.setPosition(new Vec2(25, -117));
        WalkChecks q13 = new WalkChecks(this);
        q13.setPosition(new Vec2(78, -117));
        WalkChecks q14 = new WalkChecks(this);
        q14.setPosition(new Vec2(101, -117));
        WalkChecks q15 = new WalkChecks(this);
        q15.setPosition(new Vec2(22, 52));
        WalkChecks q16 = new WalkChecks(this);
        q16.setPosition(new Vec2(-48, 52));
        WalkChecks q17 = new WalkChecks(this);
        q17.setPosition(new Vec2(-24, 104));
        WalkChecks q18 = new WalkChecks(this);
        q18.setPosition(new Vec2(5, 104));
        WalkChecks q19 = new WalkChecks(this);
        q19.setPosition(new Vec2(49, 104));






    }

    public void populate(Game game){
        super.populate(game);

        // OTHER BODIES

        getFatLady().setPosition(new Vec2(7, -12));

        // ENEMIES

        //DOGS

        dog = new Dog(this, game, this);
        dog.setPosition(new Vec2(-16, (float) 107));
        dog2 = new Dog(this, game, this);
        dog2.setPosition(new Vec2(38, (float) 107));
        dog3 = new Dog(this, game, this);
        dog3.setPosition(new Vec2(-7, (float) 56));
        dog4 = new Dog(this, game, this);
        dog4.setPosition(new Vec2(-25, (float) -20));
        dog5 = new Dog(this, game, this);
        dog5.setPosition(new Vec2(26, (float) -21));
        dog6 = new Dog(this, game, this);
        dog6.setPosition(new Vec2(-62, (float) -72));
        dog7 = new Dog(this, game, this);
        dog7.setPosition(new Vec2(-82, (float) -112));

        //PUPPIES
        pup2 = new Puppy(this, game, this);
        pup2.setPosition(new Vec2(-20, (float) -112));
        pup3 = new Puppy(this, game, this);
        pup3.setPosition(new Vec2(37, (float) -112));
        pup4 = new Puppy(this, game, this);
        pup4.setPosition(new Vec2(93, (float) -111));
        pup5 = new Puppy(this, game, this);
        pup5.setPosition(new Vec2(9, (float) -99));
        pup = new Puppy(this, game, this);
        pup.setPosition(new Vec2(64, (float) 5));

        // collectables
        burger1 = new FairyDust(this);
        burger1.setPosition(new Vec2(-27, (float) -4));
        burger2 = new FairyDust(this);
        burger2.setPosition(new Vec2(-27, (float) 13));
        burger3 = new FairyDust(this);
        burger3.setPosition(new Vec2(32, (float) 6));
        burger4 = new FairyDust(this);
        burger4.setPosition(new Vec2(32, (float) 25));
        burger5 = new FairyDust(this);
        burger5.setPosition(new Vec2(-27, (float) -4));
        burger6 = new FairyDust(this);
        burger6.setPosition(new Vec2(-27, (float) 13));
        burger7 = new FairyDust(this);
        burger7.setPosition(new Vec2(32, (float) 6));
        burger8 = new FairyDust(this);
        burger8.setPosition(new Vec2(32, (float) 25));
    }


    @Override
    public boolean isComplete() {
        if (getFatLady().getBurgerCount() > 6)
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
        Image background = new ImageIcon("data/lvl2.jpg").getImage();
        return background;
    }
    @Override
    public JLabel playerTips(){
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));

        label.setText("<html>" +
                "<body width='170'><h2>Game Tips:</h2>\n" +
                "<p>\n" +
                "Check out your right click. Puppies can grow up now." +
                "You need 7 packs of fairy powder." +
                "Some platforms move to make certain areas accessible.\n" +
                "</html>");
        return label;
    }

    @Override
    public String getLevelName() {
        return "L2";
    }

    @Override
    public boolean onPlatform() {
        return true;
    }
}
