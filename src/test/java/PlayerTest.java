import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testGetMarker() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());

        Player player2 = new Player('O');
        assertEquals('O', player2.getMarker());
    }
}
