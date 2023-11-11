package mehdi;

import java.util.LinkedList;

/**
 * La classe transition représente une transition dans un réseau de Petri.
 * Une transition est caractérisée par ses arcs entrants 
 *  et ses arcs sortants . Elle permet de déterminer si elle est
 * tirable et de réaliser le tirage de la transition.
 */
public class Transition {
    
    private LinkedList<Arc> ExitingArcList;
    private LinkedList<EnteringArc> EnteringArcList;
    
    /**
     * Constructeur de la transition avec les listes d'arcs entrants et sortants.
     *
     * @param exiting   Liste des arcs sortants de la transition.
     * @param entering  Liste des arcs entrants dans la transition.
     */
    public Transition(LinkedList<Arc> ExitingArcList, LinkedList<EnteringArc> EnteringArcList) {
        this.ExitingArcList = ExitingArcList;
        this.EnteringArcList = EnteringArcList;
    }
        
    /**
     * Retourne la liste des arcs entrants de la transition.
     *
     * @return Liste des arcs entrants.
     */
    public LinkedList<EnteringArc> getEnteringArcList() {
        return this.EnteringArcList;
    }
    
    /**
     * Retourne la liste des arcs sortants de la transition.
     *
     * @return Liste des arcs sortants.
     */
    public LinkedList<Arc> getExitingArcList() {
        return this.ExitingArcList;
    }
    
    /**
     * Vérifie si la transition est tirable.
     *
     * @return true si la transition est tirable, sinon false.
     */
    public boolean isFirable() {
        for (EnteringArc arc : this.EnteringArcList) {
            if (!arc.isExecutable()) {
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
    public void addExitingArc(Arc arc) {
        this.ExitingArcList.add(arc);
    }
    
    /**
     * Ajoute un arc entrant à la liste des arcs entrants de la transition.
     *
     * @param arc L'arc entrant à ajouter.
     */
    public void addEnteringArc(EnteringArc arc) {
        this.EnteringArcList.add(arc);
    }
    
    /**
     * Réalise le tirage de la transition en exécutant les arcs entrants et sortants.
     *
     * @throws NotFirableTransitionException Si la transition n'est pas tirable.
     */
    public void fire() throws NotFirableTransitionException {
        if (this.isFirable()) {
            for (Arc arc : this.getEnteringArcList()) {
                arc.execute();
            }
            for (Arc arc : this.getExitingArcList()) {
                arc.execute();
            }
            System.out.println("Tirage fait avec succès");
        } else {
            throw new NotFirableTransitionException();
        }
    }
}
