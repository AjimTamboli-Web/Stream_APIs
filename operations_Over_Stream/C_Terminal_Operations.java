package stream_API.operations_Over_Stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collector;

public class C_Terminal_Operations {

	public static void main(String[] args) {
		
//		 ⭕ count() - Returns the count of elements in the stream.
		// It returns the count of elements in this stream. This is a special case of a reduction.
//		⭕ reduce() - used to combine all elements of a stream into a single result.
//	👉 It repeatedly applies a binary operation to accumulate values.   Convert many elements → one value
//        reduce():  The reduce method takes a BinaryOperator as a parameter.
//		⭕ noneMatch() -  Returns true if no elements of the Stream match the given predicate.
		
		System.out.println(
		List.of(3,6,58,9,2,9,54,1,75,2)
		.stream()
		
//		.max((i,j) -> (Integer.compare(i, j)))         // max value return in a Optional [ ]
		.min((i,j) -> {return Integer.compare(i, j);}) // min value return in a Optional [ ]
		
		
//		.reduce(1,(i,j) -> {return i*j;})   // using identity()
//		.reduce(0,(i,j) -> {return i+j;})   // using identity()
//		.reduce((i, j) -> {return i+j;})    // using Optional
		
//		.anyMatch((a) -> {return a < 10;})
//		.allMatch((i) -> {return i > 7;})
//		.noneMatch((i) -> {return i > 8;})
		
//		.count() // return long value Returns the count of elements in the stream.
				);
		
		
		Collector<Integer, List<Integer>, List<Integer>> evenCollector =
			    Collector.of(
			        ArrayList::new,        // supplier
			        (list, e) -> {          // accumulator
			            if (e % 2 == 0) list.add(e);
			        },
			        (l1, l2) -> {           // combiner
			            l1.addAll(l2);
			            return l1;
			        }
			    );
		
		Collector<Integer, List<Integer>, List<Integer>> oddCollector = 
				Collector.of(
					LinkedList::new, 	   // supplier
					(li, str	) -> {			 // accumulator
						if (str % 2 == 1) li.add(str);
					},
					(l1,l2) -> { 			// combiner
						l1.addAll(l2);
						return l1;
					}
					);
				
		
		List<Integer> numbers = List.of(32,77,46,91,64,37,28,59);
		
		List<Integer> evens =
			    numbers.stream().collect(evenCollector);
		List<Integer> odds = 
				numbers.stream().collect(oddCollector);
		
		System.out.println("List:: " + numbers);
		System.out.println("Evens:: " + evens);
		System.out.println("Odds:: " + odds);
	}

}
