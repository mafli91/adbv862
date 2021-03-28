package game.used.objects.other;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.Serializable;

/**
 * ComicStrip class for level 10.
 * @see ComicStrip
 */

public class ComicStrip10 extends ComicStrip implements Serializable {

    /**
     * @param shape shape of the object
     */
    private static Shape shape = new BoxShape(40, 26);

    /**
     * @param image1 an image being a page 1 in the comic
     */
    private static final BodyImage image1 = ExceptionHandling.catchError("data/CCC1.png", "" +
            "Comic strip L10 part 1", 42f );
    /**
     * @param image2 an image being a page 2 in the comic
     */
    private static final BodyImage image2 = ExceptionHandling.catchError("data/CCC2.png", "" +
            "Comic strip L10 part 2", 42f );
    /**
     * @param image3 an image being a page 3 in the comic
     */
    private static final BodyImage image3 = ExceptionHandling.catchError("data/CCC3.png", "" +
            "Comic strip L10 part 3", 42f );

    /**
     * @param i1 attached body image for image1
     */
    private AttachedImage i1;
    private AttachedImage i2;
    private AttachedImage i3;


    private Game game;

    /**
     * counts page swapping by pressing enter to show next picture
     * @see game.used.world.FatControl
     */
    private int swapCount = 1;

    public ComicStrip10(World w, Game game) {
        super(w, shape);
        this.game = game;
        this.swapPic();
    }

    /**
     * set swap count
     * @param i increment swap count by i
     */
    public void setSwapCount(int i){
        this.swapCount = swapCount +1;
    }

    /**
     * get swapCount
     * @return swapCount
     */
    @Override
    public int getSwapCount() {
        return swapCount;
    }

    /**
     * using switch changes attached body images depending on the swapCount to show
     * next page in the comic;
     */
    public void swapPic(){
        switch (swapCount){
            case 1:
                this.removeAllImages();
                i1 = new AttachedImage(this, image1, 1, 0, new Vec2(0,0));
                break;
            case 2:
                this.removeAllImages();
                i2 = new AttachedImage(this, image2, 1, 0, new Vec2(0,0));
                break;
            case 3:
                this.removeAllImages();
                i3 = new AttachedImage(this, image3, 1, 0, new Vec2(0,0));
                break;
            case 4:
                break;
        }

    }

}
