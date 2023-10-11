package mehdi;

public class Arc {
    private int weight;
    private Place place;
    private Transition transition;
    
    public Arc(int weight, Place place, Transition transition) {
        this.place= place;
        this.weight= weight;
        this.transition=transition;
        }
    public int get_Weight() {
    	return this.weight;
    }
    public Place get_Place() {
    	return this.place;
    }
    public Transition get_Transition() {
    	return this.transition;
    }

}
