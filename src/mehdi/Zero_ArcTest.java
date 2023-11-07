package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Zero_ArcTest {

	private Zero_Arc zeroArc;
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(0, null);
        zeroArc = new Zero_Arc(0, place, null); 
    }

    @Test
    public void testExecute() {
        zeroArc.execute();
        assertEquals(0, place.get_tokens_nb());
    }

    @Test
    public void testIsExecutableWhenExecutable() {
        assertTrue(zeroArc.is_executable());
    }

    @Test
    public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
        place.set_tokens_nb(1); 
        assertFalse(zeroArc.is_executable());
    }

}
