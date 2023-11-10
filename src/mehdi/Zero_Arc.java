package mehdi;

/**
 * La classe Zero_Arc représente un type spécialisé d'arc d'entrée dans un réseau de Petri.
 * Un arc de zéro est utilisé pour représenter une connexion entre une place et une transition avec
 * un poids nul. Il n'effectue aucune action lors de l'exécution et est exécutable uniquement lorsque
 * la place associée n'a aucun jeton.
 * 
 * Elle hérite de la classe Entering_Arc et ajuste le poids à zéro lors de la création de l'arc.
 */
public class Zero_Arc extends Entering_Arc {

    /**
     * Constructeur de l'arc de zéro avec le poids fixé à zéro, le lieu et la transition.
     *
     * @param weight      Le poids de l'arc (fixé à zéro).
     * @param place       Le lieu connecté par l'arc.
     * @param transition  La transition connectée par l'arc.
     */
    public Zero_Arc(int weight, Place place, Transition transition) {
        super(0, place, transition); // Le poids est fixé à zéro
        // TODO Auto-generated constructor stub
    }

    /**
     * Ne réalise aucune action lors de l'exécution de l'arc de zéro.
     */
    @Override
    public void execute() {
        // Aucune action
    }

    /**
     * Vérifie si l'arc de zéro est exécutable uniquement lorsque la place associée n'a aucun jeton.
     *
     * @return true si l'arc est exécutable, sinon false.
     */
    @Override
    public boolean is_executable() {
        return this.place.get_tokens_nb() == 0;
    }
}
