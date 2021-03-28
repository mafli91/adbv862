package game.used.world.GUI;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import game.used.levels.*;
import game.used.objects.collectable.FairyDust;
import game.used.objects.collectable.Collectable;
import game.used.objects.collectable.Lolly;
import game.used.objects.enemy.*;
import game.used.objects.enemy.boss.Boss;
import game.used.objects.enemy.boss.BossEye;
import game.used.objects.hero.BlueFairy;
import game.used.objects.hero.FatFairy;
import game.used.objects.hero.Hero;
import game.used.objects.other.*;
import game.used.world.Game;
import org.jbox2d.common.Vec2;

import java.io.*;

/**
 * Class allowing to save and load game state
 */
public class SaveLoad {


    /**
     * Saves state of objects in the level stored in populate()
     * @param level current level saved
     * @param game game object
     * @param fileName name of the file to be saved into
     * @throws IOException
     */
    public static void saving (GameLevels level, Game game, String fileName) throws IOException {

        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);

            if (game.getHeroine())
                writer.write("BLUE"+"\n");
            else
                writer.write("FAT"+"\n");

            writer.write(level.getLevelName() + "\n");


            for (StaticBody body : level.getStaticBodies()) {
                if (body instanceof ComicStrip0) {
                    writer.write("ComicStrip0"+ ","+((ComicStrip) body).getSwapCount()+ "\n");
                } else if (body instanceof ComicStrip8) {
                    writer.write("ComicStrip8"+ ","+((ComicStrip) body).getSwapCount()+ "\n");
                } else if (body instanceof ComicStrip10) {
                    writer.write("ComicStrip10"+ ","+((ComicStrip) body).getSwapCount()+ "\n");
                } else if (body instanceof ComicStrip12) {
                    writer.write("ComicStrip12"+ ","+((ComicStrip) body).getSwapCount()+ "\n");
                }}


            for (DynamicBody body : level.getDynamicBodies()) {
                if (body instanceof FairyDust) {
                    writer.write("Burger" + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
                }else if (body instanceof Lolly) {
                    writer.write("Lolly" + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
                }else if (body instanceof Dog) {
                    writer.write("Dog"+ ","+body.getPosition().x+ ","+body.getPosition().y+","+
                            ((Enemy) body).getSpeed()+","+((Enemy) body).getLife()+ "\n");
                }else if (body instanceof Puppy) {
                    writer.write("Puppy"+ ","+body.getPosition().x+ ","+body.getPosition().y+","+
                            ((Enemy) body).getSpeed()+","+((Enemy) body).getLife()+ "\n");
                }else if (body instanceof Wolf) {
                    writer.write("Wolf"+ ","+body.getPosition().x+ ","+body.getPosition().y+","+
                            ((Enemy) body).getSpeed()+","+((Enemy) body).getLife()+ "\n");
                }else if (body instanceof Bat) {
                    writer.write("Bat"+ ","+body.getPosition().x+ ","+body.getPosition().y+","+
                            ((Enemy) body).getSpeed()+","+((Enemy) body).getLife()+ "\n");
                }else if (body instanceof BossEye) {
                    writer.write("BossEye"+ ","+body.getPosition().x+ ","+body.getPosition().y+","+
                            ((BossEye) body).getLife()+ "\n");
                }else if (body instanceof Boss) {
                    writer.write("Boss"+ ","+body.getPosition().x+ ","+body.getPosition().y+","+
                            ((Boss) body).getSpeed()+","+body.getGravityScale()+","+((Boss) body).getLife()+","+
                            ((Boss)body).getEyeCount()+"\n");
                }else if (body instanceof FatFairy) {
                    writer.write("FatFairy" + ","+ body.getPosition().x+","+body.getPosition().y+","+
                            ((Hero)body).getFat()+","+((Hero)body).getBurgerCount()+","+
                            ((Hero)body).getLayers()+","+((Hero)body).getLollipopCount()+ "\n");
                }else if (body instanceof BlueFairy) {
                        writer.write("BlueFairy"+ ","+ body.getPosition().x+","+body.getPosition().y+","+
                                ((Hero)body).getFat()+","+((Hero)body).getBurgerCount()+","+
                                ((Hero)body).getLayers()+","+((Hero)body).getLollipopCount()+ "\n");
                }
            }
            if (!(level instanceof Lvl5 || level instanceof Lvl6 || level instanceof Lvl7))
                writer.write("This has been loaded from the save, daa..."+"\n");
            else
                writer.write("I assume you can read so why even..."+"\n");

        } finally {
            if (writer != null) {
                writer.close();
                game.appendLog("Game saved");
            }
        }
    }

    /**
     * Reads and restores saved game from the file
     * @param game game object
     * @param fileName name of the file to load the game from
     * @return level
     * @throws IOException
     */
    public static GameLevels loading(Game game, File fileName) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            if(line.equals("BLUE"))
                game.setHeroine(true);
            else if(line.equals("FAT"))
                game.setHeroine(false);

