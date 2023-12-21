package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
	
public class JavaStream {

	public static void main(String[] args) {

		//create list
		List<Integer> asList = Arrays.asList(9, 2, 5, 4, 1);

		//create stream with 'asList'
		Stream<Integer> stream = asList.stream();

		//long count = stream.count();
		//stream.forEach(n -> System.out.println("value : "+n));

		System.out.println("**********Using Filter, Map, Reduce in Stream***********");
		Integer number = stream
				.filter(n->	 n%2==1)  //-->  filter odd number(which is divide/2 value will be equal to 1)

				.sorted()	
				.map(n-> n*2) //--> map the number with multiple of 2(each number will be multiply with 2)

				.reduce(0, (c,e) -> c+e); //sum each number and get the total sum value

		System.out.println(number);


		System.out.println("**********Terminal operation only execute if filter return true***********");
		//-->terminal operation only execute if filter return true
		long count = Stream.of("abi", "ravi", "shek").filter(name-> 
		{
			name.startsWith("r");
			return false;  			//-> false - count is 0
			//return true; 			//-> true - count is 3

		}).count();

		//count =0 because we return false in every filter iteration
		System.out.println(count);


		//using for each in stream
		System.out.println("**********using for each in stream***********");
		Stream.of("abi", "ravi", "sheak").filter(name->name.length()>3).forEach(s-> System.out.println(s));


		//limit result
		System.out.println("**********limit result***********");
		Stream.of("abi", "ravi", "sheak").filter(name->name.length()>3).limit(1).forEach(s-> System.out.println(s));

		
		System.out.println("**********Merge two list using steam concat***********");
		List<String> list1 = Arrays.asList("z", "y", "r", "a", "g");
		List<String> list2 = Arrays.asList("i", "q", "d", "k", "b","o");
		
		Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
		concatStream.sorted().forEach(s-> System.out.print(s+" "));
		
		//boolean anyMatch = concatStream.anyMatch(s-> s.equals("z"));
		//System.out.println(anyMatch);
		
		System.out.println();
		System.out.println("**********collector in stream***********");
		List<String> collectList = Stream.of("abi", "ravi", "sheak").filter(name->name.length()>3).map(name-> name.toUpperCase())
										 .collect(Collectors.toList());  //to collect the result and add to list
		
		collectList.stream().forEach(s-> System.out.println(s));
		
		
		System.out.println("**********Remove duplicate in stream using 	distinct***********");
		List<Integer> newList = Arrays.asList(1,2,3,1,4,2,5,6,7,3);
		newList.stream().distinct().sorted().forEach(n -> System.out.print(n+" "));
		
		
		
	}
}
