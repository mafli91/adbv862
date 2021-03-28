package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.objects.enemy.Dog;
import game.used.objects.other.WalkChecks;

/**
 * Class checks if dog collided with the class walkchecks and if yes turns him around
 * @deprecated
 */

public class DogWalk implements CollisionListener {
    private Dog dog;

    public DogWalk(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void collide(CollisionEvent walk) {
        if (walk.getOtherBody() instanceof WalkChecks) {
            this.dog.stopWalking();
            this.dog.setSpeed(-1 * this.dog.getSpeed());
            this.dog.startWalking(this.dog.getSpeed());
        }


    }
}
