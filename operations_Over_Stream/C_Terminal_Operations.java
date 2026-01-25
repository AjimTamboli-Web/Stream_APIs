package stream_API.operations_Over_Stream;

import java.util.List;

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
		
//		.reduce(1,(i,j) -> {return i*j;})   // using identity()
//		.reduce(0,(i,j) -> {return i+j;})   // using identity()
//		.reduce((i, j) -> {return i+j;})    // using Optional
		
//		.anyMatch((a) -> {return a < 10;})
//		.allMatch((i) -> {return i > 7;})
//		.noneMatch((i) -> {return i > 8;})
		
		
		
		
//		.count() // return long value Returns the count of elements in the stream.
				);
	}

}
