package mehdi;

import java.util.LinkedList;

public class Transition {
    private LinkedList<Arc> exiting_ArcsList;
    private LinkedList<Entering_Arc> entering_ArcsList;
    
    public Transition(LinkedList<Arc> exiting , LinkedList<Entering_Arc> entering ) {
        this.exiting_ArcsList = exiting;
        this.entering_ArcsList = entering;
    }
        
    public LinkedList<Entering_Arc> get_enteringList() {
        	return this.entering_ArcsList;
    }
    
    public LinkedList<Arc> get_exitingList() {
    	return this.exiting_ArcsList;
    }
    
    public boolean is_firable() {
    	for (Entering_Arc arc : this.entering_ArcsList) {
    		if (arc.is_executable()==false) {
    			return false; 
    		}
    	}
		return true;
    }
    
    public void add_exitingArc(Arc arc) {
		this.exiting_ArcsList.add(arc);
	}
    
    public void add_enteringArc(Entering_Arc arc) {
		this.entering_ArcsList.add(arc);
	}
    
    public void fire() throws NotFirableTransitionException{
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
			throw new NotFirableTransitionException();
		}
    }

}