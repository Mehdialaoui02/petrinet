package mehdi;

/**
 * La classe ExitingArc représente une classe spécialisée d'arc de sortie
 * dans un réseau de Petri. Un arc de sortie est utilisé pour retirer un certain nombre
 * de jetons d'un lieu (Place) lors de l'exécution.
 * 
 * Elle hérite de la classe Arc et implémente les méthodes abstraites
 * nécessaires pour définir le comportement spécifique de l'arc de sortie.
 */
public class ExitingArc extends Arc {

	/**
	 * Constructeur de l'arc de sortie avec le poids spécifié, le lieu et la transition.
	 *
	 * @param weight      le poids de l'arc.
	 * @param place       le lieu connecté par l'arc.
	 * @param transition  la transition connectée par l'arc.
	 */
	public ExitingArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Vérifie si l'arc est un arc d'entrée.
	 *
	 * @return false car il s'agit d'un arc de sortie.
	 */
	public boolean isEntering() {
		return false;
	}

	/**
	 * Vérifie si l'arc est un arc de sortie.
	 *
	 * @return true si c'est un arc de sortie, sinon false.
	 */
	public boolean isExiting() {
		return true;
	}

	/**
	 * Exécute l'arc de sortie en retirant un certain nombre de jetons du lieu associé.
	 * Gère une exception si une tentative est faite pour retirer plus de jetons que le lieu n'en a.
	 */
	@Override
	public void execute() {
		try {
			this.place.addTokens(this.weight);
		} catch (NegativeTokenValueException e) {
			// TODO Auto-generated catch block
		}
	}
}
