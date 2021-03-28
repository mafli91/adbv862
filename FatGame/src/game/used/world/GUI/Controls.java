package game.used.world.GUI;

import game.used.levels.GameLevels;
import game.used.world.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.Serializable;


/**
 * Creates a pop-up window with info about in game controls and
 * volume control slider at the bottom
 */
public class Controls implements ChangeListener, Serializable {

    private JFrame frame;
    private JLabel sliderLabel;
    private JLabel description;
    private JSlider volumeControl;
    private Game game;
    private GameLevels level;
    private JPanel descriptionPanel;
    private JPanel sliderPanel;

    // CONSTRUCTOR
    public Controls(Game game, GameLevels level) {
        this.game = game;
        this.level = level;

        framethings();
        sliderThings();
        controlsDescription();

        frame.add(descriptionPanel, BorderLayout.CENTER);
        frame.add(sliderPanel, BorderLayout.SOUTH);
    }

    /** create a frame */
    private void framethings(){
        frame = new JFrame("BURGER WORLD CONTROLS");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(550, 440));
        frame.setPreferredSize(new Dimension(550, 600));
        frame.setMaximumSize(new Dimension(550, 460));
        ImageIcon icon = new ImageIcon("data/heel.png");
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

    /** add volume control slider */
    private void sliderThings(){
        sliderPanel = new JPanel();
        sliderPanel.setBackground(Color.lightGray);
        sliderPanel.setPreferredSize(new Dimension(180, 75));

        volumeControl = new JSlider(1, 100, 40);
        volumeControl.setBackground(Color.lightGray);
        volumeControl.setPreferredSize(new Dimension(300, 50));
        volumeControl.setPaintTicks(true);
        volumeControl.setMinorTickSpacing(10);
        volumeControl.setPaintTrack(true);
        volumeControl.setMajorTickSpacing(25);
        volumeControl.setPaintLabels(true);
        volumeControl.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
        volumeControl.addChangeListener(this);

        sliderLabel = new JLabel();
        sliderPanel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));

        sliderPanel.add(volumeControl);
        sliderPanel.add(sliderLabel);

    }

    /** add text description about in-game controls */
    private void controlsDescription() {
        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(Color.lightGray);

        description = new JLabel("Description");
        description.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        description.setForeground(Color.BLACK);
        description.setText("<html>" +
                "<body width='530'><h2><u>::::GAME CONTROLS::::</u></h2><br>" +
                "<b> <u>KEYBOARD:</u>  </b>\n<br>"+
                "<b> ASDW </b><br>\n is LEFT, DOWN, RIGHT and JUMP\n<br>" +
                "<b> Q and R</b><br> \n makes Uuma kick left and right, short range, deals 4 damage\n<br>" +
                "if you play Booma she releases a hedgehog that explodes after 2 s into 8 shards each dealing 1 damage.<br> "+
                "<b> SHIFT </b><br>\n  when pressed makes you move faster using A + D\n<br>"+
                "<b> SPACE </b><br> \n creates a protective bubble from damage, but effects still apply\n<br><br>"+
                "<b> <u>MOUSE:</u>  </b>\n<br>"+
                "<b> Left Button </b><br>\n  makes you shoot a magical star, long range, deal 1 damage\n<br>"+
                "<b> Right Button</b><br>\n  makes Uuma puff a cloud, middle range dealing 2 damage\n<br>" +
                "if you play Booma she releases a butterfly flying like a sinusoid, deals 3 damage.<br>"+
                "<b> Scroll Wheel </b><br>\n  let you zoom the view in and out of the view\n<br>" +
                "<b>ALL UUMA ATTACKS CARRY 40% chance to deal 1 extra damage, 10% chance for extra 4 damage " +
                "and 10% chance for extra 6 damage. <br>"+
                "<b> <u>MUSIC VOLUME:</u>  </b>\n<br>"+
                "</html>");

        descriptionPanel.add(description, BorderLayout.CENTER);
    }

    /** setls slider work to change volume of soundtracks */
    @Override
    public void stateChanged(ChangeEvent e) {

        sliderLabel.setText("In-game sound volume "+ volumeControl.getValue());
        level.gameMusic.setVolume((float) ((int) volumeControl.getValue())/100);
    }
}
