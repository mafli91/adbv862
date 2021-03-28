package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.FatFairy;
import game.used.objects.hero.Hero;
import game.used.objects.other.MovPlat;
import game.used.world.Game;

import java.io.Serializable;

/**
 *  Sets gravity of moving platform to negative effectively making it fly up with hero
 *
 * @see MovPlat
 * @see game.used.objects.other.MovPlatSup
 *
 */

public class MovingPUp implements CollisionListener, Serializable {
    private MovPlat platform;
    private Game game;
    private GameLevels level;

    public MovingPUp(Game game, GameLevels level, MovPlat platform) {
        this.platform = platform;
        this.level = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent moving) {
        if (moving.getOtherBody() instanceof Hero) {
            this.platform.setGravityScale(-15);

        }

    }
}
