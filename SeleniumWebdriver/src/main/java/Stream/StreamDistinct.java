package Stream;

import java.util.Arrays;
import java.util.List;

public class StreamDistinct {

	public static void main(String[] args) {
		
		/*
		 * distinct() is used for remove the duplicate in list.
		 * In this case, list have duplicate values then we used distinct we got only unique value.
		 */
		List<Integer> newList = Arrays.asList(1,2,3,1,4,2,5,6,7,3);
		newList.stream().distinct().sorted().forEach(n -> System.out.print(n+" "));
	}
}
