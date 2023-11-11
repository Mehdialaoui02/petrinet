import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.ZeroArc;

class ZeroArcTest {

	private ZeroArc zeroArc;
	private Place place;

	@BeforeEach
	public void setUp() {
		place = new Place(0, null);
		zeroArc = new ZeroArc(0, place, null); 
	}

	@Test
	public void testExecute() {
		zeroArc.execute();
		assertEquals(0, place.getTokenNumber());
	}

	@Test
	public void testIsExecutableWhenExecutable() { //RRR
		assertTrue(zeroArc.isExecutable());
	}

	@Test
	public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
		place.setTokenNumber(1); 
		assertFalse(zeroArc.isExecutable());
	}

}
