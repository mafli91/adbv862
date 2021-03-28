package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.enemy.*;
import game.used.objects.hero.Hero;
import game.used.world.Game;

import java.io.Serializable;

/** checks collisions between hero and enemies to deal damage and apply effects
 * to the hero when touched by enemy [not boss]
 *
 * @see Bat
 * @see Wolf
 * @see Puppy
 * @see Dog
 */


public class EnemyAttacks implements CollisionListener, Serializable {

    private GameLevels level;
    private Game game;
    private Enemy enemy;
    private Hero chub;
    private int a; //odds of attack
    private int s = 0;// timer
    private int s1 = 0;


    public EnemyAttacks(Game game, GameLevels level, Enemy enemy, Hero chub) {

        this.game = game;
        this.level = level;
        this.enemy = enemy;
        this.chub = chub;

    }

    @Override
    public void collide(CollisionEvent attack) {
        float x = chub.getPosition().normalize();

        if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof Dog) {
            chub.skinny(2);
            enemy.jump(6);
            if (chub.getPosition().x > 0)
                chub.startWalking(-x);
            else
                chub.startWalking(x);
            chub.jump(12);
            game.appendLog("Cautious dog pushed you away...");
            game.appendLog("... and that's why you hate dogs.");
        }

        else if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof Puppy) {
            //if pup's life is low it will bite
            if (enemy.getLife() <= 8) {
                chub.skinny(3);
                enemy.jump(4);
                game.appendLog("Puppy is tired of playing and bit you with baby sharp teeth...");
            } else {
                if (chub.getPosition().x > 0)
                    chub.startWalking(-x / 10);
                else
                    chub.startWalking(x / 10);
                game.appendLog("Puppy wants to play jump...");
                game.appendLog("... forces you to take another route.");

            }
        }

        else if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof Wolf) {
            chub.skinny(2);
            if (chub.getLollipopCount() > 0) {
                chub.setLollipopCount(chub.getLollipopCount() - 1);
                enemy.setLollipopCount(1);
            }
            enemy.attack1();
            enemy.attack2();
            enemy.attack3();
        }

        else if (attack.getOtherBody() == chub && attack.getReportingBody() instanceof Bat) {
            chub.skinny(1);
            // bat increases your gravity effectively making you unable to jump
            chub.setGravityScale(5);
            game.appendLog("You've been poisoned! Slow for 9 seconds...");
            // lasts 9 seconds
            javax.swing.Timer battimer = new javax.swing.Timer(9000, e -> {
                s++;
                chub.setGravityScale(1);
            });
            battimer.setRepeats(false);
            battimer.start();
            a = (int) (Math.random() * 100);

            // 5% chance bat steals a burger
            if (a > 95) {
                enemy.attack1();
                chub.setFat(chub.getFat() - 1);
            }
        }
    }
    public void updateHero( Hero h){
        this.chub = h;
    }
}
