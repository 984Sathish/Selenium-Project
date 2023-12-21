package Set;

import java.util.LinkedHashSet;
import java.util.Spliterator;

public class Linked_HashSet {

	/*
	 *1.It extends the HashSet class and implements Set interface
	 *2.It also contains unique elements. It maintains the insertion order and permits null elements.
	 */

	static int i = 1;

	public static void main(String[] args) {

		LinkedHashSet<String> linkHset = new LinkedHashSet<>();

		linkHset.add("Home");
		linkHset.add("School");
		linkHset.add("College");
		linkHset.add("Gym");

		System.out.println("Initial Linked HashSet- "+linkHset+ "\n");

		linkHset.remove("School");

		System.out.println("After removing - "+linkHset+ "\n");

		System.out.println("----Using spliterator()-----");

		Spliterator<String> str = linkHset.spliterator();

		System.out.println("Example 1---> ");
		while(str.tryAdvance((n)->System.out.println(i++ +". Alphabet - "+n))); 
		System.out.println();


		System.out.println("Example 2---> ");
		Spliterator<String> str1 = linkHset.spliterator();
		str1.forEachRemaining(  
				(n)-> {  
					String lc = n.toUpperCase();  
					System.out.println("Lower case = "+n);  
					System.out.println("Upper case = "+lc);   
				}  
				);  

	}

}
