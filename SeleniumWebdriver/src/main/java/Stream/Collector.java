package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector {

	public static void main(String[] args) {
		
		/*
		 *collecter is used to the add the result in new list.
		 *In this cases, filter and map value become store in collectList. 
		 * 
		 */
		List<String> collectList = Stream.of("abi", "ravi", "sheak").filter(name->name.length()>3).map(name-> name.toUpperCase())
				 .collect(Collectors.toList()); 

		collectList.stream().forEach(s-> System.out.println(s));

	}
}
