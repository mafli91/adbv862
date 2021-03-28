package game.used.objects.other;

import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

import java.io.Serializable;

/**
 * Abstract class ComicStrip as a base for ComicStrip0,8,10,12. For description of methods see ComicStrip10.
 * @see ComicStrip10
 * @see ComicStrip0
 * @see ComicStrip12
 * @see ComicStrip8
 */

public abstract class ComicStrip extends StaticBody implements Serializable {

    public ComicStrip(World world, Shape shape) {
        super(world, shape);
    }

    public abstract int getSwapCount();
    public abstract void swapPic();

}