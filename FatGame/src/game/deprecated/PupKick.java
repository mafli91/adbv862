package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Puppy;
import game.used.objects.hero.FatFairy;
import game.used.world.Game;

/**
 * Class lets the mouse spawned foot to interact with the puppy if within the range to be kicked
 * @deprecated
 */


public class PupKick implements CollisionListener {
    private Game game;
    private GameLevels level;
    private Puppy enemy;
    private FatFairy chub;
    private boolean kickedP;


    public PupKick(Game game, GameLevels level, FatFairy chub, Puppy enemy) {

        this.game = game;
        this.level = level;
        this.chub = chub;
        this.enemy = enemy;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {

    }

    /** @Override
    public void collide(CollisionEvent kick) {
// checks collision between puppy and the foot
        if (this.ifKickedP() && (kick.getReportingBody() == this.enemy)) {
            if (kick.getOtherBody() instanceof Foot) {
                System.out.println("PUP Kick");
                if (this.enemy.getLife() > 2) {
                    this.enemy.jump(8);
                    System.out.println("You successfully kicked the puppy. It has "
                            + this.enemy.getLife() + " health left...");
                    this.enemy.setLife(1);
                } else if (this.enemy.getLife() == 2) {
                    kick.getOtherBody().setPosition(kick.getOtherBody().getPosition().sub(new Vec2(0, -6)));
                    System.out.println("You successfully kicked the puppy. It has "
                            + this.enemy.getLife() + " health left...");
                    this.enemy.setLife(1);
                } else if (this.enemy.getLife() == 1) {
                    System.out.println(" YOU KILLED PUPPY ");
                    this.enemy.setLife(1);
                    this.enemy.destroy();
                }
            }
        }
    }
// checks if puppy is within the range to be kicked

    public boolean ifKickedP() {

        // x and y coordinates of the puppy

        //float x = chub.getPosition().sub(this.enemy.getPos()).x;
        //float y = chub.getPosition().sub(this.enemy.getPos()).y;
        //System.out.println("PUP POS X =" + x + "     Y = " + y);

       ///if (x >= -11 && x <= 11 && y <= 11 && y >= -11) {
            this.kickedP = true;
            System.out.println("PUPPY KICK POSSIBLE");
        } else this.kickedP = false;
        return this.kickedP;
    } */
}






