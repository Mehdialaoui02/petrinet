import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import mehdi.EnteringArc;
import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.Transition;

class EnteringArcTest {

	private EnteringArc enteringArc;
	private Place place;
	private Transition transition;

	@BeforeEach
	public void setUp() {
		place = new Place(3, null); // Initialize with 3 tokens
		transition = new Transition(null, null);
		enteringArc = new EnteringArc(2, place, transition);
	}

	@Test
	public void testIsEntering() {
		assertTrue(enteringArc.isEntering());
	}

	@Test
	public void testIsExiting() {
		assertFalse(enteringArc.isExiting());
	}

	@Test
	public void testIsExecutable() {
		assertTrue(enteringArc.isExecutable());
	}

	@Test
	public void testExecute() {
		enteringArc.execute();
		assertEquals(1, place.getTokenNumber());
	}

	@Test
	public void testExecuteNotEnoughTokens() throws NegativeTokenValueException {
		place.setTokenNumber(1);
		enteringArc.execute();
		assertEquals(0, place.getTokenNumber());
	}

	@Test
	public void testIsExecutableWhenExecutable() {
		assertTrue(enteringArc.isExecutable());
	}

	@Test
	public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
		place.setTokenNumber(1); 
		assertFalse(enteringArc.isExecutable());
	}

}
