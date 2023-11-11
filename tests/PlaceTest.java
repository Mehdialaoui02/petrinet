import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;


import mehdi.Arc;
import mehdi.Entering_Arc;
import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.Transition;

class PlaceTest {


    @Test
    public void testGetTokensNumber() {
    	Place place = new Place(5, new LinkedList<Arc>());
        assertEquals(5, place.get_tokens_nb());
    }

    @Test
    public void testSetTokensNumber() throws NegativeTokenValueException {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.set_tokens_nb(5);
        assertEquals(5, place.get_tokens_nb());
    }

    @Test
    public void testIsEmptyWhenEmpty() throws NegativeTokenValueException {

    	Place place = new Place(8, new LinkedList<Arc>());
    	place.set_tokens_nb(0);

        assertTrue(place.is_empty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() throws NegativeTokenValueException {
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
    public void testAddTokens() throws NegativeTokenValueException { //CAJ1 -- CAJ0
    	Place place = new Place(5, new LinkedList<Arc>());
        place.add_tokens(3);
        assertEquals(8, place.get_tokens_nb());
    }

    @Test
    public void testRemoveTokens() throws NegativeTokenValueException { 
    	Place place = new Place(5, new LinkedList<Arc>());
        place.set_tokens_nb(5);//CDJ1 -- CDJ0
        place.remove_tokens(2);//CEJ1 -- CEJ0
        assertEquals(3, place.get_tokens_nb());
    }

    @Test
    public void testRemoveAllTokens() throws NegativeTokenValueException {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.set_tokens_nb(3);
        place.remove_all_tokens();
        assertEquals(0, place.get_tokens_nb());
    }

}
