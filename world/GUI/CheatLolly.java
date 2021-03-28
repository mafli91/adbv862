package game.used.world.GUI;

import game.used.levels.GameLevels;
import game.used.world.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;


/**
 * Makes a pop-up window with some info about enemies
 */
public class CheatLolly implements Serializable, ActionListener {

    private JFrame frame;
    private JLabel sliderLabel;
    private JLabel description;
    private Game game;
    private GameLevels level;
    private JPanel descriptionPanel;
    private JButton yes;

    // CONSTRUCTOR
    public CheatLolly(Game game, GameLevels level) {
        this.game = game;
        this.level = level;

        framethings();
        controlsDescription();

        frame.add(descriptionPanel, BorderLayout.CENTER);
        frame.add(yes, BorderLayout.EAST);
    }

    /** create a JFrame */
    private void framethings(){
        frame = new JFrame("Cheat");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(450, 150));
        frame.setPreferredSize(new Dimension(415, 160));
        frame.setMaximumSize(new Dimension(460, 200));
        ImageIcon icon = new ImageIcon("data/lolly.png");
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
        description.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        description.setForeground(Color.BLACK);
        description.setText("<html>" +
                "<body width='350'><h2><u>::::DO YOU WANT TO CHEAT?::::</u></h2>" +
                "<b> <u>Click yes to gain extra lollies and lives</u>  </b>\n<br>"+
                "</html>");
        descriptionPanel.add(description, BorderLayout.CENTER);
        yes = new JButton("YES");
        yes.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        yes.setFocusable(false);
        yes.addActionListener(this);
        yes.setPreferredSize(new Dimension(65, 100));
    }

    /** upon clicking button gives extra 20 lollipops */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == yes){
            level.getFatLady().setLollipopCount(level.getFatLady().getLollipopCount() + 69);
            level.getFatLady().setLayers(666);
            game.getView().writeForeground("You're cheating.");
        }
    }
}
