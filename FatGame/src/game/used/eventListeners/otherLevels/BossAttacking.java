package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.enemy.boss.*;
import game.used.objects.hero.Hero;
import game.used.world.Game;

import java.io.Serializable;

/** Class for damage output from attacks by the boss
 * when in contact with Hero
 *
 * @see Hero
 * @see BossSpell
 * @see Curse
 * @see Heel
 * @see EyeSpell
 * */


public class BossAttacking implements CollisionListener, Serializable {

    private GameLevels level;
    private Game game;
    private BossAttacks attack;
    private Hero chub;
    private int s1 = 0;

    public BossAttacking(Game game, GameLevels level,  Hero chub) {

        this.game = game;
        this.level = level;
        //this.attack = attack;
        this.chub = chub;

    }

    @Override
    public void collide(CollisionEvent attack) {

        if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof Heel){
            chub.skinny(3);
            game.appendLog("You got booted!");
            attack.getReportingBody().destroy();
        }

        else if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof BossSpell){
            chub.skinny(1);
            game.appendLog("She SHOT YOU!");
            attack.getReportingBody().destroy();
        }

        else if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof EyeSpell){
            chub.skinny(1);
            game.appendLog("IT shot you! Gross...");
            attack.getReportingBody().destroy();
        }

        else if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof Curse){
            game.appendLog("You've been cursed!");
            game.appendLog("Damage will apply in 4 seconds");
            game.appendLog("Cast a barrier to avoid it!");

            // curse deals damage with a 4 seconds delay
            javax.swing.Timer spelltimer = new javax.swing.Timer( 4000 , e -> {
                s1++;
                chub.skinny(5);

            });
            spelltimer.setRepeats( false );
            spelltimer.start();

        }
    }

    public void updateHero( Hero h){
        this.chub = h;
    }

}
