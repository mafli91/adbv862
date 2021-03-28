package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.objects.hero.Hero;
import game.used.objects.other.MovPlat;

import java.io.Serializable;

/**
 *  Checks if you're on moving platform
 *
 * @see Hero
 * @see MovPlat
 */

public class IsOnPlatform implements CollisionListener, Serializable {

    private Hero lady;
    public IsOnPlatform (Hero lady) {this.lady = lady;}

    @Override
    public void collide(CollisionEvent is) {
        if (is.getOtherBody() instanceof MovPlat)
            this.lady.setOnPlatform(true);
        else this.lady.setOnPlatform(false);
    }

    public void updateHero( Hero h){
        this.lady = h;
    }
}
