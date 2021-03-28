package game.used.objects.other;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import game.used.eventListeners.otherLevels.FloorIsLava;
import game.used.levels.GameLevels;
import game.used.world.Game;

import java.awt.*;
import java.io.Serializable;

/**
 * Makes burning floor
 * all lava floors are made using for loops
 *
 * @see FloorIsLava
 */

public class LavaTiles extends StaticBody implements Serializable {

    private Game game;
    private GameLevels level;

    private static float x;
    public LavaTiles(World w, Game game, GameLevels level) {
        super(w, check);
        this.game = game;
        this.level = level;
        this.setFillColor(Color.red);
        this.setLineColor(Color.orange);
        this.addCollisionListener(new FloorIsLava(game, level, level.getFatLady()));
    }

    private static Shape check = new BoxShape(0.25F, 0.4f);


}