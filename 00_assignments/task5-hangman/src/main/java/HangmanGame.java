import java.util.Scanner;

/*
 * =====================================================================
 * Write your implementation for the assignment at the "TODO" sections.
 * For more details, refer to README.md.
 * =====================================================================
 */

public class HangmanGame {
    public static void main(String[] args) {

        // Scanner to read the input
        Scanner scanner = new Scanner(System.in);

        // Read the secret word and turn it into an array of characters
        System.out.println("Enter the secret word:");
        String completeWord = scanner.nextLine();
        char[] word = completeWord.toCharArray();

        // Initialize an array to track guessed letters, a counter for the number of wrong guesses
        boolean[] guessed_letter = new boolean[word.length];
        int remaining_guesses = 6;

        // While the game is not over, do the following:
        while (remaining_guesses > 0) {
            // 1. Reveal the letters correctly guessed so far.
            System.out.println("Current progress:");
            for (int i = 0; i < word.length; ++i) {
                System.out.print(guessed_letter[i] ? word[i] : '_');
            }
            System.out.println();
            System.out.printf("You have %d wrong guesses left.%n", remaining_guesses);

            // 2. Read the next letter from the standard input.
            System.out.print("Guess a letter:");
            String input = scanner.nextLine();
            while (input.isEmpty()) {
                System.out.println("Please don't enter empty lines (or I will get very angry)");
                System.out.print("Guess a letter:");
                input = scanner.nextLine();
            }
            char guess = input.charAt(0);

            // 3. Update according to whether the letter is in the secret word or not.
            boolean is_contained = false;
            for (int i = 0; i < word.length; ++i) {
                if (guess == word[i]) {
                    guessed_letter[i] = true;
                    is_contained = true;
                }
            }
            if (!is_contained) {
                System.out.println("Wrong guess!");
                --remaining_guesses;
                // we can end this iteration because since the user did not find any new letter he cannot know the correct word
                continue;
            }

            boolean word_found = true;
            for (int i = 0; i < guessed_letter.length && word_found; ++i) {
                word_found = guessed_letter[i];
            }
            if (word_found) break;
        }

        if (remaining_guesses > 0) {
            // 4. If the player has guessed the word, print "Congratulations! ...".
            System.out.printf("Congratulations! You've guessed the word: %s%n", completeWord);
        } else {
            // 5. If the player made too many wrong guesses, print "Game Over! ...".
            System.out.printf("Game Over! The correct word was: %s%n", completeWord);
        }

        scanner.close();
    }
}