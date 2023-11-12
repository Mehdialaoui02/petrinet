package mehdi;

/**
 * La classe EnteringArc représente une classe spécialisée d'arc d'entrée
 * dans un réseau de Petri. Un arc d'entrée est utilisé pour ajouter un certain nombre
 * de jetons à un lieu (Place) lors de l'exécution.
 * 
 * Elle hérite de la classe {@link Arc} et implémente les méthodes abstraites
 * nécessaires pour définir le comportement spécifique de l'arc d'entrée.
 */
public class EnteringArc extends Arc {

	/**
	 * Constructeur de l'arc d'entrée avec le poids spécifié, le lieu et la transition.
	 *
	 * @param weight      le poids de l'arc.
	 * @param place       le lieu connecté par l'arc.
	 * @param transition  la transition connectée par l'arc.
	 * @throws ExistingArcException 
	 */
	public EnteringArc(int weight, Place place, Transition transition) throws ExistingArcException {
		super(weight, place, transition);
		this.transition.addEnteringArc(this);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Vérifie si l'arc est un arc d'entrée.
	 *
	 * @return true} si c'est un arc d'entrée, sinon false.
	 */
	public boolean isEntering() {
		return true;
	}

	/**
	 * Vérifie si l'arc est un arc de sortie.
	 *
	 * @return false car il s'agit d'un arc d'entrée.
	 */
	public boolean isExiting() {
		return false;
	}

	/**
	 * Exécute l'arc d'entrée en ajoutant un certain nombre de jetons au lieu associé.
	 */
	@Override
	public void execute() {
		this.place.removeTokens(this.weight);
	}

	/**
	 * Vérifie si l'arc d'entrée est exécutable en fonction du nombre de jetons
	 * présents dans le lieu associé.
	 *
	 * @return true si l'arc est exécutable, sinon false.
	 */
	public boolean isExecutable() {
		return this.place.getTokenNumber() >= this.weight;
	}
}
