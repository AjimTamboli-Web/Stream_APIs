package stream_API.operations_Over_Stream;

import java.util.List;

public class C_Terminal_Operations {

	public static void main(String[] args) {
		
		System.out.println(
		List.of(3,6,58,9,2,9,54,1,75)
		.stream()
		
		.anyMatch((a) -> {return a < 10;})
		
//		.allMatch((i) -> {return i > 7;})
		
				);
	}

}
