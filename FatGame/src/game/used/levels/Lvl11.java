package game.used.levels;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.used.objects.enemy.boss.Boss;
import game.used.objects.enemy.boss.BossEye;
import game.used.objects.enemy.boss.Wig;
import game.used.objects.other.ComicStrip0;
import game.used.objects.other.LavaTiles;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * Level 11, playable, Boss level
 * @see Boss
 * @see BossEye
 * @see GameLevels
 */
public class Lvl11 extends GameLevels implements Serializable {

    private BossEye eye1;
    private BossEye eye2;
    private BossEye eye3;
    private BossEye eye4;
    private BossEye eye5;
    private BossEye eye6;
    private BossEye eye7;
    private BossEye eye8;
    private BossEye eye9;
    private BossEye eye10;
    private BossEye eye11;
    private BossEye eye12;


    public Lvl11(Game game) {
        super(game);

        //sound
        try {
            gameMusic = new SoundClip("data/sound/anti-machinegun.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(volume);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            catchMusicError(gameMusic);
        }

        //container
        Shape x1 = new BoxShape(84.5f, 0.3f);
        StaticBody w1 = new StaticBody(this, x1);
        w1.setPosition(new Vec2(-78, 6.5f));
        w1.rotateDegrees(90);
        Shape x2 = new BoxShape(84.5f, 0.3f);
        StaticBody w2 = new StaticBody(this, x2);
        w2.setPosition(new Vec2(78, 6.5f));
        w2.rotateDegrees(90);
        Shape x3 = new BoxShape(78, 0.3f);
        StaticBody w3 = new StaticBody(this, x3);
        w3.setPosition(new Vec2(0, 91));
        Shape x4 = new BoxShape(78, 0.3f);
        StaticBody w4 = new StaticBody(this, x4);
        w4.setPosition(new Vec2(0, -78));


        //platforms

        Shape a1 = new BoxShape(13, 0.3f);
        StaticBody d1 = new StaticBody(this, a1);
        d1.setPosition(new Vec2(0, 23));

        Shape a2 = new BoxShape(6, 0.3f);
        StaticBody d2 = new StaticBody(this, a2);
        d2.setPosition(new Vec2(-45, 39f));

        Shape a3 = new BoxShape(6, 0.3f);
        StaticBody d3 = new StaticBody(this, a3);
        d3.setPosition(new Vec2(39, 39));

        Shape a5 = new BoxShape(6, 0.3f);
        StaticBody d5 = new StaticBody(this, a5);
        d5.setPosition(new Vec2(-72, 39f));

        Shape a6 = new BoxShape(6, 0.3f);
        StaticBody d6 = new StaticBody(this, a6);
        d6.setPosition(new Vec2(-45, 26f));

        Shape a7 = new BoxShape(6, 0.3f);
        StaticBody d7 = new StaticBody(this, a7);
        d7.setPosition(new Vec2(-72, 13f));

        Shape a8 = new BoxShape(6, 0.3f);
        StaticBody d8 = new StaticBody(this, a8);
        d8.setPosition(new Vec2(-45, 0f));

        Shape a9 = new BoxShape(6, 0.3f);
        StaticBody d9 = new StaticBody(this, a9);
        d9.setPosition(new Vec2(-72, -13));

        Shape a10 = new BoxShape(6, 0.3f);
        StaticBody d10 = new StaticBody(this, a10);
        d10.setPosition(new Vec2(-45, -26f));

        Shape a11 = new BoxShape(6, 0.3f);
        StaticBody d11 = new StaticBody(this, a11);
        d11.setPosition(new Vec2(-72, -39));

        Shape a12 = new BoxShape(6, 0.3f);
        StaticBody d12 = new StaticBody(this, a12);
        d12.setPosition(new Vec2(-45, -52));

        Shape a13 = new BoxShape(6, 0.3f);
        StaticBody d13 = new StaticBody(this, a13);
        d13.setPosition(new Vec2(-72, -65));

        Shape a14 = new BoxShape(6, 0.3f);
        StaticBody d14 = new StaticBody(this, a14);
        d14.setPosition(new Vec2(-45, -78));

        Shape a16 = new BoxShape(6, 0.3f);
        StaticBody d16 = new StaticBody(this, a16);
        d16.setPosition(new Vec2(39, 39));

        Shape a17 = new BoxShape(6, 0.3f);
        StaticBody d17 = new StaticBody(this, a17);
        d17.setPosition(new Vec2(72, 39));

        Shape a18 = new BoxShape(6, 0.3f);
        StaticBody d18 = new StaticBody(this, a18);
        d18.setPosition(new Vec2(45, 26));

        Shape a19 = new BoxShape(6, 0.3f);
        StaticBody d19 = new StaticBody(this, a19);
        d19.setPosition(new Vec2(72, 13));

        Shape a20 = new BoxShape(6, 0.3f);
        StaticBody d20 = new StaticBody(this, a20);
        d20.setPosition(new Vec2(45, 0));

        Shape a21 = new BoxShape(6, 0.3f);
        StaticBody d21 = new StaticBody(this, a21);
        d21.setPosition(new Vec2(72, -13));

        Shape a22 = new BoxShape(6, 0.3f);
        StaticBody d22 = new StaticBody(this, a22);
        d22.setPosition(new Vec2(45, -26));

        Shape a23 = new BoxShape(6, 0.3f);
        StaticBody d23 = new StaticBody(this, a23);
        d23.setPosition(new Vec2(72, -39));

        Shape a24 = new BoxShape(6, 0.3f);
        StaticBody d24 = new StaticBody(this, a24);
        d24.setPosition(new Vec2(45, -52));

        Shape a25 = new BoxShape(6, 0.3f);
        StaticBody d25 = new StaticBody(this, a25);
        d25.setPosition(new Vec2(72, -65));

        Shape a26 = new BoxShape(6, 0.3f);
        StaticBody d26 = new StaticBody(this, a26);
        d26.setPosition(new Vec2(45, -78));



        //red tiles
        for(int i = 0; i < 79; i++){
            LavaTiles b1 = new LavaTiles(this, game, this);
            b1.setPosition(new Vec2((float) (-78+i*0.5),-78f));}

        for(int i = 0; i < 79; i++){
            LavaTiles b2 = new LavaTiles(this, game, this);
            b2.setPosition(new Vec2((float) (39+i*0.5),-78f));}

        // wig

        Wig wig = new Wig(this, this);
        wig.setPosition(new Vec2(100, -50));


    }


    public void populate(Game game){
        super.populate(game);
        // Hero methods
        getFatLady().setPosition(new Vec2(-70, -45));


        // Enemies
        boss = new Boss(this, this, game, this.getFatLady());
        boss.setPosition(new Vec2(0, -70));


        eye1 = new BossEye(this, this, game, getFatLady());
        eye1.setPosition(new Vec2(-31, -58));
        eye2 = new BossEye(this, this, game, getFatLady());
        eye2.setPosition(new Vec2(31, -58));
        eye3 = new BossEye(this, this, game, getFatLady());
        eye3.setPosition(new Vec2(0, -46));
        eye4 = new BossEye(this, this, game, getFatLady());
        eye4.setPosition(new Vec2(-25, -34));
        eye5 = new BossEye(this, this, game, getFatLady());
        eye5.setPosition(new Vec2(25, -34));
        eye6 = new BossEye(this, this, game, getFatLady());
        eye6.setPosition(new Vec2(0, -22));
        eye7 = new BossEye(this, this, game, getFatLady());
        eye7.setPosition(new Vec2(-19, -10));
        eye8 = new BossEye(this, this, game, getFatLady());
        eye8.setPosition(new Vec2(19, -10));
        eye9 = new BossEye(this, this, game, getFatLady());
        eye9.setPosition(new Vec2(0, 2));
        eye10= new BossEye(this, this, game, getFatLady());
        eye10.setPosition(new Vec2(-13, 14));
        eye11 = new BossEye(this, this, game, getFatLady());
        eye11.setPosition(new Vec2(13, 14));
        eye12 = new BossEye(this, this, game, getFatLady());
        eye12.setPosition(new Vec2(0, 26));
        game.getView().writeForeground("POKEY EYES !!!");

    }



    @Override
    public boolean isComplete() {
        return complete;
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
        Image background = new ImageIcon("data/lvl7.jpg").getImage();
        return background;
    }

    public JLabel playerTips() {
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 11));

        label.setText("<html>" +
                "<body width='170'><h2>Game Tips:</h2>\n" +
                "<p>\n" +
                "Avoid bullets jumping on platforms. " +
                "Kill all the eyes to win. " +
                "They cast curses and shoot." +
                "</html>");
        return label;

    }
    @Override
    public String getLevelName() {
        return "L11";
    }
}