package game.used.objects.other;

import city.cs.engine.*;
import game.used.levels.GameLevels;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.Serializable;
/**
 * ComicStrip class for level 0.
 * @see ComicStrip
 */
public class ComicStrip0 extends ComicStrip implements Serializable {

    private static Shape shape = new BoxShape(40, 26);

    private static final BodyImage image1 = ExceptionHandling.catchError("data/C1.png", "" +
            "Comic strip L0 part 1", 42f );
    private static final BodyImage image2 =ExceptionHandling.catchError("data/C2.png", "" +
            "Comic strip L0 part 2", 42f );
    private static final BodyImage image3 =ExceptionHandling.catchError("data/C3.png", "" +
            "Comic strip L0 part 3", 42f );
    private static final BodyImage image4 =ExceptionHandling.catchError("data/C4.png", "" +
            "Comic strip L0 part 4", 42f );
    private static final BodyImage image5 =ExceptionHandling.catchError("data/C5.png", "" +
            "Comic strip L0 part 5", 42f );
    private static final BodyImage image6 =ExceptionHandling.catchError("data/C6.png", "" +
            "Comic strip L0 part 6", 42f );
    private static final BodyImage image7 =ExceptionHandling.catchError("data/C7.png", "" +
            "Comic strip L0 part 7", 42f );
    private static final BodyImage image8 =ExceptionHandling.catchError("data/C8.png", "" +
            "Comic strip L0 part 8", 42f );
    private static final BodyImage image9 =ExceptionHandling.catchError("data/C9.png", "" +
            "Comic strip L0 part 9", 42f );
    private static final BodyImage image10 =ExceptionHandling.catchError("data/C10.png", "" +
            "Comic strip L0 part 10", 42f );

    private AttachedImage i1;
    private AttachedImage i2;
    private AttachedImage i3;
    private AttachedImage i4;
    private AttachedImage i5;
    private AttachedImage i6;
    private AttachedImage i7;
    private AttachedImage i8;
    private AttachedImage i9;
    private AttachedImage i10;

    private Game game;

    private int swapCount = 1;

    public ComicStrip0(World w, Game game) {
        super(w, shape);
        this.game = game;
        this.swapPic();
    }

    public int getSwapCount(){
        return swapCount;
    }
    public void setSwapCount(int i){
        this.swapCount = swapCount +i;
    }

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
                this.removeAllImages();
                i4 = new AttachedImage(this, image4, 1, 0, new Vec2(0,0));
                break;
            case 5:
                this.removeAllImages();
                i5 = new AttachedImage(this, image5, 1, 0, new Vec2(0,0));
                break;
            case 6:
                this.removeAllImages();
                i6 = new AttachedImage(this, image6, 1, 0, new Vec2(0,0));
                break;
            case 7:
                this.removeAllImages();
                i7 = new AttachedImage(this, image7, 1, 0, new Vec2(0,0));
                break;
            case 8:
                this.removeAllImages();
                i8 = new AttachedImage(this, image8, 1, 0, new Vec2(0,0));
                break;
            case 9:
                this.removeAllImages();
                i9 = new AttachedImage(this, image9, 1, 0, new Vec2(0,0));
                break;
            case 10:
                this.removeAllImages();
                i10 = new AttachedImage(this, image10, 1, 0, new Vec2(0,0));
                break;
            default:
                break;
        }

    }

}
