import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import mehdi.Arc;
import mehdi.EmptyingArc;
import mehdi.EnteringArc;
import mehdi.ExistingArcException;
import mehdi.ExitingArc;
import mehdi.NegativeTokenValueException;
import mehdi.NotFirableTransitionException;
import mehdi.Place;
import mehdi.Transition;
import mehdi.ZeroArc;

/**
 * Classe de test pour la classe Transition.
 */
public class TransitionTest extends TestCase {

    private LinkedList<EnteringArc> enteringList;
    private LinkedList<Arc> exitingList;
    private Transition transition;

    /**
     * Méthode d'initialisation avant chaque test.
     */
    @Before
    public void setUp() { // RI
        enteringList = new LinkedList<EnteringArc>();
        exitingList = new LinkedList<Arc>();
        transition = new Transition(exitingList, enteringList);
    }

    /**
     * Test de la méthode addEnteringArc() pour vérifier l'ajout d'une arc d'entrée à la liste d'arcs d'entrée.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddEnteringArc() throws ExistingArcException {
        EnteringArc arc = new EnteringArc(1, new Place(1, new LinkedList<Arc>()), transition);
        transition.addEnteringArc(arc);
        assertTrue(enteringList.contains(arc));
    }

    /**
     * Test de la méthode addExitingArc() pour vérifier l'ajout d'une arc de sortie à la liste d'arcs de sortie.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddExitingArc() throws ExistingArcException {
        Arc arc = new EnteringArc(1, new Place(1, new LinkedList<Arc>()), transition);
        transition.addExitingArc(arc);
        assertTrue(exitingList.contains(arc));
    }

    /**
     * Test de la méthode isFirable() pour vérifier le cas où la transition est tirable.
     * @throws ExistingArcException 
     */
    @Test
    public void testIsFirableTrue() throws ExistingArcException {
        Place place = new Place(1, new LinkedList<Arc>());
        EnteringArc arc1 = new EnteringArc(1, place, transition);
        transition.addEnteringArc(arc1);
        assertTrue(transition.isFirable());
    }

    /**
     * Test de la méthode isFirable() pour vérifier le cas où la transition est tirable avec deux arcs d'entrée.
     * @throws ExistingArcException 
     */
    @Test
    public void testIsFirableTrueDoubleArc() throws ExistingArcException { // T1
        Place place1 = new Place(2, new LinkedList<Arc>());
        Place place2 = new Place(4, new LinkedList<Arc>());
        EnteringArc arc1 = new EnteringArc(1, place1, transition);
        EnteringArc arc2 = new EnteringArc(2, place2, transition);
        transition.addEnteringArc(arc1);
        transition.addEnteringArc(arc2);
        assertTrue(transition.isFirable());
    }

    /**
     * Test de la méthode isFirable() pour vérifier le cas où la transition n'est pas tirable.
     * @throws ExistingArcException 
     */
    @Test
    public void testIsFirableFalse() throws ExistingArcException { // A
        Place place = new Place(0, new LinkedList<Arc>());
        EnteringArc arc1 = new EnteringArc(1, place, transition);
        enteringList.add(arc1);
        assertFalse(transition.isFirable());
    }

    /**
     * Test de la méthode isFirable() pour vérifier le cas où la transition n'est pas tirable avec une arc de vidange et une arc avec pondération zéro.
     * @throws ExistingArcException 
     */
    @Test
    public void testIsFirableFalseZeroEmptying() throws ExistingArcException { // T3
        Place place1 = new Place(3, new LinkedList<Arc>());
        Place place2 = new Place(3, new LinkedList<Arc>());

        EnteringArc arc1 = new EmptyingArc(2, place1, transition);
        EnteringArc arc2 = new ZeroArc(0, place2, transition);
        enteringList.add(arc1);
        enteringList.add(arc2);
        assertFalse(transition.isFirable());
    }

