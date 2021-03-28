package game.used.world;

import city.cs.engine.UserView;
import city.cs.engine.World;
import game.used.objects.hero.Hero;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.io.Serializable;

/**
 * Makes the main view in the game that player interacts with
 * @see Game
 * @see Hero
 */

public class MyView extends UserView implements Serializable {

    private Game game;
    private Hero lady;
    private Image back;
    /**
     * @param string with string2 & 3 are values to be displayed on the view
     */
    private String string = "Come on then hottie";
    private String string2 = " ";
    private String string3 = " ";

    public MyView(World w, Game game, int width, int height, Hero lady) {
        // background picture
        super(w, width, height);
        this.game = game;
        this.lady = lady;
        //back = new ImageIcon("data/backstreet.jpg").getImage();
        // setting the centre of the view
        this.setCentre(new Vec2(0.5F, 3));
    }

    public void setBack(Image background) {
        this.back = background;
    }

    /**
     * sets string to be written at the bottom of the view
     * @param s string to be written
     */
    public void writeForeground(String s){
        this.string = s;
    }

    /**
     * sets string to be written at the top of the view
     * @param s string to be written
     */
    public void writeCredits(String s){ this.string2 = s; }

    /**
     * sets string to be written at the second to the top position of the view
     * @param s string to be written
     */
    public void writeCredits2(String s){ this.string3 = s; }


    @Override
    /**
     * creates the picture in the background */
    protected void paintBackground(Graphics2D g) {
        g.drawImage(back, 0, 0, this);    }

    @Override
    /**
     *  creates the text displayed at the bottom of the view */
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        g.setColor(Color.magenta);
        g.drawString("   LAYERS : " + lady.getLayers() + "   DUST : "
                + lady.getFat() + "    LOLLIES : "+ lady.getLollipopCount(), 15, 450);
        g.drawString(string, 15, 430);
        g.drawString(string2, 20, 25);
        g.drawString(string3, 20, 50);
    }

    /**
     * updates current level hero
     * @param l new hero value
     */
    public void updateHero (Hero l){
        this.lady = l;
    }

}
