package stream_API.functional_Interfaces;

import java.util.function.Predicate;

public class Predicate_interface {

	public static void main(String[] args) {
		
/*
 * 
 * 	
 */
		
	//Represents a predicate (boolean-valued function) of one argument.      boolean test(T t);	
		// test()  ✔ Executes condition   ✔ Returns boolean
		
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
		
		Predicate<Integer> predica = pre.and(predic);
		System.out.println("No is Prime and Even? " + predica.test(17));

//    negate() - Logical NOT   =>>  ✔ Reverses condition
		Predicate<Integer> odd = pre.negate();
		System.out.println("Reverse the condition: " + odd.test(3));
		
//  or() - Logical OR   =>> ✔ Predicate not run when both is false otherwise true 
		
		Predicate<Integer> predicat = pre.or(predic);
		System.out.println("Any one condition is true : " + predicat.test(92));
		
// isEqual() - Static Method	  =>> ✔ Uses equals()   ✔ Null-safe
		
		Predicate<Integer> pro = Predicate.isEqual(23);
		System.out.println("Is Equals check: " + pro.test(78));
		
		
	}

}










