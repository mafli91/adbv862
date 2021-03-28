package game.used.eventListeners.otherLevels;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Bat;
import game.used.objects.enemy.Enemy;
import game.used.objects.enemy.boss.Boss;
import game.used.objects.enemy.boss.BossEye;
import game.used.objects.hero.*;
import game.used.world.Game;

import java.io.Serializable;

/** checks collisions between hero's attacks and enemies to deal damage and apply effects
 *
 * @see Enemy
 * @see Hero
 * @see Attacks
 * */

public class AttackEnemy implements CollisionListener, Serializable {

    private Game game;
    private GameLevels level;
    private Hero lady;
    private Enemy enemy;
    private boolean kicked = false;
    private int fatBoost; // calculate critical for FatFairy
    private int a;


    public AttackEnemy(Game game, GameLevels level, Hero lady, Enemy enemy) {

        this.game = game;
        this.level = level;
        this.lady = lady;
        this.enemy = enemy;

    }


    @Override
    public void collide(CollisionEvent kick) {

        // check for fatFairy bonus damage
        if(lady instanceof FatFairy) {
            a = (int) (Math.random() * 100)+1;
            if (a >= 91) // 10% chance extra 6 damage
                fatBoost = 6;
            else if (a>=81 && a<91) // extra 4 damage
                fatBoost = 4;
            else if (a>=40 && a<81) // extra 1 damage
                fatBoost = 1;
            else
                fatBoost = 0;
        }
        else
            fatBoost = 0;

        // if not boss
        if (!(kick.getReportingBody() instanceof Boss)) {

            // damage from QE attack
            if (kick.getOtherBody() instanceof Foot) {
                game.appendLog("Kick");
                if (this.enemy.getLife() < 5+fatBoost) {
                    game.appendLog("You booted that animal!");
                    this.enemy.destroy();
                    if(kick.getReportingBody()instanceof BossEye)
                        level.boss.setEyeCount(1);
                } else {
                    this.enemy.setLife(4+fatBoost);
                    game.appendLog("Animal has " + this.enemy.getLife() + " lives left...");
                }
                //enemy jumps but not bat
                if (!(kick.getOtherBody() instanceof Bat))
                    this.enemy.jump(11);
            }

            else if (kick.getOtherBody() instanceof Puff) {
                game.appendLog("Puff");
                if (this.enemy.getLife() < 3+fatBoost) {
                    game.appendLog("You killed the foe!");
                    this.enemy.destroy();
                    if(kick.getReportingBody()instanceof BossEye)
                        level.boss.setEyeCount(1);
                } else {
                    this.enemy.setLife(2+fatBoost);
                    game.appendLog("Foe has " + this.enemy.getLife() + " lives left...");
                }
                if (!(kick.getOtherBody() instanceof Bat))
                    this.enemy.jump(-1 * enemy.getSpeed());
            }

            else if (kick.getOtherBody() instanceof HedgeSpike) {
                game.appendLog("boom");
                if (this.enemy.getLife() < 2) {
                    game.appendLog("You killed the foe!");
                    this.enemy.destroy();
                    if(kick.getReportingBody()instanceof BossEye)
                        level.boss.setEyeCount(1);
                } else {
                    this.enemy.setLife(1+fatBoost);
                    game.appendLog("Foe has " + this.enemy.getLife() + " lives left...");
                }
                if (!(kick.getOtherBody() instanceof Bat))
                    this.enemy.jump(-1 * enemy.getSpeed());
            }

            else if(kick.getOtherBody() instanceof Hedgehog) {

                if (!(kick.getOtherBody() instanceof Bat))
                    this.enemy.jump(-1 * (enemy.getSpeed() / 5));
            }

            else if (kick.getOtherBody() instanceof Butterfly) {
                game.appendLog("So pretty");
                if (this.enemy.getLife() < 4) {
                    game.appendLog("You killed the foe!");
                    this.enemy.destroy();
                    if(kick.getReportingBody()instanceof BossEye)
                        level.boss.setEyeCount(1);
                } else {
                    this.enemy.setLife(3);
                    game.appendLog("Foe has " + this.enemy.getLife() + " lives left...");
                }
                if (!(kick.getOtherBody() instanceof Bat))
                    this.enemy.jump(-1 * enemy.getSpeed());
            }

            else if (kick.getOtherBody() instanceof Spell) {
                game.appendLog("Poing!");
                if (this.enemy.getLife() <= 1+fatBoost) {
                    game.appendLog("You killed the enemy!");
                    this.enemy.destroy();
                    if(kick.getReportingBody()instanceof BossEye)
                        level.boss.setEyeCount(1);
                } else {
                    this.enemy.setLife(1+fatBoost);
                    game.appendLog("Enemy has " + this.enemy.getLife() + " lives left...");
                }
                if (!(kick.getOtherBody() instanceof Bat))
                    this.enemy.jump(-1 * (enemy.getSpeed() / 5));
            }
        }

        // attacks deal the same damage to the boss but have different output
        else if (kick.getReportingBody() instanceof Boss){

            if (kick.getOtherBody() instanceof Foot) {
                game.appendLog("Kick and split!");
                if (this.enemy.getLife() < 5+fatBoost) {
                    game.appendLog("You booted that ugly!");
                    this.level.complete = true;
                    this.enemy.setLife(4+fatBoost);
                } else {
                    this.enemy.setLife(4+fatBoost);
                    game.appendLog("She has " + this.enemy.getLife() + " lives left...");
                }
            } else if (kick.getOtherBody() instanceof HedgeSpike) {
                    game.appendLog("That's a jab!");
                    if (this.enemy.getLife() < 3) {
                        this.level.complete = true;
                        this.enemy.setLife(2);
                    } else {
                        this.enemy.setLife(2);
                        game.appendLog("She has " + this.enemy.getLife() + " lives left...");
                    }
            } else if (kick.getOtherBody() instanceof Butterfly) {
                    game.appendLog("Such pretty wasted on such ugly");
                    if (this.enemy.getLife() < 4) {
                        this.level.complete = true;
                        this.enemy.setLife(3);
                    } else {
                        this.enemy.setLife(3);
                        game.appendLog("She has " + this.enemy.getLife() + " lives left...");
                    }
            } else if (kick.getOtherBody() instanceof Puff) {
                game.appendLog("Hope ugly chokes!");
                if (this.enemy.getLife() < 3+fatBoost) {
                    this.level.complete = true;
                    this.enemy.setLife(2+fatBoost);
                } else {
                    this.enemy.setLife(2+fatBoost);
                    this.enemy.jump(4);
                    game.appendLog("She has " + this.enemy.getLife() + " lives left...");
                }
            } else if (kick.getOtherBody() instanceof Spell) {
                game.appendLog("Poing off that boing!");
                if (this.enemy.getLife() == 1+fatBoost) {
                    this.level.complete = true;
                    this.enemy.setLife(1+fatBoost);
                } else {
                    this.enemy.setLife(1+fatBoost);
                    game.appendLog("She has " + this.enemy.getLife() + " lives left...");
                }
            }
        }
    }


    // checks if enemy is withing the distance to interact
    /* Not in use now
     *
     * public boolean kickedD() {

        //x and y coordinates of the enemy

        float x = lady.getPosition().sub(this.lady.getPosition()).x;
        float y = lady.getPosition().sub(this.lady.getPosition()).y;
        //System.out.println("ENEMY POS X =" + x + "     Y = " + y);

        if (x >= -10 && x <= 10 && y <= 10 && y >= -10) {
            this.kicked = true;
            System.out.println("DOG KICK POSSIBLE");
        } else this.kicked = false;
        return this.kicked;
    } */
}
