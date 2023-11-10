package mehdi;

import java.util.LinkedList;

/**
 * La classe PetriNet permet de gérer un réseau de Petri. Elle facilite la création
 * et la gestion des éléments du réseau tels que les transitions, les places et les arcs.
 */
public class PetriNet {
	
    private LinkedList<Transition> transitionsList; 
    private LinkedList<Place> placesList;
    private LinkedList<Arc> arclist;
	
    /**
     * Constructeur du réseau de Petri.
     *
     * @param transitionsList  Liste des transitions présentes dans le réseau.
     * @param placeList        Liste des places présentes dans le réseau.
     * @param arclist          Liste des arcs présents dans le réseau.
     */
    public PetriNet(LinkedList<Transition> transitionsList, LinkedList<Place> placeList, LinkedList<Arc> arclist) {
        this.transitionsList = transitionsList;
        this.placesList = placeList;
        this.arclist = arclist;
    }
	
    /**
     * Retourne la liste des transitions tirables dans le réseau de Petri.
     *
     * @return Liste des transitions tirables.
     */
    public LinkedList<Transition> firable_transitions() {
        LinkedList<Transition> firableTransitions = new LinkedList<Transition>();
        for (Transition t : this.transitionsList) {
            if (t.is_firable()) {
                firableTransitions.add(t);
            }
        }
        return firableTransitions;
    }
	
    /**
     * Tire une transition spécifiée.
     *
     * @param t Transition à tirer.
     * @throws NotFirableTransitionException Si la transition n'est pas tirable..
     */
    public void fire(Transition t) throws NotFirableTransitionException {
        t.fire();	
    }
	
    /**
     * Ajoute une transition au réseau de Petri.
     *
     * @param t Transition à ajouter.
     */
    public void add_transition(Transition t) {
        this.transitionsList.addLast(t);
    }
	
    /**
     * Supprime une transition du réseau de Petri.
     *
     * @param transition Transition à supprimer.
     */
    public void remove_transition(Transition transition) {
        this.transitionsList.remove(transition);
    }
	
    /**
     * Ajoute un arc entrant au réseau de Petri.
     *
     * @param w Poids de l'arc.
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void add_enteringArc(int w, Place p, Transition t) {
        Entering_Arc arc = new Entering_Arc(w, p, t);
        t.add_enteringArc(arc);
        arclist.add(arc);
    }
		
    /**
     * Ajoute un arc sortant au réseau de Petri.
     *
     * @param w Poids de l'arc.
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void add_exitingArc(int w, Place p, Transition t) {
        Exiting_Arc arc = new Exiting_Arc(w, p, t);
        t.add_exitingArc(arc);	
        arclist.add(arc);
    }
	
    /**
     * Ajoute un arc avec un poids nul au réseau de Petri.
     *
     * @param w Poids de l'arc (poids nul).
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void add_zeroArc(int w, Place p, Transition t) {
        Zero_Arc arc = new Zero_Arc(w, p, t);
        t.add_enteringArc(arc);
        arclist.add(arc);
    }
	
    /**
     * Ajoute un arc de vidage au réseau de Petri.
     *
     * @param w Poids de l'arc.
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void add_emptyingArc(int w, Place p, Transition t) {
        Emptying_Arc arc = new Emptying_Arc(w, p, t);
        t.add_enteringArc(arc);
        arclist.add(arc);
    }

    /**
     * Retourne la liste des places du réseau de Petri.
     *
     * @return Liste des places.
     */
    public LinkedList<Place> getPlacesList() {
        return placesList;
    }

    /**
     * Retourne la liste des arcs du réseau de Petri.
     *
     * @return Liste des arcs.
     */
    public LinkedList<Arc> getArclist() {
        return arclist;
    }
}