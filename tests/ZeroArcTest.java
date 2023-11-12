import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.ZeroArc;

/**
 * Classe de test pour la classe ZeroArc.
 */
class ZeroArcTest {

    private ZeroArc zeroArc;
    private Place place;

    /**
     * Méthode d'initialisation avant chaque test.
     */
    @BeforeEach
    public void setUp() {
        place = new Place(0, null);
        zeroArc = new ZeroArc(0, place, null);
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
     */
    @Test
    public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
        place.setTokenNumber(1);
        assertFalse(zeroArc.isExecutable());
    }
}