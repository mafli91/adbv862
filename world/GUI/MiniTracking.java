package game.used.world.GUI;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;
import game.used.objects.hero.Hero;
import org.jbox2d.common.Vec2;

import java.io.Serializable;


/**
 * Makes tracking for the mini view in the bottom right corner
 */

public class MiniTracking implements StepListener, Serializable {
    private Hero lady;
    private UserView view;
    public MiniTracking(UserView view, Hero lady) {
        this.view = view;
        this.lady = lady;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(lady.getPosition()));
    }
    public void updateHero( Hero l) {
        this.lady=l;
    }
}