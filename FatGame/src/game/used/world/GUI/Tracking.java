package game.used.world.GUI;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.used.objects.hero.Hero;
import game.used.world.MyView;
import org.jbox2d.common.Vec2;

import java.io.Serializable;

/**
 * Makes tracking for the main view in the game
 */

public class Tracking implements StepListener, Serializable {
    private MyView view;
    private Hero lady;
    public Tracking(MyView view, Hero lady) {
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
    public void updateView ( MyView v){
        this.view = v;
    }


}