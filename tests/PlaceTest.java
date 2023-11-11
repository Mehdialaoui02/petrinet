import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;


import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.Transition;

class PlaceTest {


    @Test
    public void testGetTokensNumber() {
    	Place place = new Place(5, new LinkedList<Arc>());
        assertEquals(5, place.getTokenNumber());
    }

    @Test
    public void testSetTokensNumber() throws NegativeTokenValueException {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(5);
        assertEquals(5, place.getTokenNumber());
    }

    @Test
    public void testIsEmptyWhenEmpty() throws NegativeTokenValueException {

    	Place place = new Place(8, new LinkedList<Arc>());
    	place.setTokenNumber(0);

        assertTrue(place.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() throws NegativeTokenValueException {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(3);
        assertFalse(place.isEmpty());
    }

    @Test
    public void testAddArc() {
    	Place place = new Place(5, new LinkedList<Arc>());
        Arc arc = new EnteringArc(3, place, new Transition(null, null));
        place.addArc(arc);
        assertEquals(1, place.getArcList().size());
    }

    @Test
    public void testAddTokens() throws NegativeTokenValueException { //CAJ1 -- CAJ0
    	Place place = new Place(5, new LinkedList<Arc>());
        place.addTokens(3);
        assertEquals(8, place.getTokenNumber());
    }

    @Test
    public void testRemoveTokens() throws NegativeTokenValueException { 
    	Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(5);//CDJ1 -- CDJ0
        place.removeTokens(2);//CEJ1 -- CEJ0
        assertEquals(3, place.getTokenNumber());
    }

    @Test
    public void testRemoveAllTokens() throws NegativeTokenValueException {
    	Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(3);
        place.removeAllTokens();
        assertEquals(0, place.getTokenNumber());
    }

}
