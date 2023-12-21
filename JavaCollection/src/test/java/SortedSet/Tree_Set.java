package SortedSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Tree_Set {

	/*
	 * 1.Like HashSet, TreeSet also contains unique elements. 
	 * 2.However, the access and retrieval time of TreeSet is quite fast. 
	 * 3.The elements in TreeSet stored in ascending order.
	 */

	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<>();

		treeSet.add("Home");
		treeSet.add("Gym");
		treeSet.add("Office");
		treeSet.add("School");
		treeSet.add("College");

		System.out.println("Inital treeSet - "+treeSet +"\n");

		//ceiling - returns the least element in this set greater than or equal to the given element
		System.out.println("ceiling - "+treeSet.ceiling("College") +"\n");

		System.out.println("-----Decending Iterator-----");

		// descendingIterator - iterator over the elements in this set in descending order
		Iterator<String> descendingIterator = treeSet.descendingIterator();
		while(descendingIterator.hasNext()) {
			System.out.println(descendingIterator.next());
		}

		System.out.println("\n" +"Descending set - "+treeSet.descendingSet() +"\n");

		System.out.println("First element - "+treeSet.first() +"\n");
		System.out.println("Last element - "+treeSet.last() +"\n");

		// return elements of TreeSet which are less than the specified element.
		System.out.println("headSet - "+treeSet.headSet("Office") +"\n");

		//return greater than or equal to the specified element.
		System.out.println("tailset - "+treeSet.tailSet("Office") +"\n");

		//return strictly greater than the given element,
		System.out.println("Higher - "+treeSet.higher("Gym") +"\n");

		//return strictly less than the given element,
		System.out.println("Lower - "+treeSet.lower("Gym") +"\n");

		//removes the first (lowest) element
		treeSet.pollFirst();
		System.out.println("After PollFirst - "+ treeSet +"\n");

		//removes the last (highest) element
		treeSet.pollLast();
		System.out.println("After PollLast - "+ treeSet +"\n");

		//return elements ranging from fromElement to toElement. fromElement is inclusive and toElement is exclusive.
		treeSet.subSet("College", "Office");  //like substring() method
		System.out.println("After subset - "+ treeSet +"\n");
	}

}
