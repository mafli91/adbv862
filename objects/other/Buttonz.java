package game.used.objects.other;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.used.eventListeners.lvl567.ButtonOrder;
import game.used.eventListeners.lvl567.DoorListener;
import game.used.eventListeners.lvl567.DoorNextLevel;
import game.used.levels.GameLevels;
import game.used.world.Game;

import java.awt.*;
import java.io.Serializable;

/**
 * Interactive 'button' object class
 * @see game.used.eventListeners.lvl567.ButtonListener
 * @see ButtonOrder
 * @see DoorListener
 * @see DoorNextLevel
 */
public class Buttonz extends StaticBody implements Serializable {

    private Game game;
    private GameLevels level;
    /**
     * @param button shape of the button
     */
    private static Shape button = new CircleShape(2.5F);

    /**
     * @param activated button has been activated
     */
    private boolean activated = false;
    /**
     * @param open button has opened the door
     */
    private boolean open = false;
    /**
     * @param hitCount button's "life count"
     */
    private int hitCount = 0;
    public Buttonz(World w, Game game, GameLevels level) {
        super(w, button);
        this.game = game;
        this.level = level;
        this.setLineColor(Color.BLUE);
        this.setFillColor(Color.blue);
        //this.colours();

    }


    /**counts times button been hit
     * if 4-5 times is activated, over 6 hits it will be deactivated and counter resets
     * @param i int value to increment by hit count
     */
    public void gotHit(int i){
        this.hitCount = hitCount + i;
        if (hitCount > 3 && hitCount <6){
            this.activated = true;
        } if (hitCount > 6){
            this.setFillColor(Color.blue);
            this.activated = false;
            this.hitCount = 0;
        }
    }

    /** checks if  button activated
     *
     * @return activated
     */
    public boolean isActivated() {
        return activated;
    }

    /**
     * changes activated to new value
     * @param activated new value of boolean activated
     */
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    /** makes button 'open', used for interaction with 'door to next level' */
    public boolean isOpen() {
        return open;
    }

    /**
     * set's button to open
     * @param open new value for boolean open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }


}
