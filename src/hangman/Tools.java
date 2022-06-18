package hangman;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class Tools {

    private static final String OS = System.getProperty("os.name").toLowerCase();

    /**
     * Clears console screen. Detect the platform and apply the correct method.
     */
    public static void clearConsole() {
        if (System.console() != null) {
            if (OS.contains("win")) { //Clear console windows
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException ex) {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //25 new line
                }
            } else { //Clear console in bash
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } else { //Clear console universal method
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //25 new line
        }
    }

    /**
     * Generates a random int between a given margin.
     *
     * @param min Smallest number possible.
     * @param max Biggest number possible.
     * @return Integer random generated.
     */
    public static int random(int min, int max) {
        double random = Math.random() * (max - min + 1) + min;
        return (int) random;
    }
}
