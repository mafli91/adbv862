package game.used.levels;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.eventListeners.otherLevels.*;
import game.used.objects.collectable.FairyDust;
import game.used.objects.collectable.Collectable;
import game.used.objects.collectable.Lolly;
import game.used.objects.enemy.Bat;
import game.used.objects.enemy.Dog;
import game.used.objects.enemy.Enemy;
import game.used.objects.other.*;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * Level 4, playable
 * @see GameLevels
 */
public class Lvl4 extends GameLevels implements Serializable {

    private Enemy dog;
    private Enemy dog2;
    private Enemy dog3;
    private Enemy dog4;
    private Enemy dog5;
    private Enemy dog6;
    private Enemy dog7;
    private Enemy pup;
    private Enemy pup2;
    private Enemy pup3;
    private Enemy pup4;
    private Enemy bat;
    private Enemy bat2;
    private Enemy bat3;
    private Enemy bat4;
    private Enemy bat5;
    private Enemy bat6;
    private Enemy bat7;
    private Enemy bat8;
    private Enemy bat9;
    private Enemy bat10;
    private Enemy bat11;
    private Enemy bat12;
    private Enemy bat13;
    private Enemy bat14;
    private Enemy bat15;
    private Enemy bat16;
    private Enemy bat17;
    private Enemy bat18;
    private Enemy bat19;
    private Enemy bat20;
    private Enemy bat21;
    private Enemy bat22;
    private Enemy bat23;
    private Enemy bat24;
    private Enemy bat25;
    private Enemy bat26;
    private Enemy bat27;
    private Enemy bat28;
    private Enemy bat29;
    private Enemy bat30;
    private Enemy bat31;
    private Enemy bat32;
    private Enemy bat33;
    private Enemy bat34;
    private Enemy bat35;
    private Enemy bat36;
    private Collectable burger1;
    private Collectable burger2;
    private Collectable burger3;
    private Collectable burger4;
    private Collectable burger5;
    private Collectable burger6;
    private Collectable burger7;
    private Collectable lolly;


