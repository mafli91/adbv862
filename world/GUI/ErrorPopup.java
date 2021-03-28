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
 * Makes a pop-up window with some info about error
 * @see ExceptionHandling
 */
public class ErrorPopup implements Serializable {

    private JFrame frame;
    private JLabel description;
    private Game game;
    private GameLevels level;
    private JPanel descriptionPanel;
    private JButton yes;

    // CONSTRUCTOR
    public ErrorPopup(String fileName) {

        frame = new JFrame("MISSING FILE");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(450, 150));
        frame.setPreferredSize(new Dimension(415, 160));
        frame.setMaximumSize(new Dimension(460, 200));
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

        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.lightGray);

        description = new JLabel("Description");
        description.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
        description.setForeground(Color.BLACK);
        description.setText("<html>" +
                "<body width='430'><h2><u>::::SOME FILE IS MISSING::::</u></h2>" +
                "<b> <u>Missing file   </b>"+ fileName + " <b> we're sorry. Pick a substitute. </b> </u>" +
                "</html>");
        descriptionPanel.add(description, BorderLayout.CENTER);

        frame.add(descriptionPanel, BorderLayout.CENTER);

    }

}
