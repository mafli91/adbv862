package game.deprecated;

import city.cs.engine.*;
import game.used.objects.collectable.FairyDust;
import game.used.objects.enemy.Dog;
import game.used.objects.enemy.Puppy;
import game.used.objects.hero.FatFairy;

/**
 * @deprecated
 */
public class GameWorld extends World {


    private FatFairy lady;
    private Puppy pup;
    private Puppy pup2;
    private Dog dog;
    private Dog dog2;
    private FairyDust fairyDust1;
    private FairyDust fairyDust2;
    private FairyDust fairyDust3;
    private FairyDust fairyDust4;

    public GameWorld() {
        super();

        /**
        // make the ground + walls
        Shape groundShape = new BoxShape(40, 0.3f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -25f));
        Body leftWall = new StaticBody(this, groundShape);
        leftWall.setPosition(new Vec2(-40, 0));
        leftWall.setAngleDegrees(90);
        Body rightWall = new StaticBody(this, groundShape);
        rightWall.setPosition(new Vec2(40, 0));
        rightWall.setAngleDegrees(90);

        //add other platforms for dogs and puppies- platforms
        //and bunPlatforms for burgers- bunP
        Shape platformShape = new BoxShape(15, 0.3f);
        Shape bunPShape = new BoxShape(5, 0.3f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-25, -14f));
        Body bunP1 = new StaticBody(this, bunPShape);
        bunP1.setPosition(new Vec2(-27, -6f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(20, -5f));
        Body bunP2 = new StaticBody(this, bunPShape);
        bunP2.setPosition(new Vec2(-27, 12f));
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-25, 4f));
        Body bunP3 = new StaticBody(this, bunPShape);
        bunP3.setPosition(new Vec2(32, 4f));
        Body platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(20, 13f));
        Body bunP4 = new StaticBody(this, bunPShape);
        bunP4.setPosition(new Vec2(32, 22f));

        //checkers for puppies and dogs
        WalkChecks w1 = new WalkChecks(this);
        w1.setPosition(new Vec2(-38, -25));
        WalkChecks w2 = new WalkChecks(this);
        w2.setPosition(new Vec2(38, -25));
        WalkChecks w3 = new WalkChecks(this);
        w3.setPosition(new Vec2(-38, -14));
        WalkChecks w4 = new WalkChecks(this);
        w4.setPosition(new Vec2(-13, -14));
        WalkChecks w5 = new WalkChecks(this);
        w5.setPosition(new Vec2(8, -5));
        WalkChecks w6 = new WalkChecks(this);
        w6.setPosition(new Vec2(36, -5));
        WalkChecks w7 = new WalkChecks(this);
        w7.setPosition(new Vec2(-38, 4));
        WalkChecks w8 = new WalkChecks(this);
        w8.setPosition(new Vec2(-13, 4));
        WalkChecks w9 = new WalkChecks(this);
        w9.setPosition(new Vec2(8, 13));
        WalkChecks w10 = new WalkChecks(this);
        w10.setPosition(new Vec2(36, 13));


        // other bodies

        //fat lady
        lady = new FatLady(this);
        lady.setPosition(new Vec2(7, -12));
        lady.gone();

        // puppies
        pup = new Puppy(this);
        pup.pupWalk();
        pup.setPosition(new Vec2(-14, (float) -10));
        pup.addCollisionListener(new PupKick(lady, pup));
        pup.addCollisionListener(new PuppyJab(lady, pup));
        pup.addCollisionListener(new PupWalk(pup));
        pup2 = new Puppy(this);
        pup2.pupWalk();
        pup2.setPosition(new Vec2(-14, (float) 5));
        pup2.addCollisionListener(new PupKick(lady, pup2));
        pup2.addCollisionListener(new PuppyJab(lady, pup2));
        pup2.addCollisionListener(new PupWalk(pup2));

        //dogs
        dog = new Dog(this);
        dog.dogWalk();
        dog.setPosition(new Vec2(15, (float) -2));
        dog.addCollisionListener(new Bite(lady, dog));
        dog.addCollisionListener(new DogKick(lady, dog));
        dog.addCollisionListener(new DogWalk(dog));
        dog2 = new Dog(this);
        dog2.dogWalk();
        dog2.setPosition(new Vec2(15, (float) 15));
        dog2.addCollisionListener(new Bite(lady, dog2));
        dog2.addCollisionListener(new DogKick(lady, dog2));
        dog2.addCollisionListener(new DogWalk(dog2));

        // burgers
        burger1 = new Burger(this);
        burger1.setPosition(new Vec2(-27, (float) -4));
        burger1.addCollisionListener(new Munch(lady, burger1));
        burger2 = new Burger(this);
        burger2.setPosition(new Vec2(-27, (float) 13));
        burger2.addCollisionListener(new Munch(lady, burger2));
        burger3 = new Burger(this);
        burger3.setPosition(new Vec2(32, (float) 6));
        burger3.addCollisionListener(new Munch(lady, burger3));
        burger4 = new Burger(this);
        burger4.setPosition(new Vec2(32, (float) 25));
        burger4.addCollisionListener(new Munch(lady, burger4));


    }


    public FatLady getFatLady() {
        return lady;
    }

*/
}
}
