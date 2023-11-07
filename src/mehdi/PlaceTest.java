package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PlaceTest {

	private Place place;

    @Before
    public void setUp() {
        LinkedList<Arc> arcsList = new LinkedList<Arc>();
        place = new Place(0, arcsList);
    }

    @Test
    public void testGetTokensNumber() {
        assertEquals(0, place.get_tokens_nb());
    }

    @Test
    public void testSetTokensNumber() {
        place.set_tokens_nb(5);
        assertEquals(5, place.get_tokens_nb());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
    	System.out.println(place.get_tokens_nb());
        assertTrue(place.is_empty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        place.set_tokens_nb(3);
        assertFalse(place.is_empty());
    }

    @Test
    public void testAddArc() {
        Arc arc = new Entering_Arc(3, place, new Transition(null, null));
        place.add_arc(arc);
        assertEquals(1, place.get_arcList().size());
    }

    @Test
    public void testAddTokens() {
        place.add_tokens(3);
        assertEquals(3, place.get_tokens_nb());
    }

    @Test
    public void testRemoveTokens() {
        place.set_tokens_nb(5);
        place.remove_tokens(2);
        assertEquals(3, place.get_tokens_nb());
    }

    @Test
    public void testRemoveAllTokens() {
        place.set_tokens_nb(5);
        place.remove_all_tokens();
        assertEquals(0, place.get_tokens_nb());
    }

}
