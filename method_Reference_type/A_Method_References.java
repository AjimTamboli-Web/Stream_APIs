package stream_API.method_Reference_type;

import java.util.*;

public class A_Method_References {

	public static void main(String[] args) {
		
		
/*
 * A method reference is a shorthand (compact) way to write a lambda expression when the lambda just calls an existing method.	
 * 👉 It improves readability and makes code cleaner.
 * They were introduced in Java 8 to make lambda expressions shorter, cleaner, and more readable.
 * Method references use the double colon (::) operator and are mainly used with functional interfaces.	
 * 
 * Used only when a lambda expression calls a single existing method.
 *  
 * Why Method References Work in Streams?
 * =>> Streams use functional interfaces like: Predicate<T>, Consumer<T>, Supplier<T>, Function<T, R>
 *     Method references are automatically mapped to the abstract method of these interfaces.
 * 
 * Types of Method References 
 *  1. Reference to a Static Method
 *  2. Reference to an Instance Method of a Particular Object
 *  3. Reference to an Instance Method of an Arbitrary Object
 *  4. Reference to a Constructor
 *  
 *  
 */
		List<Integer> li = new ArrayList<>();
		 li.addAll(List.of(2,7,2,5,8,3,4,9,3,6,1,10));
		
		 li.stream()
		 // Lambda
//		 .forEach((i) -> {System.out.println(i);});
		 
		 // Method Reference
		 .forEach(System.out::println);
		
		 
		 // Syntax ->>  ClassName::methodName     - static method
		 //         objectReference::methodName   - instance method
		 //             ClassName::new            - constructor
	}

}
