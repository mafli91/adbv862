package game.used.objects.enemy.boss;

import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

import java.io.Serializable;

/**
 *  Class to join all of the bosses attacks in one group,
 *  makes using listeners easier
 */
public abstract class BossAttacks extends DynamicBody implements Serializable {

    public BossAttacks(World world, Shape shape) {
        super(world, shape);
    }

    public void attackTask() {
    }

}
