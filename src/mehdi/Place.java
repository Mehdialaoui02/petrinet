package mehdi;

import java.util.LinkedList;

public class Place {
	
	private int tokens_number;
	private LinkedList<Arc> arcsList;
	
	public Place(int tokens_number, LinkedList<Arc> arcsList) {
		this.tokens_number = tokens_number;
		this.arcsList = arcsList;
	}
	
	public int get_tokens_nb() {
		return this.tokens_number;
	}
	
	public void set_tokens_nb(int n) {
		this.tokens_number = n;
	}
	
	public boolean is_empty() {
		if (this.tokens_number == 0) {
			return true;
		}
		return false;
	}
	
	public LinkedList<Arc> get_arcList(){
		return this.arcsList;
	}
	
	public void add_tokens(int number) {
		this.tokens_number += number;
	}
	
	public void remove_tokens(int number) {
		this.tokens_number -= number;
	}
	
	public void remove_all_tokens() {
		this.tokens_number = 0;
	}
	

}
