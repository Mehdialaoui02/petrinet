package mehdi;

public abstract class Arc {
    protected int weight;
    protected Place place;
    protected Transition transition;
    
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
    
    public void set_weight(int w) {
    	this.weight = w;
    }
    
    public abstract boolean is_executable();
//  public boolean is_exiting() {
//	
//	}
//  public boolean is_entering() {
//	
//	}
    
    public abstract void execute();
}
