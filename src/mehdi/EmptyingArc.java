package mehdi;

/**
 * La classe EmptyingArc} représente une classe spécialisée d'arc de vidage
 * dans un réseau de Petri. Un arc de vidage est utilisé pour vider un lieu (Place)
 * en retirant tous ses jetons lors de l'exécution.
 * 
 * Elle hérite de la classe Entering_arc et implémente les méthodes abstraites
 * nécessaires pour définir le comportement spécifique de l'arc de vidage.
 */
public class EmptyingArc extends EnteringArc {

	/**
	 * Constructeur de l'arc de vidage avec le poids spécifié, le lieu et la transition.
	 *
	 * @param weight      le poids de l'arc.
	 * @param place       le lieu connecté par l'arc.
	 * @param transition  la transition connectée par l'arc.
	 */
	public EmptyingArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Exécute l'arc de vidage en retirant tous les jetons du lieu associé.
	 */
	@Override
	public void execute() {
		this.place.removeAllTokens();
	}

	/**
	 * Vérifie si l'arc de vidage est exécutable en fonction du nombre de jetons
	 * présents dans le lieu associé.
	 *
	 * @return true si l'arc est exécutable, sinon false..
	 */
	@Override
	public boolean isExecutable() {
		return this.place.getTokenNumber() > 0;
	}
}

