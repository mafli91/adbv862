package game.deprecated;

import city.cs.engine.DestructionEvent;
import city.cs.engine.DestructionListener;
import game.used.levels.GameLevels;
import game.used.objects.other.MovPlatSup;
import game.used.world.Game;

/**
 * @deprecated
 */
public class WallCrumble implements DestructionListener {
    private Game game;
    private GameLevels level;
    private CrunchyWall wall;
    private MovPlatSup dot;


    public WallCrumble(Game game, GameLevels level, CrunchyWall wall, MovPlatSup dot) {
        this.level = level;
        this.game = game;
        this.wall = wall;
        this.dot = dot;
    }

    @Override
    public void destroy(DestructionEvent destroy) {
        if (destroy.getSource() == wall)
            this.dot.destroy();
    }
}
