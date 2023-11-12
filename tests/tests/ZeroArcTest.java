package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.NegativeTokenValueException;
import mehdi.NotFirableTransitionException;
import mehdi.Place;
import mehdi.Transition;
import mehdi.ZeroArc;
import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.ExistingArcException;

/**
 * Classe de test pour la classe ZeroArc.
 */
class ZeroArcTest {

    private ZeroArc zeroArc;
    private Place place;
    private Transition transition; 

    /**
     * Méthode d'initialisation avant chaque test.
     * @throws ExistingArcException 
     */
    @BeforeEach
    public void setUp() throws ExistingArcException {
    	transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        place = new Place(0, new LinkedList<Arc>() );
        zeroArc = new ZeroArc(0, place, transition );
    }

    /**
     * Test de la méthode execute() pour vérifier l'exécution de l'arc de pondération zéro.
     */
    @Test
    public void testExecute() {
        zeroArc.execute();
        assertEquals(0, place.getTokenNumber());
    }

    /**
     * Test de la méthode isExecutable() pour vérifier le cas où l'arc de pondération zéro est exécutable.
     */
    @Test
    public void testIsExecutableWhenExecutable() { // RRR
        assertTrue(zeroArc.isExecutable());
    }

    /**
     * Test de la méthode isExecutable() pour vérifier le cas où l'arc de pondération zéro n'est pas exécutable.
     * @throws NegativeTokenValueException
     */
    @Test
    public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
        place.setTokenNumber(1);
        assertFalse(zeroArc.isExecutable());
    }
}