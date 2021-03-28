package game.used.world.GUI;

import game.used.levels.GameLevels;
import game.used.world.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.Serializable;

/**
 * Makes a pop-up window with some info about levels
 */
public class AboutLevels implements Serializable {

    private JFrame frame;
    private JLabel sliderLabel;
    private JLabel description;
    private JSlider volumeControl;
    private Game game;
    private GameLevels level;
    private JPanel descriptionPanel;
    private JPanel sliderPanel;

    // CONSTRUCTOR

    public AboutLevels(Game game, GameLevels level) {
        this.game = game;
        this.level = level;

        framethings();
        controlsDescription();

        frame.add(descriptionPanel, BorderLayout.CENTER);
    }

    /** create a JFrame */
    private void framethings(){
        frame = new JFrame("About Levels");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(400, 500));
        frame.setPreferredSize(new Dimension(400, 550));
        frame.setMaximumSize(new Dimension(450, 600));
        ImageIcon icon = new ImageIcon("data/spellStar.png");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setLocationByPlatform(true);
        // let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);
    }

    /** create a panel with text in label for the window */
    private void controlsDescription() {
        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.lightGray);

        description = new JLabel("Description");
        description.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        description.setForeground(Color.BLACK);
        description.setText("<html>" +
                "<body width='345'><h2><u>::::ABOUT LEVELS::::</u></h2><br><br>" +
                "<b> <u>LEVELS 1-4 :</u>  </b>\n<br>"+
                "You start with a simple goal to collect indicated amount of dust," +
                "that is spread around the map for you to get. " +
                "Once you achieve it you have enough magic to move to the next level pressing N. \n<br><br>"+
                "<b> <u>LEVELS 5-7:</u>  </b>\n<br>"+
                "You have to open the blue portals shooting blue round buttons " +
                "provided to move on through. Button is activated when it turns pink. " +
                "You're still encouraged to collect dust and lollies to increase your life count. " +
                "Once you achieve it you'll move on to the boss level. \n<br><br>"+
                "<b> <u>BOSS LEVELS :</u>  </b>\n<br>"+
                "Goal is simple - kill everything on the screen that's not you. <br>" +
                "Just watch out- it shoots back now! <br><br>" +
                "The rest is a comic style story."+
                "</html>");

        descriptionPanel.add(description, BorderLayout.CENTER);
    }

}
