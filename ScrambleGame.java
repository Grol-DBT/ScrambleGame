import java.util.Scanner;

public class ScrambleGame {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Scramble Game");

        // Check User input
        checkInput();

    }

    public static void checkInput() {
        // Initialize array of words and hints
        String wordsAndHints[][] = {
                { "apple", "This is a delicious fruit." },
                { "french", "This is a european language." },
                { "coffee", "This is a delicious beverage, often served hot." }
        };
        for (int i = 0; i < 3; i++) {
            Scanner in = new Scanner(System.in);
            String word;
            do {
                System.out.println(
                        "Word Number " + (i + 1) + ": Unscramble the word: " + scramble(wordsAndHints[(i)][0]));
                userPrompts();
                // Process user input
                word = in.next();
                if (word.equals("h")) {
                    System.out.println('\t' + wordsAndHints[(i)][1]);
                } else if (word.equals(wordsAndHints[(i)][0])) {
                    System.out.println("You are correct");
                } else if (word.equals("q")) {
                    System.exit(0);
                } else {
                    System.out.println("Incorrect. The word is " + wordsAndHints[(i)][0]);
                }
            } while (word.equals("h"));
        }
    }

    public static String scramble(String s) {
        // TASK 1: Create and array of characters
        char[] letters = s.toCharArray();

        // TASK 2: SWAP EACH CHARACTER WITH ONE AT A RANDOM SPOT
        for (int i = 0; i < s.length(); i++) {
            // step a: get a random cell
            int loc = (int) (Math.random() * s.length());

            // step b: swap
            char temp = letters[i];
            letters[i] = letters[loc];
            letters[loc] = temp;
        }
        // TASK 3: CONVERT THE ARRAY TO A STRING AND RETURN
        return new String(letters);
    }

    public static void userPrompts() {
        // Prompt the user for input
        System.out.println("Type the letter h, followed by [ENTER], if you want a hint.");
        System.out.println("Type the letter q, followed by [ENTER], if you want to quit the game.");
        System.out.println("User input: ");
    }

}
