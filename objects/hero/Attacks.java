package game.used.objects.hero;

import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

import java.io.Serializable;

/**
 * Hero attacks super class
 */
public abstract class Attacks extends DynamicBody implements Serializable {

    public Attacks(World world, Shape shape) {
        super(world, shape);
    }

    public void attackTask() {}

}
