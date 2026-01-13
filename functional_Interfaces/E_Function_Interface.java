package stream_API.functional_Interfaces;

import java.util.function.Function;

public class E_Function_Interface {

	public static void main(String[] args) {
	
/*
 * Function<T, R> represents a function that:  ➡ Takes one input (T)   ➡ Returns one output (R)
 *  R apply(T t);   ✔ Input is mandatory  ✔ Output is mandatory   ✔ Used heavily in Stream API
 * Function: Represents a function that accepts one argument and produces a result.
 * ⭕ T: denotes the type of the input argument
   ⭕ R: denotes the return type of the function 
 * Methods in Function Interface:
        Java allows combining multiple functions.   
    1) apply() -  R apply(T t)
	2) andThen() - default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
	    // ➡ Executes current function first, then the next.
	3) compose() - default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
	   //  ➡ Executes given function first, then current.
	4) identity() - static <T> Function<T, T> identity()
	   //  Returns a function that returns the same value.
 * 
 */
		
		// public interface Function<T, R> 
		Function<Integer,String> fun = (u) -> {
			String f =  u.toString();
			StringBuffer sb = new StringBuffer(f);
			String r = sb.reverse().toString();
			System.out.println("2nd Reverse it : " + r);
			return r;
		};

		System.out.println(fun.apply(3235));
		
		Function<String,Integer> fun2 = (o) -> {
			int a =  o.length() * 1234;
			System.out.println("1st Generate no: " + a);
			return a;
		};
	   	System.out.println(fun2.apply("Hello"));
   //*******************************************************************************
	   	
	   	Function<String,String> fun3 = fun.compose(fun2);
	   	System.out.println(fun3.apply("Welcome TO")); // at the same time it generate no and reverse it
	   	
   //*********************************************************************************
	   	
	   	Function<Integer,Integer> fun4 = (a) -> {
	   		int d = a/2;
	   		System.out.println("half Number " + d);
	   		return d;
	   	};
	   	Function<Integer,Integer> fun5 = (f) -> {
	   		int d = f*2;
	   		System.out.println("Double number " + d);
	   		return d;
	   	};
	   	
	   	Function<Integer,Integer> andThenMethod = fun4.andThen(fun5);
	   	
	   	System.out.println("Your No: " + andThenMethod.apply(453));
	   	
	   	
	   	
	   	
	}

}
