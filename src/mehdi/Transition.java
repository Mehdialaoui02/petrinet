package mehdi;

import java.util.LinkedList;

public class Transition {
    private LinkedList<Arc> exiting_ArcsList;
    private LinkedList<Arc> entering_ArcsList;
    
    public Transition(LinkedList<Arc> exiting , LinkedList<Arc> entering ) {
        this.exiting_ArcsList = exiting;
        this.entering_ArcsList = entering;
       
       
    }
}