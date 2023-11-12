import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.ExistingArcException;
import mehdi.Place;
import mehdi.Transition;

/**
 * Classe de test pour la classe abstraite Arc
 */
class ArcTest {

    private Arc arc;
    private Place place;
    private Transition transition;

    /**
     * Méthode d'initialisation avant chaque test.
     * @throws ExistingArcException 
     */
    @BeforeEach
    public void setUp() throws ExistingArcException {
        place = new Place(1, new LinkedList<Arc>());
        transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        arc = new EnteringArc(2, place, transition); // Nous avons utiliser EnteringArc comme instance de la classe Arc car elle est abstraite
    }

    /**
     * Test de la méthode getWeight() pour vérifier la récupération du poids de l'arc.
     */
    @Test
    public void testGetWeight() {
        assertEquals(2, arc.getWeight());
    }

    /**
     * Test de la méthode getPlace() pour vérifier la récupération de la place associée à l'arc.
     */
    @Test
    public void testGetPlace() {
        assertEquals(place, arc.getPlace());
    }

    /**
     * Test de la méthode getTransition() pour vérifier la récupération de la transition associée à l'arc.
     */
    @Test
    public void testGetTransition() {
        assertEquals(transition, arc.getTransition());
    }

    /**
     * Test de la méthode setWeight() pour vérifier la modification du poids de l'arc.
     */
    @Test
    public void testSetWeight() {
        arc.setWeight(3);
        assertEquals(3, arc.getWeight());
    }

    /**
     * Test de la méthode execute() pour vérifier le comportement de l'exécution de l'arc.
     * Note: Implémenter le test en fonction de la logique d'exécution spécifique de l'arc.
     */
    @Test
    public void testExecute() {
        // Implémenter le test pour la méthode execute, si applicable
    }
}
