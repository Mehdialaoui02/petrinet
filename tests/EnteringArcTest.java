import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import mehdi.EnteringArc;
import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.Transition;


/**
 * Classe de test pour la classe EnteringArc.
 */
class EnteringArcTest {

    private EnteringArc enteringArc;
    private Place place;
    private Transition transition;

    /**
     * Méthode d'initialisation avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        place = new Place(3, null); // Initialisé avec 3 jetons
        transition = new Transition(null, null);
        enteringArc = new EnteringArc(2, place, transition);
    }

    /**
     * Test de la méthode isEntering() pour vérifier si l'arc est une entrée.
     */
    @Test
    public void testIsEntering() {
        assertTrue(enteringArc.isEntering());
    }

    /**
     * Test de la méthode isExiting() pour vérifier si l'arc n'est pas une sortie.
     */
    @Test
    public void testIsExiting() {
        assertFalse(enteringArc.isExiting());
    }

    /**
     * Test de la méthode isExecutable() pour vérifier si l'arc est exécutable.
     */
    @Test
    public void testIsExecutable() {
        assertTrue(enteringArc.isExecutable());
    }

    /**
     * Test de la méthode execute() pour vérifier le comportement de l'exécution de l'arc.
     */
    @Test
    public void testExecute() {
        enteringArc.execute();
        assertEquals(1, place.getTokenNumber());
    }

    /**
     * Test de la méthode execute() pour vérifier le comportement de l'exécution de l'arc
     * lorsque le nombre de jetons dans la place n'est pas suffisant.
     */
    @Test
    public void testExecuteNotEnoughTokens() throws NegativeTokenValueException {
        place.setTokenNumber(1);
        enteringArc.execute();
        assertEquals(0, place.getTokenNumber());
    }

    /**
     * Test de la méthode isExecutable() pour vérifier le cas où l'arc est exécutable.
     */
    @Test
    public void testIsExecutableWhenExecutable() {
        assertTrue(enteringArc.isExecutable());
    }

    /**
     * Test de la méthode isExecutable() pour vérifier le cas où l'arc n'est pas exécutable.
     */
    @Test
    public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
        place.setTokenNumber(1);
        assertFalse(enteringArc.isExecutable());
    }
}
