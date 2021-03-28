package game.used.world;

import city.cs.engine.WorldView;
import game.used.eventListeners.otherLevels.AttacksHitWall;
import game.used.levels.GameLevels;
import game.used.levels.Lvl1;
import game.used.levels.Lvl2;
import game.used.levels.Lvl3;
import game.used.objects.hero.*;
import game.used.objects.other.MovPlatSup;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.Serializable;

/**
 * Makes mouse control possible in the game
 * @see Game
 * @see FatFairy
 * @see BlueFairy
 * @see Spell
 * @see Puff
 * @see Butterfly
 * @see GameLevels
 * @see Hero
 */

public class MouseHandler extends MouseAdapter implements Serializable {

    private WorldView view;
    private Spell spell;
    private Puff puff;
    private Butterfly butterfly;
    private GameLevels level;
    private Game game;
    private Hero lady;
    private Vec2 v;
    private float x;// hero pos
    private float y;// hero pos
    private int maxZoom = 11; //max min zoom
    private int minZoom = 9;
    private double alfa;//angle between mouse and hero
    private Vec2 bulletStart;


    public MouseHandler(GameLevels level, WorldView view, Game game, Hero lady) {
        this.view = view;
        this.level = level;
        this.game = game;
        this.lady = lady;
    }

    /**
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            /** spawns spell bullet upon pressing the mouse L
            //create a dot to get coordinates in the world */
            dotSpawn(e);
            if (level instanceof Lvl1 ||level instanceof Lvl2 ||level instanceof Lvl3) {}
            //do nothing
            else {
                bulletStart = new Vec2((float) (4 * Math.cos(alfa)) + x,
                        (float) (4 * Math.sin(alfa)) + y);
                spell = new Spell(view.getWorld());
                spell.setPosition(bulletStart);
                spell.setAngle((float) alfa);
                // normalise bullet speed based on spawn distance
                spell.setLinearVelocity(new Vec2((float) (22 * Math.cos(alfa)),
                        (float) (22 * Math.sin(alfa))));
                spell.addCollisionListener(new AttacksHitWall(game, level));
            }

        }
            else{
            /** spawns puff bullet upon pressing the mouse R if hero is FatFairy
            // if it's BlueFairy spawns a butterfly
            //create a dot to get coordinates in the world */
            dotSpawn(e);
            if (level instanceof Lvl1) {}
            //do nothing
            else {
                bulletStart = new Vec2((float) (3 * Math.cos(alfa)) + x,
                        (float) (3 * Math.sin(alfa)) + y);

                if (lady instanceof FatFairy) {
                    puff = new Puff(view.getWorld(), lady);
                    puff.setPosition(bulletStart);
                    puff.setAngle((float) alfa);
                    // normalise bullet speed based on spawn distance
                    puff.setLinearVelocity(new Vec2((float) (10 * Math.cos(alfa)),
                            (float) (10 * Math.sin(alfa))));
                    puff.addCollisionListener(new AttacksHitWall(game, level));
                } else {
                    butterfly = new Butterfly(view.getWorld());
                    butterfly.setPosition(bulletStart);
                    butterfly.setAngle((float) alfa);
                    // normalise bullet speed based on spawn distance
                    butterfly.setLinearVelocity(new Vec2((float) (16 * Math.cos(alfa)),
                            (float) (16 * Math.sin(alfa))));
                    butterfly.addCollisionListener(new AttacksHitWall(game, level));
                }
            }

        }

    }
    /** method that translates position of the mouse into coordinates used for shooting
    // and calculates angle alfa for shooting ant rotating bullets */
    private void dotSpawn(MouseEvent e) {
        //dot = new MovPlatSup(view.getWorld());
        v = new Vec2(view.viewToWorld(e.getPoint()));
        x = lady.getPosition().x;
        y = lady.getPosition().y;
        if ((v.x-x) >0 )
            alfa = Math.atan((v.y-y)/(v.x-x));
        else
            alfa = Math.atan((v.y-y)/(v.x-x)) - Math.PI;

    }

    private void checkCoordinates(){
        /* Check the coordinates for casting spell
         * by uncommenting this method;
         * alfa is an angle between hero and the mouse position e
         * bulletStart is position where bullet gets spawned
         * it's in some distance R from the hero itself
         *
         * System.out.println("alfa = " + alfa + " bulletStart = "
         *              + bulletStart);
         *
         * allows to get an exact position of a place on the map
         * that was clicked by a mouse; useful to get coordinated for placing
         * bodies on the map
         *
         * System.out.println("  X =" + dot.getPosition().x +
         *       "  Y = " + dot.getPosition().y);*/
    }

    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        /** make the mouse wheel change zoom by values max and min zoom */
        super.mouseWheelMoved(e);
        if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
            if (maxZoom > 0 && e.getWheelRotation() > 0) {
                view.setZoom(view.getZoom() + 1);
                maxZoom--;
                minZoom++;
            } else if (minZoom > 0 && e.getWheelRotation() < 0) {
                view.setZoom(view.getZoom() - 1);
                maxZoom++;
                minZoom--;
            }
        }
    }

    // UPDATE HERO FOR LEVEL
    public void updateHero (Hero l) {this.lady = l; }
    public void updateLevel ( GameLevels l){
        this.level = l;
    }

    public void mouseMoved (MouseEvent e){
        /* unused method
         * allows moving the view with mouse position if tracking is off
        x = level.getFatLady().getPosition().x;
        y = level.getFatLady().getPosition().y;
        x1 = e.getPoint().x;
        y1 = e.getPoint().y;
        if ((level.getFatLady().getPosition().sub(new Vec2(x1,y1))).length() < 40)
            view.setCentre(new Vec2(e.getPoint().x, e.getPoint().y)); */
    }

    /* unused method to substitute bullet speed normalisation
     * in case particular speed value is needed instead of rough
     * value provided by radius * bulletStart
     *
     public void bulletSpeed(){
        if (x>0)
            x = x+30;
        if (x<0)
            x = x-30;
        if (y>0)
            y = y+30;
        if (y<0)
            y = y-30;
    } */

}