import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertTrue;

/*
 * =====================================================================
 * IMPORTANT: Do NOT modify this file.
 * This file contains automated tests for your implementation in HangmanGame.java.
 * Modifying this file may lead to incorrect evaluation of your code.
 * =====================================================================
 */

public class HangmanGameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ByteArrayInputStream inContent;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        // Redirecting Output Stream
        System.setOut(new PrintStream(outContent));
        // Note: Input Stream will be set up in each test method as needed
    }

    @After
    public void restoreStreams() {
        // Restoring the original streams
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testCorrectGuess() {
        String word = "java\n";
        String guess = "j\na\nv\n"; // Correct guesses
        String input = word + guess;
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        HangmanGame.main(new String[] {});

        // Checking for a specific output indicating a correct guess and progression
        assertTrue(outContent.toString().contains("Congratulations!"));
    }

    @Test
    public void testGameOver() {
        String word = "java\n";
        String wrongGuesses = "b\nc\nd\ne\nf\ng\n"; // All wrong guesses leading to game over
        String input = word + wrongGuesses;
        inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        HangmanGame.main(new String[] {});

        // Checking for Game Over message
        assertTrue(outContent.toString().contains("Game Over!"));
    }
}
