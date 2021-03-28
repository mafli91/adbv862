package game.used.objects.enemy;

import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.io.Serializable;

/**
 * Enemy super class; for examples of method usage see Wolf, Bat or Dog
 * @see Wolf
 * @see Dog
 * @see Bat
 */

public abstract class Enemy extends Walker implements Serializable {

    public boolean turned;


    public Enemy(World world) {
        super(world);
    }

    public Enemy(World world, Shape shape) {
        super(world, shape);
    }

    public abstract void turned(boolean b);
    public void setLife(int i) {}
    public int getLife() {
        return 0;
    }
    public int getSpeed() {
        return 0;
    }
    public void setSpeed(int i) {}
    public Vec2 getPos() {
        return null;
    }
    public void attack1() {}
    public void attack2() {}
    public void attack3() {}
    public void attack4() {}
    public void isShot() {}
    public abstract void setLollipopCount(int i);
    public void itWalks() {}
    public void collisionz() {}
    public void setEyeCount(int e) {}
}