            line = reader.readLine();
            GameLevels level = null;
            if (line.equals("L0"))
                level= new Lvl0(game);
            else if (line.equals("L1"))
                level= new Lvl1(game);
            else if (line.equals("L2"))
                level= new Lvl2(game);
            else if (line.equals("L3"))
                level= new Lvl3(game);
            else if (line.equals("L4"))
                level= new Lvl4(game);
            else if (line.equals("L5"))
                level= new Lvl5(game);
            else if (line.equals("L6"))
                level= new Lvl6(game);
            else if (line.equals("L7"))
                level= new Lvl7(game);
            else if (line.equals("L8"))
                level= new Lvl8(game);
            else if (line.equals("L9"))
                level= new Lvl9(game);
            else if (line.equals("L10"))
                level= new Lvl10(game);
            else if (line.equals("L11"))
                level= new Lvl11(game);
            else if (line.equals("L12"))
                level= new Lvl12(game);
            else if (line.equals("L13"))
                level= new Lvl13(game);

            Hero hero = level.getFatLady();


            line = reader.readLine();
            while (line != null) {
                // process line
                String[] tokens = line.split(",");
                if(tokens[0].equals("ComicStrip0")) {
                    ComicStrip0 c = new ComicStrip0(level, game);
                    int sc = Integer.parseInt(tokens[1]);
                    c.setSwapCount(sc);
                }else if (tokens[0].equals("ComicStrip8")){
                    ComicStrip8 c = new ComicStrip8(level, game);
                    int sc = Integer.parseInt(tokens[1]);
                    c.setSwapCount(sc);
                }else if (tokens[0].equals("ComicStrip10")){
                    ComicStrip10 c = new ComicStrip10(level, game);
                    int sc = Integer.parseInt(tokens[1]);
                    c.setSwapCount(sc);
                }else if (tokens[0].equals("ComicStrip12")){
                    ComicStrip12 c = new ComicStrip12(level, game);
                    int sc = Integer.parseInt(tokens[1]);
                    c.setSwapCount(sc);
                }else if (tokens[0].equals("Burger")){
                    Collectable b = new FairyDust(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                }else if (tokens[0].equals("Lolly")){
                    Collectable b = new Lolly(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                }else if (tokens[0].equals("Dog")){
                    Enemy b = new Dog(level, game, level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                    int z = Integer.parseInt(tokens[3]);
                    b.setSpeed(z);
                    int l = Integer.parseInt(tokens[4]);
                    b.setLife(20-l);
                }else if (tokens[0].equals("Puppy")){
                    Enemy b = new Puppy(level, game, level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                    int z = Integer.parseInt(tokens[3]);
                    b.setSpeed(z);
                    int l = Integer.parseInt(tokens[4]);
                    b.setLife(14-l);
                }else if (tokens[0].equals("Wolf")){
                    Enemy b = new Wolf(level, game, level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                    int z = Integer.parseInt(tokens[3]);
                    b.setSpeed(z);
                    int l = Integer.parseInt(tokens[4]);
                    b.setLife(28-l);
                }else if (tokens[0].equals("Bat")){
                    Enemy b = new Bat(level, game, level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                    int z = Integer.parseInt(tokens[3]);
                    b.setSpeed(z);
                    int l = Integer.parseInt(tokens[4]);
                    b.setLife(7-l);
                }else if (tokens[0].equals("BossEye")){
                    Enemy b = new BossEye(level,level, game, level.getFatLady());
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                    int l = Integer.parseInt(tokens[3]);
                    b.setLife(50-l);
                }else if (tokens[0].equals("Boss")){
                    Enemy b = new Boss(level,level, game, level.getFatLady());
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x,y));
                    int z = Integer.parseInt(tokens[3]);
                    b.setSpeed(z);
                    int g = Integer.parseInt(tokens[4]);
                    b.setGravityScale(g);
                    int l = Integer.parseInt(tokens[5]);
                    b.setLife(50-l);
                    game.getView().writeForeground("CREEPs LIVES: "+ b.getLife()+ " !");
                    int e = Integer.parseInt(tokens[6]);
                    b.setEyeCount(e);
                }else if (tokens[0].equals("FatFairy")){
                    fairy(level, tokens);
                }else if (tokens[0].equals("BlueFairy")){
                    fairy(level, tokens);
                }

                line = reader.readLine();
                    if(line!=null)
                        game.getView().writeForeground(line);

            }

            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
            game.appendLog("Game loaded");
        }

    }

    private static void fairy(GameLevels level, String[] tokens) {
        float x = Float.parseFloat(tokens[1]);
        float y = Float.parseFloat(tokens[2]);
        level.getFatLady().setPosition(new Vec2(x,y));
        int f = Integer.parseInt(tokens[3]);
        level.getFatLady().setFat(f);
        int bc = Integer.parseInt(tokens[4]);
        level.getFatLady().setBurgerCount(bc);
        int ly = Integer.parseInt(tokens[5]);
        level.getFatLady().setLayers(ly);
        int lol = Integer.parseInt(tokens[6]);
        level.getFatLady().setLollipopCount(lol);
    }


}
