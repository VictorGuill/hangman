package hangman;

import static hangman.Hangman.gameLanguage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author victor
 */
public class GamePlay {

    public static void playing(ArrayList<String> wordsList) {
        String word;
        HashSet<Character> wordCharacters;
        ArrayList<Character> userAttemps = new ArrayList<>();
        char userInput;
        int intentos = 0;

        word = wordsList.get(Tools.random(0, wordsList.size() - 1));
        wordCharacters = getWordLetters(word);

        do {

            Tools.clearConsole();
            System.out.println("Intentos: "+intentos);
            printWordState(word, userAttemps);

            userInput = Keyboard.readChar();
            userAttemps.add(userInput);

            if (wordCharacters.contains(userInput)) {
                wordCharacters.remove(userInput);
            }
            
            intentos++;

        } while (!wordCharacters.isEmpty());

    }

    /**
     * Reads a file and returns ArrayList containig file's content.
     *
     * @return
     */
    public static ArrayList<String> readFile() {
        ArrayList<String> words = new ArrayList<>();

        try {
            FileReader wordsFile = new FileReader("files\\words_" + gameLanguage + ".txt");
            BufferedReader br = new BufferedReader(wordsFile);

            String s = br.readLine();

            while (s != null) {
                words.add(s);
                s = br.readLine();
            }

            wordsFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo."
                    + e.toString());
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al archivo."
                    + e.toString());
        }
        return words;
    }

    public static void printWordState(String word, ArrayList<Character> userAttemps) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                System.out.print("  ");
            } else if (userAttemps.contains(word.charAt(i))) {
                System.out.print(word.charAt(i) + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("");
    }

    public static HashSet<Character> getWordLetters(String word) {
        HashSet<Character> wordCharacters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                wordCharacters.add(word.charAt(i));
            }
        }
        return wordCharacters;
    }
}
