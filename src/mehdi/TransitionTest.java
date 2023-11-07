package mehdi;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TransitionTest extends TestCase {
	
	private LinkedList<Entering_Arc> enteringList;
    private LinkedList<Arc> exitingList;
    private Transition transition;

    @Before
    public void setUp() {
        enteringList = new LinkedList<Entering_Arc>();
        exitingList = new LinkedList<Arc>();
        transition = new Transition(exitingList, enteringList);
    }
    @Test
    public void testAddEnteringArc() {
    	Entering_Arc arc = new Entering_Arc(1, new Place(1,new LinkedList<Arc>()), transition);
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
        Entering_Arc arc1 = new Entering_Arc(1, place, transition);
        transition.add_enteringArc(arc1);
        assertTrue(transition.is_firable());
    }
    
    @Test
    public void testIsFirableTrueDoubleArc() {
        Place place = new Place(2, new LinkedList<Arc>());
        Entering_Arc arc1 = new Entering_Arc(1, place, transition);
        Entering_Arc arc2 = new Entering_Arc(2, place, transition);
        transition.add_enteringArc(arc1);
        transition.add_enteringArc(arc2);
        assertTrue(transition.is_firable());
    }

    @Test
    public void testIsFirableFalse() {
    	Place place = new Place(1, new LinkedList<Arc>());
    	Entering_Arc arc1 = new Entering_Arc(3, place, transition);
        enteringList.add(arc1);
        assertFalse(transition.is_firable());
    }
    
    public void testIsFirableFalseZero_Emptying() {
    	Place place = new Place(3, new LinkedList<Arc>());
    	Entering_Arc arc1 = new Emptying_Arc(2, place, transition);
    	Entering_Arc arc2 = new Zero_Arc(0, place, transition);
        enteringList.add(arc1);
        enteringList.add(arc2);
        assertFalse(transition.is_firable());
    }
    
    public void testIsFirableFalseDoubleArc() {
    	Place place = new Place(1, new LinkedList<Arc>());
    	Entering_Arc arc1 = new Entering_Arc(3, place, transition);
    	Entering_Arc arc2 = new Entering_Arc(1, place, transition);
        enteringList.add(arc1);
        enteringList.add(arc2);
        assertFalse(transition.is_firable());
    }

    @Test
    public void testFireSuccess() throws NotFirableTransitionException {
        Place enteringPlace = new Place(2, new LinkedList<Arc>());
        Place exitingPlace = new Place(1, new LinkedList<Arc>());
        Entering_Arc arc1 = new Entering_Arc(1, enteringPlace, transition);
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
        Entering_Arc arc = new Entering_Arc(3, place, transition);
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
