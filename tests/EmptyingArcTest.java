import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import mehdi.EmptyingArc;
import mehdi.NegativeTokenValueException;
import mehdi.Place;

class EmptyingArcTest {

	private EmptyingArc emptyingArc;
	private Place place;

	@BeforeEach
	public void setUp() {
		place = new Place(3, null); 
		emptyingArc = new EmptyingArc(1, place, null); //CAA
	}

	@Test
	public void testExecute() {
		emptyingArc.execute();
		assertEquals(0, place.getTokenNumber());
	}

	@Test
	public void testIsExecutableWhenExecutable() {
		assertTrue(emptyingArc.isExecutable());
	}

	@Test
	public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
		place.setTokenNumber(0); 
		assertFalse(emptyingArc.isExecutable());
	}
}
