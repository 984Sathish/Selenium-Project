package List;

import java.util.Stack;

public class StackList {

	/*
	 * Stack class is a subclass of the Vector class and represents a last-in-first-out (LIFO) stack of objects.
	 * It extends the Vector class to allow for easy implementation of the stack data structure.
	 */

	public static void main(String[] args) {

		//creating stack
		Stack<String> stack = new Stack<String>();

		//add values
		stack.push("Home");
		stack.push("Office");
		stack.push("Gym");
		stack.push("Tution");

		System.out.println("-----Pushing element on the top of the stack-----");
		System.out.println("Initial Stack: "+ stack +"\n");

		//Displaying element on the top of the stack
		System.out.println("Top element in stack: "+stack.peek() +"\n");

		System.out.println("stack size: "+stack.size() +"\n");

		System.out.println("-----Popping element from the top of the stack-----");
		for (int i = 0; i <2; i++) {
			System.out.println("Popped element: "+stack.pop());
		}

		System.out.println("Stack after pop operation: "+ stack +"\n");

		//add values
		stack.push("School");
		stack.push("College");
		stack.push("Road");

		// Searching element in the stack -
		// return 1 if the element is found (or) return -1 the element is not found
		System.out.println("Element found: "+stack.search("Road") +"\n"); 
		System.out.println("Element not found: "+stack.search("jdl;jds;f") +"\n"); 

		stack.add("Week");
		System.out.println("Final Stack: "+stack +"\n");

	}

}
