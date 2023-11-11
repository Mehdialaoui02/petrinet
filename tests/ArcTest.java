import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.Place;
import mehdi.Transition;

class ArcTest {

	private Arc arc;
	private Place place;
	private Transition transition;

	@BeforeEach
	public void setUp() {
		place = new Place(1, null);
		transition = new Transition(null, null);
		arc = new EnteringArc(2, place, transition);
	}

	@Test
	public void testGetWeight() {
		assertEquals(2, arc.getWeight());
	}

	@Test
	public void testGetPlace() {
		assertEquals(place, arc.getPlace());
	}

	@Test
	public void testGetTransition() {
		assertEquals(transition, arc.getTransition());
	}

	@Test
	public void testSetWeight() {
		arc.setWeight(3);
		assertEquals(3, arc.getWeight());
	}

	@Test
	public void testExecute() {
		// Implement test for the execute method, if applicable
	}

}
