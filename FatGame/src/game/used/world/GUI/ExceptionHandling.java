package game.used.world.GUI;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;
import game.used.levels.GameLevels;
import game.used.world.Game;
import org.jbox2d.dynamics.Body;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;

/**
 * static methods to deal with exceptions if URLs of files are corrupted or files are missing
 */
public class ExceptionHandling {

    /**
     * Creates Pop up informing about sound file error and them opens JFileChooser to let player pick a substitute file
     * @param altMusic file corrupted
     * @param soundType description of the missing file allowing user to pick fitting substitute
     */
    public static void gameMusicHandling(SoundClip altMusic, String soundType){

        ErrorPopup errorPopup = new ErrorPopup(" SOUND FILE (type " +soundType + ")" );

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("PICK SOUND FILE", "wav", "mp3"));
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setCurrentDirectory(new File("data/sound"));
        int returnVal = jfc.showOpenDialog(null);
        System.out.println("Some sound is corrupted, pick new one");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            try{
                altMusic = new SoundClip(String.valueOf(file));
                System.out.println("New music loaded");
            }
            catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
                altMusic = null;
                e.printStackTrace();
            }
            finally{
                String alt = String.valueOf(altMusic);
            }

        } else {
            System.out.println("You chose not to open a file");

        }
    }

    /**
     * Creates Pop up informing about image file error and them opens JFileChooser to let player pick a substitute file     * @param game game object
     * @param fileName filePath to an image
     * @param description description of image uploaded
     * @param heightOfImage height of the image
     */
    public static BodyImage catchError(String fileName, String description, float heightOfImage){
        BodyImage altImage = null;
        try{
            Image image = ImageIO.read(new File(fileName));
            if (image == null){
                altImage = null;
            } else altImage = new BodyImage(fileName, heightOfImage);
        } catch (IOException e) {
            e.printStackTrace();

            ErrorPopup errorPopup = new ErrorPopup(" IMAGE FILE (type " +description + ")" );

            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("PNG IMAGE FILE", "png"));
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jfc.setCurrentDirectory(new File("data"));
            int returnVal = jfc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = jfc.getSelectedFile();
                altImage = new BodyImage(String.valueOf(file), heightOfImage);
                System.out.println("New image loaded");
                System.out.println("IMAGE ISSUE RESOLVED");
            } else {
                System.out.println("You chose not to pick a" + description +" file");

            }
            System.out.println("Image corrupted: " + fileName + ".");
        }
        return altImage;
    }



}
