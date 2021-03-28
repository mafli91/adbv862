
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


/**
 * NOT IN USE, TO MOVE THE FRAME FROM THE MAIN this CLASS TO LATER
 * @deprecated
 */

 /* public class MyFrame extends JFrame implements ActionListener, Serializable {

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
    private JFileChooser fc;

    private this this;
    private thisLevels level;
    private MyView view;


    public MyFrame(World w, this this, thisLevels level, MyView view) {
        frame.this = this;
        frame.level = level;
        frame.view = view;

        frame.makeFrame();
        frame.makeRightSidePanel();
        frame.makeSouthPanel();
        frame.makeTopMenu();
        frame.addComponents();


    }

    public void addComponents(){
        // add components to the frame
        frame.add(panel2, BorderLayout.EAST);
        frame.add(log, BorderLayout.SOUTH);
        frame.add(view, BorderLayout.CENTER);
        frame.setJMenuBar(menu);
    }

    private void makeFrame(){
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(945, 685));
        frame.setPreferredSize(new Dimension(945, 700));
        frame.setMaximumSize(new Dimension(950, 655));
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
        pause.addActionListener(frame);
        pause.setMnemonic('P');
        resume = new JMenuItem("Resume");
        resume.addActionListener(frame);
        resume.setMnemonic('R');
        save = new JMenuItem("Save");
        save.addActionListener(frame);
        save.setMnemonic('V');
        load = new JMenuItem("Load");
        load.addActionListener(frame);
        load.setMnemonic('L');
        exit = new JMenuItem("Exit");
        exit.addActionListener(frame);
        exit.setMnemonic('X');
        controls = new JMenuItem("Controls");
        controls.addActionListener(frame);
        controls.setMnemonic('C');
        briefs = new JMenuItem("About Levels");
        briefs.addActionListener(frame);
        briefs.setMnemonic('O');
        enemies = new JMenuItem("About Enemies");
        enemies.addActionListener(frame);
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
        fatFairy.addActionListener(frame);
        statsMid.add(fatFairy);

        blueFairy = new JButton("<html> BLUE <br> FAIRY </html>");
        blueFairy.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        blueFairy.setFocusable(false);
        blueFairy.addActionListener(frame);
        statsMid.add(blueFairy);



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
        b0.addActionListener(frame);
        levels.add(b0);
        b1 = new JButton("LEVEL 1");
        b1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b1.setFocusable(false);
        b1.addActionListener(frame);
        levels.add(b1);
        b2 = new JButton("LEVEL 2");
        b2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b2.setFocusable(false);
        b2.addActionListener(frame);
        levels.add(b2);
        b3 = new JButton("LEVEL 3");
        b3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b3.setFocusable(false);
        b3.addActionListener(frame);
        levels.add(b3);
        b4 = new JButton("LEVEL 4");
        b4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b4.setFocusable(false);
        b4.addActionListener(frame);
        levels.add(b4);
        b5 = new JButton("LEVEL 5");
        b5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b5.setFocusable(false);
        b5.addActionListener(frame);
        levels.add(b5);
        b6 = new JButton("LEVEL 6");
        b6.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b6.setFocusable(false);
        b6.addActionListener(frame);
        levels.add(b6);
        b7 = new JButton("LEVEL 7");
        b7.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b7.setFocusable(false);
        b7.addActionListener(frame);
        levels.add(b7);
        b8 = new JButton("INTER 1");
        b8.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b8.setFocusable(false);
        b8.addActionListener(frame);
        levels.add(b8);
        b9 = new JButton("BOSS");
        b9.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b9.setFocusable(false);
        b9.addActionListener(frame);
        levels.add(b9);
        b10 = new JButton("INTER 2");
        b10.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b10.setFocusable(false);
        b10.addActionListener(frame);
        levels.add(b10);
        b11 = new JButton("BOSS#2");
        b11.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b11.setFocusable(false);
        b11.addActionListener(frame);
        levels.add(b11);
        b12 = new JButton("END");
        b12.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b12.setFocusable(false);
        b12.addActionListener(frame);
        levels.add(b12);
        b13 = new JButton("CREDITS");
        b13.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
        b13.setFocusable(false);
        b13.addActionListener(frame);
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

    private void makeSouthPanel(){
        // south panel with JTextPanel console for this
        log = new JTextArea("YOUR this LOG", 4, 1);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        log.setLineWrap(true);
        JScrollPane logScrollPane = new JScrollPane(log);
    }

    public JPanel getMiniView(){
        return miniview;
    }
    public JPanel getTips(){
        return tips;
    }
    public void appendLog(String logMessage){
        log.append(logMessage);
        log.setCaretPosition(log.getDocument().getLength());
    }
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







    @Override
    public void actionPerformed(ActionEvent e) {
        // allows to carry on past scores
        Hero hero = level.getFatLady();



        // menu interaction
        if (e.getSource()==pause){
            level.stop();
            level.thisMusic.pause();
        } else if (e.getSource()==resume) {
            level.start();
            level.thisMusic.resume();
        }

        else if (e.getSource()==save){
            fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setCurrentDirectory(new File("data/saves"));
            int returnVal = fc.showSaveDialog(save);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    SaveLoad.saving(level, this, file+".ser");

                    System.out.printf("Serialized data is saved");
                } catch (IOException i) {
                    i.printStackTrace();
                }
            } else {
                System.out.println("You chose not to save a file");
            }

        } else if (e.getSource()==load){
            fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fc.setCurrentDirectory(new File("data/saves"));
            int returnVal = fc.showOpenDialog(load);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    this.preChange();
                    this.loadLevel(SaveLoad.loading(this, file));
                    this.allLevelMethods();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                }
            } else {
                System.out.println("You chose not to open a file");
            }
        }


        else if(e.getSource()==exit){
            System.out.println("Already?! You can last longer with lidocaine");
            System.exit(0);
        } else if (e.getSource()==controls){
            Controls controls = new Controls(this, level);
        } else if (e.getSource()==briefs){
            AboutLevels aboutLevelz = new AboutLevels(this, level);
        } else if (e.getSource()==enemies){
            AboutEnemies aboutEnemiez = new AboutEnemies(this, level);
        }
        // buttons to swap hero

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
            this.comicStripLevels();
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
            this.comicStripLevels();
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
            this.comicStripLevels();
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
            this.comicStripLevels();
        }else if (e.getSource()==b13){
            this.preChange();
            level = new Lvl13(this);
            level.getFatLady().setFat(hero.getFat());
            level.getFatLady().setLayers(hero.getLayers());
            level.getFatLady().setLollipopCount(hero.getLollipopCount());
            this.newLevelGo();
        }
    }
}


 Turns out objects using City Engine are not Serializable because even if
 * I make Attached Images transient World View is not Serializable
 * neither are some Body properties. So no, this cannot be simply serialized.
 * !! _m_(>_<)'_m_ !!

 else if (e.getSource()==save){
 fc = new JFileChooser();
 fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
 fc.setCurrentDirectory(new File ("data/saves"));
 int returnVal = fc.showSaveDialog(save);

 if (returnVal == JFileChooser.APPROVE_OPTION) {
 File file = fc.getSelectedFile();
 try {
 FileOutputStream fileOut =
 new FileOutputStream(file+".ser");
 ObjectOutputStream out = new ObjectOutputStream(fileOut);
 out.writeObject(level);
 out.close();
 fileOut.close();
 System.out.printf("Serialized data is saved");
 } catch (IOException i) {
 i.printStackTrace();
 }
 } else {
 System.out.println("You chose not to save a file");
 }

 } else if (e.getSource()==load){
 fc = new JFileChooser();
 fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
 fc.setCurrentDirectory(new File("data/saves"));
 int returnVal = fc.showOpenDialog(load);

 if (returnVal == JFileChooser.APPROVE_OPTION) {
 File file = fc.getSelectedFile();
 try {

 FileInputStream fileIn = new FileInputStream(file);
 ObjectInputStream in = new ObjectInputStream(fileIn);
 in.readObject();
 in.close();
 fileIn.close();
 } catch (IOException i) {
 i.printStackTrace();
 return;
 } catch (ClassNotFoundException c) {
 System.out.println("Save not found");
 c.printStackTrace();
 return;
 }
 } else {
 System.out.println("You chose not to open a file");
 } */