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
        char[] word = scanner.nextLine().toCharArray();

        // TODO: Initialize an array to track guessed letters, a counter for the
        // number of wrong guesses, etc.

        // TODO: While the game is not over, do the following:
        // 1. Reveal the letters correctly guessed so far.
        // 2. Read the next letter from the standard input.
        // 3. Update according to whether the letter is in the secret word or not.
        // 4. If the player has guessed the word, print "Congratulations! ...".
        // 5. If the player made too many wrong guesses, print "Game Over! ...".

        scanner.close();
    }
}
