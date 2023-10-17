package mehdi;

import java.util.LinkedList;

public class PetriNet {
	
	private LinkedList<Transition> transitionsList; 
	private LinkedList<Place> placesList;
	
	public PetriNet(LinkedList<Transition> transitionsList, LinkedList<Place> placeList) {
		this.transitionsList = transitionsList;
		this.placesList = placeList;
	}
	
	public void firable_transitions() {
		for (Transition t : this.transitionsList) {
			System.out.println("La liste est :");
            System.out.println(t.is_firable());
        }
	}
	
	public void fire(Transition t) {
		if (t.is_firable()) {
			for (Arc arc : t.get_enteringList()) {
				arc.execute();
			}
			for (Arc arc : t.get_exitingList()) {
				arc.execute();
			}
		System.out.println("Tirage fait avec succès");	
		}
		else {
			System.out.println("Tirage impossible");
		}
	}
	
	
//	private void add_transition(exiting_ArcsList, entreing_ArcList) {
//		
//	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Transition> L = new LinkedList<Transition>();
		LinkedList<Place> L2 = new LinkedList<Place>();
		
		PetriNet p = new PetriNet(L,L2);
		p.firable_transitions();
		
	}

}
