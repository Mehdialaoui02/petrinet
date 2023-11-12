import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import mehdi.Arc;
import mehdi.EnteringArc;
import mehdi.ExistingArcException;
import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.Transition;

/**
 * Classe de test pour la classe Place.
 */
class PlaceTest {

    /**
     * Test de la méthode getTokensNumber() pour vérifier le nombre initial de jetons dans une place.
     */
    @Test
    public void testGetTokensNumber() {
        Place place = new Place(5, new LinkedList<Arc>());
        assertEquals(5, place.getTokenNumber());
    }

    /**
     * Test de la méthode setTokensNumber() pour vérifier la modification du nombre de jetons dans une place.
     */
    @Test
    public void testSetTokensNumber() throws NegativeTokenValueException {
        Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(5);
        assertEquals(5, place.getTokenNumber());
    }

    /**
     * Test de la méthode isEmpty() lorsque la place est vide.
     */
    @Test
    public void testIsEmptyWhenEmpty() throws NegativeTokenValueException {
        Place place = new Place(8, new LinkedList<Arc>());
        place.setTokenNumber(0);
        assertTrue(place.isEmpty());
    }

    /**
     * Test de la méthode isEmpty() lorsque la place n'est pas vide.
     */
    @Test
    public void testIsEmptyWhenNotEmpty() throws NegativeTokenValueException {
        Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(3);
        assertFalse(place.isEmpty());
    }

    /**
     * Test de la méthode addArc() pour vérifier l'ajout d'un arc à la liste des arcs de la place.
     * @throws ExistingArcException 
     */
    @Test
    public void testAddArc() throws ExistingArcException {
        Place place = new Place(5, new LinkedList<Arc>());
        Arc arc = new EnteringArc(3, place, new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>()));
        assertEquals(1, place.getArcList().size());
    }

    /**
     * Test de la méthode addTokens() pour vérifier l'ajout de jetons à une place.
     */
    @Test
    public void testAddTokens() throws NegativeTokenValueException { //CAJ1 -- CAJ0
        Place place = new Place(5, new LinkedList<Arc>());
        place.addTokens(3);
        assertEquals(8, place.getTokenNumber());
    }

    /**
     * Test de la méthode removeTokens() pour vérifier la suppression de jetons d'une place.
     */
    @Test
    public void testRemoveTokens() throws NegativeTokenValueException { 
        Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(5);
        place.removeTokens(2);
        assertEquals(3, place.getTokenNumber());
    }

    /**
     * Test de la méthode removeAllTokens() pour vérifier la suppression de tous les jetons d'une place.
     */
    @Test
    public void testRemoveAllTokens() throws NegativeTokenValueException {
        Place place = new Place(5, new LinkedList<Arc>());
        place.setTokenNumber(3);
        place.removeAllTokens();
        assertEquals(0, place.getTokenNumber());
    }
}

