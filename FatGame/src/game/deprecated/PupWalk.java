package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.objects.enemy.Puppy;
import game.used.objects.other.WalkChecks;

/**
 * Class checks if pup collided with the class walkchecks and if yes turns him around
 * @deprecated
 */

public class PupWalk implements CollisionListener {
    private Puppy pup;

    public PupWalk(Puppy pup) {
        this.pup = pup;
    }

    @Override
    public void collide(CollisionEvent walk) {
        if (walk.getOtherBody() instanceof WalkChecks) {
            this.pup.stopWalking();
            this.pup.setSpeed(-1 * this.pup.getSpeed());
            this.pup.startWalking(this.pup.getSpeed());
        }


    }
}
