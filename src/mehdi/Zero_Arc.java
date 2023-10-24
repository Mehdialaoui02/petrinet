package mehdi;

public class Zero_Arc extends Entering_Arc{

	public Zero_Arc(int weight, Place place, Transition transition, String type) {
		super(weight, place, transition, type);
		// TODO Auto-generated constructor stub
		this.weight = 0;
	}
	 
	@Override
	public void execute() {
	}
	@Override
	public boolean is_executable() {
		return this.place.get_tokens_nb() == 0;
	}
	
}
