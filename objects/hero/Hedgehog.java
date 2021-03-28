package game.used.objects.hero;

import city.cs.engine.*;
import game.used.eventListeners.otherLevels.AttacksHitWall;
import game.used.levels.GameLevels;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.Serializable;

/**
 * creates an object Hedgehog
 * @see Attacks
 * @see HedgeSpike
 */
public class Hedgehog extends Attacks implements Serializable {

    private Hero lady;
    private Game game;
    private GameLevels level;
    private static final Shape hedge = new PolygonShape(
            -0.72f,-0.88f, 0.82f,-0.89f, 1.16f,0.42f, -0.88f,0.44f);

    private static final BodyImage left = ExceptionHandling.catchError("data/hedgeL.png", "" +
            "Hedgehog facing left", 5f );


    private static final BodyImage right = ExceptionHandling.catchError("data/hedgeR.png", "" +
            "Hedgehog facing right", 5f );
    /**
     * @param hedge soundclip for Hedgehod
     */
    private static SoundClip hedgeh;
    static {
        try {
            hedgeh = new SoundClip("data/sound/hedgeh.mp3");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
            ExceptionHandling.gameMusicHandling(hedgeh, "Hedgehog sound");
        }}

    // Spike positioning
    private Vec2 position;
    // x1-4 & y1-4 store x and y positions for spikes
    private float x1;
    private float x2;
    private float x3;
    private float x4;
    private float y1;
    private float y2;
    private float y3;
    private float y4;
    // hedgehog explosion radius
    private float r = 1;
    //timer int value
    int seconds = 0;



    public Hedgehog(World world, Hero lady, Game game, GameLevels level) {
        super(world, hedge);
        this.lady = lady;
        this.game = game;
        this.level = level;
        setGravityScale(0);
        attackTask();
        hedgeh.play();
    }

    /**
     * destroys object and creates spikes bomb, if lollipopCount of
     * Booma >3 there will be two explosions
     */
    public void attackTask() {
        javax.swing.Timer footTimer = new javax.swing.Timer( 2000 , e -> {
            seconds++;
            this.positioning();
            this.spikeMaking();
            if (lady.getLollipopCount()>3)
                this.spikeMaking();
            this.destroy();
        });
        footTimer.setRepeats( false );
        footTimer.start();
    }
    public static BodyImage getLeft() {
        return left;
    }

    public static BodyImage getRight() {
        return right;
    }

    /**
     * calculates positions for setting spikes upon explosion
     */
    private void positioning(){
        position = this.getPosition();
        x1 = position.x;
        x2 = (float) (position.x+(r/Math.sqrt(2)));
        x3 = position.x + r;
        x4 = (float) (position.x-(r/Math.sqrt(2)));
        y1 = position.y;
        y2 = (float) (position.y+(r/Math.sqrt(2)));
        y3 = position.y - r;
        y4 = (float) (position.y-(r/Math.sqrt(2)));
    }

    /**
     * creates explosion of spikes using positions from positioning()
     * result are 8 HedgeSpikes in a circle spaced evenly
     */
    private void spikeMaking(){
        HedgeSpike spike1 = new HedgeSpike(this.getWorld());
        spike1.setPosition(new Vec2(x1,y1+r));
        spike1.setLinearVelocity(new Vec2(0, 20));
        spike1.addCollisionListener(new AttacksHitWall(game, level));
        spike1.rotateDegrees(315);

        HedgeSpike spike2 = new HedgeSpike(this.getWorld());
        spike2.setPosition(new Vec2(x2,y2));
        spike2.setLinearVelocity(new Vec2(20, 20));
        spike2.addCollisionListener(new AttacksHitWall(game, level));
        spike2.rotateDegrees(270);

        HedgeSpike spike3 = new HedgeSpike(this.getWorld());
        spike3.setPosition(new Vec2(x3,y1));
        spike3.setLinearVelocity(new Vec2(20, 0));
        spike3.addCollisionListener(new AttacksHitWall(game, level));
        spike3.rotateDegrees(225);

        HedgeSpike spike4 = new HedgeSpike(this.getWorld());
        spike4.setPosition(new Vec2(x4,y4));
        spike4.setLinearVelocity(new Vec2(20, -20));
        spike4.addCollisionListener(new AttacksHitWall(game, level));
        spike4.rotateDegrees(180);

        HedgeSpike spike5 = new HedgeSpike(this.getWorld());
        spike5.setPosition(new Vec2(x1,y3));
        spike5.setLinearVelocity(new Vec2(0, -20));
        spike5.addCollisionListener(new AttacksHitWall(game, level));
        spike5.rotateDegrees(135);

        HedgeSpike spike6 = new HedgeSpike(this.getWorld());
        spike6.setPosition(new Vec2(x4,y4));
        spike6.setLinearVelocity(new Vec2(-20, -20));
        spike6.addCollisionListener(new AttacksHitWall(game, level));
        spike6.rotateDegrees(90);

        HedgeSpike spike7 = new HedgeSpike(this.getWorld());
        spike7.setPosition(new Vec2(x1-r,y1));
        spike7.setLinearVelocity(new Vec2(-20, 0));
        spike7.addCollisionListener(new AttacksHitWall(game, level));
        spike7.rotateDegrees(45);

        HedgeSpike spike8 = new HedgeSpike(this.getWorld());
        spike8.setPosition(new Vec2(x4,y2));
        spike8.setLinearVelocity(new Vec2(-20, 20));
        spike8.addCollisionListener(new AttacksHitWall(game, level));
        spike8.rotateDegrees(0);
    }

    @Override
    public void destroy(){
        super.destroy();
    }
}