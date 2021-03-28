package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.objects.hero.Hero;
import game.used.objects.other.MovPlat;
import game.used.world.Game;

import java.io.Serializable;

/**
 *  makes a moving platform go down in contact with check point
 *
 * @see Hero
 * @see MovPlat
 * @see game.used.objects.other.MovPlatSup
 */

public class MovingPDown implements CollisionListener, Serializable {
    private MovPlat platform;
    private Game game;
    private Hero lady;
    public static boolean takingARide;

    public MovingPDown(Game game, Hero lady, MovPlat platform) {
        this.platform = platform;
        this.lady = lady;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent moving) {
        if (moving.getOtherBody() instanceof MovPlat) {
            this.platform.setGravityScale(1);
            this.lady.setOnPlatform(false);
        }

    }
}
