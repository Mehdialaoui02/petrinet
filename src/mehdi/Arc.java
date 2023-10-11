package mehdi;

public class Arc {
    private int weight;
    private Place place;
    private Transition transition;
    
    public Arc(int weight, Place place, Transition transition) {
        this.place=place;
        this.weight= weight;
        this.transition=transition;
        }

}
