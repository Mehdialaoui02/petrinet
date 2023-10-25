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
		t.fire();	
	}
		
	
	
	public void add_transition(LinkedList<Arc> exiting_ArcList, LinkedList<Arc> entering_ArcList) {
		Transition transition  = new Transition(exiting_ArcList, entering_ArcList);
		this.transitionsList.addLast(transition);
	}
	
	public void remove_transition(Transition transition) {
		this.transitionsList.remove(transition);
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Transition> L = new LinkedList<Transition>();
		LinkedList<Place> L2 = new LinkedList<Place>();
		
		PetriNet p = new PetriNet(L,L2);
		p.firable_transitions();
		
	}

}
