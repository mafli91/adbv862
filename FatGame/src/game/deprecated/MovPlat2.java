package game.deprecated;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @deprecated
 */
public class MovPlat2 extends StaticBody {

    public MovPlat2(World w) {
        super(w, moving);
        autodestruct();
    }

    private static float y = -8;
    private int seconds = 0;
    private int seconds2 = 0;
    private Vec2 position = this.getPosition();

    public static float getY() {
        return y;
    }

    public void setY(float y) {
        MovPlat2.y = y;
    }

    private static Shape moving = new BoxShape(6, 1f);


    private void setPos(Vec2 pos){
        this.position = pos;
    }
    private MovPlat2 moved;
    private void autodestruct() {
        Timer destroyTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                destroy();
            }
        };
        destroyTimer.schedule(task, 600);
    }

    public void move ( int a, int b) {

        Timer moveTimer = new Timer();
        TimerTask draw = new TimerTask() {
            @Override
            public void run() {
                seconds2++;
                moved = new MovPlat2(getWorld());
                if (moved.getPosition().x < a)
                    moved.setPosition(new Vec2((float) (position.x + 0.2),
                            position.y));
                else if (moved.getPosition().x > b)
                    moved.setPosition(new Vec2((float) (position.x - 0.2),
                            position.y));
                position = moved.getPosition();
            }
        };
        TimerTask erase = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                moved.destroy();
            }
        };
        moveTimer.scheduleAtFixedRate(draw, 450, 450);
        moveTimer.scheduleAtFixedRate(erase, 540, 540);
    }
}

