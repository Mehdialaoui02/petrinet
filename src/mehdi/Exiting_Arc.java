package mehdi;

public class Exiting_Arc extends Arc {

	public Exiting_Arc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
	}
	
	public boolean is_entering() {
		return false;
	}
	
	public boolean is_exiting() {
		return true;
	}

	@Override
	public void execute() {
		this.place.add_tokens(this.weight);
	}

}