    public Lvl4(Game game) {
        super(game);

        //sound
        try {
            gameMusic = new SoundClip("data/sound/game1.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }


        //container
        Shape x1 = new BoxShape(104, 0.3f);
        StaticBody w1 = new StaticBody(this, x1);
        w1.setPosition(new Vec2(-117, 0f));
        w1.rotateDegrees(90);
        Shape x2 = new BoxShape(104, 0.3f);
        StaticBody w2 = new StaticBody(this, x2);
        w2.setPosition(new Vec2(104, 0f));
        w2.rotateDegrees(90);
        Shape x3 = new BoxShape(110.5f, 0.3f);
        StaticBody w3 = new StaticBody(this, x3);
        w3.setPosition(new Vec2(-6.5f, 104));
        Shape x4 = new BoxShape(110.5f, 0.3f);
        StaticBody w4 = new StaticBody(this, x4);
        w4.setPosition(new Vec2(-6.5f, -104));


        //platforms

        Shape a1 = new BoxShape(9, 0.3f);
        StaticBody d1 = new StaticBody(this, a1);
        d1.setPosition(new Vec2(-107, 91));

        Shape a2 = new BoxShape(16F, 0.3f);
        StaticBody d2 = new StaticBody(this, a2);
        d2.setPosition(new Vec2(-67, 91f));

        Shape a3 = new BoxShape(6F, 0.3f);
        StaticBody d3 = new StaticBody(this, a3);
        d3.setPosition(new Vec2(-52, 97));
        d3.setAngleDegrees(90);

        Shape a4 = new BoxShape(19.5F, 0.3f);
        StaticBody d4 = new StaticBody(this, a4);
        d4.setPosition(new Vec2(-32, 91f));

        Shape a5 = new BoxShape(22, 0.3f);
        StaticBody d5 = new StaticBody(this, a5);
        d5.setPosition(new Vec2(22, 91));

        Shape a6 = new BoxShape(6, 0.3f);
        StaticBody d6 = new StaticBody(this, a6);
        d6.setPosition(new Vec2(45, 97));
        d6.setAngleDegrees(90);

        Shape a7 = new BoxShape(9.1f, 0.3f);
        StaticBody d7 = new StaticBody(this, a7);
        d7.setPosition(new Vec2(54.5f, 91));

        Shape a8 = new BoxShape(13, 0.3f);
        StaticBody d8 = new StaticBody(this, a8);
        d8.setPosition(new Vec2(91, 91));

        Shape a9 = new BoxShape(13, 0.3f);
        StaticBody d9 = new StaticBody(this, a9);
        d9.setPosition(new Vec2(-20, 78));

        Shape a10 = new BoxShape(7, 0.3f);
        StaticBody d10 = new StaticBody(this, a10);
        d10.setPosition(new Vec2(59, 78));

        Shape a11 = new BoxShape(7, 0.3f);
        StaticBody d11 = new StaticBody(this, a11);
        d11.setPosition(new Vec2(13, 71));

        Shape a12 = new BoxShape(9.1f, 0.3f);
        StaticBody d12 = new StaticBody(this, a12);
        d12.setPosition(new Vec2(-99, 54.5f));
        d12.setAngleDegrees(90);

        Shape a13 = new BoxShape(22, 0.3f);
        StaticBody d13 = new StaticBody(this, a13);
        d13.setPosition(new Vec2(-84, 41.5f));
        d13.setAngleDegrees(90);

        Shape a14 = new BoxShape(6, 0.3f);
        StaticBody d14 = new StaticBody(this, a14);
        d14.setPosition(new Vec2(-80F, 67f));
        d14.setAngleDegrees(45);

        Shape a15 = new BoxShape(13, 0.3f);
        StaticBody d15 = new StaticBody(this, a15);
        d15.setPosition(new Vec2(-20, 58));

        Shape a16 = new BoxShape(7, 0.3f);
        StaticBody d16 = new StaticBody(this, a16);
        d16.setPosition(new Vec2(72, 65f));

        Shape a17 = new BoxShape(65, 0.3f);
        StaticBody d17 = new StaticBody(this, a17);
        d17.setPosition(new Vec2(0, 39));

        Shape a18 = new BoxShape(3, 0.3f);
        StaticBody d18 = new StaticBody(this, a18);
        d18.setPosition(new Vec2(-101, 32));

        Shape a19 = new BoxShape(6.5F, 0.3f);
        StaticBody d19 = new StaticBody(this, a19);
        d19.setPosition(new Vec2(-98, 26f));
        d19.setAngleDegrees(90);

        Shape a20 = new BoxShape(22, 0.3f);
        StaticBody d20 = new StaticBody(this, a20);
        d20.setPosition(new Vec2(-75, 19));

        Shape a21 = new BoxShape(28, 0.3f);
        StaticBody d21 = new StaticBody(this, a21);
        d21.setPosition(new Vec2(-6, 19));

        Shape a22 = new BoxShape(13, 0.3f);
        StaticBody d22 = new StaticBody(this, a22);
        d22.setPosition(new Vec2(91, 13));

        Shape a23 = new BoxShape(6.5f, 0.3f);
        StaticBody d23 = new StaticBody(this, a23);
        d23.setPosition(new Vec2(-52, 13));
        d23.setAngleDegrees(90);

        Shape a24 = new BoxShape(3, 0.3f);
        StaticBody d24 = new StaticBody(this, a24);
        d24.setPosition(new Vec2(-94, -5.5f));

        Shape a25 = new BoxShape(6.5f, 0.3f);
        StaticBody d25 = new StaticBody(this, a25);
        d25.setPosition(new Vec2(97.5f, 39));

        Shape a26 = new BoxShape(7, 0.3f);
        StaticBody d26 = new StaticBody(this, a26);
        d26.setPosition(new Vec2(59, -13f));

        Shape a27 = new BoxShape(7, 0.3f);
        StaticBody d27 = new StaticBody(this, a27);
        d27.setPosition(new Vec2(-72, -26f));

        Shape a28 = new BoxShape(13, 0.3f);
        StaticBody d28 = new StaticBody(this, a28);
        d28.setPosition(new Vec2(13, -26f));

        Shape a29 = new BoxShape(35.7f, 0.3f);
        StaticBody d29 = new StaticBody(this, a29);
        d29.setPosition(new Vec2(-97, -41f));
        d29.setAngleDegrees(90);

        Shape a30 = new BoxShape(20, 0.3f);
        StaticBody d30 = new StaticBody(this, a30);
        d30.setPosition(new Vec2(-19, -52f));

        Shape a31 = new BoxShape(26, 0.3f);
        StaticBody d31 = new StaticBody(this, a31);
        d31.setPosition(new Vec2(26, -52f));
        d31.setAngleDegrees(90);

        Shape a32 = new BoxShape(32.5F, 0.3f);
        StaticBody d32 = new StaticBody(this, a32);
        d32.setPosition(new Vec2(-84, -78f));

        Shape a33 = new BoxShape(32.5f, 0.3f);
        StaticBody d33 = new StaticBody(this, a33);
        d33.setPosition(new Vec2(20, -78f));

        Shape a34 = new BoxShape(13, 0.3f);
        StaticBody d34 = new StaticBody(this, a34);
        d34.setPosition(new Vec2(-26F, -91f));

        Shape a35 = new BoxShape(6, 0.3f);
        StaticBody d35 = new StaticBody(this, a35);
        d35.setPosition(new Vec2(-13f, -84f));
        d35.setAngleDegrees(90);

        Shape a36 = new BoxShape(19, 0.3f);
        StaticBody d36 = new StaticBody(this, a36);
        d36.setPosition(new Vec2(86, -91f));


        //red tiles
        for(int i = 0; i < 53; i++) {
            LavaTiles b1 = new LavaTiles(this, game, this);
            b1.setPosition(new Vec2((float) (-65 + i * 0.5), -26f));
        }

        // Walk check tiles

        WalkChecks q1 = new WalkChecks(this);
        q1.setPosition(new Vec2( (float)67.95371  , (float) -91 ));
        WalkChecks q2 = new WalkChecks(this);
        q2.setPosition(new Vec2( (float)101.15372  , (float) -91 ));
        WalkChecks q3 = new WalkChecks(this);
        q3.setPosition(new Vec2( (float)-8.646287  , (float) -104 ));
        WalkChecks q4 = new WalkChecks(this);
        q4.setPosition(new Vec2( (float)98.753716  , (float) -104 ));
        WalkChecks q5 = new WalkChecks(this);
        q5.setPosition(new Vec2( (float)-33.00921  , (float) -104 ));
        WalkChecks q6 = new WalkChecks(this);
        q6.setPosition(new Vec2( (float)-75.29705  , (float) -104 ));
        WalkChecks q7 = new WalkChecks(this);
        q7.setPosition(new Vec2( (float)-113.89705  , (float) -104 ));
        WalkChecks q8 = new WalkChecks(this);
        q8.setPosition(new Vec2( (float)-94.68685  , (float) -78 ));
        WalkChecks q9 = new WalkChecks(this);
        q9.setPosition(new Vec2( (float)-54.08685  , (float) -78 ));
        WalkChecks q10 = new WalkChecks(this);
        q10.setPosition(new Vec2( (float)-99.55168  , (float) 91 ));
        WalkChecks q11 = new WalkChecks(this);
        q11.setPosition(new Vec2( (float)-115.351685  , (float) 91 ));
        WalkChecks q12 = new WalkChecks(this);
        q12.setPosition(new Vec2( (float)-81.95168  , (float) 91 ));
        WalkChecks q13 = new WalkChecks(this);
        q13.setPosition(new Vec2( (float)-54.151684  , (float) 91 ));
        WalkChecks q14 = new WalkChecks(this);
        q14.setPosition(new Vec2( (float)-48.951683  , (float) 91 ));
        WalkChecks q15 = new WalkChecks(this);
        q15.setPosition(new Vec2( (float)-14.151682  , (float) 91 ));
        WalkChecks q16 = new WalkChecks(this);
        q16.setPosition(new Vec2( (float)-15.224318  , (float) 91 ));
        WalkChecks q17 = new WalkChecks(this);
        q17.setPosition(new Vec2( (float)1.7756826  , (float) 91 ));
        WalkChecks q18 = new WalkChecks(this);
        q18.setPosition(new Vec2( (float)42.175682  , (float) 91 ));
        WalkChecks q19 = new WalkChecks(this);
        q19.setPosition(new Vec2( (float)-62.894157  , (float) 39 ));
        WalkChecks q20 = new WalkChecks(this);
        q20.setPosition(new Vec2( (float)61.485218  , (float) 39 ));

        //vertical moving platforms

        MovPlat xm2 = new MovPlat(this);
        xm2.setPosition(new Vec2(-90, 39));
        getFatLady().addCollisionListener(new IsOnPlatform(getFatLady()));
        xm2.addCollisionListener(new MovingPUp(game, this, xm2));
        MovPlatSup xmu2 = new MovPlatSup(this);//add collision
        xmu2.setPosition(new Vec2(-94,65f));
        MovPlatSup xmt2 = new MovPlatSup(this);//add collision
        xmt2.setPosition(new Vec2(-94,22f));
        xmu2.addCollisionListener(new MovingPDown(game, getFatLady(), xm2));

        MovPlat xm3 = new MovPlat(this);
        xm3.setPosition(new Vec2(-111, -52f));
        getFatLady().addCollisionListener(new IsOnPlatform(getFatLady()));
        xm3.addCollisionListener(new MovingPUp(game, this, xm3));
        MovPlatSup xmu3 = new MovPlatSup(this);//add collision
        xmu3.setPosition(new Vec2(-108,-6f));
        MovPlatSup xmt3 = new MovPlatSup(this);//add collision
        xmt3.setPosition(new Vec2(-108,-67f));
        xmu3.addCollisionListener(new MovingPDown(game, getFatLady(), xm3));

        // sideways
        MovPlat xm = new MovPlat(this);
        xm.setPosition(new Vec2(-30, -13f));
        xm.setGravityScale(1);
        xm.moveSides();
        xm.correction();
        for (int i =0; i<6; i++){
            MovPlatSup xms = new MovPlatSup(this);
            xms.setPosition(new Vec2 ((float) (-49 + 12*i), -13f)); }
        MovPlatSup xml1 = new MovPlatSup(this);//add collision
        xml1.setPosition(new Vec2(-53,-12f));
        xml1.addCollisionListener(new MovingPHor(game, this, xm));
        MovPlatSup xmr1 = new MovPlatSup(this);//add collision
        xmr1.setPosition(new Vec2(13,-12f));
        xmr1.addCollisionListener(new MovingPHor(game, this, xm));

        // Crunchy walls
        Shape c11 = new BoxShape(6, 0.4f);
        StaticBody c1 = new StaticBody(this, c11);
        c1.setPosition(new Vec2(-91, 91));
        c1.addCollisionListener(new WallCrunch(game, this));
        c1.setFillColor(Color.lightGray);
        c1.setLineColor(Color.lightGray);

        Shape c22 = new BoxShape(6F, 0.4f);
        StaticBody c2 = new StaticBody(this, c22);
        c2.setPosition(new Vec2(-3, 91f));
        c2.addCollisionListener(new WallCrunch(game, this));
        c2.setFillColor(Color.lightGray);
        c2.setLineColor(Color.lightGray);

        Shape c33 = new BoxShape(6F, 0.4f);
        StaticBody c3 = new StaticBody(this, c33);
        c3.setPosition(new Vec2(71, 91));
        c3.addCollisionListener(new WallCrunch(game, this));
        c3.setFillColor(Color.lightGray);
        c3.setLineColor(Color.lightGray);

        Shape c44 = new BoxShape(8F, 0.4f);
        StaticBody c4 = new StaticBody(this, c44);
        c4.setPosition(new Vec2(-107, 19));
        c4.addCollisionListener(new WallCrunch(game, this));
        c4.setFillColor(Color.lightGray);
        c4.setLineColor(Color.lightGray);

        Shape c55 = new BoxShape(13, 0.4f);
        StaticBody c5 = new StaticBody(this, c55);
        c5.setPosition(new Vec2(-71, -91));
        c5.rotateDegrees(90);
        c5.addCollisionListener(new WallCrunch(game, this));
        c5.setFillColor(Color.lightGray);
        c5.setLineColor(Color.lightGray);

        Shape c66 = new BoxShape(6, 0.4f);
        StaticBody c6 = new StaticBody(this, c66);
        c6.setPosition(new Vec2(-19, -98));
        c6.setAngleDegrees(90);
        c6.addCollisionListener(new WallCrunch(game, this));
        c6.setFillColor(Color.lightGray);
        c6.setLineColor(Color.lightGray);



    }
    public void populate(Game game){
        super.populate(game);


        // Hero methods
        getFatLady().setPosition(new Vec2(39, -65));
        // Enemies

        // Bats

        bat = new Bat(this, game, this);
        bat.setPosition(new Vec2( (float)13.164287  , (float) 36.447987));
        bat2 = new Bat(this, game, this);
        bat2.setPosition(new Vec2( (float)12.964287  , (float) 34.04799));
        bat3 = new Bat(this, game, this);
        bat3.setPosition(new Vec2( (float)12.964287  , (float) 30.447987));
        bat4 = new Bat(this, game, this);
        bat4.setPosition(new Vec2( (float)12.964287  , (float) 28.047987));
        bat5 = new Bat(this, game, this);
        bat5.setPosition(new Vec2( (float)12.964287  , (float) 24.647987));
        bat6 = new Bat(this, game, this);
        bat6.setPosition(new Vec2( (float)12.964287  , (float) 21.647987));
        bat7 = new Bat(this, game, this);
        bat7.setPosition(new Vec2( (float)-42.940006  , (float) 62.644993));
        bat8 = new Bat(this, game, this);
        bat8.setPosition(new Vec2( (float)11.659995  , (float) 61.444992));
        bat9 = new Bat(this, game, this);
        bat9.setPosition(new Vec2( (float)40.659996  , (float) 68.645));
        bat10 = new Bat(this, game, this);
        bat10 .setPosition(new Vec2( (float)4.2599955  , (float) 76.44499));
        bat11 = new Bat(this, game, this);
        bat11 .setPosition(new Vec2( (float)-25.740005  , (float) 84.244995));
        bat12 = new Bat(this, game, this);
        bat12 .setPosition(new Vec2( (float)-40.540005  , (float) 101.04499));
        bat13 = new Bat(this, game, this);
        bat13 .setPosition(new Vec2( (float)-40.740005  , (float) 97.645));
        bat14 = new Bat(this, game, this);
        bat14 .setPosition(new Vec2( (float)1.4599953  , (float) 98.44499));
        bat15 = new Bat(this, game, this);
        bat15.setPosition(new Vec2( (float)2.6599953  , (float) 94.04499));
        bat16 = new Bat(this, game, this);
        bat16.setPosition(new Vec2( (float)49.459995  , (float) 101.244995));
        bat17 = new Bat(this, game, this);
        bat17 .setPosition(new Vec2( (float)54.059998  , (float) 98.44499));
        bat18 = new Bat(this, game, this);
        bat18 .setPosition(new Vec2( (float)62.459995  , (float) 93.244995));
        bat19 = new Bat(this, game, this);
        bat19 .setPosition(new Vec2( (float)-81.14001  , (float) 89.44499));
        bat20 = new Bat(this, game, this);
        bat20 .setPosition(new Vec2( (float)-112.002205  , (float) 16.844992));
        bat21 = new Bat(this, game, this);
        bat21 .setPosition(new Vec2( (float)-103.80221  , (float) 16.844992));
        bat22 = new Bat(this, game, this);
        bat22 .setPosition(new Vec2( (float)-95.80221  , (float) 15.644993));
        bat23 = new Bat(this, game, this);
        bat23 .setPosition(new Vec2( (float)-85.2022  , (float) 15.444992));
        bat24 = new Bat(this, game, this);
        bat24 .setPosition(new Vec2( (float)-79.40221  , (float) 13.044992));
        bat25 = new Bat(this, game, this);
        bat25.setPosition(new Vec2( (float)-74.6022  , (float) 9.444992));
        bat26 = new Bat(this, game, this);
        bat26.setPosition(new Vec2( (float)-83.6022  , (float) 7.2449923));
        bat27 = new Bat(this, game, this);
        bat27 .setPosition(new Vec2( (float)-85.80221  , (float) 4.6449924));
        bat28 = new Bat(this, game, this);
        bat28 .setPosition(new Vec2( (float)-88.2022  , (float) -0.15500781));
        bat29 = new Bat(this, game, this);
        bat29 .setPosition(new Vec2( (float)-90.6022  , (float) -4.3550076));
        bat30 = new Bat(this, game, this);
        bat30 .setPosition(new Vec2( (float)-66.6022  , (float) -1.1550078));
        bat31 = new Bat(this, game, this);
        bat31 .setPosition(new Vec2( (float)-63.602203  , (float) 4.844992));
        bat32 = new Bat(this, game, this);
        bat32.setPosition(new Vec2( (float)-50.202206  , (float) 3.8449922));
        bat33 = new Bat(this, game, this);
        bat33 .setPosition(new Vec2( (float)-45.802204  , (float) -0.15500781));
        bat34 = new Bat(this, game, this);
        bat34  .setPosition(new Vec2( (float)-60.10937  , (float) -57.555008));
        bat35 = new Bat(this, game, this);
        bat35 .setPosition(new Vec2( (float)-59.909374  , (float) -67.55501));
        bat36 = new Bat(this, game, this);
        bat36.setPosition(new Vec2( (float)-60.909374  , (float) -76.15501));

        // Dogs

        dog = new Dog(this, game, this);
        dog.setPosition(new Vec2( (float)-26.695005  , (float) -103.29945));
        dog2 = new Dog(this, game, this);
        dog2.setPosition(new Vec2( (float)-110.69705  , (float) -99.15378));
        dog3 = new Dog(this, game, this);
        dog3.setPosition(new Vec2( (float)-28.312857  , (float) 41.444992));
        dog4 = new Dog(this, game, this);
        dog4.setPosition(new Vec2( (float)-20.312855  , (float) 41.24499));
        dog5 = new Dog(this, game, this);
        dog5.setPosition(new Vec2( (float)-108.723724  , (float) 93.844986));
        dog6 = new Dog(this, game, this);
        dog6.setPosition(new Vec2( (float)-58.923725  , (float) 94.04499));
        dog7 = new Dog(this, game, this);
        dog7.setPosition(new Vec2( (float)-39.00517  , (float) 93.24499));

        //Puppies

        pup = new Dog(this, game, this);
        pup.setPosition(new Vec2( (float)41.32676  , (float) 41.044994));
        pup2 = new Dog(this, game, this);
        pup2.setPosition(new Vec2( (float)33.32676  , (float) 93.44499));
        pup3 = new Dog(this, game, this);
        pup3.setPosition(new Vec2( (float)-52.699444  , (float) -100.155014));
        pup4 = new Dog(this, game, this);
        pup4.setPosition(new Vec2( (float)85.15372  , (float) -88.155014));

        // COLLECTABLES

        // burgers
        burger1 = new FairyDust(this);
        burger1.setPosition(new Vec2( (float)-112.81502  , (float) -82.354996));
        burger2 = new FairyDust(this);
        burger2.setPosition(new Vec2( (float)98.20267  , (float) -83.75501));
        burger3 = new FairyDust(this);
        burger3.setPosition(new Vec2( (float)58.091633  , (float) 88.844986));
        burger4 = new FairyDust(this);
        burger4.setPosition(new Vec2( (float)-47.90837  , (float) 101.04499));
        burger5 = new FairyDust(this);
        burger5.setPosition(new Vec2( (float)39.49163  , (float) 100.24499));
        burger6 = new FairyDust(this);
        burger6.setPosition(new Vec2( (float)-56.19069  , (float) 101.844986));
        burger7 = new FairyDust(this);
        burger7.setPosition(new Vec2( (float)-101.50462  , (float) 28.244993));

        // Lolly
        lolly = new Lolly(this);
        lolly.setPosition(new Vec2( (float)-101.50462  , (float) 28.244993));
    }



    @Override
    public boolean isComplete() {
        if (getFatLady().getBurgerCount() >6)
            return true;
        else
            return false;
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
        Image background = new ImageIcon("data/lvl4.jpg").getImage();
        return background;
    }
    @Override
    public JLabel playerTips(){
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));

        label.setText("<html>" +
                "<body width='170'><h2>Game Tips:</h2>\n" +
                "<p>\n" +
                "Check out your left click!" +
                "If you collect a lollipop you can use a barrier with spacebar." +
                "Dogs can grow up now.\n" +
                "</html>");
        return label;
    }

    @Override
    public String getLevelName() {
        return "L4";
    }
}
