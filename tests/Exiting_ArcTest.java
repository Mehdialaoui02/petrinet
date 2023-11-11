import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.ExitingArc;
import mehdi.Place;

class ExitingArcTest {

	private ExitingArc exitingArc;
	private Place place;

	@BeforeEach
    public void setUp() {
        place = new Place(0,null); 
        exitingArc = new ExitingArc(2, place, null); 
    }

    @Test
    public void testIsEntering() {
        assertFalse(exitingArc.isEntering());
    }

    @Test
    public void testIsExiting() {
        assertTrue(exitingArc.isExiting());
    }

    @Test
    public void testExecute() {
        exitingArc.execute();
        assertEquals(2, place.getTokenNumber());
    }

}
