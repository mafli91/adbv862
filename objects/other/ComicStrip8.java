package game.used.objects.other;

import city.cs.engine.*;
import game.used.world.GUI.ExceptionHandling;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.Serializable;

/**
 * ComicStrip class for level 8.
 * @see ComicStrip
 */
public class ComicStrip8 extends ComicStrip implements Serializable {

    private static Shape shape = new BoxShape(40, 26);

    private static final BodyImage image1 = ExceptionHandling.catchError("data/CC1.png", "" +
            "Comic strip L8 part 1", 42f );
    private static final BodyImage image2 = ExceptionHandling.catchError("data/CC2.png", "" +
            "Comic strip L8 part 2", 42f );
    private static final BodyImage image3 = ExceptionHandling.catchError("data/CC3.png", "" +
            "Comic strip L8 part 3", 42f );
    private static final BodyImage image4 = ExceptionHandling.catchError("data/CC4.png", "" +
            "Comic strip L8 part 4", 42f );
    private static final BodyImage image5 = ExceptionHandling.catchError("data/CC5.png", "" +
            "Comic strip L8 part 5", 42f );
    private static final BodyImage image6 = ExceptionHandling.catchError("data/CC6.png", "" +
            "Comic strip L8 part 6", 42f );
    private static final BodyImage image7 = ExceptionHandling.catchError("data/CC7.png", "" +
            "Comic strip L8 part 7", 42f );
    private static final BodyImage image8 = ExceptionHandling.catchError("data/CC8.png", "" +
            "Comic strip L8 part 8", 42f );
    private static final BodyImage image9 = ExceptionHandling.catchError("data/CC9.png", "" +
            "Comic strip L8 part 9", 42f );
    private static final BodyImage image10 = ExceptionHandling.catchError("data/CC10.png", "" +
            "Comic strip L8 part 10", 42f );
    private static final BodyImage image11 = ExceptionHandling.catchError("data/CC11.png", "" +
            "Comic strip L8 part 11", 42f );
    private static final BodyImage image12 = ExceptionHandling.catchError("data/CC12.png", "" +
            "Comic strip L8 part 12", 42f );

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
    private AttachedImage i11;
    private AttachedImage i12;

    private Game game;

    private int swapCount = 1;

    public ComicStrip8(World w, Game game) {
        super(w, shape);
        this.game = game;
        this.swapPic();
    }

    public void setSwapCount(int i){
        this.swapCount = swapCount +1;
    }

    @Override
    public int getSwapCount() {
        return swapCount;
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
            case 11:
                this.removeAllImages();
                i11 = new AttachedImage(this, image11, 1, 0, new Vec2(0,0));
                break;
            case 12:
                this.removeAllImages();
                i12 = new AttachedImage(this, image12, 1, 0, new Vec2(0,0));
                break;
            default:
                break;
        }

    }

}
