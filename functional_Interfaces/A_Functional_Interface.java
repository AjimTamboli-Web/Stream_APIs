package stream_API.functional_Interfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class A_Functional_Interface {

	public static void main(String[] args) {

/*
 * A functional interface in Java is an interface that has only one abstract method, making it suitable for 
    use with lambda expressions and method references (introduced in Java 8).		
 * A functional interface can also extend another functional interface.
 * Before Java 8, developers had to use anonymous inner classes to provide interface implementations. 
 * Types of functional interface: Function, Consumer, Predicate, Supplier
 * Java 8 introduced four main functional interface types under the package java.util.function. 
   These are widely used in Stream API, collections and lambda-based operations.
 * ✔ It can have:
	any number of default methods
	any number of static methods
	methods from Object class (toString, equals, hashCode)
 * ✔ It cannot have more than one abstract method
 * 👉 Functional Interface is the foundation of Lambda Expression
 * Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
 * 
 * 1> Predicate<T> =>boolean Test(T t) => boolean
 * 2> Consumer<T> =>void Accept(T t) => Void
 * 3> Supplier<T> =>T Get() => T
 * 4> Function<T,R> => T Apply(R r) => R
 * 
 */
		
		i_adding<Integer> add = new i_adding<>() {  // custom interface

			@Override
			public Integer add(Integer a,Integer b) {
				     int d =   a+b;
				return d;
			}	              // before java 8 uses anonymous class
		};
		System.out.println("Using anonymous class " + add.add(32, 90));
//***************************************************************************************************
		i_adding<Integer> add2 = (y,e) -> {
			   int r = y + e;
			return r;            // after java 8 introduce Lambda  / 🔥 Clean, short, readable
		};                  
		System.out.println("Using Lambda: " + add2.add(23, 89));
//***************************************************************************************************
		// even no find out
		Predicate<Integer> prep = (y) -> {   // Predicate is functional interface
			return y%2==0;
		};
		System.out.println("***Using Predicate Functional Interface :::");
	    System.out.println("No is even? "+prep.test(42));
//***************************************************************************************************
	     // odd no find out
	    Consumer<Integer> cons = (v) -> {   // Consumer is functional interface
	    		boolean k = v % 2 == 1;
	    		System.out.println("No is Odd? " + k);
	    };
	    System.out.println("***Using Consumer Functional Interface :::");
	    cons.accept(23);
//***************************************************************************************************
		// generate OTP (random)
	    Supplier<Integer> sup = () -> {    // Supplier is functional interface
			return (int)(Math.random()*10000);
		};
		System.out.println("***Using Supplier Functional Interface :::");
		System.out.println(sup.get());
//***************************************************************************************************
		
		Function<String,Integer> fun = (i) -> {
			return i.length();
		};
		System.out.println("***Using Functional Inteface ::: ");
		System.out.println(fun.apply("Fast and Furious"));
		
		
	}

}

@FunctionalInterface
interface i_adding<T> {   // this is a functional interface
	T add(T o,T u);   // only one abstract method
}


