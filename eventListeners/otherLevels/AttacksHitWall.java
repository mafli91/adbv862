package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Enemy;
import game.used.objects.enemy.boss.BossSpell;
import game.used.objects.enemy.boss.Heel;
import game.used.objects.hero.Attacks;
import game.used.world.Game;

import java.io.Serializable;

/** collisions between attacks and other bodies
 *checks if objects of class Attacks, Heel and BossSpell
 * hit staticBody or Enemy
 *
 * @see Enemy
 * @see Attacks
 * @see Heel
 * @see BossSpell
 * */


public class AttacksHitWall implements CollisionListener, Serializable {
    private GameLevels level;
    private Game game;
    public AttacksHitWall(Game game, GameLevels level) {

        this.game = game;
        this.level = level;
    }

    @Override
    public void collide(CollisionEvent hitWall) {
        // attacks will be deflected by all bodies but Static and Enemies
        if (hitWall.getReportingBody() instanceof Attacks) {
            if ((hitWall.getOtherBody() instanceof StaticBody) || (hitWall.getOtherBody() instanceof Enemy))
                hitWall.getReportingBody().destroy();
        }
        // some boss' attacks will also be destroyed
        else if (hitWall.getReportingBody() instanceof Heel ||
                hitWall.getReportingBody() instanceof BossSpell) {
            if (hitWall.getOtherBody() instanceof StaticBody)
                hitWall.getReportingBody().destroy();
        }
    }
}
