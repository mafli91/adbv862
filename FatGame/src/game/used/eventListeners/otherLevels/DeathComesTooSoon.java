package game.used.eventListeners.otherLevels;

import city.cs.engine.DestructionEvent;
import city.cs.engine.DestructionListener;
import game.used.levels.GameLevels;
import game.used.objects.enemy.boss.BossAttacks;
import game.used.objects.hero.Hero;
import game.used.world.Game;

import java.io.Serializable;

/**
 * Destruction listener for Hero in case of death sends player to beginning of the game
 *
 * @see Hero
 * @see Game
 */

public class DeathComesTooSoon implements DestructionListener, Serializable {

    private Game game;
    private Hero chub;
    private GameLevels level;


    public DeathComesTooSoon( Game game, Hero chub, GameLevels level) {

        this.game = game;
        this.chub = chub;
        this.level = level;

    }

    @Override
    public void destroy(DestructionEvent death) {
        if (death.getSource()== chub)
            game.goToZero();
    }
}
