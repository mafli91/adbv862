package game.used.levels;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.eventListeners.lvl567.ButtonListener;
import game.used.eventListeners.lvl567.DoorListener;
import game.used.eventListeners.lvl567.DoorNextLevel;
import game.used.eventListeners.otherLevels.MovingPHor;
import game.used.eventListeners.otherLevels.WallCrunch;
import game.used.objects.collectable.FairyDust;
import game.used.objects.collectable.Collectable;
import game.used.objects.collectable.Lolly;
import game.used.objects.enemy.Bat;
import game.used.objects.enemy.Dog;
import game.used.objects.enemy.Enemy;
import game.used.objects.enemy.Wolf;
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
 * Level 5, playable
 * Due to custom creation of Buttons and StaticBodies being portals to next level
 * doesn't support being saved to a file without Serializable
 * @see GameLevels
 */
public class Lvl5 extends GameLevels implements Serializable {

    private Enemy bat;
    private Enemy bat1;
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
    private Enemy dog;
    private Enemy dog2;
    private Enemy dog3;
    private Enemy wolf;
    private Enemy wolf2;
    private Enemy wolf3;
    private Enemy wolf4;
    private Enemy wolf5;
    private Collectable burger1;
    private Collectable burger2;
    private Collectable burger3;
    private Collectable burger4;
    private Collectable burger5;
    private Collectable burger6;
    private Collectable burger7;
    private Collectable lolly;
    private Collectable lolly2;
    private Collectable lolly3;
    private Collectable lolly4;

