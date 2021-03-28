package game.used.levels;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.used.eventListeners.otherLevels.DeathComesTooSoon;
import game.used.eventListeners.otherLevels.IsOnPlatform;
import game.used.eventListeners.otherLevels.Munch;
import game.used.objects.enemy.boss.Boss;
import game.used.objects.hero.BlueFairy;
import game.used.objects.hero.FatFairy;
import game.used.objects.hero.Hero;
import game.used.objects.other.ComicStrip0;
import game.used.objects.other.ComicStrip10;
import game.used.objects.other.ComicStrip12;
import game.used.objects.other.ComicStrip8;
import game.used.world.GUI.ErrorPopup;
import game.used.world.Game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.ImagingOpException;
import java.io.*;

/**
 *  Super class for all levels in the game
 */

public abstract class GameLevels extends World implements Serializable {

    // generate objects accessed in other classes
    private Hero hero;
    private Game game;
    public ComicStrip0 comic0;
    public ComicStrip8 comic8;
    public ComicStrip10 comic10;
    public ComicStrip12 comic12;
    public Boss boss;
    public SoundClip gameMusic;
    private JFileChooser jfc;
    /**
     * @param label JLabel used in method playerTips
     */
    public JLabel label = new JLabel("My label");; // label for right-side bottom panel


    /**
     * @param l1 each level has it's l-identificator to make GUI buttons clickable if true
     *           unclickable if false
     */
    public boolean l1 = false;
    public boolean l2 = false;
    public boolean l3 = false;
    public boolean l4 = false;
    public boolean l5 = false;
    public boolean l6 = false;
    public boolean l7 = false;
    public boolean l8 = false;
    public boolean l9 = false;
    public boolean l10 = false;
    public boolean l11 = false;
    public boolean l12 = false;
    public boolean l13 = false;

    /**
     * @param complete used in level checking and method isComplete
     */
    public boolean complete = false; // used for level checking
    /**
     * @param volume allows to control soundtrack volume
     * @see game.used.world.GUI.Controls
     */
    public float volume = (float) 0.4;// to control volume in game
    /**
     * @param volumeFX allows to control FX sounds volume
     */
    public float volumeFX = 0.5f; // not really implemented yet


    public GameLevels(Game game)  {
        this.game = game;
        setHero(game.getHeroine());

    }

    /**
     * methods containing all bodies that would be used to save to file
     * when Serializable inaccessible
     * @param game Game class accessor
     * @see Game
     * @see game.used.world.GUI.SaveLoad
     *
     */
    public void populate(Game game){};


    /**
     * allows to change Hero
     * @param h variable to swap Hero for
     */
    public void setFatHero(Hero h){
        this.hero = h;
    }

    /**
     * Getter for Hero
     * @return returns Hero from the level
     */
    public Hero getFatLady() {return hero;}

    /**
     * Checks if level was completed according to certain standards set in each level
     * retruns boolean verified in specific method in different classes
     * @return boolean confirming if level was finished
     * @see game.used.world.FatControl
     * @see game.used.eventListeners.lvl567.DoorNextLevel
     */
    public abstract boolean isComplete(); // to check if level is complete

    /**
     * checks if hero is on platform
     * @return boolean confirming if hero is on platform
     * @see IsOnPlatform
     * @see game.used.objects.other.MovPlat
     */
    public abstract boolean onPlatform(); //to check if hero's on a platform

    /**
     * Checks to see if hero got off a platform
     * not in use currently
     * @return boolean confirming if hero got off platform
     *
     */
    public abstract boolean offPlatform();

    /**
     * allows to swap background in each level for a new image
     * @return image to be places in the background
     * @see game.used.world.GUI.Tracking
     * @see game.used.world.MyView
     */
    public abstract Image paintBackground();  // allows change of background depending on a level

    /** sets different label for each level in right side panel
     * of main GUI
     *
     * @return returns Jlabel label with different text for each level
     */
    public JLabel playerTips() {
        return null;
    }

    // not in use yet

    /**
     * Sets FX sound volume in the game
     * @param i volumeFX will be set to that value
     * @return volumeFX
     */
    public float setVolFX(float i) {
        this.volumeFX = i;
        return volumeFX;
    }

    /**
     * Allows to get comic strip objects of class ComicStrip
     * @return ComicStripX where X stands for wanted comic strip number (0,8,10,12)
     */
    public ComicStrip0 getComicStrip0() { return comic0;}
    public ComicStrip8 getComicStrip8() { return comic8;}
    public ComicStrip10 getComicStrip10() { return comic10;}
    public ComicStrip12 getComicStrip12() { return comic12;}

    /**
     * allows toggle between two available heroines, used with GUI
     * creates Hero objects of sub-classes with their listeners
     *
     * @param b boolean for method setHeroine in Game if true Hero is BlueFairy else FatFairy
     * @see Hero
     * @see Game
     * @see IsOnPlatform
     * @see Munch
     * @see DeathComesTooSoon
     */
    public void setHero(boolean b) {
        game.setHeroine(b);
        if (game.getHeroine()){
            hero = new BlueFairy(this);
        }else {
            hero = new FatFairy(this);
        }
        hero.addCollisionListener(new IsOnPlatform(hero));
        hero.addCollisionListener(new Munch(game, this, hero));
        hero.addDestructionListener(new DeathComesTooSoon(game, hero, this));
    }

    /**
     * Allows to get string value of level name needed for saving
     *
     * @see game.used.world.GUI.SaveLoad
     * @see Game
     * @return string of value L+level number
     */
    public abstract String getLevelName();

    /**
     * Method for displaying File chooser if missing BodyImage file caught
     * @param body body missing image
     * @param altImage name of body image field
     * @param heightOfImage height of image float
     * @throws IOException throws IOException
     * @see IOException
     * @see BodyImage
     * @see JFileChooser
     *
     */
    public void catchError(Body body, BodyImage altImage, float heightOfImage) throws IOException{

        jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("image", "png"));
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setCurrentDirectory(new File("data/images"));
        int returnVal = jfc.showOpenDialog(null);
        game.getView().writeForeground("some image corrupted, pick new one");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            try{
            body.removeAllImages();
            altImage = new BodyImage(String.valueOf(file), heightOfImage);
            System.out.println("New image loaded");
            game.getView().writeForeground("New image loaded");
            }
            catch(ImagingOpException i){
                altImage = null;
                i.printStackTrace();
            }
            finally{
                body.addImage(altImage);
            }

        } else {
            System.out.println("You chose not to open a file");
            game.getView().writeForeground("You chose no image");
            body.addImage(null);
        }
    }

    /**
     * Method displaying popup with a note about missing sound file in level
     * and allowing user to pick a substitute from filechooser
     *
     * @param altMusic field missing the file to be substituted
     * @see ErrorPopup
     * @see JFileChooser
     * @see SoundClip
     */
    public void catchMusicError(SoundClip altMusic){
        ErrorPopup errorPopup = new ErrorPopup(" SOUND FILE (type SOUNDTRACK) " );
        jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("soundfile", "wav", "mp3"));
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setCurrentDirectory(new File("data/sound"));
        int returnVal = jfc.showOpenDialog(null);
        System.out.println("some sound is corrupted, pick new one");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            try{
                altMusic = new SoundClip(String.valueOf(file));
                this.gameMusic = altMusic;
                gameMusic.loop();
                System.out.println("New music loaded");
            }
            catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
                gameMusic = null;
                e.printStackTrace();
            }
            finally{
                game.appendLog("Music Changed");
            }

        } else {
            System.out.println("You chose not to open a file");
            game.getView().writeForeground("You chose no music");
        }
    }

}
