package hangman;

import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class Hangman {

    public static String gameLanguage = "es";

    public static void main(String[] args) {
        ArrayList<String> wordsList;
        boolean programRunning = true;

        Tools.clearConsole();
        wordsList = GamePlay.readFile();

        do {
            switch (Menu()) {
                case 1:
                    GamePlay.playing(wordsList);
                    break;
                case 2:
                    System.out.println("Caso 2");
                    break;
                case 3:
                    System.out.println("Caso 3");
                    break;
            }
        } while (programRunning);
    }

    public static int Menu() {
        int userInput;
        boolean invalidInput = true;

        do {
            System.out.println("┌──┤HANG MAN├──┐\n");
            System.out.println("  1. Play");
            System.out.println("  2. Language");
            System.out.println("  3. Exit\n");

            userInput = Keyboard.readChar();
            Tools.clearConsole();

            if (userInput == 1 || userInput == 2 || userInput == 3) {
                invalidInput = false;
            } else {
                System.out.println("Input invalido.");
            }
        } while (invalidInput);
        return userInput;
    }
}
