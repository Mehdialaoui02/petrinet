package mehdi;

import java.util.LinkedList;

/**
 * La classe Place représente une place dans un réseau de Petri. Une place
 * peut contenir un certain nombre de jetons et est connectée à des arcs.
 */
public class Place {
	
    private int tokens_number;
    private LinkedList<Arc> arcsList;
	
    /**
     * Constructeur de la place avec le nombre initial de jetons et la liste des arcs connectés.
     *
     * @param tokens_number  Le nombre initial de jetons dans la place.
     * @param arcsList       Liste des arcs connectés à la place.
     */
    public Place(int tokens_number, LinkedList<Arc> arcsList) {
        this.tokens_number = tokens_number;
        this.arcsList = arcsList;
    }
	
    /**
     * Retourne le nombre de jetons actuel dans la place.
     *
     * @return Le nombre de jetons dans la place.
     */
    public int get_tokens_nb() {
        return this.tokens_number;
    }
	
    /**
     * Définit le nombre de jetons dans la place.
     *
     * @param n Le nouveau nombre de jetons.
     * @throws NegativeTokenValueException Si la tentative de définir un nombre négatif de jetons est faite.
     */
    public void set_tokens_nb(int n) throws NegativeTokenValueException {
        if (n >= 0) {
            this.tokens_number = n;
        } else {
            throw new NegativeTokenValueException();
        }
    }
	
    /**
     * Vérifie si la place est vide.
     *
     * @return {@code true} si la place est vide, sinon {@code false}.
     */
    public boolean is_empty() {
        return this.tokens_number == 0;
    }
	
    /**
     * Ajoute un arc à la liste des arcs connectés à la place.
     *
     * @param arc L'arc à ajouter.
     */
    public void add_arc(Arc arc) {
        this.arcsList.add(arc);
    }
	
    /**
     * Retourne la liste des arcs connectés à la place.
     *
     * @return Liste des arcs connectés à la place.
     */
    public LinkedList<Arc> get_arcList() {
        return this.arcsList;
    }
	
    /**
     * Ajoute un certain nombre de jetons à la place.
     *
     * @param number Le nombre de jetons à ajouter.
     * @throws NegativeTokenValueException Si la tentative d'ajout d'un nombre négatif de jetons est faite.
     */
    public void add_tokens(int number) throws NegativeTokenValueException { 
        if (number + this.tokens_number >= 0) {
            this.tokens_number += number;
        } else {
            throw new NegativeTokenValueException();
        }
    }
	
    /**
     * Retire un certain nombre de jetons de la place.
     *
     * @param number Le nombre de jetons à retirer.
     */
    public void remove_tokens(int number) {
        if (this.tokens_number >= number) {
            this.tokens_number -= number;
        } else {
            this.tokens_number = 0;
        }
    }
	
    /**
     * Retire tous les jetons de la place.
     */
    public void remove_all_tokens() {
        this.tokens_number = 0;
    }
}

