package mehdi;

import java.util.LinkedList;

/**
 * La classe PetriNet permet de gérer le réseau de petri. Elle permet de créer toute les parties du réseau.
 */
public class PetriNet {
	
	private LinkedList<Transition> transitionsList; 
	private LinkedList<Place> placesList;
	
	/**
	 * Consrteucteur du réseau de petri
	 * @param transitionsList : Liste des transitions présentent dans le réseau. 
	 * @param placeList : Liste des places présentent dans le réseau.
	 */
	public PetriNet(LinkedList<Transition> transitionsList, LinkedList<Place> placeList) {
		this.transitionsList = transitionsList;
		this.placesList = placeList;
	}
	
	/**
	 * Montre toutes les transitions tirables dans le réseau de petri
	 */
	public LinkedList<Transition> firable_transitions() {
		LinkedList<Transition> firableTransitions = new LinkedList<Transition>();
		for (Transition t : this.transitionsList) {
            firableTransitions.add(t);
        }
		return firableTransitions;
	}
	
	/**
	 * Tire une transition
	 * @param t : Transition à tirer
	 */
	public void fire(Transition t) {
		t.fire();	
	}
		
	
	/**
	 * Crée une transition dans le réseau de petri
	 * @param exiting_ArcList : Liste des arcs sortants de la transition.
	 * @param entering_ArcList : Liste des arcs entrants dans la transition
	 */
	public void add_transition(LinkedList<Arc> exiting_ArcList, LinkedList<Arc> entering_ArcList) {
		Transition transition  = new Transition(exiting_ArcList, entering_ArcList);
		this.transitionsList.addLast(transition);
	}
	
	/**
	 * Enlève une transition du réseau de petri
	 * @param transition : Transition à enlever.
	 */
	public void remove_transition(Transition transition) {
		this.transitionsList.remove(transition);
	}

	public LinkedList<Place> getPlacesList() {
		return placesList;
	}
	


}
