import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import mehdi.Arc;
import mehdi.Emptying_Arc;
import mehdi.Entering_Arc;
import mehdi.Exiting_Arc;
import mehdi.NotFirableTransitionException;
import mehdi.Place;
import mehdi.Transition;
import mehdi.Zero_Arc;

public class TransitionTest extends TestCase {
	
	private LinkedList<Entering_Arc> enteringList;
    private LinkedList<Arc> exitingList;
    private Transition transition;

    @Before
    public void setUp() { //RI
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
    public void testIsFirableTrueDoubleArc() { //T1
        Place place1 = new Place(2, new LinkedList<Arc>());
        Place place2 = new Place(4, new LinkedList<Arc>());
        Entering_Arc arc1 = new Entering_Arc(1, place1, transition);
        Entering_Arc arc2 = new Entering_Arc(2, place2, transition);
        transition.add_enteringArc(arc1);
        transition.add_enteringArc(arc2);
        assertTrue(transition.is_firable());
    }

    @Test
    public void testIsFirableFalse() { //A
    	Place place = new Place(0, new LinkedList<Arc>());
    	Entering_Arc arc1 = new Entering_Arc(1, place, transition);
        enteringList.add(arc1);
        assertFalse(transition.is_firable());
    }
    
    public void testIsFirableFalseZero_Emptying() { //T3
    	Place place1 = new Place(3, new LinkedList<Arc>());
    	Place place2 = new Place(3, new LinkedList<Arc>());

    	Entering_Arc arc1 = new Emptying_Arc(2, place1, transition);
    	Entering_Arc arc2 = new Zero_Arc(0, place2, transition);
        enteringList.add(arc1);
        enteringList.add(arc2);
        assertFalse(transition.is_firable());
    }
    
    public void testIsFirableFalseDoubleArc() { //T2
    	Place place1 = new Place(2, new LinkedList<Arc>());
    	Place place2 = new Place(1, new LinkedList<Arc>());

    	Entering_Arc arc1 = new Entering_Arc(3, place1, transition);
    	Entering_Arc arc2 = new Entering_Arc(1, place2, transition);
        enteringList.add(arc1);
        enteringList.add(arc2);
        assertFalse(transition.is_firable());
    }

    @Test
    public void testFireSuccess() throws NotFirableTransitionException { //C
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
    @Test
    public void testFireEmptying() throws NotFirableTransitionException { //RFF
        Place enteringPlace = new Place(2, new LinkedList<Arc>());
        Entering_Arc arc1 = new Emptying_Arc(1, enteringPlace, transition);
        transition.add_enteringArc(arc1);


        transition.fire();

        assertEquals(0, enteringPlace.get_tokens_nb());
    }
    
    public void testFireDoubleArc() throws NotFirableTransitionException { //DEE
        Place Place1 = new Place(3, new LinkedList<Arc>());
        Place Place2 = new Place(4, new LinkedList<Arc>());
        Entering_Arc arc1 = new Entering_Arc(2, Place1, transition);
        Entering_Arc arc2 = new Entering_Arc(1, Place2, transition);
        transition.add_enteringArc(arc1);
        transition.add_enteringArc(arc2);

        transition.fire();

        assertEquals(1, Place1.get_tokens_nb());
        assertEquals(3, Place2.get_tokens_nb());
    }
    
    public void testDoubleArcSpeciaux() throws NotFirableTransitionException { //DZV
        Place Place1 = new Place(0, new LinkedList<Arc>());
        Place Place2 = new Place(5, new LinkedList<Arc>());
        Zero_Arc arc1 = new Zero_Arc(0, Place1, transition);
        Emptying_Arc arc2 = new Emptying_Arc(1, Place2, transition);
        transition.add_enteringArc(arc1);
        transition.add_enteringArc(arc2);

        transition.fire();

        assertEquals(0, Place1.get_tokens_nb());
        assertEquals(0, Place2.get_tokens_nb());
    }
}	
