package stream_API.functional_Interfaces;

import java.util.function.BinaryOperator;

public class F_BinaryOperator_interface {

	public static void main(String[] args) {
		
/*
 * This functional interface which takes in one generic namely:-   T apply(T t1, T t2);
	T: denotes the type of the input arguments and the return value of the operation	
 *  👉 It takes TWO inputs of the SAME type and
	👉 returns ONE output of the SAME type.
 * 	
 * public interface BinaryOperator<T> extends BiFunction<T,T,T> { }
 * 👉 BinaryOperator<T> = BiFunction<T,T,T>
 * 
 * In BinaryOperator only two method present and they will be static:: 	 Static Helper Methods 🔥
 * 1️⃣ BinaryOperator.maxBy(Comparator) 
  This methods return a BinaryOperator which returns the greater of the two elements based on a given comparator
 * 				****************
 * 2️⃣ BinaryOperator.minBy(Comparator)
  This method returns a BinaryOperator which returns the lesser of the two elements based on a given comparator
 * 
 * 🧠 These are heavily used in stream reduction.
 * 
 * The BinaryOperator<T> extends the BiFunction<T, T, T> type.
 *                   So it inherits the following methods from the BiFunction Interface:
      apply(T t, T u)
      andThen(Function<? super R, ? extends V> after)
 * 
 * reduce() lives here 🔥
 * 
 * 
 */

		BinaryOperator<Integer> bi = (i,j) -> (i + j);
		
		System.out.println(bi.apply(4, 8));
		
		// finding Max
		BinaryOperator<Integer> biop = BinaryOperator.maxBy((i,j) -> {return i.compareTo(j);	});
		
		// or you can use this type hard code way   using ternary operation
		BinaryOperator<Integer> op = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 :-1));
		
		System.out.println("Max: " + biop.apply(32, 89));
		System.out.println("Max: " + op.apply(56, 9));
		
		// finding Min
		BinaryOperator<Integer> biop2 = BinaryOperator.minBy((i,j) -> {return i.compareTo(j); });
		
		// both way to find minimum value
		BinaryOperator<Integer> op2 = BinaryOperator.minBy((a,b) -> (a > b) ? 1 :((a==b) ? 0 : -1));
		
		System.out.println("Min: " + biop2.apply(32, 67));
		System.out.println("Max: " + op2.apply(53, 24));
	}

}
