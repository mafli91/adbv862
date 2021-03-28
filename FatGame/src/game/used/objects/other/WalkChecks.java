package game.used.objects.other;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class to make the walls that are used for collision checks
 * @see game.used.eventListeners.otherLevels.EnemyWalk
 * @see game.used.objects.enemy.Enemy
 */


public class WalkChecks extends StaticBody implements Serializable {

    public WalkChecks(World w) {
        super(w, check);
    }

    private static Shape check = new BoxShape(3, 0.301f);


    }

