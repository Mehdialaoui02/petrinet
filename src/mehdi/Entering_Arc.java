package mehdi;

/**
 * La classe Entering_Arc représente une classe spécialisée d'arc d'entrée
 * dans un réseau de Petri. Un arc d'entrée est utilisé pour ajouter un certain nombre
 * de jetons à un lieu (Place) lors de l'exécution.
 * 
 * Elle hérite de la classe {@link Arc} et implémente les méthodes abstraites
 * nécessaires pour définir le comportement spécifique de l'arc d'entrée.
 */
public class Entering_Arc extends Arc {

    /**
     * Constructeur de l'arc d'entrée avec le poids spécifié, le lieu et la transition.
     *
     * @param weight      le poids de l'arc.
     * @param place       le lieu connecté par l'arc.
     * @param transition  la transition connectée par l'arc.
     */
    public Entering_Arc(int weight, Place place, Transition transition) {
        super(weight, place, transition);
        // TODO Auto-generated constructor stub
    }

    /**
     * Vérifie si l'arc est un arc d'entrée.
     *
     * @return true} si c'est un arc d'entrée, sinon false.
     */
    public boolean is_entering() {
        return true;
    }

    /**
     * Vérifie si l'arc est un arc de sortie.
     *
     * @return false car il s'agit d'un arc d'entrée.
     */
    public boolean is_exiting() {
        return false;
    }

    /**
     * Exécute l'arc d'entrée en ajoutant un certain nombre de jetons au lieu associé.
     */
    @Override
    public void execute() {
        this.place.remove_tokens(this.weight);
    }

    /**
     * Vérifie si l'arc d'entrée est exécutable en fonction du nombre de jetons
     * présents dans le lieu associé.
     *
     * @return true si l'arc est exécutable, sinon false.
     */
    public boolean is_executable() {
        return this.place.get_tokens_nb() >= this.weight;
    }
}
