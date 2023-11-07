package mehdi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PetriNetTest {

	private PetriNet petriNet;
    private LinkedList<Transition> transitionsList;
    private LinkedList<Place> placesList;
    private LinkedList<Arc> arclist;


    @Test
    public void testFirableTransitions() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        Arc arc = new Entering_Arc(3, place, transition1);
        
        Arc arc2 = new Exiting_Arc(3, place, transition1);
        transition1.add_enteringArc(arc);
        transition1.add_exitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        Arc arc3 = new Entering_Arc(3, place2, transition2);
        
        transition2.add_enteringArc(arc3);
    
        petriNet.add_transition(transition1);
        petriNet.add_transition(transition2);
        
        
        
        LinkedList<Transition> firableTransitions = new LinkedList<>();
        firableTransitions.add(transition1); //Seule la transition 1 est tirable;

        LinkedList<Transition> firableTransitions_to_test = petriNet.firable_transitions();
        assertEquals(firableTransitions, firableTransitions_to_test);
    }

    @Test
    public void testFire_firable_transition() throws NotFirableTransitionException {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        Arc arc = new Entering_Arc(3, place, transition1);
        
        Arc arc2 = new Exiting_Arc(3, place, transition1);
        transition1.add_enteringArc(arc);
        transition1.add_exitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        Arc arc3 = new Entering_Arc(3, place2, transition2);
        
        transition2.add_enteringArc(arc3);
    
        petriNet.add_transition(transition1);
        petriNet.add_transition(transition2);

        petriNet.fire(transition1);

    }
    @Test
    public void testFire_not_firable_transition() throws NotFirableTransitionException {
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        Arc arc = new Entering_Arc(3, place, transition1);
        
        Arc arc2 = new Exiting_Arc(3, place, transition1);
        transition1.add_enteringArc(arc);
        transition1.add_exitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        Arc arc3 = new Entering_Arc(3, place2, transition2);
        
        transition2.add_enteringArc(arc3);
    
        petriNet.add_transition(transition1);
        petriNet.add_transition(transition2);
        
        try {
        petriNet.fire(transition2);
        }
        catch(NotFirableTransitionException e) {
        	assert(true);
        }
    }


    @Test
    public void testAddTransition() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        Arc arc = new Entering_Arc(3, place, transition1);
        
        Arc arc2 = new Exiting_Arc(3, place, transition1);
        transition1.add_enteringArc(arc);
        transition1.add_exitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        Arc arc3 = new Entering_Arc(3, place2, transition2);
        
        transition2.add_enteringArc(arc3);
    
        petriNet.add_transition(transition1);
        petriNet.add_transition(transition2);
        
        assertEquals(2, transitionsList.size());

    }

    @Test
    public void testRemoveTransition() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        Arc arc = new Entering_Arc(3, place, transition1);
        
        Arc arc2 = new Exiting_Arc(3, place, transition1);
        transition1.add_enteringArc(arc);
        transition1.add_exitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        Arc arc3 = new Entering_Arc(3, place2, transition2);
        
        transition2.add_enteringArc(arc3);
    
        petriNet.add_transition(transition1);
        petriNet.add_transition(transition1);
        petriNet.add_transition(transition2);

        petriNet.remove_transition(transition1);

        assertEquals(2, transitionsList.size());
    }

    @Test
    public void testAddEnteringArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        petriNet.add_enteringArc(1, place, transition);

        assertEquals(1, petriNet.getArclist().size());
    }

    @Test
    public void testAddExitingArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        petriNet.add_exitingArc(1, place, transition);

        assertEquals(1, petriNet.getArclist().size());
    }

    @Test
    public void testAddZeroArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        petriNet.add_zeroArc(1, place, transition);

        assertEquals(1, petriNet.getArclist().size());
    }

    @Test
    public void testAddEmptyingArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<Arc>());
        petriNet.add_emptyingArc(1, place, transition);

        assertEquals(1, transition.get_enteringList().size());
    }

    @Test
    public void testGetPlacesList() {

    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        assertEquals(placesList, petriNet.getPlacesList());
    }

    @Test
    public void testGetArcList() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        assertEquals(arclist, petriNet.getArclist());
    }

}
