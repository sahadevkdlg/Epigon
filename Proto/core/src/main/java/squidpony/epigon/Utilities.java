package squidpony.epigon;

import com.badlogic.gdx.graphics.Color;
import squidpony.squidgrid.Direction;
import squidpony.squidgrid.gui.gdx.SColor;
import squidpony.squidmath.RNG;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Tommy Ettinger on 9/28/2017.
 */
public class Utilities {

    public static String caps(String input, String delimiter) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        return Arrays.stream(input.split(" "))
            .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
            .collect(Collectors.joining(" "));
    }

    public static String caps(String input) {
        return caps(input, " ");
    }

    /**
     * Provides a String full of lines appropriate for the direction. If a stable set is desired, using the first
     * character from the set returned will work nicely.
     */
    public static String linesFor(Direction dir) {
        switch (dir) {
            case DOWN:
            case UP:
                return "|｜∣ǀ";
            case DOWN_LEFT:
            case UP_RIGHT:
                return "/／╱⁄";
            case DOWN_RIGHT:
            case UP_LEFT:
                return "\\＼╲";
            case LEFT:
            case RIGHT:
                return "-－−‐‑‒–—―";
            case NONE:
            default:
                return "+＋✚✕✖✗";
        }
    }

    /**
     * Provides a String full of arrows appropriate for the direction. If a stable set is desired, using the first
     * character from the set returned will work nicely.
     */
    public static String arrowsFor(Direction dir) {
        switch (dir) {
            case DOWN:
                return "↓↡";
            case DOWN_LEFT:
                return "↙";
            case DOWN_RIGHT:
                return "↘";
            case LEFT:
                return "←↞↢";
            case UP:
                return "↑↟";
            case UP_LEFT:
                return "↖";
            case UP_RIGHT:
                return "↗";
            case RIGHT:
                return "→↠↣";
            case NONE:
            default:
                return "⊙⊛";
        }
    }

    public static Color[][] randomColors(int innerSize, RNG rng) {
        Color[][] cs = new Color[8][innerSize];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < innerSize; j++) {
                cs[i][j] = SColor.randomColorWheel(rng);
            }
        }
        return cs;
    }

}
