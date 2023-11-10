package mehdi;

/**
 * La classe Emptying_Arc} représente une classe spécialisée d'arc de vidage
 * dans un réseau de Petri. Un arc de vidage est utilisé pour vider un lieu (Place)
 * en retirant tous ses jetons lors de l'exécution.
 * 
 * Elle hérite de la classe Entering_arc et implémente les méthodes abstraites
 * nécessaires pour définir le comportement spécifique de l'arc de vidage.
 */
public class Emptying_Arc extends Entering_Arc {

    /**
     * Constructeur de l'arc de vidage avec le poids spécifié, le lieu et la transition.
     *
     * @param weight      le poids de l'arc.
     * @param place       le lieu connecté par l'arc.
     * @param transition  la transition connectée par l'arc.
     */
    public Emptying_Arc(int weight, Place place, Transition transition) {
        super(weight, place, transition);
        // TODO Auto-generated constructor stub
    }

    /**
     * Exécute l'arc de vidage en retirant tous les jetons du lieu associé.
     */
    @Override
    public void execute() {
        this.place.remove_all_tokens();
    }

    /**
     * Vérifie si l'arc de vidage est exécutable en fonction du nombre de jetons
     * présents dans le lieu associé.
     *
     * @return true si l'arc est exécutable, sinon false..
     */
    @Override
    public boolean is_executable() {
        return this.place.get_tokens_nb() > 0;
    }
}

