package Deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Array_Deque {

	/*
	 * 1.ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions
	 * 2.Allows users to add or remove an element from both sides of the queue.
	 */

	public static void main(String[] args) {
		
		//implementation of the Deque interface
		Deque<String> arrDeque = new ArrayDeque<>();

		arrDeque.add("Home");
		arrDeque.add("Gym");
		arrDeque.add("Office");

		System.out.println("Created ArrayDeque - "+arrDeque +"\n");

		arrDeque.addFirst("School");
		arrDeque.addLast("College");
		System.out.println("After add - "+arrDeque +"\n");

		arrDeque.removeFirst();
		arrDeque.removeLast();
		System.out.println("After remove - "+arrDeque +"\n");

		//add element to last 
		arrDeque.offer("Ice");

		//add element to first
		arrDeque.offerFirst("Tution");

		//add element to last
		arrDeque.offerLast("Road");

		System.out.println("After offer() - "+arrDeque +"\n");

		System.out.println("get first - "+arrDeque.getFirst() +"\n");
		System.out.println("get last - "+arrDeque.getLast() +"\n");

		//Remove top element
		arrDeque.poll();

		//Remove top element
		arrDeque.pollFirst();

		//Remove last element
		arrDeque.pollLast();

		System.out.println("After poll() - "+arrDeque +"\n");

		System.out.println("Peak() - "+arrDeque.peek() +"\n");
		System.out.println("PeakFirst() - "+arrDeque.peekFirst() +"\n");
		System.out.println("PeakLast() - "+arrDeque.peekLast() +"\n");


		ArrayDeque<Integer> ad = new ArrayDeque<>();
		ad.add(1);
		ad.add(5);
		ad.add(1);
		ad.add(2);
		ad.add(4);
		ad.add(1);

		System.out.println("Intial Array Queue - "+ad +"\n");

		ad.removeFirstOccurrence(1);
		System.out.println("After remove first occurence - "+ad +"\n");

		ad.removeLastOccurrence(1);
		System.out.println("After remove Last occurence - "+ad +"\n");


		ad.push(6);

		System.out.println("After push -"+ad+ "\n");

		ad.pop();  //Queue interface maintains the first-in-first-out order.

		System.out.println("After pop - "+ad+ "\n");

	}

}
