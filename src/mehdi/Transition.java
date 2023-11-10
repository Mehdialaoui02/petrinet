package mehdi;

import java.util.LinkedList;

/**
 * La classe transition représente une transition dans un réseau de Petri.
 * Une transition est caractérisée par ses arcs entrants 
 *  et ses arcs sortants . Elle permet de déterminer si elle est
 * tirable et de réaliser le tirage de la transition.
 */
public class Transition {
    
    private LinkedList<Arc> exiting_ArcsList;
    private LinkedList<Entering_Arc> entering_ArcsList;
    
    /**
     * Constructeur de la transition avec les listes d'arcs entrants et sortants.
     *
     * @param exiting   Liste des arcs sortants de la transition.
     * @param entering  Liste des arcs entrants dans la transition.
     */
    public Transition(LinkedList<Arc> exiting, LinkedList<Entering_Arc> entering) {
        this.exiting_ArcsList = exiting;
        this.entering_ArcsList = entering;
    }
        
    /**
     * Retourne la liste des arcs entrants de la transition.
     *
     * @return Liste des arcs entrants.
     */
    public LinkedList<Entering_Arc> get_enteringList() {
        return this.entering_ArcsList;
    }
    
    /**
     * Retourne la liste des arcs sortants de la transition.
     *
     * @return Liste des arcs sortants.
     */
    public LinkedList<Arc> get_exitingList() {
        return this.exiting_ArcsList;
    }
    
    /**
     * Vérifie si la transition est tirable.
     *
     * @return true si la transition est tirable, sinon false.
     */
    public boolean is_firable() {
        for (Entering_Arc arc : this.entering_ArcsList) {
            if (!arc.is_executable()) {
                return false; 
            }
        }
        return true;
    }
    
    /**
     * Ajoute un arc sortant à la liste des arcs sortants de la transition.
     *
     * @param arc L'arc sortant à ajouter.
     */
    public void add_exitingArc(Arc arc) {
        this.exiting_ArcsList.add(arc);
    }
    
    /**
     * Ajoute un arc entrant à la liste des arcs entrants de la transition.
     *
     * @param arc L'arc entrant à ajouter.
     */
    public void add_enteringArc(Entering_Arc arc) {
        this.entering_ArcsList.add(arc);
    }
    
    /**
     * Réalise le tirage de la transition en exécutant les arcs entrants et sortants.
     *
     * @throws NotFirableTransitionException Si la transition n'est pas tirable.
     */
    public void fire() throws NotFirableTransitionException {
        if (this.is_firable()) {
            for (Arc arc : this.get_enteringList()) {
                arc.execute();
            }
            for (Arc arc : this.get_exitingList()) {
                arc.execute();
            }
            System.out.println("Tirage fait avec succès");
        } else {
            throw new NotFirableTransitionException();
        }
    }
}
