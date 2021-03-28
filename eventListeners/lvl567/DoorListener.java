package game.used.eventListeners.lvl567;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.Attacks;
import game.used.objects.hero.Hero;
import game.used.objects.other.Buttonz;
import game.used.world.Game;

import java.io.Serializable;

/** Listens if platform has been touched by player/ attacked to destroy it
 * if a button it's connected too has been activated
 *
 *@see Buttonz
 *@see ButtonListener
 *@see DoorNextLevel
 */
public class DoorListener  implements CollisionListener, Serializable {

    private Game game;
    private GameLevels level;
    private Buttonz button;

    public DoorListener(Game game, GameLevels level, Buttonz button) {
        this.level = level;
        this.game = game;
        this.button = button;
    }


    @Override
    public void collide(CollisionEvent shot) {
        if (this.button.isActivated()) {
            if (shot.getOtherBody() instanceof Attacks || shot.getOtherBody() instanceof Hero) {
                shot.getReportingBody().destroy();
            }
        }
    }
}
