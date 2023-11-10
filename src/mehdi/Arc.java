package mehdi;

/**
 * La classe Arc est une classe absraite qui représentes les arcs dans un réseau de petri
 * Un arc lie entre une place et un transition
 */
public abstract class Arc {
    /**
     * Le poids de l'arc
     */
    protected int weight;

    /**
     * La place à laquelle l'arc est lié
     */
    protected Place place;

    /**
     * La transition à laquelle l'arc est lié
     */
    protected Transition transition;

    /**
     * Initialise les paramètres de l'arc
     *
     * @param weight      Le poids de l'arc.
     * @param place       La place à laquelle l'arc est lié.
     * @param transition  La transition à laquelle l'arc est lié.
     */
    public Arc(int weight, Place place, Transition transition) {
        this.place = place;
        this.weight = weight;
        this.transition = transition;
    }

    /**
     * Retourne le poids de l'arc.
     *
     * @return Le poids de l'arc.
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Retourne la place à laquelle l'arc est lié.
     *
     * @return la place à laquelle l'arc est lié.
     */
    public Place getPlace() {
        return this.place;
    }

    /**
     * Retourne la transition à laquelle l'arc est lié.
     *
     * @return la transition à laquelle l'arc est lié.
     */
    public Transition getTransition() {
        return this.transition;
    }

    /**
     * Change le poids de l'arc.
     *
     * @param weight : le nouveau poids de l'arc..
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Méthode abstraite qui sera définie pour les sous classes de l'arc. Elle définit le comportement de l'arc en cas de tirage.
     */
    public abstract void execute();
}

