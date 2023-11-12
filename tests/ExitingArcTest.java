import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.ExitingArc;
import mehdi.NegativeTokenValueException;
import mehdi.Place;


/**
 * Classe de test pour la classe ExitingArc.
 */
class ExitingArcTest {

    private ExitingArc exitingArc;
    private Place place;

    /**
     * Méthode d'initialisation avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        place = new Place(0, null); 
        exitingArc = new ExitingArc(2, place, null); 
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
