package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Entering_ArcTest {

	private Entering_Arc enteringArc;
    private Place place;
    private Transition transition;

    @BeforeEach
    public void setUp() {
        place = new Place(3, null); // Initialize with 3 tokens
        transition = new Transition(null, null);
        enteringArc = new Entering_Arc(2, place, transition);
    }

    @Test
    public void testIsEntering() {
        assertTrue(enteringArc.is_entering());
    }

    @Test
    public void testIsExiting() {
        assertFalse(enteringArc.is_exiting());
    }

    @Test
    public void testIsExecutable() {
        assertTrue(enteringArc.is_executable());
    }

    @Test
    public void testExecute() {
        enteringArc.execute();
        assertEquals(1, place.get_tokens_nb());
    }

    @Test
    public void testExecuteNotEnoughTokens() {
        place.set_tokens_nb(1);
        enteringArc.execute();
        assertEquals(0, place.get_tokens_nb());
    }
    
    @Test
    public void testIsExecutableWhenExecutable() {
        assertTrue(enteringArc.is_executable());
    }

    @Test
    public void testIsExecutableWhenNotExecutable() {
        place.set_tokens_nb(1); 
        assertFalse(enteringArc.is_executable());
    }

}
