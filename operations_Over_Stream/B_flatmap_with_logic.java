package stream_API.operations_Over_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class B_flatmap_with_logic {

	public static void main(String[] args) {
		
/*
 * Why do we need flatMap()?
 * Because map() can create nested streams, and streams don’t like nesting.		
 * Removes nesting  ==>> Stream<T> → Stream<R>
 * 
 * 🔹 flatMap() with Primitive Streams
 * flatMapToInt()		IntStream
 * flatMapToLong()		LongStream
 * flatMapToDouble()		DoubleStream
 * 
 */
		
		List<String> sentences = List.of(   // reverse the string with every word
			    "java stream api",
			    "flatmap is powerful"
			);
		
		sentences.stream()
		.map((i)-> (i.split(" ")))
		.flatMap((i) -> {return Arrays.stream(i);})   // to get out one by one element
		.map(StringBuffer::new)
		.map(StringBuffer::reverse)
		.map(StringBuffer::toString)
		.forEach(System.out::println);
		
	// **************************************************************************************
		
		List<List<List<Integer>>> list = List.of(List.of(List.of(32,45,76,87),List.of(32,54,19)));
							//	[[[32, 45, 76, 87], [32, 54, 19]]] addition of all integer
		
     int d=		list.stream()
					.flatMap((i)-> i.stream())  //getting out of the depth
					.flatMap(i -> i.stream())   // depth out
					.peek(System.out::println)
					.reduce(0,(i,j) -> (i+j));
		
		System.out.println(d);
		
		

	}

}
