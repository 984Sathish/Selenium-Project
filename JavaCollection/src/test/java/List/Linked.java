package List;

import java.util.LinkedList;

public class Linked {

	/*
	 * Linked List is a linear data structure, in which elements are not stored at a contiguous location, rather they are linked using pointers. 
	 * Linked List forms a series of connected nodes, where each node stores the data and the address of the next node.
	 * LinkedList to manipulate data.
	 * The LinkedList class has all of the same methods as the ArrayList class because they both implement the List interface. 
	 * This means that you can add items, change items, remove items and clear the list in the same way.
	 * 
	 */

	public static void main(String[] args) {

		//creating linked list
		LinkedList<String> linkedList = new LinkedList<String>();

		//add value
		linkedList.add("Home");
		linkedList.add("Office");
		linkedList.add("Gym");

		System.out.println("-----After adding values in linkedlist-----");
		System.out.println(linkedList +"\n");

		System.out.println("Get by index: "+linkedList.get(2) +"\n"); 

		linkedList.addFirst("School");
		linkedList.removeLast();

		System.out.println("-----After addFirst, removeLast-----");
		System.out.println(linkedList +"\n");

		linkedList.addLast("College");
		linkedList.removeFirst();

		System.out.println("-----After addLast, removeFirst-----");
		System.out.println(linkedList +"\n");

		System.out.println("get First value: "+ linkedList.getFirst() +"\n");
		System.out.println("get Last value: "+ linkedList.getLast() +"\n");
		
		

	}

}
