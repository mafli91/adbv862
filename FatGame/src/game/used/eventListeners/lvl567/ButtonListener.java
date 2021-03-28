package game.used.eventListeners.lvl567;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.Attacks;
import game.used.objects.other.Buttonz;
import game.used.world.Game;

import java.awt.*;
import java.io.Serializable;

/**
 *
 * Class checks if buttons been shot to change their state and visual cue
 * @see Buttonz
 * @see ButtonOrder
 * @see DoorListener
 * @see DoorNextLevel
 */
public class ButtonListener implements CollisionListener, Serializable {

    private Game game;
    private GameLevels level;
    private Buttonz button;

    public ButtonListener(Game game, GameLevels level, Buttonz button) {
        this.level = level;
        this.game = game;
        this.button = button;
    }

    @Override
    public void collide(CollisionEvent shot) {
        if(shot.getOtherBody() instanceof Attacks) {
            this.button.gotHit(1);
            if (this.button.isActivated()) {
                this.button.setOpen(true);
                this.button.setFillColor(Color.magenta);
            } else
                this.button.setFillColor(Color.BLUE);
        }
    }
}
