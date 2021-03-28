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
public class Cheat implements Serializable, ActionListener {

    private JFrame frame;
    private JLabel description;
    private Game game;
    private GameLevels level;
    private JPanel descriptionPanel;
    private JButton yes;

    // CONSTRUCTOR
    public Cheat(Game game, GameLevels level) {
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
        ImageIcon icon = new ImageIcon("data/puppy.png");
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
                "<b> <u>Click yes to unlock buttons to all levels</u>  </b>\n<br>"+
                "</html>");
        descriptionPanel.add(description, BorderLayout.CENTER);
        yes = new JButton("YES");
        yes.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        yes.setFocusable(false);
        yes.addActionListener(this);
        yes.setPreferredSize(new Dimension(65, 100));
    }

    /**
     * activates all level buttons
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == yes){
            level.l1 = true;
            game.getButton("b1").setEnabled(true);
            level.l2 = true;
            game.getButton("b2").setEnabled(true);
            level.l3 = true;
            game.getButton("b3").setEnabled(true);
            level.l4 = true;
            game.getButton("b4").setEnabled(true);
            level.l5 = true;
            game.getButton("b5").setEnabled(true);
            level.l6 = true;
            game.getButton("b6").setEnabled(true);
            level.l7 = true;
            game.getButton("b7").setEnabled(true);
            level.l8 = true;
            game.getButton("b8").setEnabled(true);
            level.l9 = true;
            game.getButton("b9").setEnabled(true);
            level.l10 = true;
            game.getButton("b10").setEnabled(true);
            level.l11 = true;
            game.getButton("b11").setEnabled(true);
            level.l12 = true;
            game.getButton("b12").setEnabled(true);
            level.l13 = true;
            game.getButton("b13").setEnabled(true);
            game.getView().writeForeground("You're cheating.");
            game.appendLog("CHEATER CHEATER DON'T BE A QUITTER");
        }
    }
}