    public Lvl5(Game game) {
        super(game);

        //sound
        try {
            gameMusic = new SoundClip("data/sound/i-will.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }

        //container
        Shape x1 = new BoxShape(136.5f, 0.3f);
        StaticBody w1 = new StaticBody(this, x1);
        w1.setPosition(new Vec2(-117, 32.5f));
        w1.rotateDegrees(90);
        Shape x2 = new BoxShape(136.5f, 0.3f);
        StaticBody w2 = new StaticBody(this, x2);
        w2.setPosition(new Vec2(104, 32.5f));
        w2.rotateDegrees(90);
        Shape x3 = new BoxShape(110.5f, 0.3f);
        StaticBody w3 = new StaticBody(this, x3);
        w3.setPosition(new Vec2(-6, 169));
        Shape x4 = new BoxShape(110.5f, 0.3f);
        StaticBody w4 = new StaticBody(this, x4);
        w4.setPosition(new Vec2(-6, -104f));


        //platforms

        Shape a1 = new BoxShape(26, 0.3f);
        StaticBody d1 = new StaticBody(this, a1);
        d1.setPosition(new Vec2(-91, 117));

        Shape a2 = new BoxShape(78, 0.3f);
        StaticBody d2 = new StaticBody(this, a2);
        d2.setPosition(new Vec2(26, 117));

        Shape a3 = new BoxShape(13, 0.3f);
        StaticBody d3 = new StaticBody(this, a3);
        d3.setPosition(new Vec2(-104, 104));

        Shape a4 = new BoxShape(91, 0.3f);
        StaticBody d4 = new StaticBody(this, a4);
        d4.setPosition(new Vec2(13, 104));

        Shape a5 = new BoxShape(52, 0.3f);
        StaticBody d5 = new StaticBody(this, a5);
        d5.setPosition(new Vec2(-65, 91));

        Shape a6 = new BoxShape(52, 0.3f);
        StaticBody d6 = new StaticBody(this, a6);
        d6.setPosition(new Vec2(-39, 78));

        Shape a7 = new BoxShape(19.5f, 0.3f);
        StaticBody d7 = new StaticBody(this, a7);
        d7.setPosition(new Vec2(85, 91));

        Shape a8 = new BoxShape(6, 0.3f);
        StaticBody d8 = new StaticBody(this, a8);
        d8.setPosition(new Vec2(85, 78));

        Shape a9 = new BoxShape(6, 0.3f);
        StaticBody d9 = new StaticBody(this, a9);
        d9.setPosition(new Vec2(99, 65));

        Shape a10 = new BoxShape(78, 0.3f);
        StaticBody d10 = new StaticBody(this, a10);
        d10.setPosition(new Vec2(-39, 65));

        Shape a11 = new BoxShape(6, 0.3f);
        StaticBody d11 = new StaticBody(this, a11);
        d11.setPosition(new Vec2(85, 52));

        Shape a12 = new BoxShape(19.5f, 0.3f);
        StaticBody d12 = new StaticBody(this, a12);
        d12.setPosition(new Vec2(58.5f, 39));

        Shape a13 = new BoxShape(6, 0.3f);
        StaticBody d13 = new StaticBody(this, a13);
        d13.setPosition(new Vec2(99, 39));

        Shape a14 = new BoxShape(13, 0.3f);
        StaticBody d14 = new StaticBody(this, a14);
        d14.setPosition(new Vec2(65, 26));

        Shape a15 = new BoxShape(26, 0.3f);
        StaticBody d15 = new StaticBody(this, a15);
        d15.setPosition(new Vec2(-13, 20));

        Shape a16 = new BoxShape(9.7f, 0.3f);
        StaticBody d16 = new StaticBody(this, a16);
        d16.setPosition(new Vec2(-94, -6));

        Shape a17 = new BoxShape(9.7F, 0.3f);
        StaticBody d17 = new StaticBody(this, a17);
        d17.setPosition(new Vec2(-49, -6));

        Shape a18 = new BoxShape(26, 0.3f);
        StaticBody d18 = new StaticBody(this, a18);
        d18.setPosition(new Vec2(13, 10));

        Shape a19 = new BoxShape(26, 0.3f);
        StaticBody d19 = new StaticBody(this, a19);
        d19.setPosition(new Vec2(0, 0));

        Shape a20 = new BoxShape(13, 0.3f);
        StaticBody d20 = new StaticBody(this, a20);
        d20.setPosition(new Vec2(26, -13));

        Shape a21 = new BoxShape(9.1f, 0.3f);
        StaticBody d21 = new StaticBody(this, a21);
        d21.setPosition(new Vec2(-16, -26));

        Shape a22 = new BoxShape(6, 0.3f);
        StaticBody d22 = new StaticBody(this, a22);
        d22.setPosition(new Vec2(-32, -29));

        Shape a23 = new BoxShape(3, 0.3f);
        StaticBody d23 = new StaticBody(this, a23);
        d23.setPosition(new Vec2(49, 13));

        Shape a24 = new BoxShape(3, 0.3f);
        StaticBody d24 = new StaticBody(this, a24);
        d24.setPosition(new Vec2(68, 6));

        Shape a25 = new BoxShape(3, 0.3f);
        StaticBody d25 = new StaticBody(this, a25);
        d25.setPosition(new Vec2(49, -6));

        Shape a26 = new BoxShape(6, 0.3f);
        StaticBody d26 = new StaticBody(this, a26);
        d26.setPosition(new Vec2(84, 13));

        Shape a27 = new BoxShape(6, 0.3f);
        StaticBody d27 = new StaticBody(this, a27);
        d27.setPosition(new Vec2(98, 0));

        Shape a28 = new BoxShape(3, 0.3f);
        StaticBody d28 = new StaticBody(this, a28);
        d28.setPosition(new Vec2(68, -26));

        Shape a29 = new BoxShape(26, 0.3f);
        StaticBody d29 = new StaticBody(this, a29);
        d29.setPosition(new Vec2(-91, -45));

        Shape a30 = new BoxShape(9.1f, 0.3f);
        StaticBody d30 = new StaticBody(this, a30);
        d30.setPosition(new Vec2(-101, -78));

        Shape a31 = new BoxShape(6, 0.3f);
        StaticBody d31 = new StaticBody(this, a31);
        d31.setPosition(new Vec2(-72, -57));

        Shape a32 = new BoxShape(6, 0.3f);
        StaticBody d32 = new StaticBody(this, a32);
        d32.setPosition(new Vec2(-52, -78));

        Shape a33 = new BoxShape(6, 0.3f);
        StaticBody d33 = new StaticBody(this, a33);
        d33.setPosition(new Vec2(-32, -57));

        Shape a34 = new BoxShape(13, 0.3f);
        StaticBody d34 = new StaticBody(this, a34);
        d34.setPosition(new Vec2(91, -52));

        Shape a35 = new BoxShape(6, 0.3f);
        StaticBody d35 = new StaticBody(this, a35);
        d35.setPosition(new Vec2(26, -85));

        Shape a36 = new BoxShape(39, 0.3f);
        StaticBody d36 = new StaticBody(this, a36);
        d36.setPosition(new Vec2(52, -39));

        Shape a37 = new BoxShape(13, 0.3f);
        StaticBody d37 = new StaticBody(this, a37);
        d37.setPosition(new Vec2(13, 91));
        d37.setAngleDegrees(90);

        Shape a38 = new BoxShape(13, 0.3f);
        StaticBody d38 = new StaticBody(this, a38);
        d38.setPosition(new Vec2(-52, 21));
        d38.setAngleDegrees(90);

        Shape a39 = new BoxShape(6, 0.3f);
        StaticBody d39 = new StaticBody(this, a39);
        d39.setPosition(new Vec2(-65, -51));
        d39.setAngleDegrees(90);

        Shape a40 = new BoxShape(58.5f, 0.3f);
        StaticBody d40 = new StaticBody(this, a40);
        d40.setPosition(new Vec2(-26, -25));
        d40.setAngleDegrees(90);

        Shape a41 = new BoxShape(32.5f, 0.3f);
        StaticBody d41 = new StaticBody(this, a41);
        d41.setPosition(new Vec2(39, 6.5f));
        d41.setAngleDegrees(90);

        Shape a42 = new BoxShape(65f, 0.3f);
        StaticBody d42 = new StaticBody(this, a42);
        d42.setPosition(new Vec2(78, 26f));
        d42.setAngleDegrees(90);


        //red tiles
        for(int i = 0; i < 181; i++) {
            LavaTiles b1 = new LavaTiles(this, game, this);
            b1.setPosition(new Vec2((float) (-52 + i * 0.5), 34f));
        }
        for(int i = 0; i < 55; i++) {
            LavaTiles b2 = new LavaTiles(this, game, this);
            b2.setPosition(new Vec2((float) (-117 + i * 0.5), 19f));
        }
        for(int i = 0; i < 27; i++) {
            LavaTiles b3 = new LavaTiles(this, game, this);
            b3.setPosition(new Vec2((float) (-117F + i * 0.5), -6f));
        }
        for(int i = 0; i < 53; i++) {
            LavaTiles b4 = new LavaTiles(this, game, this);
            b4.setPosition(new Vec2((float) (-84F + i * 0.5), -6f));
        }
        // Walk check tiles

        WalkChecks q1 = new WalkChecks(this);
        q1.setPosition(new Vec2( (float)15.120299  , (float) -39));
        WalkChecks q2 = new WalkChecks(this);
        q2.setPosition(new Vec2( (float)73.1203  , (float) -39));
        WalkChecks q3 = new WalkChecks(this);
        q3.setPosition(new Vec2( (float)-20.663961  , (float) 0));
        WalkChecks q4 = new WalkChecks(this);
        q4.setPosition(new Vec2( (float)20.33604  , (float) 0));
        WalkChecks q5 = new WalkChecks(this);
        q5.setPosition(new Vec2( (float)-22.86396  , (float) 20));
        WalkChecks q6 = new WalkChecks(this);
        q6.setPosition(new Vec2( (float)8.736039  , (float) 20));
        WalkChecks q7 = new WalkChecks(this);
        q7.setPosition(new Vec2( (float)-71.06057  , (float) -104));
        WalkChecks q8 = new WalkChecks(this);
        q8.setPosition(new Vec2( (float)99.02734  , (float) -104));
        WalkChecks q9 = new WalkChecks(this);
        q9.setPosition(new Vec2( (float)31.943462  , (float) 65));
        WalkChecks q10 = new WalkChecks(this);
        q10.setPosition(new Vec2( (float)-31.256538  , (float) 65));
        WalkChecks q11 = new WalkChecks(this);
        q11.setPosition(new Vec2( (float)-109.26309  , (float) 65));
        WalkChecks q12 = new WalkChecks(this);
        q12.setPosition(new Vec2( (float)-44.82744  , (float) 117));
        WalkChecks q13 = new WalkChecks(this);
        q13.setPosition(new Vec2( (float)-111.027435  , (float) 91));
        WalkChecks q14 = new WalkChecks(this);
        q14.setPosition(new Vec2( (float)-19.227438  , (float) 91));
        WalkChecks q15 = new WalkChecks(this);
        q15.setPosition(new Vec2( (float)96.814445  , (float) 104));
        WalkChecks q16 = new WalkChecks(this);
        q16.setPosition(new Vec2( (float)-71.58727  , (float) 104));
        WalkChecks q17 = new WalkChecks(this);
        q17.setPosition(new Vec2( (float)92.71874  , (float) 0));
        WalkChecks q18 = new WalkChecks(this);
        q18.setPosition(new Vec2( (float)100.71874  , (float) 0));
        WalkChecks q19 = new WalkChecks(this);
        q19.setPosition(new Vec2( (float)88.51874  , (float) -39));

        // Crunchy walls
        Shape c11 = new BoxShape(6, 0.4f);
        StaticBody c1 = new StaticBody(this, c11);
        c1.setPosition(new Vec2(78, 97));
        c1.addCollisionListener(new WallCrunch(game, this));
        c1.setFillColor(Color.lightGray);
        c1.setLineColor(Color.lightGray);
        c1.rotateDegrees(90);

        Shape c22 = new BoxShape(6F, 0.4f);
        StaticBody c2 = new StaticBody(this, c22);
        c2.setPosition(new Vec2(84, 0));
        c2.addCollisionListener(new WallCrunch(game, this));
        c2.setFillColor(Color.lightGray);
        c2.setLineColor(Color.lightGray);

        Shape c222 = new BoxShape(5F, 0.4f);
        StaticBody c21 = new StaticBody(this, c222);
        c21.setPosition(new Vec2(90, -13));
        c21.addCollisionListener(new WallCrunch(game, this));
        c21.setFillColor(Color.lightGray);
        c21.setLineColor(Color.lightGray);

        Shape c33 = new BoxShape(6F, 0.4f);
        StaticBody c3 = new StaticBody(this, c33);
        c3.setPosition(new Vec2(13, 26));
        c3.addCollisionListener(new WallCrunch(game, this));
        c3.setFillColor(Color.lightGray);
        c3.setLineColor(Color.lightGray);
        c3.rotateDegrees(90);

        Shape c44 = new BoxShape(6F, 0.4f);
        StaticBody c4 = new StaticBody(this, c44);
        c4.setPosition(new Vec2(-52, 0));
        c4.addCollisionListener(new WallCrunch(game, this));
        c4.setFillColor(Color.lightGray);
        c4.setLineColor(Color.lightGray);
        c4.rotateDegrees(90);

        Shape c55 = new BoxShape(22, 0.4f);
        StaticBody c5 = new StaticBody(this, c55);
        c5.setPosition(new Vec2(-79, -82));
        c5.addCollisionListener(new WallCrunch(game, this));
        c5.setFillColor(Color.lightGray);
        c5.setLineColor(Color.lightGray);
        c5.rotateDegrees(90);

        Shape c66 = new BoxShape(6, 0.4f);
        StaticBody c6 = new StaticBody(this, c66);
        c6.setPosition(new Vec2(39, 110));
        c6.rotateDegrees(90);
        c6.addCollisionListener(new WallCrunch(game, this));
        c6.setFillColor(Color.lightGray);
        c6.setLineColor(Color.lightGray);

        // sideways
        MovPlat xm = new MovPlat(this);
        xm.setPosition(new Vec2(0, 39f));
        xm.setGravityScale(5);
        xm.correction();
        xm.moveSides();
        for (int i =0; i<15; i++){
            MovPlatSup xms = new MovPlatSup(this);
            xms.setPosition(new Vec2 ((float) (-60 + 6*i), 38.3f)); }
        MovPlatSup xml1 = new MovPlatSup(this);//add collision
        xml1.setPosition(new Vec2(27,39f));
        xml1.addCollisionListener(new MovingPHor(game, this, xm));
        MovPlatSup xmr1 = new MovPlatSup(this);//add collision
        xmr1.setPosition(new Vec2(-65,39f));
        xmr1.addCollisionListener(new MovingPHor(game, this, xm));

        MovPlat xm2 = new MovPlat(this);
        xm2.setPosition(new Vec2(26, -65f));
        xm2.setGravityScale(5);
        xm2.moveSides();
        xm2.correction();
        for (int i =0; i<13; i++){
            MovPlatSup xms = new MovPlatSup(this);
            xms.setPosition(new Vec2 ((float) (-7 + 6*i), -65.5f)); }
        MovPlatSup xml2 = new MovPlatSup(this);//add collision
        xml2.setPosition(new Vec2(-14,-65));
        xml2.addCollisionListener(new MovingPHor(game, this, xm2));
        MovPlatSup xmr2 = new MovPlatSup(this);//add collision
        xmr2.setPosition(new Vec2(66,-65));
        xmr2.addCollisionListener(new MovingPHor(game, this, xm2));

// BUTTONS AND DOOR
        //buttons
        Buttonz butt1 = new Buttonz(this, game, this);
        Buttonz butt2 = new Buttonz(this, game, this);
        Buttonz butt3 = new Buttonz(this, game, this);
        butt1.setPosition(new Vec2(102.57433f, 112.64499f));
        butt1.addCollisionListener(new ButtonListener(game, this, butt1));
        butt2.setPosition(new Vec2(74.91659f, 36.769993f));
        butt2.addCollisionListener(new ButtonListener(game, this, butt2));
        butt3.setPosition(new Vec2(80.87748f, 88.708954f));
        butt3.addCollisionListener(new ButtonListener(game, this, butt3));

        // door
        Shape door1 = new BoxShape(6, 0.4f);
        StaticBody door11 = new StaticBody(this, door1);
        door11.setFillColor(Color.BLUE);
        door11.setPosition(new Vec2(-16, 98));
        door11.setAngleDegrees(90);
        door11.addCollisionListener(new DoorListener(game, this, butt1));

        Shape door2 = new BoxShape(6, 0.4f);
        StaticBody door22 = new StaticBody(this, door2);
        door22.setFillColor(Color.BLUE);
        door22.setPosition(new Vec2(85, 39));
        door22.addCollisionListener(new DoorListener(game, this, butt2));

        Shape door3 = new BoxShape(10, 0.4f);
        StaticBody door33 = new StaticBody(this, door3);
        door33.setFillColor(Color.BLUE);
        door33.setPosition(new Vec2(0, -103));
        door33.addCollisionListener(new DoorNextLevel(game, this, butt3));


    }

    public void populate(Game game){
        super.populate(game);




        // Hero methods
        getFatLady().setPosition(new Vec2(-104, 127));
        //getFatLady().gone();

        // Enemies

        // Bats
        bat = new Bat(this, game, this);
        bat.setPosition(new Vec2( (float)81.45902  , (float) 89.244995));
        bat1 = new Bat(this, game, this);
        bat1.setPosition(new Vec2( (float)81.25902  , (float) 86.84499));
        bat2 = new Bat(this, game, this);
        bat2.setPosition(new Vec2( (float)82.45902  , (float) 74.04499));
        bat3 = new Bat(this, game, this);
        bat3.setPosition(new Vec2( (float)82.25902  , (float) 69.244995));
        bat4 = new Bat(this, game, this);
        bat4.setPosition(new Vec2( (float)82.45902  , (float) 62.444992));
        bat5 = new Bat(this, game, this);
        bat5.setPosition(new Vec2( (float)82.65902  , (float) 56.844994));
        bat6 = new Bat(this, game, this);
        bat6.setPosition(new Vec2( (float)83.65902  , (float) 49.044994));
        bat7= new Bat(this, game, this);
        bat7.setPosition(new Vec2( (float)82.25902  , (float) 44.644993));
        bat8 = new Bat(this, game, this);
        bat8.setPosition(new Vec2( (float)42.78717  , (float) 37.045));
        bat9 = new Bat(this, game, this);
        bat9.setPosition(new Vec2( (float)54.187172  , (float) 34.644997));
        bat10 = new Bat(this, game, this);
        bat10.setPosition(new Vec2( (float)64.987175  , (float) 32.045));
        bat11 = new Bat(this, game, this);
        bat11.setPosition(new Vec2( (float)44.187172  , (float) 30.244997));
        bat12 = new Bat(this, game, this);
        bat12.setPosition(new Vec2( (float)-23.524126  , (float) -7.9550014));
        bat13 = new Bat(this, game, this);
        bat13.setPosition(new Vec2( (float)-22.724127  , (float) -28.155003));
        bat14 = new Bat(this, game, this);
        bat14.setPosition(new Vec2( (float)-22.724127  , (float) -32.755));
        bat15 = new Bat(this, game, this);
        bat15.setPosition(new Vec2( (float)75.075874  , (float) -32.155003));
        bat16 = new Bat(this, game, this);
        bat16.setPosition(new Vec2( (float)-21.524126  , (float) 31.644999));
        bat17 = new Bat(this, game, this);
        bat17.setPosition(new Vec2( (float)-88.566086  , (float) -51.153767));
        bat18 = new Bat(this, game, this);
        bat18.setPosition(new Vec2( (float)-108.96608  , (float) -52.753765));
        bat19 = new Bat(this, game, this);
        bat19.setPosition(new Vec2( (float)-60.927044  , (float) 40.04708));
        bat20 = new Bat(this, game, this);
        bat20.setPosition(new Vec2( (float)-45.127045  , (float) 47.447083));
        bat21 = new Bat(this, game, this);
        bat21.setPosition(new Vec2( (float)-110.72704  , (float) 56.04708));

        //wolves

        wolf = new Wolf(this, game, this);
        wolf.setPosition(new Vec2( (float)-17.934996  , (float) 23.644999));
        wolf2 = new Wolf(this, game, this);
        wolf2.setPosition(new Vec2( (float)-14.534995  , (float) 3.4449983));
        wolf3 = new Wolf(this, game, this);
        wolf3 .setPosition(new Vec2( (float)-101.46427  , (float) 69.945));
        wolf4 = new Wolf(this, game, this);
        wolf4.setPosition(new Vec2( (float)69.214455  , (float) 109.846794));
        wolf5 = new Wolf(this, game, this);
        wolf5.setPosition(new Vec2( (float)-98.00716  , (float) 96.64499));

        //dogs

        dog = new Dog(this, game, this);
        dog.setPosition(new Vec2( (float)96.434715  , (float) 4.8671794));
        dog2 = new Dog(this, game, this);
        dog2 .setPosition(new Vec2( (float)80.247116  , (float) -98.55501));
        dog3 = new Dog(this, game, this);
        dog3.setPosition(new Vec2( (float)42.7203  , (float) -34.75501));

        // COLLECTABLES
        // Burgers
        burger1 = new FairyDust(this);
        burger1.setPosition(new Vec2( (float)-20.66632  , (float) 31.445));
        burger2 = new FairyDust(this);
        burger2.setPosition(new Vec2( (float)-74.822525  , (float) -46.355007));
        burger3 = new FairyDust(this);
        burger3.setPosition(new Vec2( (float)-68.822525  , (float) -46.75501));
        burger4 = new FairyDust(this);
        burger4.setPosition(new Vec2( (float)-29.96032  , (float) 30.444994));
        burger5 = new FairyDust(this);
        burger5.setPosition(new Vec2( (float)81.15535  , (float) 81.24499));
        burger6 = new FairyDust(this);
        burger6.setPosition(new Vec2( (float)84.55535  , (float) 94.24499));
        burger7 = new FairyDust(this);
        burger7.setPosition(new Vec2( (float)94.55535  , (float) 94.04499));


        // Lollies
        lolly = new Lolly(this);
        lolly.setPosition(new Vec2( (float)98.90864  , (float) 114.04499));
        lolly2 = new Lolly(this);
        lolly2.setPosition(new Vec2( (float)99.30864  , (float) 101.44499));
        lolly3 = new Lolly(this);
        lolly3.setPosition(new Vec2( (float)-13.868731  , (float) 60.96781));
        lolly4 = new Lolly(this);
        lolly4.setPosition(new Vec2( (float)-34.572987  , (float) 32.047));
    }

    @Override
    public boolean isComplete() {
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
        Image background = new ImageIcon("data/lvl5.jpg").getImage();
        return background;
    }

    @Override
    public JLabel playerTips(){
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));

        label.setText("<html>" +
                "<body width='170'><h2>Game Tips:</h2>\n" +
                "<p>\n" +
                "To move on shoot blue buttons and touch blue platform. Walk through.\n" +
                "This level doesn't support saving." +
                "</html>");
        return label;
    }

    @Override
    public String getLevelName() {
        return "L5";
    }

}
