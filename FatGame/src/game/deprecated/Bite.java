package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Dog;
import game.used.objects.hero.FatFairy;
import game.used.objects.enemy.Puppy;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

/**
 * Class for dog biting when touched
 * @deprecated
 */

public class Bite implements CollisionListener {

    private final Game game;
    private final GameLevels level;
    private Dog dog;
    private FatFairy chub;

    public Bite(Game game, GameLevels level, Dog dog, FatFairy chub) {

        this.game = game;
        this.level = level;
        this.chub = chub;
        this.dog = dog;

    }

    //collision between fat lady and the dog
    @Override
    public void collide(CollisionEvent bite) {
        if (bite.getOtherBody() == chub && bite.getReportingBody() == dog) {
            chub.skinny(1);
            dog.jump(6);
        } else if (bite.getOtherBody() == chub && (bite.getReportingBody() instanceof Puppy)) {
            chub.applyForce(new Vec2(40, 1), new Vec2(0, 0));
            System.out.println("Playing puppy dragged you away from a burger...");
            System.out.println("... and that's why you hate dogs.");
        }

    }
}
