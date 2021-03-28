package game.used.eventListeners.lvl567;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.Attacks;
import game.used.objects.other.Buttonz;
import game.used.world.Game;

import java.awt.*;
import java.io.Serializable;

/**
 *
 * Class to make a simple puzzle game in level 7 using 4 buttons
 * checks if buttons are activated in the right order, otherwise resets them
 * though color change makes it easy to guess
 *
 * @see Buttonz
 * @see ButtonListener
 * @see DoorListener
 * @see DoorNextLevel
 */

public class ButtonOrder implements CollisionListener, Serializable {

    private Game game;
    private GameLevels level;
    private Buttonz button1;
    private Buttonz button2;
    private Buttonz button3;
    private Buttonz button4;

    public ButtonOrder(Game game, GameLevels level, Buttonz button1,
                       Buttonz button2, Buttonz button3, Buttonz button4) {
        this.level = level;
        this.game = game;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;

    }


    @Override
    public void collide(CollisionEvent shot) {
        //checks if shot
        if (shot.getOtherBody() instanceof Attacks) {
            //checks which button
            if (shot.getReportingBody() == button1) {
                this.button1.gotHit(4);
                // checks if in the right order
                if (button4.isOpen() && button2.isOpen() &&
                        button3.isOpen() && button1.isActivated()) {
                    button1.setOpen(true);
                    button1.setFillColor(Color.magenta);
                } else {
                    //else resets two other
                    button2.setOpen(false);
                    button3.setOpen(false);
                    button2.setActivated(false);
                    button3.setActivated(false);
                    button2.setFillColor(Color.blue);
                    button3.setFillColor(Color.blue);
                }
            } else if (shot.getReportingBody() == button2) {
                this.button2.gotHit(4);
                if (button3.isOpen() && button2.isActivated()) {
                    button2.setOpen(true);
                    button2.setFillColor(Color.magenta);
                } else {
                    button1.setOpen(false);
                    button4.setOpen(false);
                    button1.setActivated(false);
                    button4.setActivated(false);
                    button1.setFillColor(Color.blue);
                    button4.setFillColor(Color.blue);
                }
            } else if (shot.getReportingBody() == button3) {
                this.button3.gotHit(4);
                if (button3.isActivated()) {
                    button3.setOpen(true);
                    button3.setFillColor(Color.magenta);
                } else {
                    button1.setOpen(false);
                    button2.setOpen(false);
                    button4.setOpen(false);
                    button1.setActivated(false);
                    button2.setActivated(false);
                    button4.setActivated(false);
                    button1.setFillColor(Color.blue);
                    button2.setFillColor(Color.blue);
                    button4.setFillColor(Color.blue);
                }
            } else if (shot.getReportingBody() == button4) {
                this.button4.gotHit(4);
                if (button2.isOpen() && button3.isOpen() && button4.isActivated()) {
                    button4.setOpen(true);
                    button4.setFillColor(Color.magenta);
                } else {
                    button1.setOpen(false);
                    button3.setOpen(false);
                    button1.setActivated(false);
                    button3.setActivated(false);
                    button1.setFillColor(Color.blue);
                    button3.setFillColor(Color.blue);
                }
            }
        }
    }
}