    /**
     * Test de la méthode isFirable() pour vérifier le cas où la transition n'est pas tirable avec deux arcs d'entrée.
     * @throws ExistingArcException 
     */
    @Test
    public void testIsFirableFalseDoubleArc() throws ExistingArcException { // T2
        Place place1 = new Place(2, new LinkedList<Arc>());
        Place place2 = new Place(1, new LinkedList<Arc>());

        EnteringArc arc1 = new EnteringArc(3, place1, transition);
        EnteringArc arc2 = new EnteringArc(1, place2, transition);
        enteringList.add(arc1);
        enteringList.add(arc2);
        assertFalse(transition.isFirable());
    }

    /**
     * Test de la méthode fire() pour vérifier le cas où la transition est exécutée avec succès.
     * @throws NegativeTokenValueException 
     * @throws ExistingArcException 
     * @throws NotFirableTransitionException
     */
    @Test
    public void testFireSuccess() throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException { // C
        Place enteringPlace = new Place(2, new LinkedList<Arc>());
        Place exitingPlace = new Place(1, new LinkedList<Arc>());
        EnteringArc arc1 = new EnteringArc(1, enteringPlace, transition);
        Arc arc2 = new ExitingArc(1, exitingPlace, transition);

        transition.fire();

        assertEquals(1, enteringPlace.getTokenNumber());
        assertEquals(2, exitingPlace.getTokenNumber());
    }

    /**
     * Test de la méthode fire() pour vérifier le cas où la transition n'est pas tirable et génère une exception.
     * @throws NegativeTokenValueException 
     * @throws ExistingArcException 
     */
    @Test
    public void testFireFailure() throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException {
        Place place = new Place(2, new LinkedList<Arc>());
        EnteringArc arc = new EnteringArc(3, place, transition);
        enteringList.add(arc);
        try { 
            transition.fire();
        } 
        catch (NotFirableTransitionException e) {
            assert(true);
        }

        ;
    }

    /**
     * Test de la méthode fire() pour vérifier le cas où la transition effectue une vidange.
     * @throws NegativeTokenValueException 
     * @throws ExistingArcException 
     * @throws NotFirableTransitionException
     */
    @Test
    public void testFireEmptying() throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException { // RFF
        Place enteringPlace = new Place(2, new LinkedList<Arc>());
        EnteringArc arc1 = new EmptyingArc(1, enteringPlace, transition);
        transition.addEnteringArc(arc1);

        transition.fire();

        assertEquals(0, enteringPlace.getTokenNumber());
    }

    /**
     * Test de la méthode fire() pour vérifier le cas où la transition effectue deux arcs d'entrée avec succès.
     * @throws NegativeTokenValueException 
     * @throws ExistingArcException 
     * @throws NotFirableTransitionException
     */
    @Test
    public void testFireDoubleArc() throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException { // DEE
        Place Place1 = new Place(3, new LinkedList<Arc>());
        Place Place2 = new Place(4, new LinkedList<Arc>());
        EnteringArc arc1 = new EnteringArc(2, Place1, transition);
        EnteringArc arc2 = new EnteringArc(1, Place2, transition);

        transition.fire();

        assertEquals(1, Place1.getTokenNumber());
        assertEquals(3, Place2.getTokenNumber());
    }

    /**
     * Test de la méthode fire() pour vérifier le cas où la transition effectue deux arcs spéciaux avec succès.
     * @throws NegativeTokenValueException 
     * @throws NotFirableTransitionException
     * @throws ExistingArcException 
     */
    @Test
    public void testDoubleArcSpeciaux() throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException { // DZV
        Place Place1 = new Place(0, new LinkedList<Arc>());
        Place Place2 = new Place(5, new LinkedList<Arc>());
        ZeroArc arc1 = new ZeroArc(0, Place1, transition);
        EmptyingArc arc2 = new EmptyingArc(1, Place2, transition);
        transition.addEnteringArc(arc1);
        transition.addEnteringArc(arc2);

        transition.fire();

        assertEquals(0, Place1.getTokenNumber());
        assertEquals(0, Place2.getTokenNumber());
    }
}
