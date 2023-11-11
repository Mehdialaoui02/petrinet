package mehdi;

import java.util.LinkedList;

/**
 * La classe PetriNet permet de gérer un réseau de Petri. Elle facilite la création
 * et la gestion des éléments du réseau tels que les transitions, les places et les arcs.
 */
public class PetriNet {
	
    private LinkedList<Transition> TransitionList; 
    private LinkedList<Place> PlaceList;
    private LinkedList<Arc> ArcList;
	
    /**
     * Constructeur du réseau de Petri.
     *
     * @param transitionsList  Liste des transitions présentes dans le réseau.
     * @param placeList        Liste des places présentes dans le réseau.
     * @param arclist          Liste des arcs présents dans le réseau.
     */
    public PetriNet(LinkedList<Transition> TransitionList, LinkedList<Place> PlaceList, LinkedList<Arc> ArcList) {
        this.TransitionList = TransitionList;
        this.PlaceList = PlaceList;
        this.ArcList = ArcList;
    }
	
    /**
     * Retourne la liste des transitions tirables dans le réseau de Petri.
     *
     * @return Liste des transitions tirables.
     */
    public LinkedList<Transition> firableTransitions() {
        LinkedList<Transition> firableTransitions = new LinkedList<Transition>();
        for (Transition t : this.TransitionList) {
            if (t.isFirable()) {
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
    public void addTransition(Transition t) {
        this.TransitionList.addLast(t);
    }
	
    /**
     * Supprime une transition du réseau de Petri.
     *
     * @param transition Transition à supprimer.
     */
    public void removeTransition(Transition transition) {
        this.TransitionList.remove(transition);
    }
	
    /**
     * Ajoute un arc entrant au réseau de Petri.
     *
     * @param w Poids de l'arc.
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void addEnteringArc(int w, Place p, Transition t) {
        EnteringArc arc = new EnteringArc(w, p, t);
        t.addEnteringArc(arc);
        ArcList.add(arc);
    }
		
    /**
     * Ajoute un arc sortant au réseau de Petri.
     *
     * @param w Poids de l'arc.
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void addExitingArc(int w, Place p, Transition t) {
        ExitingArc arc = new ExitingArc(w, p, t);
        t.addExitingArc(arc);	
        ArcList.add(arc);
    }
	
    /**
     * Ajoute un arc avec un poids nul au réseau de Petri.
     *
     * @param w Poids de l'arc (poids nul).
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void addZeroArc(int w, Place p, Transition t) {
        ZeroArc arc = new ZeroArc(w, p, t);
        t.addEnteringArc(arc);
        ArcList.add(arc);
    }
	
    /**
     * Ajoute un arc de vidage au réseau de Petri.
     *
     * @param w Poids de l'arc.
     * @param p Place connectée par l'arc.
     * @param t Transition connectée par l'arc.
     */
    public void addEmptyingArc(int w, Place p, Transition t) {
        EmptyingArc arc = new EmptyingArc(w, p, t);
        t.addEnteringArc(arc);
        ArcList.add(arc);
    }

    /**
     * Retourne la liste des places du réseau de Petri.
     *
     * @return Liste des places.
     */
    public LinkedList<Place> getPlacesList() {
        return PlaceList;
    }

    /**
     * Retourne la liste des arcs du réseau de Petri.
     *
     * @return Liste des arcs.
     */
    public LinkedList<Arc> getArclist() {
        return ArcList;
    }
}