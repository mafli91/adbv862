package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.FatFairy;
import game.used.objects.other.MovPlat;
import game.used.world.Game;

/**
 * @deprecated
 */
public class OddPlatform implements CollisionListener {
    private MovPlat platform;
    private Game game;
    private GameLevels level;

    public OddPlatform(Game game, GameLevels level, MovPlat platform) {
        this.platform = platform;
        this.level = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent moving) {
        if (moving.getOtherBody() instanceof FatFairy) {
            this.platform.setGravityScale(-5);
        }

    }
}
