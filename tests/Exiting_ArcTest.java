package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Exiting_ArcTest {

	private Exiting_Arc exitingArc;
	private Place place;

	@BeforeEach
    public void setUp() {
        place = new Place(0,null); 
        exitingArc = new Exiting_Arc(2, place, null); 
    }

    @Test
    public void testIsEntering() {
        assertFalse(exitingArc.is_entering());
    }

    @Test
    public void testIsExiting() {
        assertTrue(exitingArc.is_exiting());
    }

    @Test
    public void testExecute() {
        exitingArc.execute();
        assertEquals(2, place.get_tokens_nb());
    }

}
