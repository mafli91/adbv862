package game.used.objects.enemy.boss;

import city.cs.engine.*;
import game.used.levels.GameLevels;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Class creating Wig object
 * a joke in the game regarding the story
 * @see game.used.objects.other.ComicStrip8
 * @see game.used.objects.other.ComicStrip12
 */
public class Wig extends DynamicBody implements Serializable {

    /**
     * @param wigshape object's shape
     */
    private static final Shape wigshape = new PolygonShape(
            -1.2f,0.19f, 0.76f,0.21f, 0.66f,1.2f, -1.21f,1.25f);
    /**
     * @param image body image of the object
     */
    private static BodyImage image = ExceptionHandling.catchError("data/wig.png", "" +
            "Wig", 3.5f );
    private GameLevels level;
    /**
     * @param s s & s2 are timer's int values
     */
    private int s = 0;
    private int s2 =0;
    private int x;
    private int y;

    public Wig(World world, GameLevels level){
        super(world, wigshape);
        addImage(image);
        setGravityScale(20);
        this.level = level;
        this.putOnWig();
    }

    /**
     * every 2.5 s checks if Hero is within the range and calls wigOn
     */
    private void putOnWig() {
        javax.swing.Timer dtimer = new javax.swing.Timer(2500, e -> {
            s++;
            x = (int) Math.abs(level.getFatLady().getPosition().x - this.getPosition().x);
            y = (int) Math.abs(level.getFatLady().getPosition().y - this.getPosition().y);
            this.wigOn();
        });
        dtimer.setRepeats(true);
        dtimer.start();
    }

    /**
     * put's the wig on the hero and changes hero's gravity scale to 0
     * after 4s sends the wig flying and returns hero's normal gravity
     */
    private void wigOn(){
        if(x<33 && y<33){
            this.putOn(level.getFatLady());
            this.setGravityScale(0);
            level.getFatLady().setGravityScale(0);
            javax.swing.Timer timer = new javax.swing.Timer( 4000 , e -> {
                s2++;
                this.setLinearVelocity(new Vec2(20, 4));
                this.setGravityScale(20);
                level.getFatLady().setGravityScale(1);
            });
            timer.setRepeats( false );
            timer.start();
        }
    }

}