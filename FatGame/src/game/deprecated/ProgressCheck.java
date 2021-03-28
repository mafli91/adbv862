package game.deprecated;

import game.used.levels.GameLevels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @deprecated
 */
public class ProgressCheck {

    public static void keepProgress(GameLevels level)throws IOException {

        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter("data/sound/progress/buttoncheck.ser");
            writer.write("L1"+","+level.l1+"\n");
            writer.write("L2"+","+level.l2+"\n");
            writer.write("L3"+","+level.l3+"\n");
            writer.write("L4"+","+level.l4+"\n");
            writer.write("L5"+","+level.l5+"\n");
            writer.write("L6"+","+level.l6+"\n");
            writer.write("L7"+","+level.l7+"\n");
            writer.write("L8"+","+level.l8+"\n");
            writer.write("L9"+","+level.l9+"\n");
            writer.write("L10"+","+level.l10+"\n");
            writer.write("L11"+","+level.l11+"\n");
            writer.write("L12"+","+level.l12+"\n");
            writer.write("L13"+","+level.l13+"\n");

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    public static void checkProgress(GameLevels level)throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            fr = new FileReader("data/sound/progress/buttoncheck.ser");
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            line = reader.readLine();
            while (line != null) {
                // process line
                String[] tokens = line.split(",");
                if (line.equals("L1")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l1 = l;
                } else if (line.equals("L2")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l2 = l;
                } else if (line.equals("L3")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l3 = l;
                } else if (line.equals("L4")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l4 = l;
                } else if (line.equals("L5")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l5 = l;
                } else if (line.equals("L6")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l6 = l;
                } else if (line.equals("L7")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l7 = l;
                } else if (line.equals("L8")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l8 = l;
                } else if (line.equals("L9")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l9 = l;
                } else if (line.equals("L10")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l10 = l;
                } else if (line.equals("L11")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l11 = l;
                } else if (line.equals("L12")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l12 = l;
                } else if (line.equals("L13")) {
                    boolean l = Boolean.parseBoolean(tokens[1]);
                    level.l13 = l;
                }
            }
        }finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }}

}
