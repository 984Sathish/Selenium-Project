package Stream;

import java.util.stream.Stream;

public class Map {

	public static void main(String[] args) {

		/*
		 * Map is used to perform action without changing the size of list.
		 * In this cases,  we make the words as upper case only. not changing any size.
		 */
		Stream.of("abi", "ravi", "sheak").map(name-> name.toUpperCase())
											.forEach(s-> System.out.println(s)) ;

	}

}
