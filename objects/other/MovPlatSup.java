package game.used.objects.other;

import city.cs.engine.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * A dot used to support moving platforms, create their collisions
 @see MovPlat
 @see game.used.eventListeners.otherLevels.MovingPDown
 @see game.used.eventListeners.otherLevels.MovingPUp
 @see game.used.eventListeners.otherLevels.MovingPHor
 */

public class MovPlatSup extends StaticBody implements Serializable {

    public MovPlatSup(World w)  {
        super(w, dot);
    }

    private static Shape dot = new CircleShape((float) 0.006);


}
