package stream_API.method_Reference_type;

import java.util.List;
import java.util.function.Function;


public class B_Ref_Static_Method {

	public static void main(String[] args) {
	
/*
 * A method reference is a short-hand way to refer to a method without calling it.
 * Think of it as:   “Hey JVM, use that method wherever a lambda is expected.”
 * A static method reference refers to a static method of a class.
 * 
 *  Why Static Method Reference Works ??
 *  Because static methods do NOT need an object, and
	functional interfaces only care about method signature, not method name.
 * Rule (VERY IMPORTANT ⚠️) =>>  The method signature must match the functional interface method	
 * 	
 * Method Reference is NOT a Method Call ❌
 * 
 * Where Static Method Reference is Best Used =>
 * ✔ Stream pipelines	✔ Utility methods	✔ Comparators	✔ Validation logic	✔ Mapping / filtering operations
 * 
 * Static method reference is a shorthand for a lambda expression that calls a static method whose signature
 * 	 matches the functional interface method.
 */
	
	// Using Lambda 	
		Function<String,Integer> f = (s) -> {return Integer.parseInt(s);};
		 System.out.println(f.apply("26"));
		
	// Using Static method reference 
		Function<String,Integer> re = Integer::parseInt;  // return int (auto-boxed)
		System.out.println(re.apply("78"));    
//		✔ Same behavior     	✔ Cleaner   		✔ More readable
		
// *******************************************************************************************		
		
//		Example: Convert String list to Integer list	
		
		List<String> str = List.of("21","32","65","3");
		
		List<Integer> num =		str.stream()
									.map(Integer::parseInt)
									.toList();
		System.out.println(num);
// ******************************************************************************************		
		
		 int a =     // for reduce()

		List.of(3,2,1,34,456,76,235,76) .stream()
		
		.filter(Ref_Stac::com)
		.map(Ref_Stac::adi)
//		.peek((i) -> {System.out.println(i);})
		.reduce(0,Ref_Stac::red)
//		.forEach(Ref_Stac::add);
		
//		.forEach((i) -> {System.out.println(i);});
		
		; // int a  closed

		 System.out.println(a);
	}
}

class Ref_Stac  {   // Custom Static Method

	public static void add(int a) {     // Consumer
		System.out.println(a);
	}
	
	public static int adi(int a) {       // Function
		return a*2;
	}
	
	public static boolean com(int a) {    // Predicate
		return a%2 ==0;
	}
	
	public static int red(int a, int b) {    // BinaryOperator
		return a+b;
	}
	
}