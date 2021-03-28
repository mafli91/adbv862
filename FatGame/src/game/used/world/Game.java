package game.used.world;

import city.cs.engine.UserView;
import game.used.eventListeners.otherLevels.BossAttacking;
import game.used.eventListeners.otherLevels.EnemyAttacks;
import game.used.eventListeners.otherLevels.FloorIsLava;
import game.used.eventListeners.otherLevels.IsOnPlatform;
import game.used.levels.*;
import game.used.objects.hero.Hero;
import game.used.world.GUI.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
/**
 *
 *GAME ABOUT TWO WEIRD FAIRIES IN TROUBLE
 *
 *
 * using City Engine from CS Comp Sci CUL
 * All music is done by Marek Flis in CakeWalk with exception of:
 * All about that bass Meghan Trainor
 * Fat Bones-UK
 * Fat Weird Al Yankovic
 * @author      Marek Flis
 * @version     4
 * @since       1
 *
 */



public class Game<game> implements Serializable, ActionListener {
    /**
     * New JFrame for the game
     */
    private  JFrame frame;

    /**
     * The World in which the bodies move and interact.
     */
    public GameLevels level;
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;
    private JFrame debugView;
    private UserView wideView;
    private FatControl control;
    private MouseHandler mouse;
    private Tracking tracking;
    private MiniTracking miniTrack;

    /**
     * @param heroine used in swapping hero buttons
     */
    private boolean heroine = false;

    // JFrame
    private JMenuBar menu;
    private JMenuItem pause;
    private JMenuItem resume;
    private JMenuItem save;
    private JMenuItem load;
    private JMenuItem exit;
    private JMenuItem controls;
    private JMenuItem briefs;
    private JMenuItem enemies;
    private JPanel panel2;
    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b10;
    private JButton b11;
    private JButton b12;
    private JButton b13;
    private JButton fatFairy;
    private JButton blueFairy;
    private JLabel wolfs;
    private JPanel tips;
    private JLabel dogs;
    private JPanel miniview;
    private JTextArea log;
    private String logText;
    private JFileChooser fc;
    private JPanel pane;


    /**
     * Initialise a new Game.
     */
    public Game() throws IOException {


        // make the world

        level = new LStart(this);
        level.populate(this);

        // make view and it's methods
        view = new MyView(level, this, 750, 600, level.getFatLady());
        view.setBounds(0, 25, 750, 650);
        view.setZoom(13);
        view.setBack(level.paintBackground());
        // uncomment this to draw a n-metre grid over the view
        //view.setGridResolution(13);

        // mouse
        mouse = new MouseHandler(level, view, this, level.getFatLady());
        view.addMouseListener(mouse);
        view.addMouseListener(new GiveFocus(view));
        view.addMouseWheelListener(mouse);

        // tracking
        tracking = new Tracking(view, level.getFatLady());
        level.addStepListener(tracking);

        // controller
        control = new FatControl(level.getFatLady(), view, level, this);
        view.addKeyListener(control);

        // make a miniview in a corner
        wideView = new UserView(level, 180, 180);
        wideView.setZoom(2);
        miniTrack = new MiniTracking(wideView, level.getFatLady());
        this.level.addStepListener(miniTrack);

        // make frame
        this.makeFrame();
        // add local components to the frame
        this.makeRightSidePanel();
        this.makeSouthPanel();
        this.makeTopMenu();
        this.addComponents();
        this.getMiniView().add(wideView);


        // uncomment this to make a debugging view
        //debugView = new DebugViewer(level, 500, 500);

        // start our game world simulation!
        level.start();
    }


