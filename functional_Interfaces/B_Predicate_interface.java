package stream_API.functional_Interfaces;

import java.util.List;
import java.util.function.Predicate;

public class B_Predicate_interface {

	public static void main(String[] args) {
		
/*
 * A Predicate is a functional interface that:
	⭕Takes one input
	⭕Applies a condition
	⭕Returns true or false
 * 👉 Predicate = boolean-valued function
 * 
 * Why Predicate is used ==>>> In Stream API, we often filter data.
 * ✔️ Predicate is used inside filter()    ✔️ It decides which elements stay and which are removed
 * Before Java 8:
		⭕ Conditions were written inside loops
		⭕ Logic tightly coupled with iteration
		⭕ Hard to reuse and combine
   Java 8 introduced:
		✔ Lambda
		✔ Functional interfaces
		✔ Stream API
	👉 Predicate separates condition logic from processing logic.	
 * 
 * Represents a predicate (boolean-valued function) of one argument.      boolean test(T t);	
 *  test()  ✔ Executes condition   ✔ Returns boolean
 *  default methods =>> and(), negate(), or()
 *  static methods =>> isEqual(),  not()
 *  
 *  Predicate is a functional interface representing a condition that takes one input and returns true 
 		or false, commonly used for filtering and validation in Java.
 */
		
	
		
		// Evaluates this predicate on the given argument.boolean test(T t)
		
		// no is even or odd
		Predicate<Integer> pre = (i) -> {
			return i%2 == 0;	 
		};
		
		System.out.println("No is even?: " + pre.test(43));
		
		// name is palindrome or not
		Predicate<String> pred = (j) -> {
			StringBuffer sb = new StringBuffer(j);
			String str = sb.reverse().toString();
			return j.equals(str);
		};
		
		System.out.println("Name is Palindrome? : " + pred.test("madam"));
		
		// no is prime or not
		Predicate<Integer> predic = (k) -> {
			boolean flag = true;
			for(int i=2;i<k;i++) {
				if(k%i==0) {
					flag = false;
				}
			}
			return flag;
		};
		
	    System.out.println("No is Prime? : " + predic.test(5));
		
		
 // 		and()  - Logical AND  =>> ✔ Second predicate runs only if first is true
	// Returns a composed predicate that represents a short-circuiting logical AND of this predicate and another
	    
		Predicate<Integer> predica = pre.and(predic);
		System.out.println("No is Prime and Even? " + predica.test(17));

//    negate() - Logical NOT   =>>  ✔ Reverses condition
	// Returns a predicate that represents the logical negation of this predicate.	
		
		Predicate<Integer> odd = pre.negate();
		System.out.println("Reverse the condition: " + odd.test(3));
		
//  or() - Logical OR   =>> ✔ Predicate not run when both is false otherwise true 
	//  Returns a composed predicate that represents a short-circuiting logical OR of this predicate and another
		
		Predicate<Integer> predicat = pre.or(predic);
		System.out.println("Any one condition is true : " + predicat.test(92));
		
// isEqual() - Static Method	  =>> ✔ Uses equals()   ✔ Null-safe
	//  Returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object)
		
		Predicate<Integer> pro = Predicate.isEqual(23);
		System.out.println("Is Equals check: " + pro.test(78));

		
		
		List<Integer> list = List.of(5, 10, 15, 20, 25, 30);
		
		Predicate<Integer> preli = (f) -> {
			return f > 10;
		};
		Predicate<Integer> divis = (a) -> {
			return a % 5 == 0;
		};
		
		Predicate<Integer> finalpre = preli.and(divis);
		
		list.stream()
				.filter(finalpre)
				.forEach(System.out::println);
		
		
	}

}










