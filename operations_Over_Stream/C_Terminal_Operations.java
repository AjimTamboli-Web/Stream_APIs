package stream_API.operations_Over_Stream;

import java.util.List;

public class C_Terminal_Operations {

	public static void main(String[] args) {
		
//		 ⭕ count() - Returns the count of elements in the stream.
		// It returns the count of elements in this stream. This is a special case of a reduction.
		
		System.out.println(
		List.of(3,6,58,9,2,9,54,1,75)
		.stream()
		
//		.anyMatch((a) -> {return a < 10;})
		
		
//		.allMatch((i) -> {return i > 7;})
		
		
		
		.count() // return long value Returns the count of elements in the stream.
				);
	}

}
