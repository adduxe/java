import java.util.Scanner;

enum Choices { U, O, S, C, Q }	// Possible Actions: Push, Pop, Show, Clear, Quit respectively.

public class Structure{
	
	private static String userInput = "";

	private static Scanner in = new Scanner(System.in);

	private static Action Options[] = new Action[Choices.Q.ordinal() + 1];


	private static void push(Queue q){
		
		int n = 0;
		
		System.out.print("\nEnter a value to push: ");
		
		userInput = in.nextLine();
		n = Integer.parseInt(userInput);
		
		q.putQueue(n);
		
		if (q.isFull){
			System.out.println("\nQueue is now full.");
		}
		
		return;

	}	// push()


	private static void pop(Queue q){
		
		int n = 0;
		
		n = q.getQueue();
		
		if (n != Integer.MIN_VALUE){
			System.out.println("\nPopped value: " + n);
		}

		if (q.isEmpty){
			System.out.println("Queue is now empty.");
		}
		
		return;

	}	// pop()

	
	private static Choices getUserInput(Queue q){		// Know what the user wants to do.
	
		System.out.println("\nWhat do you want to do:");
		
		System.out.print("\n  " + Choices.U + ") " + Options[Choices.U.ordinal()].getName());
		if (q.isFull){
			System.out.print("  (Queue is already full)");
		}

		System.out.print("\n  " + Choices.O + ") " + Options[Choices.O.ordinal()].getName());
		if (q.isEmpty){
			System.out.print("  (Queue is empty)");
		}
		
		System.out.print("\n  " + Choices.S + ") " + Options[Choices.S.ordinal()].getName());
		if (q.isEmpty){
			System.out.print("  (Queue is empty)");
		}

		System.out.print("\n  " + Choices.C + ") " + Options[Choices.C.ordinal()].getName());
		if (q.isEmpty){
			System.out.print("  (Queue is empty)");
		} else {
			System.out.print("  (Queue has contents)");
		}
		
		System.out.println("\n  " + Choices.Q + ") " + Options[Choices.Q.ordinal()].getName());

		System.out.print("\nEnter ");
		for(Choices c: Choices.values()){
			System.out.print("'" + c + "' ");
		}
		
		System.out.print(": ");
		
		String userInput = in.nextLine();
		
		return Choices.valueOf(userInput.toUpperCase());
		
	}	// getUserInput()
	

	public static void main(String args[]){

		int n = 0;

		System.out.print("\nPlease enter the desired queue size: ");
		
		userInput = in.nextLine();
		
		n = Integer.parseInt(userInput);
		
		Queue queue = new Queue(n);
		
		Options[Choices.U.ordinal()] = new Action('U', "Push");
		Options[Choices.O.ordinal()] = new Action('O', "Pop");
		Options[Choices.S.ordinal()] = new Action('S', "Show");
		Options[Choices.C.ordinal()] = new Action('C', "Clear");
		Options[Choices.Q.ordinal()] = new Action('Q', "Quit");

		Choices userChoice;

		do{

			userChoice = getUserInput(queue);
			
			switch(userChoice){
				
				case U: 	// push()
				
					if (queue.isFull){
						System.out.println("\nQueue is already full! Pop a value first.");
					} else {
						push(queue);
					}
					 break;
					 
				case O:	// pop()
				
					if (queue.isEmpty){
						System.out.println("\nQueue is empty! There is nothing to pop.");
					} else {
						pop(queue);
					}
					 break;

				case S:	// show()
				
					if (queue.isEmpty){
						System.out.println("\nQueue is empty! There is nothing to display.");
					} else {
						queue.showQueue();
					}
					 break;
					 
				case C:	// clear()
					if (queue.isEmpty){
						System.out.println("\nThe queue is currently empty. No need to clear.");
					} else {
						queue.clearQueue();
						System.out.println("\nThe queue has been cleared.");
					}
					 break;
				
				case Q:
					break;
				
				default:
//					System.out.println("choice = " + userChoice);
					break;
			}	// switch()

		}while(userChoice != Choices.Q);
	
		return;
	}	// main()

}	// TestQueue{}