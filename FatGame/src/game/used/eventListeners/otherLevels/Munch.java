package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.collectable.FairyDust;
import game.used.objects.collectable.Lolly;
import game.used.objects.hero.Hero;
import game.used.world.Game;

import java.io.Serializable;

/**
 * Class checks if fat lady touched dust/lolly and if yes destroys it
 * and adds them to hero's stash
 *
 * @see Lolly
 * @see FairyDust
 * @see Hero
 */

public class Munch implements CollisionListener, Serializable {
    private FairyDust bun;
    private Lolly lolly;
    private Hero chub;
    private Game game;
    private GameLevels level;

    public Munch(Game game, GameLevels level, Hero chub) {
        this.chub = chub;
        this.level = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent eat) {
        if (eat.getOtherBody() instanceof FairyDust) {
            this.chub.getFatter();
            this.chub.setBurgerCount(chub.getBurgerCount()+1);
            eat.getOtherBody().destroy();
            game.appendLog("You gained more power, AMAZING!");

        } if (eat.getOtherBody() instanceof Lolly) {
            eat.getOtherBody().destroy();
            chub.setLollipopCount(chub.getLollipopCount()+1);
            game.appendLog("Extra barrier time for you! Use it wisely!");

        }

    }
}
