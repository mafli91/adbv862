package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Bat;
import game.used.objects.enemy.Enemy;
import game.used.objects.other.WalkChecks;
import game.used.world.Game;

import java.io.Serializable;

/** the thread of timer correction of walking with this class used to cause deadlock;
 * to make enemies turn around when on the check platforms, or if bat, in contact with things
 *
 * @see Enemy
 * @see Bat
 */

public class EnemyWalk implements CollisionListener, Serializable {

    private Game game;
    private GameLevels level;
    private Enemy enemy;


    public EnemyWalk(Game game, GameLevels level, Enemy enemy) {

        this.game = game;
        this.level = level;
        this.enemy = enemy;

    }


    @Override
    public void collide(CollisionEvent walk) {

        // if not bat
        if (!(enemy instanceof Bat)) {
                if (walk.getOtherBody() instanceof WalkChecks) {
                    this.enemy.stopWalking();
                    this.enemy.setSpeed(-1 * this.enemy.getSpeed());
                    this.enemy.itWalks();
                }
        }
        // if bat it will bounce off many things
        else if (walk.getOtherBody() instanceof StaticBody ||
                walk.getOtherBody() instanceof DynamicBody ||
                walk.getOtherBody() instanceof Enemy) {
            this.enemy.stopWalking();
            this.enemy.setSpeed(-1 * this.enemy.getSpeed());
                this.enemy.startWalking(this.enemy.getSpeed());
            }
        }
    }


