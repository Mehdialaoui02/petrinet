import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.ExitingArc;
import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.Transition;


/**
 * Classe de test pour la classe ExitingArc.
 */
class ExitingArcTest {

    private ExitingArc exitingArc;
    private Place place;
    private Transition transition;

    /**
     * Méthode d'initialisation avant chaque test.
     */
    @BeforeEach
    public void setUp() {
    	transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        place = new Place(0, new LinkedList<Arc>()); 
        exitingArc = new ExitingArc(2, place, transition); 
    }

    /**
     * Test de la méthode isEntering() pour vérifier si l'arc n'est pas une entrée.
     */
    @Test
    public void testIsEntering() {
        assertFalse(exitingArc.isEntering());
    }

    /**
     * Test de la méthode isExiting() pour vérifier si l'arc est une sortie.
     */
    @Test
    public void testIsExiting() {
        assertTrue(exitingArc.isExiting());
    }

    /**
     * Test de la méthode execute() pour vérifier le comportement de l'exécution de l'arc.
     * @throws NegativeTokenValueException 
     */
    @Test
    public void testExecute() throws NegativeTokenValueException {
        exitingArc.execute();
        assertEquals(2, place.getTokenNumber());
    }
}
