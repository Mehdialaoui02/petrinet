package tests;
/**
 * Importation des assertions JUnit nécessaires pour les tests.
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

/**
 * Importation des annotations JUnit pour la configuration des tests.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mehdi.Arc;
/**
 * Importation des classes nécessaires au test.
 */
import mehdi.EmptyingArc;
import mehdi.EnteringArc;
import mehdi.ExistingArcException;
import mehdi.NegativeTokenValueException;
import mehdi.Place;
import mehdi.Transition;

/**
 * Définition de la classe de test pour EmptyingArc.
 */
class EmptyingArcTest {

    /**
     * Déclaration des variables de test.
     */
    private EmptyingArc emptyingArc;
    private Place place;
    private Transition transition;

    /**
     * Méthode exécutée avant chaque test pour initialiser les objets nécessaires.
     * @throws ExistingArcException 
     */
    @BeforeEach
    public void setUp() throws ExistingArcException {
        /**
         * Création d'une place avec 3 jetons (tokens) initiaux.
         */
        place = new Place(3, new LinkedList<Arc>()); 
        transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
        /**
         * Création d'un arc de vidange (EmptyingArc) avec une pondération de 1 et lié à la place créée.
         */
        emptyingArc = new EmptyingArc(1, place, transition); //CAA
    }

    /**
     * Test de la méthode execute() pour vérifier la vidange de la place.
     */
    @Test
    public void testExecute() {
        /**
         * Exécution de la méthode execute() sur l'arc de vidange.
         */
        emptyingArc.execute();
        /**
         * Vérification que le nombre de jetons dans la place est maintenant 0.
         */
        assertEquals(0, place.getTokenNumber());
    }

    /**
     * Test de la méthode isExecutable() lorsque l'arc est exécutable.
     */
    @Test
    public void testIsExecutableWhenExecutable() {
        /**
         * Vérification que la méthode isExecutable() retourne true.
         */
        assertTrue(emptyingArc.isExecutable());
    }

    /**
     * Test de la méthode isExecutable() lorsque l'arc n'est pas exécutable en raison du nombre de jetons nul.
     */
    @Test
    public void testIsExecutableWhenNotExecutable() throws NegativeTokenValueException {
        /**
         * Réglage du nombre de jetons dans la place à 0.
         */
        place.setTokenNumber(0); 
        /**
         * Vérification que la méthode isExecutable() retourne false.
         */
        assertFalse(emptyingArc.isExecutable());
    }
}

