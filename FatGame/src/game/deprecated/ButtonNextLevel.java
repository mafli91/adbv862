package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.Attacks;
import game.used.objects.other.Buttonz;
import game.used.world.Game;

/**
 * @deprecated
 */
public class ButtonNextLevel implements CollisionListener {

    private Game game;
    private GameLevels level;
    private Buttonz button;

    public ButtonNextLevel(Game game, GameLevels level, Buttonz button) {
        this.level = level;
        this.game = game;
        this.button = button;
    }

    @Override
    public void collide(CollisionEvent shot) {
        if(shot.getOtherBody() instanceof Attacks){
            this.button.gotHit(1);
            if (button.isActivated())
                this.button.setOpen(true);
        }
    }
}
