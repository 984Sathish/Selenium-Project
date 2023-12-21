package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Array {

	/*
	 * Use an ArrayList for storing and accessing data.
	 * The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. 
	 * If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.
	 */

	public static void main(String[] args) {

		//creating Array list
		ArrayList<String> arrayList = new ArrayList<String>();

		//adding object in array list
		arrayList.add("School");
		arrayList.add("College");
		arrayList.add("Home");

		System.out.println("-----After adding values in array-----");
		System.out.println(arrayList +"\n");

		//print array value using iterator
		Iterator<String> itr = arrayList.iterator();
		while(itr.hasNext()) {
			itr.next(); ////System.out.println(itr.next());
		}

		//get() - get value by index
		System.out.println("Using index: "+arrayList.get(1) +"\n");

		//set() - change value
		arrayList.set(2, "Gym");

		//remove() - remove value by index
		arrayList.remove(0);

		System.out.println("-----After remover, set the value-----");
		System.out.println(arrayList +"\n");

		//using for loop 
		for (int i = 0; i < arrayList.size(); i++) {
			//System.out.println(arrayList.get(i));
		}

		//clear() - remove all elements
		arrayList.clear();

		//size() - get arraylist size
		System.out.println("After clear all value: "+arrayList.size() +"\n"); 

		arrayList.add("School");
		arrayList.add("College");
		arrayList.add("Home");

		//Collections.sort() - Sort the array
		Collections.sort(arrayList );


		System.out.println("-----After sorting-----");
		System.out.println(arrayList +"\n");

		//using for each
		for (String i : arrayList) {
			//System.out.println(i);
		}


	}

}
