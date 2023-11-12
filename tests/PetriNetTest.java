import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.ExistingArcException;
import mehdi.ExitingArc;
import mehdi.NegativeTokenValueException;
import mehdi.NotFirableTransitionException;
import mehdi.PetriNet;
import mehdi.Place;
import mehdi.Transition;

/**
 * Classe de test pour la classe PetriNet.
 */
class PetriNetTest {

    private PetriNet petriNet;
    private LinkedList<Transition> transitionsList;
    private LinkedList<Place> placesList;
    private LinkedList<Arc> arclist;

    /**
     * Test de la méthode firableTransitions() pour vérifier les transitions tirable d'un réseau de Petri.
     * @throws ExistingArcException 
     */
    @Test
    public void testFirableTransitions() throws ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création de deux transitions, une avec une arc d'entrée et une avec une arc de sortie
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);

        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc2 = new EnteringArc(3, place2, transition2);


        // Ajout des transitions au réseau de Petri
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);

        // Création de la liste de transitions tirable attendue
        LinkedList<Transition> firableTransitions = new LinkedList<>();
        firableTransitions.add(transition1); // Seule la transition 1 est tirable;

        // Récupération des transitions tirable et comparaison avec la liste attendue
        LinkedList<Transition> firableTransitionsToTest = petriNet.firableTransitions();
        assertEquals(firableTransitions, firableTransitionsToTest);
    }

    /**
     * Test de la méthode fire() pour vérifier l'exécution d'une transition tirable.
     * @throws NegativeTokenValueException 
     * @throws ExistingArcException 
     */
    @Test
    public void testFireFirableTransition() throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création de deux transitions, une avec une arc d'entrée et une avec une arc de sortie
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);

        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);


        // Ajout des transitions au réseau de Petri
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);

        // Exécution de la transition tirable
        petriNet.fire(transition1);
    }

    /**
     * Test de la méthode fire() pour vérifier la gestion d'une transition non tirable.
     * @throws NegativeTokenValueException 
     * @throws ExistingArcException 
     */
    @Test
    public void testFireNotFirableTransition() throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création de deux transitions, une avec une arc d'entrée et une avec une arc de sortie
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);


        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);


        // Ajout des transitions au réseau de Petri
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);

        // Tentative d'exécution d'une transition non tirable
        try {
            petriNet.fire(transition2);
        } catch (NotFirableTransitionException e) {
            // L'exception est attendue dans ce cas
            assertTrue(true);
        }
    }

    /**
     * Test de la méthode addTransition() pour vérifier l'ajout de transitions au réseau de Petri.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddTransition() throws ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création de deux transitions avec des arcs d'entrée et de sortie
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);


        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);


        // Ajout des transitions au réseau de Petri
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);

        // Vérification du nombre de transitions dans le réseau
        assertEquals(2, transitionsList.size());
    }

    /**
     * Test de la méthode removeTransition() pour vérifier la suppression de transitions du réseau de Petri.
     * @throws ExistingArcException 
     */
    @Test
    public void testRemoveTransition() throws ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création de deux transitions avec des arcs d'entrée et de sortie
        Transition transition1 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        Transition transition2 = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        Place place = new Place(4, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition1);


        Place place2 = new Place(2, new LinkedList<Arc>());
        EnteringArc arc3 = new EnteringArc(3, place2, transition2);


        // Ajout des transitions au réseau de Petri
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition1);
        petriNet.addTransition(transition2);

        // Suppression d'une transition du réseau de Petri
        petriNet.removeTransition(transition1);

        // Vérification du nombre de transitions dans le réseau
        assertEquals(2, transitionsList.size());
    }

    /**
     * Test de la méthode addEnteringArc() pour vérifier l'ajout d'une arc d'entrée au réseau de Petri.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddEnteringArc() throws ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création d'une place et d'une transition
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        // Ajout d'une arc d'entrée au réseau de Petri
        petriNet.addEnteringArc(1, place, transition);

        // Vérification du nombre d'arcs dans le réseau
        assertEquals(1, petriNet.getArclist().size());
    }

    /**
     * Test de la méthode addExitingArc() pour vérifier l'ajout d'une arc de sortie au réseau de Petri.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddExitingArc() throws ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création d'une place et d'une transition
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        // Ajout d'une arc de sortie au réseau de Petri
        petriNet.addExitingArc(1, place, transition);

        // Vérification du nombre d'arcs dans le réseau
        assertEquals(1, petriNet.getArclist().size());
    }

    /**
     * Test de la méthode addZeroArc() pour vérifier l'ajout d'une arc avec une pondération nulle au réseau de Petri.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddZeroArc() throws ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création d'une place et d'une transition
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        // Ajout d'une arc avec une pondération nulle au réseau de Petri
        petriNet.addZeroArc(1, place, transition);

        // Vérification du nombre d'arcs dans le réseau
        assertEquals(1, petriNet.getArclist().size());
    }

    /**
     * Test de la méthode addEmptyingArc() pour vérifier l'ajout d'une arc de vidange au réseau de Petri.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddEmptyingArc() throws ExistingArcException {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Création d'une place et d'une transition
        Place place = new Place(0, new LinkedList<Arc>());
        Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());

        // Ajout d'une arc de vidange au réseau de Petri
        petriNet.addEmptyingArc(1, place, transition);

        // Vérification du nombre d'arcs dans la liste d'arc d'entrée de la transition
        assertEquals(1, transition.getEnteringArcList().size());
    }

    /**
     * Test de la méthode getPlacesList() pour vérifier la récupération de la liste des places dans le réseau de Petri.
     */
    @Test
    public void testGetPlacesList() {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Vérification de la récupération de la liste des places
        assertEquals(placesList, petriNet.getPlacesList());
    }

    /**
     * Test de la méthode getArcList() pour vérifier la récupération de la liste des arcs dans le réseau de Petri.
     */
    @Test
    public void testGetArcList() {

        // Initialisation des listes nécessaires
        transitionsList = new LinkedList<Transition>();
        placesList = new LinkedList<Place>();
        arclist = new LinkedList<Arc>();
        petriNet = new PetriNet(transitionsList, placesList, arclist);

        // Vérification de la récupération de la liste des arcs
        assertEquals(arclist, petriNet.getArclist());
    }
}
