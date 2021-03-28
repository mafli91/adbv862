package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.other.MovPlat;
import game.used.world.Game;

import java.io.Serializable;

/**
 *  Makes moving platform start moving [walking] the other way upon contact with check point
 *
 * @see MovPlat
 * @see game.used.objects.other.MovPlatSup
 */

public class MovingPHor implements CollisionListener, Serializable {
    private MovPlat platform;
    private Game game;
    private GameLevels level;


    public MovingPHor(Game game, GameLevels level, MovPlat platform) {
        this.platform = platform;
        this.level = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent moving) {
        if (moving.getOtherBody() instanceof MovPlat && platform.getWalking()) {
            this.platform.stopWalking();
            this.platform.setY(-1 * MovPlat.getY());
            this.platform.startWalking(MovPlat.getY());
        }

    }
}
