package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class Hash_Set {

	/**
	 * 1.Implements Set Interface.
	 * 2.duplicate values are not allowed.
	 * 3.Not guaranteed to be inserted in the same order. Objects are inserted based on their hash code.
	 * 4.NULL elements are allowed in HashSet
	 * 5.All the constructors are internally creating HashMap Object.
	 * 6.HashSet is used for avoiding duplicate data and to find value with the fast method.
	 */

	public static void main(String[] args) {

		HashSet<String> hashSet = new HashSet<>();

		hashSet.add("School");
		hashSet.add("Office");
		hashSet.add("Tution");
		System.out.println("Intial HashSet - "+hashSet+ "\n");

		hashSet.add("Office");

		//if you give two Objects that are equal then it stores only the first on
		System.out.println("Remove duplicate element - "+hashSet+ "\n");

		hashSet.remove("School");
		System.out.println("Remove element - "+hashSet+ "\n");

		System.out.println("-----Using iterator----- ");
		Iterator<String> itr = hashSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("Office");
		hashSet2.add("Tution");

		System.out.println(hashSet.equals(hashSet2)+ "\n");

		hashSet.add("Home");

		System.out.println("-----Before removeAll method-----");
		System.out.println("HashSet 1 - " +hashSet+ "\n");
		System.out.println("HashSet 2 - "+hashSet2+ "\n");

		//Remove hashset based on hashset2 values
		hashSet.removeAll(hashSet2);
		System.out.println("-----After removeAll method-----");
		System.out.println("HashSet 1 - " +hashSet+ "\n");
		System.out.println("HashSet 2 - "+hashSet2+ "\n");

		hashSet.addAll(hashSet2);
		System.out.println("-----After addAll method-----");
		System.out.println("HashSet 1 - " +hashSet+ "\n");
		System.out.println("HashSet 2 - "+hashSet2+ "\n");

		System.out.println("Hashset 1 containsAll of Hashset 2 - "+hashSet.containsAll(hashSet2)+ "\n");
		System.out.println("Hashset 2 containsAll of Hashset 1 - "+hashSet2.containsAll(hashSet)+ "\n");

		System.out.println("Hashset 1 retainAll of Hashset 2 - "+hashSet.retainAll(hashSet2)+ "\n");
		System.out.println("Hashset 2 retainAll of Hashset 1 - "+hashSet2.retainAll(hashSet)+ "\n");

		Set<Integer> hashSet3 = new HashSet<>();

		hashSet3.add(5);
		hashSet3.add(8);
		hashSet3.add(2);
		hashSet3.add(9);
		hashSet3.add(4);
		hashSet3.add(1);
		//stream
		Stream<Integer> stream = hashSet3.stream();

		Integer number = stream
				.filter(n->	 n%2==1) 	//--> filter odd number(which is divide/2 value will be equal to 1)
				.sorted()
				.map(n-> n*2)		 	//--> map the number with multiple of 2(each number will be multiply with 2)
				.reduce(0, (a,b) -> a+b);//--> sum each number and get the total sum value

		System.out.println("After Stream --> "+number);
	}

}
