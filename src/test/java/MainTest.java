import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testValidGamePlay() {
        String input = "0\n0\n1\n1\n0\n1\n2\n2\n0\n2\n";
        simulateInputOutput(input, "Player X wins!", "The game is a draw.");
    }

    @Test
    public void testInvalidRowInput() {
        String input = "3\n0\n0\n0\n1\n1\n2\n2\n0\n2\n";
        simulateInputOutput(input, "Invalid input. Please enter numbers between 0 and 2.", "Player X wins!", "The game is a draw.");
    }

    @Test
    public void testInvalidColumnInput() {
        String input = "0\n0\n1\n3\n1\n1\n2\n2\n0\n2\n";
        simulateInputOutput(input, "Invalid input. Please enter numbers between 0 and 2.", "Player X wins!", "The game is a draw.");
    }

    @Test
    public void testOccupiedCellInput() {
        String input = "0\n0\n0\n0\n1\n1\n2\n2\n0\n1\n0\n2\n";
        simulateInputOutput(input, "Cell is not empty. Please try again.", "Player X wins!", "The game is a draw.");
    }

    private void simulateInputOutput(String input, String... expectedOutputs) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            Main.main(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown during test: " + e.getMessage());
        } finally {
            // Reset System.in and System.out to their original values
            System.setIn(System.in);
            System.setOut(System.out);
        }

        String gameOutput = out.toString();
        for (String expected : expectedOutputs) {
            assertTrue(gameOutput.contains(expected), "Expected output not found: " + expected);
        }
    }
}
