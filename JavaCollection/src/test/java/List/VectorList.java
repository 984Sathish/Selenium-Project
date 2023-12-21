package List;

import java.util.Iterator;
import java.util.Vector;

public class VectorList {

	/**
	 * Vector uses a dynamic array to store the data elements. 
	 * It is similar to ArrayList.
	 * However, It is synchronized and contains many methods that are not the part of Collection framework.
	 *It also maintains an insertion order like an ArrayList. 
	 *Still, it is rarely used in a non-thread environment as it is synchronized, 
	 *and due to this, it gives a poor performance in adding, searching, deleting, and updating its elements.
	 */

	public static void main(String[] args) {

		Vector<String> vector = new Vector<String>(6);
		vector.add("Home");
		vector.add("Office");
		vector.add("School");

		System.out.println("-----After adding value in Vector-----");
		System.out.println(vector +"\n");

		vector.add(1, "Gym");

		//Adds the specified component to the end of this vector, increasing its size by one
		vector.addElement("Tution");

		System.out.println("-----After add, addElement-----");
		System.out.println(vector +"\n");

		Iterator<String> itr = vector.iterator();
		while(itr.hasNext()) {
			itr.next();//System.out.println(itr.next());
		}

		System.out.println("Capacity of Vector: "+vector.capacity() +"\n");

		System.out.println("elementAt method: "+vector.elementAt(1) +"\n");

		System.out.println("get by index: "+vector.get(1) +"\n");

		System.out.println("Hashcode: "+vector.hashCode() +"\n");

		Object vector2 = vector.clone();
		System.out.println("cloned vector: "+vector2 +"\n");

		System.out.println("Index of 'Office' is:"+vector.indexOf("Office") +"\n");
		System.out.println("Index of 'Tution' is:"+vector.indexOf("Tution", 4) +"\n");
		System.out.println("Index of not specified element:"+ vector.indexOf("jldjld") +"\n");

		vector.insertElementAt("Road", 5);
		System.out.println("Last index of: "+vector.lastIndexOf("Road") +"\n");


		vector.setSize(10);
		System.out.println("After set size, Capacity of Vector: "+vector.capacity() +"\n");

		vector.trimToSize();
		System.out.println("After trim size, Capacity of Vector: "+vector.capacity() +"\n");

		//created array 
		String arr[] = new String[10];
		arr[0] = "Hello";
		arr[1] = "World";
		System.out.println("-----Initial array is-----");
		for(String str: arr) {
			System.out.println(str);
		}

		//copyInto - Copies the components of this vector into the specified array. 
		vector.copyInto(arr);

		System.out.println("-----Final array is-----");
		for(String str: arr) {
			System.out.println(str);
		}


	}

}
