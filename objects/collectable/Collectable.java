package game.used.objects.collectable;

import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

import java.io.Serializable;

/**
 * Collectables belong to this class
 * @see game.used.eventListeners.otherLevels.Munch
 * @see FairyDust
 * @see Lolly
 */
public abstract class Collectable extends DynamicBody implements Serializable {
    public Collectable(World world, Shape shape) {
        super(world, shape);
    }

    /**
     * applies torque to object, uses timer to change it's value
     */
    public void foodTorque() {} // to make collectables shake a bit
}
