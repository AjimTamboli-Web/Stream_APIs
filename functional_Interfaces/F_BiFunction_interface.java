package stream_API.functional_Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;


public class F_BiFunction_interface {

	public static void main(String[] args) {
	
/* BiFunction<T,U,R>
 * It represents a function which takes in two arguments and produces a result. 👉 It takes TWO inputs and returns ONE output.
 * Hence this functional interface which takes in 3 parameters namely:-
 * 
 *  T   ->   First input      U   -> Second input       R     -> Return type
 * 	Syntax:     R apply(T t, U u)
 * 
 * >>  andThen(Function<? super R, ? extends V>) 👉 Used to transform the result of BiFunction.
 *                                                  ⚠️ andThen() runs after apply()
 *   Note: The function being passed as the argument should be of type Function and not BiFunction. 
 *   It isn't possible to add a BiFunction to an existing BiFunction using andThen().
 *   
 */
		
		BiFunction<String,String[],List<Integer>> bi = (i,j) -> {
			List<Integer> a = new ArrayList<>();
			a.add(i.length());
			a.add(j.length);
			return a;
		};
		
		System.out.println(bi.apply("Tom", new String[] {"ti","deo"}));
		
		BiFunction<List<Integer>,Integer,List<Integer>> bi2 = (i,j) -> {
			List<Integer> f = new ArrayList<>(); 
			for(int e : i) {
				int l=e*j;
				f.add(l);
			}	
			return f ;
		};

		System.out.println(bi2.apply(List.of(2,4,6), 5));
		
		BiFunction<Integer,Integer,Long> bi3 = (i,j) ->{
			Long k = (long) (i*j);
			return k;
		};
		
		// andThen 
		bi3 = bi3.andThen((e) -> (e+5));   // ⚠️ andThen() runs after apply()
		
		

		
		System.out.println( bi3.apply(8, 2));
		
	}

}
