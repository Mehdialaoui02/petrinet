package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PlaceTest {

    @Test
    public void testGetTokensNumber() {
    	Place place = new Place(5, new LinkedList<Arc>());
        assertEquals(5, place.get_tokens_nb());
    }

    @Test
    public void testSetTokensNumber() {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.set_tokens_nb(5);
        assertEquals(5, place.get_tokens_nb());
    }

    @Test
    public void testIsEmptyWhenEmpty() {
    	Place place = new Place(8, new LinkedList<Arc>());
    	place.set_tokens_nb(0);
        assertTrue(place.is_empty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.set_tokens_nb(3);
        assertFalse(place.is_empty());
    }

    @Test
    public void testAddArc() {
    	Place place = new Place(5, new LinkedList<Arc>());
        Arc arc = new Entering_Arc(3, place, new Transition(null, null));
        place.add_arc(arc);
        assertEquals(1, place.get_arcList().size());
    }

    @Test
    public void testAddTokens() {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.add_tokens(3);
        assertEquals(8, place.get_tokens_nb());
    }

    @Test
    public void testRemoveTokens() {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.set_tokens_nb(5);
        place.remove_tokens(2);
        assertEquals(3, place.get_tokens_nb());
    }

    @Test
    public void testRemoveAllTokens() {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.set_tokens_nb(3);
        place.remove_all_tokens();
        assertEquals(0, place.get_tokens_nb());
    }

}
