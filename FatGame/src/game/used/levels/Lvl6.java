package game.used.levels;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.eventListeners.lvl567.ButtonListener;
import game.used.eventListeners.lvl567.ButtonOrder;
import game.used.eventListeners.lvl567.DoorListener;
import game.used.eventListeners.lvl567.DoorNextLevel;
import game.used.eventListeners.otherLevels.*;
import game.used.objects.collectable.FairyDust;
import game.used.objects.collectable.Collectable;
import game.used.objects.collectable.Lolly;
import game.used.objects.enemy.Bat;
import game.used.objects.enemy.Enemy;
import game.used.objects.enemy.Puppy;
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
 * Level 6, playable
 * Due to custom creation of Buttons and StaticBodies being portals to next level
 * doesn't support being saved to a file without Serializable
 * @see GameLevels
 */
public class Lvl6 extends GameLevels implements Serializable {

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
    private Enemy wolf;
    private Enemy wolf2;
    private Enemy wolf3;
    private Enemy wolf4;
    private Enemy pup;
    private Enemy pup2;
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


    public Lvl6(Game game) {
        super(game);

        //sound
        try {
            gameMusic = new SoundClip("data/sound/All_About_That_Bass.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }


        //container
        Shape x1 = new BoxShape(117, 0.3f);
        StaticBody w1 = new StaticBody(this, x1);
        w1.setPosition(new Vec2(-117, 13f));
        w1.rotateDegrees(90);
        Shape x2 = new BoxShape(117, 0.3f);
        StaticBody w2 = new StaticBody(this, x2);
        w2.setPosition(new Vec2(117, 13f));
        w2.rotateDegrees(90);
        Shape x3 = new BoxShape(117, 0.3f);
        StaticBody w3 = new StaticBody(this, x3);
        w3.setPosition(new Vec2(0, 130));
        Shape x4 = new BoxShape(117, 0.3f);
        StaticBody w4 = new StaticBody(this, x4);
        w4.setPosition(new Vec2(0, -104));


        //platforms

        Shape a1 = new BoxShape(13, 0.3f);
        StaticBody d1 = new StaticBody(this, a1);
        d1.setPosition(new Vec2(-78, 117));

        Shape a2 = new BoxShape(39, 0.3f);
        StaticBody d2 = new StaticBody(this, a2);
        d2.setPosition(new Vec2(-13, 104));

        Shape a3 = new BoxShape(13, 0.3f);
        StaticBody d3 = new StaticBody(this, a3);
        d3.setPosition(new Vec2(-104, 91));

        Shape a4 = new BoxShape(29, 0.3f);
        StaticBody d4 = new StaticBody(this, a4);
        d4.setPosition(new Vec2(11.5f, 91));

        Shape a5 = new BoxShape(35, 0.3f);
        StaticBody d5 = new StaticBody(this, a5);
        d5.setPosition(new Vec2(7.5F, 78));

        Shape a6 = new BoxShape(6, 0.3f);
        StaticBody d6 = new StaticBody(this, a6);
        d6.setPosition(new Vec2(-84, 65));

        Shape a7 = new BoxShape(3, 0.3f);
        StaticBody d7 = new StaticBody(this, a7);
        d7.setPosition(new Vec2(-68, 52));

        Shape a8 = new BoxShape(6, 0.3f);
        StaticBody d8 = new StaticBody(this, a8);
        d8.setPosition(new Vec2(-45.5f, 52));

        Shape a9 = new BoxShape(3, 0.3f);
        StaticBody d9 = new StaticBody(this, a9);
        d9.setPosition(new Vec2(39, 52));

        Shape a10 = new BoxShape(3, 0.3f);
        StaticBody d10 = new StaticBody(this, a10);
        d10.setPosition(new Vec2(23, 33));

        Shape a11 = new BoxShape(3, 0.3f);
        StaticBody d11 = new StaticBody(this, a11);
        d11.setPosition(new Vec2(-29, 29));

        Shape a12 = new BoxShape(6, 0.3f);
        StaticBody d12 = new StaticBody(this, a12);
        d12.setPosition(new Vec2(-84, 39));

        Shape a13 = new BoxShape(6, 0.3f);
        StaticBody d13 = new StaticBody(this, a13);
        d13.setPosition(new Vec2(-110, 26));

        Shape a14 = new BoxShape(3, 0.3f);
        StaticBody d14 = new StaticBody(this, a14);
        d14.setPosition(new Vec2(-68, 26));

        Shape a15 = new BoxShape(6, 0.3f);
        StaticBody d15 = new StaticBody(this, a15);
        d15.setPosition(new Vec2(-110, 13));

        Shape a16 = new BoxShape(6, 0.3f);
        StaticBody d16 = new StaticBody(this, a16);
        d16.setPosition(new Vec2(-110, 0));

        Shape a17 = new BoxShape(6, 0.3f);
        StaticBody d17 = new StaticBody(this, a17);
        d17.setPosition(new Vec2(-13, 13));

        Shape a18 = new BoxShape(3, 0.3f);
        StaticBody d18 = new StaticBody(this, a18);
        d18.setPosition(new Vec2(36, 13));

        Shape a19 = new BoxShape(3, 0.3f);
        StaticBody d19 = new StaticBody(this, a19);
        d19.setPosition(new Vec2(-94, -13));

        Shape a20 = new BoxShape(6, 0.3f);
        StaticBody d20 = new StaticBody(this, a20);
        d20.setPosition(new Vec2(-110, -39));

        Shape a21 = new BoxShape(19, 0.3f);
        StaticBody d21 = new StaticBody(this, a21);
        d21.setPosition(new Vec2(-6, -45));

        Shape a22 = new BoxShape(39, 0.3f);
        StaticBody d22 = new StaticBody(this, a22);
        d22.setPosition(new Vec2(78, -65));

        Shape a23 = new BoxShape(32, 0.3f);
        StaticBody d23 = new StaticBody(this, a23);
        d23.setPosition(new Vec2(45, -91));

        Shape a24 = new BoxShape(16, 0.3f);
        StaticBody d24 = new StaticBody(this, a24);
        d24.setPosition(new Vec2(-91, -30));
        d24.setAngleDegrees(90);

        Shape a25 = new BoxShape(16, 0.3f);
        StaticBody d25 = new StaticBody(this, a25);
        d25.setPosition(new Vec2(-76, -30));
        d25.setAngleDegrees(90);

        Shape a26 = new BoxShape(78, 0.3f);
        StaticBody d26 = new StaticBody(this, a26);
        d26.setPosition(new Vec2(-65, 39));
        d26.setAngleDegrees(90);

        Shape a27 = new BoxShape(54.5f, 0.3f);
        StaticBody d27 = new StaticBody(this, a27);
        d27.setPosition(new Vec2(-52, 48.5f));
        d27.setAngleDegrees(90);

        Shape a28 = new BoxShape(49, 0.3f);
        StaticBody d28 = new StaticBody(this, a28);
        d28.setPosition(new Vec2(42, 81));
        d28.setAngleDegrees(90);

        Shape a29 = new BoxShape(19, 0.3f);
        StaticBody d29 = new StaticBody(this, a29);
        d29.setPosition(new Vec2(7, 25));
        d29.setAngleDegrees(90);

        Shape a30 = new BoxShape(12, 0.3f);
        StaticBody d30 = new StaticBody(this, a30);
        d30.setPosition(new Vec2(42, 6));
        d30.setAngleDegrees(90);

        Shape a31 = new BoxShape(84.5f, 0.3f);
        StaticBody d31 = new StaticBody(this, a31);
        d31.setPosition(new Vec2(32.5f, -6));

        Shape a32 = new BoxShape(15.5f, 0.3f);
        StaticBody d32 = new StaticBody(this, a32);
        d32.setPosition(new Vec2(13, -77));
        d32.setAngleDegrees(90);

        Shape a33 = new BoxShape(3, 0.3f);
        StaticBody d33 = new StaticBody(this, a33);
        d33.setPosition(new Vec2(94, -45));

        Shape a34 = new BoxShape(9, 0.3f);
        StaticBody d34 = new StaticBody(this, a34);
        d34.setPosition(new Vec2(13, -36));
        d34.setAngleDegrees(90);


        //red tiles
        for(int i = 0; i < 71; i++) {
            LavaTiles b1 = new LavaTiles(this, game, this);
            b1.setPosition(new Vec2((float) (7 + i * 0.5), 6));
        }
        for(int i = 0; i < 114; i++) {
            LavaTiles b2 = new LavaTiles(this, game, this);
            b2.setPosition(new Vec2((float) (33 + i * 0.5), -45f));
        }
        for(int i = 0; i < 106; i++) {
            LavaTiles b3 = new LavaTiles(this, game, this);
            b3.setPosition(new Vec2((float) (-117F + i * 0.5), -104f));
        }


        // Walk check tiles

        WalkChecks q1 = new WalkChecks(this);
        q1.setPosition(new Vec2( (float)37.650547  , (float) 91));
        WalkChecks q2 = new WalkChecks(this);
        q2.setPosition(new Vec2( (float)-15.949454  , (float) 91));
        WalkChecks q3 = new WalkChecks(this);
        q3 .setPosition(new Vec2( (float)-25.749454  , (float) 78));
        WalkChecks q4 = new WalkChecks(this);
        q4 .setPosition(new Vec2( (float)38.450546  , (float) 78));
        WalkChecks q5 = new WalkChecks(this);
        q5 .setPosition(new Vec2( (float)35.728  , (float) -6));
        WalkChecks q6 = new WalkChecks(this);
        q6 .setPosition(new Vec2( (float)-5.0720005  , (float) -6));
        WalkChecks q7 = new WalkChecks(this);
        q7 .setPosition(new Vec2( (float)-49.472  , (float) -6));
        WalkChecks q8 = new WalkChecks(this);
        q8 .setPosition(new Vec2( (float)73.22996  , (float) -91));
        WalkChecks q9 = new WalkChecks(this);
        q9.setPosition(new Vec2( (float)15.479956  , (float) -91));

        // MOVING PLATFORMS
        //vertical

        MovPlat xm3 = new MovPlat(this);
        xm3.setPosition(new Vec2(-88, -26));
        getFatLady().addCollisionListener(new IsOnPlatform(getFatLady()));
        xm3.addCollisionListener(new MovingPUp(game, this, xm3));
        MovPlatSup xmu3 = new MovPlatSup(this);//add collision
        xmu3.setPosition(new Vec2(-88,-13));
        MovPlatSup xmt3 = new MovPlatSup(this);//add collision
        xmt3.setPosition(new Vec2(-88,-45));
        xmu3.addCollisionListener(new MovingPDown(game, getFatLady(), xm3));

        // sideways
        MovPlat xm = new MovPlat(this);
        xm.setPosition(new Vec2(68, -39));
        xm.setGravityScale(1);
        xm.correction();
        xm.moveSides();
        for (int i =0; i<17; i++){
            MovPlatSup xms = new MovPlatSup(this);
            xms.setPosition(new Vec2 ((float) (-100 + 8*i), -60)); }
        MovPlatSup xml1 = new MovPlatSup(this);//add collision
        xml1.setPosition(new Vec2(-105,-59));
        xml1.addCollisionListener(new MovingPHor(game, this, xm));
        MovPlatSup xml2 = new MovPlatSup(this);//add collision
        xml2.setPosition(new Vec2(77,-43.5f));
        xml2.addCollisionListener(new MovingPHor(game, this, xm));
        MovPlatSup xmr1 = new MovPlatSup(this);//add collision
        xmr1.setPosition(new Vec2(29,-59));
        xmr1.addCollisionListener(new MovingPHor(game, this, xm));

        MovPlat xm2 = new MovPlat(this);
        xm2.setPosition(new Vec2(0, 66));
        xm2.setGravityScale(1);
        xm2.correction();
        xm2.moveSides();
        for (int i =0; i<10; i++){
            MovPlatSup xms = new MovPlatSup(this);
            xms.setPosition(new Vec2 ((float) (-35 + 7*i), 64.3f)); }
        MovPlatSup xml3 = new MovPlatSup(this);//add collision
        xml3.setPosition(new Vec2(-40,65));
        xml3.addCollisionListener(new MovingPHor(game, this, xm2));
        MovPlatSup xmr2 = new MovPlatSup(this);//add collision
        xmr2.setPosition(new Vec2(33,65));
        xmr2.addCollisionListener(new MovingPHor(game, this, xm2));



        // Crunchy walls
        Shape c11 = new BoxShape(6, 0.4f);
        StaticBody c1 = new StaticBody(this, c11);
        c1.setPosition(new Vec2(-85, -33));
        c1.addCollisionListener(new WallCrunch(game, this));
        c1.setFillColor(Color.lightGray);
        c1.setLineColor(Color.lightGray);

        Shape c22 = new BoxShape(9F, 0.4f);
        StaticBody c2 = new StaticBody(this, c22);
        c2.setPosition(new Vec2(32, -36));
        c2.addCollisionListener(new WallCrunch(game, this));
        c2.setFillColor(Color.lightGray);
        c2.setLineColor(Color.lightGray);
        c2.setAngleDegrees(90);

        Shape c33 = new BoxShape(15F, 0.4f);
        StaticBody c3 = new StaticBody(this, c33);
        c3.setPosition(new Vec2(26, -45));
        c3.addCollisionListener(new WallCrunch(game, this));
        c3.setFillColor(Color.lightGray);
        c3.setLineColor(Color.lightGray);

        Shape c44 = new BoxShape(9F, 0.4f);
        StaticBody c4 = new StaticBody(this, c44);
        c4.setPosition(new Vec2(13, -56));
        c4.addCollisionListener(new WallCrunch(game, this));
        c4.setFillColor(Color.lightGray);
        c4.setLineColor(Color.lightGray);
        c4.setAngleDegrees(90);

        Shape c55 = new BoxShape(22, 0.4f);
        StaticBody c5 = new StaticBody(this, c55);
        c5.setPosition(new Vec2(-65, -57));
        c5.addCollisionListener(new WallCrunch(game, this));
        c5.setFillColor(Color.lightGray);
        c5.setLineColor(Color.lightGray);
        c5.setAngleDegrees(90);

        Shape c66 = new BoxShape(6.5F, 0.4f);
        StaticBody c6 = new StaticBody(this, c66);
        c6.setPosition(new Vec2(13, 97.5f));
        c6.addCollisionListener(new WallCrunch(game, this));
        c6.setFillColor(Color.lightGray);
        c6.setLineColor(Color.lightGray);
        c6.setAngleDegrees(90);


        // BUTTONS AND DOOR
        //buttons
        Buttonz butt1 = new Buttonz(this, game, this);
        Buttonz butt2 = new Buttonz(this, game, this);
        Buttonz butt3 = new Buttonz(this, game, this);
        Buttonz butt4 = new Buttonz(this, game, this);
        Buttonz butt5 = new Buttonz(this, game, this);
        butt1.setPosition(new Vec2(-113.69f, 28.74f));
        butt1.addCollisionListener(new ButtonListener(game, this, butt1));
        butt2.setPosition(new Vec2(80, 30));
        butt2.addCollisionListener(new ButtonOrder(game, this, butt2, butt3, butt4, butt5));
        butt3.setPosition(new Vec2(90, 24));
        butt3.addCollisionListener(new ButtonOrder(game, this, butt2, butt3, butt4, butt5));
        butt4.setPosition(new Vec2(100, 18));
        butt4.addCollisionListener(new ButtonOrder(game, this, butt2, butt3, butt4, butt5));
        butt5.setPosition(new Vec2(110, 12));
        butt5.addCollisionListener(new ButtonOrder(game, this, butt2, butt3, butt4, butt5));



        // door
        Shape door1 = new BoxShape(10, 0.4f);
        StaticBody door11 = new StaticBody(this, door1);
        door11.setFillColor(Color.BLUE);
        door11.setPosition(new Vec2(42, 25));
        door11.setAngleDegrees(90);
        door11.addCollisionListener(new DoorListener(game, this, butt1));

        Shape door2 = new BoxShape(10, 0.4f);
        StaticBody door22 = new StaticBody(this, door2);
        door22.setFillColor(Color.BLUE);
        door22.setPosition(new Vec2(-56, 129));
        door22.addCollisionListener(new DoorNextLevel(game, this, butt2));


    }

    public void populate(Game game){
        super.populate(game);



        // Hero methods
        getFatLady().setPosition(new Vec2(-60, 110));
        //getFatLady().setPosition(new Vec2(80, 18));

        //getFatLady().gone();

        // Enemies

        //BATS
        bat = new Bat(this, game, this);
        bat.setPosition(new Vec2( (float)-113.7554  , (float) 6.8463926));
        bat2 = new Bat(this, game, this);
        bat2.setPosition(new Vec2( (float)-113.7554  , (float) 19.846453));
        bat3= new Bat(this, game, this);
        bat3 .setPosition(new Vec2( (float)-114.1554  , (float) 30.246452));
        bat4 = new Bat(this, game, this);
        bat4 .setPosition(new Vec2( (float)-114.1554  , (float) 33.04645));
        bat5 = new Bat(this, game, this);
        bat5 .setPosition(new Vec2( (float)-113.7554  , (float) 41.84645));
        bat6 = new Bat(this, game, this);
        bat6 .setPosition(new Vec2( (float)-113.7554  , (float) 56.04645));
        bat7 = new Bat(this, game, this);
        bat7 .setPosition(new Vec2( (float)-113.7554  , (float) 64.646454));
        bat8 = new Bat(this, game, this);
        bat8 .setPosition(new Vec2( (float)-113.3554  , (float) 77.046455));
        bat9 = new Bat(this, game, this);
        bat9 .setPosition(new Vec2( (float)-114.0675  , (float) 107.04499));
        bat10 = new Bat(this, game, this);
        bat10 .setPosition(new Vec2( (float)-114.267494  , (float) 99.64499));
        bat11 = new Bat(this, game, this);
        bat11 .setPosition(new Vec2( (float)-113.8675  , (float) 93.44499));
        bat12 = new Bat(this, game, this);
        bat12 .setPosition(new Vec2( (float)35.93965  , (float) 65.645));
        bat13 = new Bat(this, game, this);
        bat13 .setPosition(new Vec2( (float)29.139652  , (float) 65.04499));
        bat14 = new Bat(this, game, this);
        bat14.setPosition(new Vec2( (float)7.1396513  , (float) 54.444992));
        bat15 = new Bat(this, game, this);
        bat15 .setPosition(new Vec2( (float)24.939651  , (float) 39.444992));
        bat16 = new Bat(this, game, this);
        bat16.setPosition(new Vec2( (float)-20.060349  , (float) 7.6449924));
        bat17 = new Bat(this, game, this);
        bat17.setPosition(new Vec2( (float)-40.26035  , (float) 1.0449923));
        bat18 = new Bat(this, game, this);
        bat18 .setPosition(new Vec2( (float)-2.0603487  , (float) 22.045023));
        bat19 = new Bat(this, game, this);
        bat19 .setPosition(new Vec2( (float)-45.46035  , (float) 29.845024));

        //WOLF

        wolf = new Wolf(this, game, this);
        wolf.setPosition(new Vec2( (float)-27.816532  , (float) -1.3550076));
        wolf2 = new Wolf(this, game, this);
        wolf2.setPosition(new Vec2( (float)-0.21653211  , (float) -2.1550076));
        wolf3 = new Wolf(this, game, this);
        wolf3 .setPosition(new Vec2( (float)22.583467  , (float) 82.44499));
        wolf4 = new Wolf(this, game, this);
        wolf4.setPosition(new Vec2( (float)7.183468  , (float) 95.44499));

        //Puppies

        pup = new Puppy(this, game, this);
        pup.setPosition(new Vec2( (float)33.585  , (float) -86.75501));
        pup2 = new Puppy(this, game, this);
        pup2.setPosition(new Vec2( (float)57.985  , (float) -86.55501));

        //COLLECTABLES
        //BURGERS
        burger1 = new FairyDust(this);
        burger1 .setPosition(new Vec2( (float)16.311167  , (float) -30.753489));
        burger2 = new FairyDust(this);
        burger2 .setPosition(new Vec2( (float)-88.69489  , (float) 120.844986));
        burger3 = new FairyDust(this);
        burger3.setPosition(new Vec2( (float)-80.09489  , (float) 120.04499));
        burger4 = new FairyDust(this);
        burger4.setPosition(new Vec2( (float)29.70511  , (float) 88.64499));
        burger5 = new FairyDust(this);
        burger5 .setPosition(new Vec2( (float)37.10511  , (float) 89.04499));
        burger6 = new FairyDust(this);
        burger6 .setPosition(new Vec2( (float)31.676273  , (float) 4.044999));
        burger7 = new FairyDust(this);
        burger7 .setPosition(new Vec2( (float)36.876274  , (float) 3.6449993));


        //LOlolly
        lolly = new Lolly(this);
        lolly.setPosition(new Vec2( (float)39.476273  , (float) -3.9550009));
        lolly2 = new Lolly(this);
        lolly2.setPosition(new Vec2( (float)90.78548  , (float) 39.045));
        lolly3 = new Lolly(this);
        lolly3.setPosition(new Vec2( (float)-70.74946  , (float) 121.44499));
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
        Image background = new ImageIcon("data/lvl52.jpg").getImage();
        return background;
    }

    @Override
    public JLabel playerTips(){
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));

        label.setText("<html>" +
                "<body width='170'>\n" +
                "<p>\n" +
                "Shoot buttons in the right order to move on. " +
                "Go where you came from. \n" +
                "This level doesn't support saving." +
                "</html>");
        return label;
    }

    @Override
    public String getLevelName() {
        return "L6";
    }


}

