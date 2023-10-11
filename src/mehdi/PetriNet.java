package mehdi;

import java.util.LinkedList;

public class PetriNet {
	
	private LinkedList<Transition> transitionsList; 
	private LinkedList<Place> placesList;
	public PetriNet(LinkedList<Transition> transitionsList, LinkedList<Place> placeList) {
		this.transitionsList = transitionsList;
		this.placesList = placeList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
