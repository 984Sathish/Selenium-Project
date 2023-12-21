package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConcat {
	
	public static void main(String[] args) {
		
		/*
		 * concat method is used for merge two list by using stream.
		 */
		List<String> list1 = Arrays.asList("z", "y", "r", "a", "g");
		List<String> list2 = Arrays.asList("i", "q", "d", "k", "b","o");
		
		Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
		concatStream.sorted().forEach(s-> System.out.print(s+" "));
	}

}
