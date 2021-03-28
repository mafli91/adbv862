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
 * Level 3, playable
 * @see GameLevels
 */
public class Lvl3 extends GameLevels implements Serializable {

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
    private Collectable burger1;
    private Collectable burger2;
    private Collectable burger3;
    private Collectable burger4;
    private Collectable burger5;
    private Collectable burger6;
    private Collectable burger7;
    private Collectable burger8;
    private Collectable burger9;
    private Collectable burger10;


    public Lvl3(Game game) {
        super(game);

        //sound
        try {
            gameMusic = new SoundClip("data/sound/Fancy.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }

        //container
        Shape x1 = new BoxShape(78, 0.3f);
        StaticBody w1 = new StaticBody(this, x1);
        w1.setPosition(new Vec2(-104, 0f));
        w1.rotateDegrees(90);
        Shape x2 = new BoxShape(78, 0.3f);
        StaticBody w2 = new StaticBody(this, x2);
        w2.setPosition(new Vec2(78, 0f));
        w2.rotateDegrees(90);
        Shape x3 = new BoxShape(91, 0.3f);
        StaticBody w3 = new StaticBody(this, x3);
        w3.setPosition(new Vec2(-13, 78f));
        Shape x4 = new BoxShape(91, 0.3f);
        StaticBody w4 = new StaticBody(this, x4);
        w4.setPosition(new Vec2(-13, -78f));


        //platforms

        Shape a1 = new BoxShape(13, 0.3f);
        StaticBody d1 = new StaticBody(this, a1);
        d1.setPosition(new Vec2(-78, 58));

        Shape a2 = new BoxShape(32.5F, 0.3f);
        StaticBody d2 = new StaticBody(this, a2);
        d2.setPosition(new Vec2(26, 65f));

        Shape a3 = new BoxShape(32.5F, 0.3f);
        StaticBody d3 = new StaticBody(this, a3);
        d3.setPosition(new Vec2(-13, 39));

        Shape a4 = new BoxShape(7, 0.3f);
        StaticBody d4 = new StaticBody(this, a4);
        d4.setPosition(new Vec2(71, 52f));

        Shape a5 = new BoxShape(17, 0.3f);
        StaticBody d5 = new StaticBody(this, a5);
        d5.setPosition(new Vec2(61.5F, 39f));

        Shape a6 = new BoxShape(9, 0.3f);
        StaticBody d6 = new StaticBody(this, a6);
        d6.setPosition(new Vec2(3, 26f));

        Shape a7 = new BoxShape(7, 0.3f);
        StaticBody d7 = new StaticBody(this, a7);
        d7.setPosition(new Vec2(26, 13f));

        Shape a8 = new BoxShape(39, 0.3f);
        StaticBody d8 = new StaticBody(this, a8);
        d8.setPosition(new Vec2(-65, 0f));

        Shape a9 = new BoxShape(22, 0.3f);
        StaticBody d9 = new StaticBody(this, a9);
        d9.setPosition(new Vec2(-74, -26f));

        Shape a10 = new BoxShape(19.5F, 0.3f);
        StaticBody d10 = new StaticBody(this, a10);
        d10.setPosition(new Vec2(-7, -26f));

        Shape a11 = new BoxShape(7, 0.3f);
        StaticBody d11 = new StaticBody(this, a11);
        d11.setPosition(new Vec2(7, -7f));

        Shape a12 = new BoxShape(26, 0.3f);
        StaticBody d12 = new StaticBody(this, a12);
        d12.setPosition(new Vec2(52, -26f));

        Shape a13 = new BoxShape(7, 0.3f);
        StaticBody d13 = new StaticBody(this, a13);
        d13.setPosition(new Vec2(0, -52f));

        Shape a14 = new BoxShape(39, 0.3f);
        StaticBody d14 = new StaticBody(this, a14);
        d14.setPosition(new Vec2(-45.5F, -65f));

        Shape a15 = new BoxShape(15, 0.3f);
        StaticBody d15 = new StaticBody(this, a15);
        d15.setPosition(new Vec2(12, -63f));
        d15.setAngleDegrees(90);

        Shape a16 = new BoxShape(15, 0.3f);
        StaticBody d16 = new StaticBody(this, a16);
        d16.setPosition(new Vec2(27, -63f));
        d16.setAngleDegrees(90);

        Shape a17 = new BoxShape(19.5F, 0.3f);
        StaticBody d17 = new StaticBody(this, a17);
        d17.setPosition(new Vec2(59, -65f));



        //red tiles
        for(int i = 0; i < 27; i++) {
            LavaTiles b1 = new LavaTiles(this, game, this);
            b1.setPosition(new Vec2((float) (-104 + i * 0.5), 58f));
        }
        for(int i = 0; i < 53; i++) {
            LavaTiles b2 = new LavaTiles(this, game, this);
            b2.setPosition(new Vec2((float) (-52 + i * 0.5), -26f));
        }
        for(int i = 0; i < 40; i++) {
            LavaTiles b3 = new LavaTiles(this, game, this);
            b3.setPosition(new Vec2((float) (-104F + i * 0.5), -65f));
        }
        // Walk check tiles

        WalkChecks q1 = new WalkChecks(this);
        q1.setPosition(new Vec2( (float)5.825046  , (float) -78));
        WalkChecks q2 = new WalkChecks(this);
        q2.setPosition(new Vec2( (float)-97.33467  , (float) -78));
        WalkChecks q3 = new WalkChecks(this);
        q3.setPosition(new Vec2( (float)-80.53467  , (float) -65));
        WalkChecks q4 = new WalkChecks(this);
        q4.setPosition(new Vec2( (float)-11.734671  , (float) -65));
        WalkChecks q5 = new WalkChecks(this);
        q5.setPosition(new Vec2( (float)43.642414  , (float) -65));
        WalkChecks q6 = new WalkChecks(this);
        q6.setPosition(new Vec2( (float)73.04241  , (float) -65));
        WalkChecks q7 = new WalkChecks(this);
        q7.setPosition(new Vec2( (float)31.442413  , (float) -78));
        WalkChecks q8 = new WalkChecks(this);
        q8.setPosition(new Vec2( (float)74.04241  , (float) -78));
        WalkChecks q9 = new WalkChecks(this);
        q9.setPosition(new Vec2( (float)30.642414  , (float) -26));
        WalkChecks q10 = new WalkChecks(this);
        q10.setPosition(new Vec2( (float)73.04241  , (float) -26));
        WalkChecks q11 = new WalkChecks(this);
        q11.setPosition(new Vec2( (float)8.442413  , (float) -26));
        WalkChecks q12 = new WalkChecks(this);
        q12.setPosition(new Vec2( (float)-23.957586  , (float) -26));
        WalkChecks q13 = new WalkChecks(this);
        q13.setPosition(new Vec2( (float)-92.643776  , (float) -26));
        WalkChecks q14 = new WalkChecks(this);
        q14.setPosition(new Vec2( (float)-56.043777  , (float) -26));
        WalkChecks q15 = new WalkChecks(this);
        q15.setPosition(new Vec2( (float)-28.92589  , (float) 0));
        WalkChecks q16 = new WalkChecks(this);
        q16.setPosition(new Vec2( (float)-99.72589  , (float) 0));
        WalkChecks q17 = new WalkChecks(this);
        q17.setPosition(new Vec2( (float)-41.12589  , (float) 39));
        WalkChecks q18 = new WalkChecks(this);
        q18.setPosition(new Vec2( (float)15.67411  , (float) 39));
        WalkChecks q19 = new WalkChecks(this);
        q19.setPosition(new Vec2( (float)-87.241325  , (float) 58));
        WalkChecks q20 = new WalkChecks(this);
        q20.setPosition(new Vec2( (float)-67.04132  , (float) 58));
        WalkChecks q21 = new WalkChecks(this);
        q21.setPosition(new Vec2( (float)-1.6788427  , (float) 65));
        WalkChecks q22 = new WalkChecks(this);
        q22.setPosition(new Vec2( (float)54.32116  , (float) 65));
        WalkChecks q23 = new WalkChecks(this);
        q23.setPosition(new Vec2( (float)47.75583  , (float) 39));
        WalkChecks q24 = new WalkChecks(this);
        q24.setPosition(new Vec2( (float)75.15583  , (float) 39));

        //MOVING PLATFORMS
        //vertical

        MovPlat xm2 = new MovPlat(this);
        xm2.setPosition(new Vec2(19, -77f));
        getFatLady().addCollisionListener(new IsOnPlatform(getFatLady()));
        xm2.addCollisionListener(new MovingPUp(game, this, xm2));
        MovPlatSup xmu1 = new MovPlatSup(this);//add collision
        xmu1.setPosition(new Vec2(15,-49f));
        MovPlatSup xmt1 = new MovPlatSup(this);//add collision
        xmt1.setPosition(new Vec2(15,-77f));
        xmt1.addCollisionListener(new MovingPDown(game, getFatLady(), xm2));

        // horizontal support
        // sideways
        MovPlat xm = new MovPlat(this);
        xm.setPosition(new Vec2(46, 13f));
        xm.setGravityScale(1);
        xm.correction();
        xm.moveSides();
        for (int i =0; i<4; i++){
            MovPlatSup xms = new MovPlatSup(this);
            xms.setPosition(new Vec2 ((float) (38 + 12*i), 12.8f)); }
        MovPlatSup xml1 = new MovPlatSup(this);//add collision
        xml1.setPosition(new Vec2(38,13f));
        xml1.addCollisionListener(new MovingPHor(game, this, xm));
        MovPlatSup xmr1 = new MovPlatSup(this);//add collision
        xmr1.setPosition(new Vec2(76,13f));
        xmr1.addCollisionListener(new MovingPHor(game, this, xm));




    }

    public void populate(Game game){
        super.populate(game);
        // moving platforms




        // Hero methods
        getFatLady().setPosition(new Vec2(0, -34));

        // ENEMIES

        // Bats

        bat = new Bat(this, game, this);
        bat.setPosition(new Vec2( (float)-73.879265  , (float) 50.444992));
        bat2 = new Bat(this, game, this);
        bat2.setPosition(new Vec2( (float)-30.879265  , (float) 62.645096));
        bat3 = new Bat(this, game, this);
        bat3.setPosition(new Vec2( (float)57.24401  , (float) 49.044994));
        bat4 = new Bat(this, game, this);
        bat4.setPosition(new Vec2( (float)57.44401  , (float) 45.24499));
        bat5 = new Bat(this, game, this);
        bat5.setPosition(new Vec2( (float)-7.3559895  , (float) 69.44499));
        bat6 = new Bat(this, game, this);
        bat6.setPosition(new Vec2( (float)67.26568  , (float) 23.844997));
        bat7 = new Bat(this, game, this);
        bat7.setPosition(new Vec2( (float)67.065674  , (float) 19.644997));
        bat8 = new Bat(this, game, this);
        bat8.setPosition(new Vec2( (float)16.465677  , (float) 31.044996));
        bat9 = new Bat(this, game, this);
        bat9.setPosition(new Vec2( (float)-61.50145  , (float) 24.445));
        bat10 = new Bat(this, game, this);
        bat10.setPosition(new Vec2( (float)-74.27927  , (float) 53.644993));
        bat11 = new Bat(this, game, this);
        bat11.setPosition(new Vec2( (float)-61.50145  , (float) 21.445));
        bat12 = new Bat(this, game, this);
        bat12.setPosition(new Vec2( (float)-61.50145  , (float) 18.845));
        bat13 = new Bat(this, game, this);
        bat13.setPosition(new Vec2( (float)-46.101448  , (float) 23.445));
        bat14 = new Bat(this, game, this);
        bat14.setPosition(new Vec2( (float)19.098022  , (float) -53.955006));
        bat15 = new Bat(this, game, this);
        bat15.setPosition(new Vec2( (float)37.898026  , (float) -71.755005));
        bat16 = new Bat(this, game, this);
        bat16.setPosition(new Vec2( (float)47.298023  , (float) -73.15501));
        bat17 = new Bat(this, game, this);
        bat17.setPosition(new Vec2( (float)-97.70667  , (float) -66.155014));
        bat18 = new Bat(this, game, this);
        bat18.setPosition(new Vec2( (float)-63.90667  , (float) -67.155014));
        bat19 = new Bat(this, game, this);
        bat19.setPosition(new Vec2( (float)-39.38529  , (float) -4.355006));

        // Dogs
        dog = new Dog(this, game, this);
        dog.setPosition(new Vec2( (float)-61.785286  , (float) -60.155006));
        dog2 = new Dog(this, game, this);
        dog2.setPosition(new Vec2( (float)52.214714  , (float) -59.355007));
        dog3 = new Dog(this, game, this);
        dog3.setPosition(new Vec2( (float)-9.385286  , (float) -20.355007));
        dog4 = new Dog(this, game, this);
        dog4.setPosition(new Vec2( (float)-75.18529  , (float) -20.355007));
        dog5 = new Dog(this, game, this);
        dog5.setPosition(new Vec2( (float)-73.93525  , (float) 6.905625));
        dog6 = new Dog(this, game, this);
        dog6.setPosition(new Vec2( (float)51.65894  , (float) -20.955));
        dog7 = new Dog(this, game, this);
        dog7.setPosition(new Vec2( (float)31.3947  , (float) 69.37035));

        //Puppies
        pup = new Dog(this, game, this);
        pup.setPosition(new Vec2( (float)-14.805303  , (float) 44.045));
        pup2 = new Dog(this, game, this);
        pup2.setPosition(new Vec2( (float)-78.08834  , (float) 63.444992));
        pup3 = new Dog(this, game, this);
        pup3.setPosition(new Vec2( (float)-64.97495  , (float) -72.75501));


        // COLLECTABLES

        // Burgers
        burger1 = new FairyDust(this);
        burger1.setPosition(new Vec2( (float)27.755829  , (float) 75.84499));
        burger2 = new FairyDust(this);
        burger2.setPosition(new Vec2( (float)13.555829  , (float) 76.44499));
        burger3 = new FairyDust(this);
        burger3.setPosition(new Vec2( (float)74.35583  , (float) 49.644993));
        burger4 = new FairyDust(this);
        burger4.setPosition(new Vec2( (float)-101.19192  , (float) 76.244995));
        burger5 = new FairyDust(this);
        burger5.setPosition(new Vec2( (float)-101.59192  , (float) 72.244995));
        burger6 = new FairyDust(this);
        burger6.setPosition(new Vec2( (float)74.3251  , (float) 35.245003));
        burger7 = new FairyDust(this);
        burger7.setPosition(new Vec2( (float)-99.0773  , (float) -3.6550007));
        burger8 = new FairyDust(this);
        burger8.setPosition(new Vec2( (float)-99.986275  , (float) -68.15501));
        burger9 = new FairyDust(this);
        burger9.setPosition(new Vec2( (float)-99.78628  , (float) -74.55501));
        burger10 = new FairyDust(this);
        burger10.setPosition(new Vec2( (float)74.11533  , (float) -71.655014));
    }

    @Override
    public boolean isComplete() {
        if (getFatLady().getBurgerCount() > 9)
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
        Image background = new ImageIcon("data/lvl3.jpg").getImage();
        return background;
    }
    @Override
    public JLabel playerTips(){
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));

        label.setText("<html>" +
                "<body width='170'><h2>Game Tips:</h2>\n" +
                "<p>\n" +
                "You can double jump now. " +
                "Some floor is lava, so watch out!" +
                "Bats are hanging around, be careful!" +
                "Collect 10 doses to move on.\n" +
                "</html>");
        return label;
    }

    @Override
    public String getLevelName() {
        return "L3";
    }
}
