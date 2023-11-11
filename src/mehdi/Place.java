package mehdi;

import java.util.LinkedList;

/**
 * La classe Place représente une place dans un réseau de Petri. Une place
 * peut contenir un certain nombre de jetons et est connectée à des arcs.
 */
public class Place {
	
    private int tokenNumber;
    private LinkedList<Arc> ArcList;
	
    /**
     * Constructeur de la place avec le nombre initial de jetons et la liste des arcs connectés.
     *
     * @param tokensNumber  Le nombre initial de jetons dans la place.
     * @param arcsList       Liste des arcs connectés à la place.
     */
    public Place(int tokenNumber, LinkedList<Arc> ArcList) {
        this.tokenNumber = tokenNumber;
        this.ArcList = ArcList;
    }
	
    /**
     * Retourne le nombre de jetons actuel dans la place.
     *
     * @return Le nombre de jetons dans la place.
     */
    public int getTokenNumber() {
        return this.tokenNumber;
    }
	
    /**
     * Définit le nombre de jetons dans la place.
     *
     * @param n Le nouveau nombre de jetons.
     * @throws NegativeTokenValueException Si la tentative de définir un nombre négatif de jetons est faite.
     */
    public void setTokenNumber(int n) throws NegativeTokenValueException {
        if (n >= 0) {
            this.tokenNumber = n;
        } else {
            throw new NegativeTokenValueException();
        }
    }
	
    /**
     * Vérifie si la place est vide.
     *
     * @return {@code true} si la place est vide, sinon {@code false}.
     */
    public boolean isEmpty() {
        return this.tokenNumber == 0;
    }
	
    /**
     * Ajoute un arc à la liste des arcs connectés à la place.
     *
     * @param arc L'arc à ajouter.
     */
    public void addArc(Arc arc) {
        this.ArcList.add(arc);
    }
	
    /**
     * Retourne la liste des arcs connectés à la place.
     *
     * @return Liste des arcs connectés à la place.
     */
    public LinkedList<Arc> getArcList() {
        return this.ArcList;
    }
	
    /**
     * Ajoute un certain nombre de jetons à la place.
     *
     * @param number Le nombre de jetons à ajouter.
     * @throws NegativeTokenValueException Si la tentative d'ajout d'un nombre négatif de jetons est faite.
     */
    public void addTokens(int number) throws NegativeTokenValueException { 
        if (number + this.tokenNumber >= 0) {
            this.tokenNumber += number;
        } else {
            throw new NegativeTokenValueException();
        }
    }
	
    /**
     * Retire un certain nombre de jetons de la place.
     *
     * @param number Le nombre de jetons à retirer.
     */
    public void removeTokens(int number) {
        if (this.tokenNumber >= number) {
            this.tokenNumber -= number;
        } else {
            this.tokenNumber = 0;
        }
    }
	
    /**
     * Retire tous les jetons de la place.
     */
    public void removeAllTokens() {
        this.tokenNumber = 0;
    }
}

