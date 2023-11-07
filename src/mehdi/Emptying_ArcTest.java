package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Emptying_ArcTest {

	 	private Emptying_Arc emptyingArc;
	    private Place place;

	    @BeforeEach
	    public void setUp() {
	        place = new Place(3, null); 
	        emptyingArc = new Emptying_Arc(1, place, null);
	    }

	    @Test
	    public void testExecute() {
	        emptyingArc.execute();
	        assertEquals(0, place.get_tokens_nb());
	    }

	    @Test
	    public void testIsExecutableWhenExecutable() {
	        assertTrue(emptyingArc.is_executable());
	    }

	    @Test
	    public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
	        place.set_tokens_nb(0); 
	        assertFalse(emptyingArc.is_executable());
	    }
}
