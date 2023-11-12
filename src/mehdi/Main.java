package mehdi;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NotFirableTransitionException, NegativeTokenValueException, ExistingArcException {
		Scanner scanner = new Scanner(System.in);

		// Get the number of transitions from the user
		System.out.print("Enter the number of transitions: ");
		int numTransitions = scanner.nextInt();

		LinkedList<Transition> transitionsList = new LinkedList<Transition>();
		LinkedList<Place> placesList = new LinkedList<Place>();
		LinkedList<Arc> arclist = new LinkedList<Arc>();
		PetriNet petriNet = new PetriNet(transitionsList, placesList, arclist);

		// Create transitions
		for (int i = 1; i <= numTransitions; i++) {
			Transition transition = new Transition(new LinkedList<Arc>(), new LinkedList<EnteringArc>());
			Scanner scanner2 = new Scanner(System.in);
			System.out.print("Enter the number of arcs entering the transition: ");
			int numEnteringArc = scanner2.nextInt(); //La méthode nextInt gère toutes les exceptions à part pour des tokens  
			
			
			
			Scanner scanner3 = new Scanner(System.in);
			System.out.print("Enter the number of arcs exiting the transition: ");
			int numExitingArc = scanner3.nextInt();
			
			for (int j = 1; j <= numEnteringArc; j++) {
				Scanner scanner4 = new Scanner(System.in);
				System.out.print("Enter the weight of EnteringArc number %d: ".formatted(j));
				int weightArc = scanner4.nextInt();
				
				Scanner scanner5 = new Scanner(System.in);
				System.out.print("Enter the number of tokens linked with that arc: ");
				int nbTokens = scanner5.nextInt();
				LinkedList<Arc> a = new LinkedList<Arc>();
				Place place = new Place(nbTokens, a);
				EnteringArc arc = new EnteringArc(weightArc, place, transition);
				transition.addEnteringArc(arc);
			}
			
			for (int j = 1; j <= numExitingArc; j++) {
				Scanner scanner5 = new Scanner(System.in);
				System.out.print("Enter the weight of ExitingArc number %d: ".formatted(j));
				int weightArc = scanner5.nextInt();
				
				Scanner scanner6 = new Scanner(System.in);
				System.out.print("Enter the number of tokens linked with that arc: ");
				int nbTokens = scanner6.nextInt();
				LinkedList<Arc> a = new LinkedList<Arc>();
				Place place = new Place(nbTokens, a);
				ExitingArc arc = new ExitingArc(weightArc, place, transition);
				transition.addExitingArc(arc);
			}

				petriNet.addTransition(transition);
		}
		for ( Transition t : petriNet.firableTransitions()) {
			petriNet.fire(t);
		}

	}

}
