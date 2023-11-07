package mehdi;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TransitionTest extends TestCase {
	
	private LinkedList<Arc> enteringList;
    private LinkedList<Arc> exitingList;
    private Transition transition;

    @Before
    public void setUp() {
        enteringList = new LinkedList<>();
        exitingList = new LinkedList<>();
        transition = new Transition(exitingList, enteringList);
    }
    @Test
    public void testAddEnteringArc() {
        Arc arc = new Entering_Arc(1, new Place(1,new LinkedList<Arc>()), transition);
        transition.add_enteringArc(arc);
        assertTrue(enteringList.contains(arc));
    }

    @Test
    public void testAddExitingArc() {
        Arc arc = new Entering_Arc(1, new Place(1,new LinkedList<Arc>()), transition);
        transition.add_exitingArc(arc);
        assertTrue(exitingList.contains(arc));
    }

    @Test
    public void testIsFirableTrue() {
        Place place = new Place(1, new LinkedList<Arc>());
        Arc arc1 = new Entering_Arc(1, place, transition);
        transition.add_enteringArc(arc1);
        assertTrue(transition.is_firable());
    }

    @Test
    public void testIsFirableFalse() {
    	Place place = new Place(1, new LinkedList<Arc>());
    	Arc arc1 = new Entering_Arc(3, place, transition);
        enteringList.add(arc1);
        assertFalse(transition.is_firable());
    }

    @Test
    public void testFireSuccess() throws NotFirableTransitionException {
        Place enteringPlace = new Place(2, new LinkedList<Arc>());
        Place exitingPlace = new Place(1, enteringList);
        Arc arc1 = new Entering_Arc(1, enteringPlace, transition);
        Arc arc2 = new Exiting_Arc(1, exitingPlace, transition);
        transition.add_enteringArc(arc1);
        transition.add_exitingArc(arc2);

        transition.fire();

        assertEquals(1, enteringPlace.get_tokens_nb());
        assertEquals(2, exitingPlace.get_tokens_nb());
    }

    @Test
    public void testFireFailure() throws NotFirableTransitionException {
        Place place = new Place(2, new LinkedList<Arc>());
        Arc arc = new Entering_Arc(3, place, transition);
        enteringList.add(arc);
        try { 
        	transition.fire();
        } 
        catch (NotFirableTransitionException e) {
        	assert(true);
        }

        ;
    }
}	
