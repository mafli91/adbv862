package game.deprecated;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.used.levels.GameLevels;
import game.used.objects.enemy.Dog;
import game.used.objects.hero.FatFairy;
import game.used.objects.hero.Foot;
import game.used.world.Game;

/**
 * Class lets the mouse spawned foot to interact with the dog if within the range to be kicked
 * @deprecated
 */


public class DogKick implements CollisionListener {
    private final Game game;
    private final GameLevels level;
    private Dog dog;
    private FatFairy chub;
    private boolean kicked = false;


    public DogKick(Game game, GameLevels level, FatFairy chub, Dog dog) {

        this.game = game;
        this.level = level;
        this.chub = chub;
        this.dog = dog;

    }


    @Override
    public void collide(CollisionEvent kick) {
        //checks collision with the dog
        if (this.kickedD() && (kick.getReportingBody() == this.dog)) {
            // checks if the body is the foot
            if (kick.getOtherBody() instanceof Foot) {
                System.out.println("DOG Kick");
                if (this.dog.getLife() == 1) {
                    this.dog.jump(11);
                    this.dog.destroy();
                    System.out.println("You killed the dog");
                } else {
                    this.dog.jump(8);
                    this.dog.setLife(this.dog.getLife() - 1);
                    System.out.println("Dog has " + this.dog.getLife() + " lives left...");
                }
            }

        }
    }

    // checks if dog is withing the distance to interact
    public boolean kickedD() {

        //x and y coordinates of the dog

        float x = chub.getPosition().sub(this.dog.getPos()).x;
        float y = chub.getPosition().sub(this.dog.getPos()).y;
        //System.out.println("DOG POS X =" + x + "     Y = " + y);

        if (x >= -10 && x <= 10 && y <= 10 && y >= -10) {
            this.kicked = true;
            System.out.println("DOG KICK POSSIBLE");
        } else this.kicked = false;
        return this.kicked;
    }
}






