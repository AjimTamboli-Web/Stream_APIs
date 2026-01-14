package stream_API.operations_Over_Stream;

import java.util.*;
import java.util.function.*;


public class A_Stream_API_Operations {

	public static void main(String[] args) {
	
/*
 * * There are two types of Operations in Streams:
      ⭕ 1️⃣ Intermediate Operations -  filter(), map(), flatMap(), sorted(), distinct(), limit(), skip().
      ⭕ 2️⃣ Terminal Operations  - forEach(), collect(), count(), reduce(), anyMatch(), allMatch(), findFirst().
 *          		
 */
	
		Set<Integer> set = new HashSet<>();
		
		set.add(33);   set.add(12);		set.add(89);
		set.add(26);   set.add(92);
		set.add(29);   set.add(7);       set.add(49);
		System.out.println(set);

		Consumer<Integer> con = (f) -> {   // create Consumer for provide reference forEach() function
			System.out.println(f);
		};
		
		Function<Integer,Integer> fun = (a) -> {  // create Function for map() function
			return a*a;
		};
		
		Predicate<Integer> pre = (d) -> {
			return d % 2 == 1;   // only odd number get pass
		};
		
		       set.stream()    // start the stream
		                   .map(fun)    // intermediate operation            square the no
		                   .filter(pre)  // intermediate operation           only odd number pass
		                   .forEach(con);  // terminal operation             print the no
		       
		                    // at least one terminal operation need
		
		// without terminal operation stream will not get started.
		
		/*
		 * 🔹 Stream Execution Flow (Very Important ⭐)
		 * 
				       stream
		 					→ intermediate
		 					→ intermediate
		 					→ terminal (EXECUTES EVERYTHING)
		 					
		 *  👉 Output shows lazy execution (element-by-element).
		  
		 */
		
		
	}

}
