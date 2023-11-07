package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PetriNetTest {

	private PetriNet petriNet;
    private LinkedList<Transition> transitionsList;
    private LinkedList<Place> placesList;
    private LinkedList<Arc> arclist;

    @Before
    public void setUp() {
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
    }

    @Test
    public void testFirableTransitions() {
        Transition transition1 = new Transition(new LinkedList<>(), new LinkedList<>());
        Transition transition2 = new Transition(new LinkedList<>(), new LinkedList<>());
        transitionsList.add(transition1);
        transitionsList.add(transition2);

        LinkedList<Transition> firableTransitions = petriNet.firable_transitions();
        assertEquals(transitionsList, firableTransitions);
    }

    @Test
    public void testFire() {
        Transition transition = new Transition(new LinkedList<>(), new LinkedList<>());
        transitionsList.add(transition);

        petriNet.fire(transition);

        assertTrue(true);
    }

    @Test
    public void testAddTransition() {
        LinkedList<Arc> exitingArcList = new LinkedList<>();
        LinkedList<Arc> enteringArcList = new LinkedList<>();
        petriNet.add_transition(exitingArcList, enteringArcList);

        assertEquals(1, transitionsList.size());
    }

    @Test
    public void testRemoveTransition() {
        Transition transition = new Transition(new LinkedList<>(), new LinkedList<>());
        transitionsList.add(transition);

        petriNet.remove_transition(transition);

        assertEquals(0, transitionsList.size());
    }

    @Test
    public void testAddEnteringArc() {
        Place place = new Place(0, new LinkedList<>());
        Transition transition = new Transition(new LinkedList<>(), new LinkedList<>());
        petriNet.add_enteringArc(1, place, transition);

        assertEquals(1, transition.get_enteringList().size());
    }

    @Test
    public void testAddExitingArc() {
        Place place = new Place(0, new LinkedList<>());
        Transition transition = new Transition(new LinkedList<>(), new LinkedList<>());
        petriNet.add_exitingArc(1, place, transition);

        assertEquals(1, transition.get_exitingList().size());
    }

    @Test
    public void testAddZeroArc() {
        Place place = new Place(0, new LinkedList<>());
        Transition transition = new Transition(new LinkedList<>(), new LinkedList<>());
        petriNet.add_zeroArc(1, place, transition);

        assertEquals(1, transition.get_enteringList().size());
    }

    @Test
    public void testAddEmptyingArc() {
        Place place = new Place(0, new LinkedList<>());
        Transition transition = new Transition(new LinkedList<>(), new LinkedList<>());
        petriNet.add_emptyingArc(1, place, transition);

        assertEquals(1, transition.get_enteringList().size());
    }

    @Test
    public void testGetPlacesList() {
        assertEquals(placesList, petriNet.getPlacesList());
    }

    @Test
    public void testGetArcList() {
        assertEquals(arclist, petriNet.getArclist());
    }

}
