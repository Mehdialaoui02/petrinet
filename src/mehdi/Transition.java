package mehdi;

import java.util.LinkedList;

public class Transition {
    private LinkedList<Arc> exiting_ArcsList;
    private LinkedList<Arc> entering_ArcsList;
    
    public Transition(LinkedList<Arc> exiting , LinkedList<Arc> entering ) {
        this.exiting_ArcsList = exiting;
        this.entering_ArcsList = entering;
    }
        
    public LinkedList<Arc> get_enteringList() {
        	return this.entering_ArcsList;
    }
    
    public LinkedList<Arc> get_exitingList() {
    	return this.exiting_ArcsList;
    }
    
    public boolean is_firable() {
    	for (Arc arc : this.entering_ArcsList) {
    		if (arc.get_Weight()>= arc.get_Place().get_tokens_nb()) {
    			return false; 
    		}
    	}
		return true;
    	
    }
    public void fire() {
    	if (this.is_firable()) {
			for (Arc arc : this.get_enteringList()) {
				arc.execute();
			}
			for (Arc arc : this.get_exitingList()) {
				arc.execute();
			}
		System.out.println("Tirage fait avec succès");	
		}
		else {
			System.out.println("Tirage impossible");
		}
    }

}