package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArcTest {

	private Arc arc;
    private Place place;
    private Transition transition;

    @BeforeEach
    public void setUp() {
        place = new Place(1, null);
        transition = new Transition(null, null);
        arc = new Entering_Arc(2, place, transition);
    }

    @Test
    public void testGetWeight() {
        assertEquals(2, arc.get_Weight());
    }

    @Test
    public void testGetPlace() {
        assertEquals(place, arc.get_Place());
    }

    @Test
    public void testGetTransition() {
        assertEquals(transition, arc.get_Transition());
    }

    @Test
    public void testSetWeight() {
        arc.set_weight(3);
        assertEquals(3, arc.get_Weight());
    }

    @Test
    public void testExecute() {
        // Implement test for the execute method, if applicable
    }

}
