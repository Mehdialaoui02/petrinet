import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;


import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.ExitingArc;
import mehdi.NotFirableTransitionException;
import mehdi.PetriNet;
import mehdi.Place;
import mehdi.Transition;

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
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);
        
        Arc arc2 = new ExitingArc(3, place, transition1);
        transition1.addEnteringArc(arc);
        transition1.addExitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);
        
        transition2.addEnteringArc(arc3);
    
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);
        
        
        
        LinkedList<Transition> firableTransitions = new LinkedList<>();
        firableTransitions.add(transition1); //Seule la transition 1 est tirable;

        LinkedList<Transition> firableTransitionsToTest = petriNet.firableTransitions();
        assertEquals(firableTransitions, firableTransitionsToTest);
    }

    @Test
    public void testFireFirableTransition() throws NotFirableTransitionException { //B
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);
        
        Arc arc2 = new ExitingArc(3, place, transition1);
        transition1.addEnteringArc(arc);
        transition1.addExitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);
        
        transition2.addEnteringArc(arc3);
    
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);

        petriNet.fire(transition1);

    }
    @Test
    public void testFireNotFirableTransition() throws NotFirableTransitionException {
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);
        
        Arc arc2 = new ExitingArc(3, place, transition1);
        transition1.addEnteringArc(arc);
        transition1.addExitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);
        
        transition2.addEnteringArc(arc3);
    
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);
        
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
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);
        
        Arc arc2 = new ExitingArc(3, place, transition1);
        transition1.addEnteringArc(arc);
        transition1.addExitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);
        
        transition2.addEnteringArc(arc3);
    
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);
        
        assertEquals(2, transitionsList.size());

    }

    @Test
    public void testRemoveTransition() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        
        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);
        
        Arc arc2 = new ExitingArc(3, place, transition1);
        transition1.addEnteringArc(arc);
        transition1.addExitingArc(arc2);
        
        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);
        
        transition2.addEnteringArc(arc3);
    
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);

        petriNet.removeTransition(transition1);

        assertEquals(2, transitionsList.size());
    }

    @Test
    public void testAddEnteringArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        petriNet.addEnteringArc(1, place, transition);

        assertEquals(1, petriNet.getArclist().size());
    }

    @Test
    public void testAddExitingArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        petriNet.addExitingArc(1, place, transition);

        assertEquals(1, petriNet.getArclist().size());
    }

    @Test
    public void testAddZeroArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        petriNet.addZeroArc(1, place, transition);

        assertEquals(1, petriNet.getArclist().size());
    }

    @Test
    public void testAddEmptyingArc() {
    	
    	transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);
        
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        petriNet.addEmptyingArc(1, place, transition);

        assertEquals(1, transition.getEnteringArcList().size());
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
