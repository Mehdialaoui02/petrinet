package mehdi;

import java.util.LinkedList;

/**
 * La classe PetriNet permet de gérer le réseau de petri. Elle permet de créer toute les parties du réseau.
 */
public class PetriNet {
	
	private LinkedList<Transition> transitionsList; 
	private LinkedList<Place> placesList;
	private LinkedList<Arc> arclist;
	
	/**
	 * Consrteucteur du réseau de petri
	 * @param transitionsList : Liste des transitions présentent dans le réseau. 
	 * @param placeList : Liste des places présentent dans le réseau.
	 * @param arclist 
	 */
	public PetriNet(LinkedList<Transition> transitionsList, LinkedList<Place> placeList, LinkedList<Arc> arclist) {
		this.transitionsList = transitionsList;
		this.placesList = placeList;
		this.arclist = arclist;
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
	
	public void add_enteringArc(int w, Place p, Transition t) {
		Entering_Arc arc = new Entering_Arc(w,p,t);
		t.add_enteringArc(arc);
		
	}
		
	public void add_exitingArc(int w, Place p, Transition t) {
		Exiting_Arc arc = new Exiting_Arc(w,p,t);
		t.add_exitingArc(arc);	
	}
	
	public void add_zeroArc(int w, Place p, Transition t) {
		Zero_Arc arc = new Zero_Arc(w,p,t);
		t.add_enteringArc(arc);
	}
	
	public void add_emptyingArc(int w, Place p, Transition t) {
		Emptying_Arc arc = new Emptying_Arc(w,p,t);
		t.add_enteringArc(arc);
	}
	

	public LinkedList<Place> getPlacesList() {
		return placesList;
	}

	public LinkedList<Arc> getArclist() {
		return arclist;
	}
	


}
