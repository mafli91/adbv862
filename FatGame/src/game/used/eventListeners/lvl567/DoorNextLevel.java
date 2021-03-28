package game.used.eventListeners.lvl567;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.Hero;
import game.used.objects.other.Buttonz;
import game.used.world.Game;

import java.io.Serializable;

/**  Checks if the right button has been activated,
 * if yes send the player to the next level
 *
 * @see Buttonz
 * @see ButtonListener
 * @see ButtonOrder
 * */
public class DoorNextLevel  implements CollisionListener, Serializable {

    private Game game;
    private GameLevels level;
    private Buttonz button;

    public DoorNextLevel(Game game, GameLevels level, Buttonz button) {
        this.level = level;
        this.game = game;
        this.button = button;
    }


    @Override
    public void collide(CollisionEvent shot) {
        if (this.button.isActivated())
            if (button.isOpen() && shot.getOtherBody() instanceof Hero)
                game.goToNextLevel();
            }
        }