    /**
     * method for going to next level upon accomplishing level requirements
     */
    public void goToNextLevel() {
        // allows to carry on past scores
        Hero hero = level.getFatLady();
        // updates the tips panel
        this.getTips().remove(level.label);
        this.getTips().revalidate();
        this.getTips().repaint();
        // change the levels
        if (level instanceof LStart) {
            // stop old level and music
            this.preChange();
            // update level and music
            level = new Lvl0(this);
            // update hero
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            // method for all the level needs
            newLevelGo();
        } else if (level instanceof Lvl0) {
            // stop old level and music
            this.preChange();
            // update level and music
            level = new Lvl1(this);
            // update hero
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            // method for all the level needs
            newLevelGo();
            // unlock level button
            level.l1 = true;
            this.getButton("b1").setEnabled(true);
        } else if (level instanceof Lvl1) {
            // stop old level and music
            this.preChange();
            // update level
            level = new Lvl2(this);
            // update hero
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            // method for all the level needs
            newLevelGo();
            // unlock level button
            level.l2 = true;
            this.getButton("b2").setEnabled(true);
        } else if (level instanceof Lvl2) {
            this.preChange();
            level = new Lvl3(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            level.l3 = true;
            this.getButton("b3").setEnabled(true);
        } else if (level instanceof Lvl3) {
            this.preChange();
            level = new Lvl4(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            level.l4 = true;
            this.getButton("b4").setEnabled(true);
        } else if (level instanceof Lvl4) {
            this.preChange();
            level = new Lvl5(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            level.l5 = true;
            this.getButton("b5").setEnabled(true);
        } else if (level instanceof Lvl5) {
            this.preChange();
            level = new Lvl6(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            level.l6 = true;
            this.getButton("b6").setEnabled(true);
        } else if (level instanceof Lvl6) {
            this.preChange();
            level = new Lvl7(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            level.l7 = true;
            this.getButton("b7").setEnabled(true);
        } else if (level instanceof Lvl7) {
            this.preChange();
            level = new Lvl8(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            level.l8 = true;
            this.getButton("b8").setEnabled(true);
        } else if (level instanceof Lvl8) {
            this.preChange();
            level = new Lvl9(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            // you will need it probably
            level.getFatLady().skinny(-4);
            level.getFatLady().setLollipopCount(level.getFatLady().getLollipopCount() + 4);
            level.l9 = true;
            this.getButton("b9").setEnabled(true);
        } else if (level instanceof Lvl9) {
            this.preChange();
            level = new Lvl10(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            level.l10 = true;
            this.getButton("b10").setEnabled(true);
        } else if (level instanceof Lvl10) {
            this.preChange();
            level = new Lvl11(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            newLevelGo();
            // you will need it probably
            level.getFatLady().skinny(-8);
            level.getFatLady().setLollipopCount(level.getFatLady().getLollipopCount() + 4);
            level.l11 = true;
            this.getButton("b11").setEnabled(true);
        } else if (level instanceof Lvl11) {
            this.preChange();
            level = new Lvl12(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            // you will need it probably
            level.getFatLady().skinny(-8);
            newLevelGo();
            level.l12 = true;
            this.getButton("b12").setEnabled(true);
        } else if (level instanceof Lvl12) {
            this.preChange();
            level = new Lvl13(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            newLevelGo();
            level.l13 = true;
            this.getButton("b13").setEnabled(true);
        }
    }


    /**
     * call for preChange(), then new level value and then call for allLevelMethods()
     * @param level new level value
     */
    public void loadLevel(GameLevels level){
        this.preChange();
        this.level = level;
        this.allLevelMethods();
    }

    /** call for level populate() and allLevelMethods() */
    public void newLevelGo() {
        // populate level
        level.populate(this);
        this.allLevelMethods();
    }

    /**
     * method used before swapping value of the level to new level
     */
    public void preChange(){
        // before changing level
        // update tips panel
        this.getTips().remove(level.label);
        this.getTips().revalidate();
        this.getTips().repaint();
        // stop music from past level
        level.stop();
        level.gameMusic.close();
        view.writeCredits(" ");
        view.writeForeground(" ");
        view.writeCredits2(" ");
    }

    /**
     * method used to create all new levels
     */
    public void allLevelMethods(){
        // play music and set volume
        this.level.gameMusic.play();
        this.level.gameMusic.setVolume(this.level.volume);
        if (level instanceof Lvl0 || level instanceof Lvl8 || level instanceof Lvl10
                || level instanceof Lvl12) {
            // disable character swap
            this.getButton("fatFairy").setEnabled(false);
            this.getButton("blueFairy").setEnabled(false);
            view.setBackground(Color.black);
        } else {
            // enable character swap
            this.getButton("fatFairy").setEnabled(true);
            this.getButton("blueFairy").setEnabled(true);
            view.setBack(this.level.paintBackground());
            //add tracking
            this.level.addStepListener(new Tracking(view, this.level.getFatLady()));
            this.level.addStepListener(new MiniTracking(wideView, this.level.getFatLady()));
            tracking.updateView(view);
            tracking.updateHero(this.level.getFatLady());
            mouse.updateHero(this.level.getFatLady());
            mouse.updateLevel(this.level);
        }
        //update views
        view.setZoom(12);
        view.setWorld(this.level);
        wideView.setWorld(this.level);
        wideView.setZoom(1);
        // update controllers
        control.updateHero(this.level.getFatLady());
        control.updateLevel(this.level);
        miniTrack.updateHero(this.level.getFatLady());
        view.updateHero(this.level.getFatLady());
        // update labels
        this.getTips().add(this.level.playerTips(), BorderLayout.CENTER);
        view.writeCredits(level.getLevelName());
        // uncomment this to make a debugging view for each level
        //debugView = new DebugViewer(level, 500, 500);
        // start new level
        this.level.start();
    }

    /** checks the value of current level and returns it as new for use in GUI buttons */
    public GameLevels switchLevel(){
        if(level instanceof LStart)
            return new LStart(this);
        else if (level instanceof  Lvl0)
            return new Lvl0(this);
        else if (level instanceof Lvl1)
            return new Lvl1(this);
        else if (level instanceof Lvl2)
            return new Lvl2(this);
        else if (level instanceof Lvl3)
            return new Lvl3(this);
        else if (level instanceof Lvl4)
            return new Lvl4(this);
        else if (level instanceof Lvl5)
            return new Lvl5(this);
        else if (level instanceof Lvl6)
            return new Lvl6(this);
        else if (level instanceof Lvl7)
            return new Lvl7(this);
        else if (level instanceof Lvl8)
            return new Lvl8(this);
        else if (level instanceof Lvl9)
            return new Lvl9(this);
        else if (level instanceof Lvl10)
            return new Lvl10(this);
        else if (level instanceof Lvl11)
            return new Lvl11(this);
        else if (level instanceof Lvl12)
            return new Lvl12(this);
        else
            return new Lvl13(this);
    }

    /** returns boolean that triggers hero change in Game Levels
     * @see GameLevels
     * */
    public boolean getHeroine(){
        return heroine;
    }

    /** changes boolean for swapping Hero in Game Levels
     * true is BlueFairy false is FatFairy
     * @see GameLevels
     * @param b new boolean value
     */
    public void setHeroine(boolean b){
        this.heroine = b;
    }
    /** method to start game from Level 0 */
    public void goToZero(){
        this.preChange();
        this.setHeroine(!getHeroine());
        try {
            level = new LStart(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        newLevelGo();
        this.appendLog("WOW. MAYBE TRY A DIFFERENT FAIRY...");
    }

 /** return view */
    public MyView getView() {
        return view;
    }

    /** create a frame to contain GUI */
    private void makeFrame(){
        frame = new JFrame("CANDYLAND");
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(800, 700));
        frame.setPreferredSize(new Dimension(950, 750));
        frame.setMaximumSize(new Dimension(1000, 800));
        ImageIcon icon = new ImageIcon("data/butterfly.png");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // let the frame be resized
        frame.setResizable(true);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);
    }

    /** add components to the frame */
    public void addComponents(){
        // add components to the frame
        frame.add(panel2, BorderLayout.EAST);
        frame.add(pane, BorderLayout.SOUTH);
        frame.add(view, BorderLayout.CENTER);
        frame.setJMenuBar(menu);
    }

    /** make menu at the top of the frame */
    private void makeTopMenu(){
        // make top bar menu
        menu = new JMenuBar();
        menu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        menu.setPreferredSize(new Dimension(100, 25));
        JMenu file = new JMenu("File");
        file.setMnemonic('F');
        JMenu help = new JMenu("Help");
        help.setMnemonic('H');
        pause = new JMenuItem("Pause");
        pause.addActionListener(this);
        pause.setMnemonic('P');
        resume = new JMenuItem("Resume");
        resume.addActionListener(this);
        resume.setMnemonic('R');
        save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setMnemonic('V');
        load = new JMenuItem("Load");
        load.addActionListener(this);
        load.setMnemonic('L');
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setMnemonic('X');
        controls = new JMenuItem("Controls");
        controls.addActionListener(this);
        controls.setMnemonic('C');
        briefs = new JMenuItem("About Levels");
        briefs.addActionListener(this);
        briefs.setMnemonic('O');
        enemies = new JMenuItem("About Enemies");
        enemies.addActionListener(this);
        enemies.setMnemonic('U');
        menu.add(file);
        menu.add(help);
        file.add(pause);
        file.add(resume);
        file.add(save);
        file.add(load);
        file.add(exit);
        help.add(controls);
        help.add(briefs);
        help.add(enemies);

    }

    /**
     * make right-hand side of the GUI frame with buttons, mini view and tips for player
     */
    private void makeRightSidePanel(){
        // make right side panel with some text on a label
        // and two buttons to swap characters
        JPanel stats = new JPanel();
        stats.setBackground(Color.lightGray);
        stats.setLayout(new GridLayout(3,1));
        JPanel statsTop = new JPanel();
        statsTop.setBackground(Color.lightGray);
        wolfs = new JLabel("change");
        wolfs.setHorizontalTextPosition(JLabel.CENTER);
        wolfs.setVerticalTextPosition(JLabel.CENTER);
        wolfs.setForeground(Color.BLACK);
        wolfs.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        wolfs.setText("<html>" +
                "<body width='170'>"+
                "CHANGE HERO" +
                "<br>(resets level)"+
                "</html>");
        statsTop.add(wolfs, BorderLayout.CENTER);
        JPanel statsMid = new JPanel(new GridLayout(1,2));
        statsMid.setBackground(Color.lightGray);
        fatFairy = new JButton("<html> FAT <br> FAIRY </html>");
        fatFairy.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        fatFairy.setFocusable(false);
        fatFairy.addActionListener(this);
        statsMid.add(fatFairy);

        blueFairy = new JButton("<html> BLUE <br> FAIRY </html>");
        blueFairy.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        blueFairy.setFocusable(false);
        blueFairy.addActionListener(this);
        statsMid.add(blueFairy);


        // level changing buttons
        JPanel statsBottom = new JPanel();
        statsBottom.setBackground(Color.lightGray);
        dogs = new JLabel("change");
        dogs.setHorizontalTextPosition(JLabel.CENTER);
        dogs.setVerticalTextPosition(JLabel.CENTER);
        dogs.setForeground(Color.BLACK);
        dogs.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        dogs.setText("<html>" +
                "<body width='170'>"+
                "CHANGE LEVEL"+
                "</html>");
        statsBottom.add(dogs);
        stats.add(statsTop);
        stats.add(statsMid);
        stats.add(statsBottom);


        // make right-side panel with level picking
        JPanel levels = new JPanel();
        levels.setBackground(Color.lightGray);
        levels.setLayout(new GridLayout(7,3));
        b0 = new JButton("INTRO");
        b0.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b0.setFocusable(false);
        b0.addActionListener(this);
        levels.add(b0);
        b1 = new JButton("LEVEL 1");
        b1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b1.setFocusable(false);
        b1.addActionListener(this);
        levels.add(b1);
        b2 = new JButton("LEVEL 2");
        b2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b2.setFocusable(false);
        b2.addActionListener(this);
        levels.add(b2);
        b3 = new JButton("LEVEL 3");
        b3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b3.setFocusable(false);
        b3.addActionListener(this);
        levels.add(b3);
        b4 = new JButton("LEVEL 4");
        b4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b4.setFocusable(false);
        b4.addActionListener(this);
        levels.add(b4);
        b5 = new JButton("LEVEL 5");
        b5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b5.setFocusable(false);
        b5.addActionListener(this);
        levels.add(b5);
        b6 = new JButton("LEVEL 6");
        b6.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b6.setFocusable(false);
        b6.addActionListener(this);
        levels.add(b6);
        b7 = new JButton("LEVEL 7");
        b7.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b7.setFocusable(false);
        b7.addActionListener(this);
        levels.add(b7);
        b8 = new JButton("INTER 1");
        b8.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b8.setFocusable(false);
        b8.addActionListener(this);
        levels.add(b8);
        b9 = new JButton("BOSS");
        b9.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b9.setFocusable(false);
        b9.addActionListener(this);
        levels.add(b9);
        b10 = new JButton("INTER 2");
        b10.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b10.setFocusable(false);
        b10.addActionListener(this);
        levels.add(b10);
        b11 = new JButton("BOSS#2");
        b11.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b11.setFocusable(false);
        b11.addActionListener(this);
        levels.add(b11);
        b12 = new JButton("END");
        b12.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b12.setFocusable(false);
        b12.addActionListener(this);
        levels.add(b12);
        b13 = new JButton("CREDITS");
        b13.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b13.setFocusable(false);
        b13.addActionListener(this);
        levels.add(b13);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        b10.setEnabled(false);
        b11.setEnabled(false);
        b12.setEnabled(false);
        b13.setEnabled(false);


        // make right side panel with tips for levels
        tips = new JPanel();
        tips.setLayout(new BorderLayout());
        tips.setBackground(Color.lightGray);
        tips.add(level.playerTips(), BorderLayout.CENTER);

        // make bottom corner miniview
        miniview = new JPanel();
        miniview.setBackground(Color.lightGray);

        // add all smaller panels to the right side panel
        panel2 = new JPanel();
        panel2.setBackground(Color.GRAY);
        panel2.setLayout(new GridLayout(4,10));
        panel2.setPreferredSize(new Dimension(180, 50));
        panel2.add(stats);
        panel2.add(levels);
        panel2.add(tips);
        panel2.add(miniview);
    }

    /**
     * make JTextArea to use as a console in the game
     */
    private void makeSouthPanel(){
        // south panel with JTextPanel console for game
        pane = new JPanel();
        pane.setPreferredSize(new Dimension(frame.getWidth()-20, 100));
        pane.setBorder(new EmptyBorder(5,5,5,5));
        pane.setLayout(new BorderLayout(0 ,0 ));
        this.log = new JTextArea("YOUR GAME LOG \n", 4, 30);
        log.setMargin(new Insets(1,1,1,1));
        log.setEditable(false);
        log.setLineWrap(true);
        log.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        DefaultCaret caret = (DefaultCaret)log.getCaret(); // autoscroll to last message
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        log.setCaretPosition(log.getDocument().getLength());
        pane.add(log);
        // add scroll pane to make all new appended text visible
        JScrollPane logScrollPane = new JScrollPane(log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        logScrollPane.isWheelScrollingEnabled();
        logScrollPane.setAutoscrolls(true);
        // append jtext panel at the bottom
        log.append(logText);
        // append scroll panel
        pane.add(logScrollPane);
    }

    /**
     * get access to miniview
     * @return miniview
     */
    public JPanel getMiniView(){
        return miniview;
    }

    /**
     * Get access to tips panel for each level
     * @return tips panel
     */
    public JPanel getTips(){
        return tips;
    }

    /**
     * Get access to log
     * @return log text area
     */
    public JTextArea getLog(){
        return this.log;
    }

    /**
     * allows append message to the log console in any class having access to Game
     * @param logMessage message to be displayed in the console
     */
    public void appendLog(String logMessage){
        //getLog().append("\n" + logMessage + "\n");
        //getLog().
        this.logText = logMessage;
        getLog().append(logText + "\n");

    }

    /**
     * reads button names and return corresponding button used in Cheat
     * @param buttonName String value of button name
     * @return JButton corresponding to the name
     * @see Cheat
     */
    public JButton getButton(String buttonName){
        return switch (buttonName) {
            case "b0" -> b0;
            case "b1" -> b1;
            case "b2" -> b2;
            case "b3" -> b3;
            case "b4" -> b4;
            case "b5" -> b5;
            case "b6" -> b6;
            case "b7" -> b7;
            case "b8" -> b8;
            case "b9" -> b9;
            case "b10" -> b10;
            case "b11" -> b11;
            case "b12" -> b12;
            case "b13" -> b13;
            case "fatFairy" -> fatFairy;
            case "blueFairy" -> blueFairy;

            default -> throw new IllegalStateException("Unexpected value: " + buttonName);
        };

    }

    /**
     * Mthod allowing interaction with GUI in the frame
     * @param e object storing value of an action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // allows to carry on past scores
        Hero hero = level.getFatLady();



        // menu interaction
        //pause
        if (e.getSource()==pause){
            level.stop();
            level.gameMusic.pause();
        }
        //resume
        else if (e.getSource()==resume) {
            level.start();
            level.gameMusic.resume();
        }
        // save game
        // allows picking saving destination but doesn't allow to save L5-7
        else if (e.getSource()==save){
            if (!(level instanceof Lvl5 || level instanceof Lvl6 || level instanceof Lvl6)) {
                fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fc.setCurrentDirectory(new File("data/saves"));
                int returnVal = fc.showSaveDialog(save);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        SaveLoad.saving(level, this, file + ".ser");

                        System.out.printf("Serialized data is saved");
                        this.appendLog("Serialized data is saved");
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                } else {
                    System.out.println("You chose not to save a file");
                    this.appendLog("You chose no file");
                }
            } else
                this.appendLog("THIS LEVEL DOESN'T SUPPORT SAVING \n " +
                        "READ NOTES ON RIGHT-HAND SIDE PANEL PLEASE ");

        }

        // load  game from chosen saved file
        // allows picking saving destination
        else if (e.getSource()==load) {

            fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setCurrentDirectory(new File("data/saves"));
            int returnVal = fc.showOpenDialog(load);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    // load game
                    this.preChange();
                    this.loadLevel(SaveLoad.loading(this, file));
                    this.allLevelMethods();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                }
            } else {
                System.out.println("You chose not to open a file");
                this.appendLog("You chose not to open a file");
            }
        }

        // closes game
        else if(e.getSource()==exit){
            System.out.println("Already?! You can last longer with lidocaine");
            System.exit(0);
        }
        // opens Controls window
        else if (e.getSource()==controls){
            Controls controls = new Controls(this, level);
        }
        // opens AboutLevels window
        else if (e.getSource()==briefs){
            AboutLevels aboutLevelz = new AboutLevels(this, level);
        }
        // opens AboutEnemies window
        else if (e.getSource()==enemies){
            AboutEnemies aboutEnemiez = new AboutEnemies(this, level);
        }

        // buttons to swap heros
        else if (e.getSource()==fatFairy){
            this.preChange();
            level.setHero(false);
            level = this.switchLevel();
            view.writeForeground("You chose Uuma!");
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==blueFairy){
            this.preChange();
            level.setHero(true);
            level = this.switchLevel();
            view.writeForeground("You chose Booma!");
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }

        // buttons to swap levels

        else if (e.getSource()==b0){
            this.preChange();
            level = new Lvl0(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            level.populate(this);
            allLevelMethods();
        }else if (e.getSource()==b1){
            this.preChange();
            level = new Lvl1(this);
            view.writeForeground("You move with buttons!");
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();

        }else if (e.getSource()==b2){
            this.preChange();
            level = new Lvl2(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==b3){
            this.preChange();
            level = new Lvl3(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==b4){
            this.preChange();
            level = new Lvl4(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==b5){
            this.preChange();
            level = new Lvl5(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==b6){
            this.preChange();
            level = new Lvl6(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==b7){
            this.preChange();
            level = new Lvl7(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        } else if (e.getSource()==b8){
            this.preChange();
            level = new Lvl8(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            level.populate(this);
            allLevelMethods();
        }else if (e.getSource()==b9){
            this.preChange();
            level = new Lvl9(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==b10){
            this.preChange();
            level = new Lvl10(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            level.populate(this);
            allLevelMethods();
        }else if (e.getSource()==b11){
            this.preChange();
            level = new Lvl11(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }else if (e.getSource()==b12){
            this.preChange();
            level = new Lvl12(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            level.populate(this);
            allLevelMethods();
        }else if (e.getSource()==b13){
            this.preChange();
            level = new Lvl13(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }
    }


    /**
     * Run the game.
     */

    // the main that starts the game
    public static void main(String[] args) throws IOException {

        new Game();
    }


}
