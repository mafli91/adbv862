package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.FatFairy;
import game.used.objects.hero.Hero;
import game.used.world.Game;

import java.io.Serializable;

/**
 *  Lava tiles deal damage during contact and make you jump
 *
 * @see game.used.objects.other.LavaTiles
 */

public class FloorIsLava implements CollisionListener, Serializable {

    private Game game;
    private GameLevels level;
    private Hero hero;

    public FloorIsLava(Game game, GameLevels level, Hero hero) {
        this.level = level;
        this.game = game;
        this.hero = hero;
    }
    @Override
    public void collide(CollisionEvent burn) {
        if (burn.getOtherBody() instanceof Hero){
            hero.skinny(1);
            hero.jump(20);
            game.appendLog("Oh it burns! Floor IS lava!");
        }
    }
    public void updateHero( Hero h){
        this.hero = h;
    }
}
