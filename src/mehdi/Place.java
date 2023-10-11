package mehdi;

import java.util.LinkedList;

public class Place {
	
	private int tokens_number;
	private LinkedList<Arc> arcsList;
	
	public Place(int tokens_number, LinkedList<Arc> arcsList) {
		this.tokens_number = tokens_number;
		this.arcsList = arcsList;
	}

}
