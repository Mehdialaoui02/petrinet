package mehdi;

public class Emptying_Arc extends Entering_Arc{

	public Emptying_Arc(int weight, Place place, Transition transition) {
		super(weight, place, transition, "emptying");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		this.place.remove_all_tokens();
	}
	
}
