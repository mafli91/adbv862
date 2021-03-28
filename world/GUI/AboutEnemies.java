package game.used.world.GUI;

import game.used.levels.GameLevels;
import game.used.world.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.Serializable;


/**
 * Makes a pop-up window with some info about enemies
 */
public class AboutEnemies implements Serializable {

    private JFrame frame;
    private JLabel sliderLabel;
    private JLabel description;
    private Game game;
    private GameLevels level;
    private JPanel descriptionPanel;

    // CONSTRUCTOR
    public AboutEnemies(Game game, GameLevels level) {
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
        frame.setMinimumSize(new Dimension(450, 575));
        frame.setPreferredSize(new Dimension(480, 600));
        frame.setMaximumSize(new Dimension(500, 625));
        ImageIcon icon = new ImageIcon("data/puppyL.png");
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

    /** create the text for the frame in panel and labels */
    private void controlsDescription() {
        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.lightGray);

        description = new JLabel("Description");
        description.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        description.setForeground(Color.BLACK);
        description.setText("<html>" +
                "<body width='445'><h2><u>::::IN-GAME ENEMIES::::</u></h2>" +
                "<b> <u>Round spikey blobs :</u>  </b>\n<br>"+
                "The deal no damage unless their life is low. They will push you away though." +
                "Later in the game they will change into bigger blobs over time.\n<br><br>"+
                "<b> <u>Tall blobs :</u>  </b>\n<br>"+
                "They deal damage upon contact, are faster than small blobs and jump higher. " +
                "Later in the game they change into purple blobs over time. \n<br><br>"+
                "<b> <u>Big purple blobs :</u>  </b>\n<br>"+
                "They deal damage upon contact, are faster than other blobs and jump higher." +
                "They have feral mode which makes them jump fast in random direction." +
                "If you have lollipops they will steal one and spawn a small blob." +
                "If they are in feral mode and you have no lollipops they will spawn an eyeball," +
                "and if you have a lollipop and they are feral they will spawn a tall blob.\n<br><br>"+
                "<b> <u>Flying eyeballs :</u>  </b>\n<br>"+
                "They are the fastest in the game and deal minor damage upon contact " +
                "but they will effectively make you unable to jump for a few seconds after attack.  \n<br><br>"+
                "<b> <u>BOSS :</u>  </b>\n<br>"+
                "No damage upon contact but shoots spells (1dmg), throws shoes (3dmg) and casts curses " +
                "(5dmg applied after a short period) \n"+
                "</html>");

        descriptionPanel.add(description, BorderLayout.CENTER);
    }

}
