package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Priority_Queue {

	/*
	 *  Queue follows the First-In-First-Out algorithm
	 *  The PriorityQueue is based on the priority heap. 
	 *  The elements of the priority queue are ordered according to the natural ordering
	 *  an element with a maximum ASCII value will have the highest priority.
	 */

	public static void main(String[] args) {

		//implementation of the Queue interface
		Queue<String> pQueue = new PriorityQueue<>();
		
		pQueue.add("Home");
		pQueue.add("Gym");
		pQueue.add("Road");
		pQueue.add("Office");
		pQueue.add("School");
		pQueue.add("Tution");

		System.out.println("Created PriorityQueue(Sorted based on mas ASCII value) : "+pQueue +"\n");

		System.out.println("Top element of PriorityQueue using peek(): "+pQueue.peek() +"\n");
		
		System.out.println("Top element of PriorityQueue using element(): "+pQueue.element() +"\n");

		System.out.println("Removing top element in PriorityQueue: "+pQueue.poll() +"\n");

		System.out.println("Edited PriorityQueue: "+pQueue +"\n");

		pQueue.remove(); //remove first element
		System.out.println("After remove first element: "+pQueue +"\n");

		pQueue.remove("Road");
		System.out.println("After remove specific element: "+pQueue +"\n");

		System.out.println("PriorityQuere contains Road?: "+pQueue.contains("Road") +"\n");

		System.out.println("Size of PriorityQueue: "+pQueue.size() +"\n");

		System.out.println("-----Number will not get sorted elements by printing PriorityQueue-----");
		PriorityQueue<Integer> nq = new PriorityQueue<>();
		nq.add(10);
		nq.add(2);
		nq.add(5);
		nq.add(9);  
		System.out.println("Number Queue: "+ nq +"\n");

		System.out.println("-----Alphabets will not get sorted elements by printing PriorityQueue-----");
		PriorityQueue<String> aq = new PriorityQueue<>();
		aq.add("e");
		aq.add("n");
		aq.add("w");
		aq.add("o");
		System.out.println("Alphabets Queue: "+aq +"\n");
		

	}

}
