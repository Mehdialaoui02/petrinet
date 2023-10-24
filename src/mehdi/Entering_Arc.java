package mehdi;

public class Entering_Arc extends Arc {
	
	public Entering_Arc(int weight, Place place, Transition transition,String type) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
	}
	
	public boolean is_entering() {
		return true;
	}
	
	public boolean is_exiting() {
		return false;
	}

	@Override
	public void execute() {
		this.place.remove_tokens(this.weight);
	}

	public boolean is_executable() {
		return this.place.get_tokens_nb() >= this.weight;
	}
	
}
