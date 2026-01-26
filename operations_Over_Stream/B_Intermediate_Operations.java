package stream_API.operations_Over_Stream;

import java.util.Arrays;
import java.util.List;

import java.util.function.Function;
import java.util.function.Predicate;


public class B_Intermediate_Operations {

	public static void main(String[] args) {
		
/*
 * Intermediate operations(like filter,map,etc.) are lazy and return another Stream,so you can chain them together
 * Intermediate Operations are the types of operations in which multiple methods are chained in a row.
 * Intermediate operations transform a stream into another stream.
 * It enables the concept of filtering where one method filters data and passes it to another method after processing.
 * Important Intermediate Operations :: 
 *      ⭕ map() - Transform each element,   ⭕ filter() - Select elements based on condition, 
 *      ⭕ sorted() - Sort elements,         ⭕ flatMap() - Flatten nested structures, 
 *      ⭕ distinct() - Remove duplicates,   ⭕ peek() - Debug / perform action without changing stream
 *      ⭕ limit(n) - Take first n elements  ⭕ skip(n) - Ignore first n elements
 *           >> limit() & skip() This combo is commonly used for pagination. => skip = (pageNumber - 1) * pageSize
 *           >> ✔ Order of operations matters in limit and skip () 
 *     
 *      
 * These operations do not produce a result immediately.
 * They return a new Stream and are lazy (executed only when a terminal operation is called).
 * 
 * What they are :: ✔️  Used to build the pipeline,  ✔️ Operations that return a Stream,
 * 					✔️  Lazy → they do NOT execute immediately.
 * 
 */

		List<Integer> list = List.of(32,76,26,41,91,27,32,71,48,35,75,43,41,77);
		System.out.println(list);
		
	Function<Integer,Integer> fun = (f) -> { return f * 2;}; // for map()
	
	Predicate<Integer> pre = (p) -> {return p > 60;};  // for filter()
	
		
//		Optional<Integer> as=	
				list.stream()
						.map(fun)   // function implementing
//		map(Function<T, R>): Transforms each element of the Stream into another form using the provided function.
						
						.filter(pre)  // Predicate implementing
//                filter(Predicate<T>): Selects elements from the Stream based on a specified condition.		
						
						.sorted()
//			      sorted(): Sorts the elements of the Stream. Natural sorting
						
						.sorted((i,j) -> {return Integer.compare(j, i); } )  // Comparator implementing
//				sorted(Comparator?)	: Sorts the elements using comparator Interface like custom sorting.	
						
//						.peek((c) -> {System.out.println(">>" + c);})  // Consumer implementing
// 				Debug /perform action without changing stream,
//				Performs a specified action on each element of the Stream without consuming the elements.	
						
						.distinct()    // for custom class is maintaining using hashCode and .equals override
//				Removes duplicate elements from the Stream.	 It returns a stream consisting of the 
//						distinct elements (according to Object.equals(Object)).	
						
						.skip(1)  // (Skips) Ignore the first n elements, Process the remaining elements
//	 If this stream contains fewer than n elements then an empty stream will be returned.
//						✔ skip() consumes elements silently
						
						
						.limit(8)  // limit() is mandatory for infinite streams.⚠ Without limit() → infinite loop
//	It returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
//  						✔ limit() short-circuits the stream
						
						.flatMap((i) -> {return Arrays.stream(i)})
//flatMap() transforms each element into a stream and then flattens all those streams into a single stream.						
						
						
						
						.forEach((f) -> System.out.println(f)); // Terminal operations  Consumer implementing
		
		
		
			System.out.println("******************************************");
			
			List.of("Abraham").stream()
			   .map((m) -> { return new StringBuffer(m).reverse().toString();})
			   .forEach((f) -> System.out.println(f));
		
			
		
		
		
	}
}

