package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.hero.FatFairy;
import game.used.objects.enemy.Puppy;
import game.used.world.Game;

/**
 * Class allows the puppy to interact with the lady
 * @deprecated
 */


public class PuppyJab implements CollisionListener {

    private  GameLevels level;
    private  Game game;
    private Puppy pup;
    private FatFairy chub;

    public PuppyJab(Game game, GameLevels level, Puppy pup, FatFairy chub) {

        this.game = game;
        this.level = level;
        this.pup = pup;
        this.chub = chub;

    }

    @Override
    public void collide(CollisionEvent bite) {
        //x and y coordinates of puppy
        //float x = chub.getPosition().sub(this.pup.getPos()).x;
        //float y = chub.getPosition().sub(this.pup.getPos()).y;

        if (bite.getOtherBody() == chub && bite.getReportingBody() == pup) {
            //if pup's life is low it will bite
            if (pup.getLife() <= 4) {
                chub.skinny(1);
                chub.skinny(1);
                pup.jump(4);
                System.out.println("Puppy is tired and bit you with baby sharp teeth...");
            } else {
                // if pup has more than 4 life he'll make you walk right and jump
                chub.startWalking(8);
                chub.jump(12);
                System.out.println("Playing puppy pushed you away from a burger...");
                System.out.println("... and that's why you hate dogs.");
            }
        }
    }
}

