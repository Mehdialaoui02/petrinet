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
	
	public void set_tokens_nb(int n) throws NegativeTokenValueException{
		if ( n >=0) {
			this.tokens_number = n;
		} else {
			throw new NegativeTokenValueException();
		}
		
	}
	
	public boolean is_empty() {
		if (this.tokens_number == 0) {
			return true;
		}
		return false;
	}
	
	public void add_arc(Arc arc) {
		this.arcsList.add(arc);
	}
	
	public LinkedList<Arc> get_arcList(){
		return this.arcsList;
	}
	
	public void add_tokens(int number) throws NegativeTokenValueException{
		if ( number+this.tokens_number >=0) {
			this.tokens_number += number;
		} else {
			throw new NegativeTokenValueException();
		}
	}
	
	public void remove_tokens(int number) {
		if (this.tokens_number>=number) {
			this.tokens_number -= number;
		} else {
			this.tokens_number = 0;
		}
		
	}
	
	public void remove_all_tokens() {
		this.tokens_number = 0;
	}
	

}
