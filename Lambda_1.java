package stream_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda_1 {

	public static void main(String[] args) {

/* A lambda expression is a short way to write an anonymous function (a function without a name).
 * It is mainly used to implement Functional Interfaces (interfaces with only one abstract method).
 * 
 * ⏺️ Java lambda expressions >>> 
 * introduced in Java 8, allow developers to write concise, functional-style code by representing anonymous functions.
 * They enable passing code as parameters or assigning it to variables, resulting in cleaner and more readable programs.
 * ⭕ Lambda expressions implement a functional interface (An interface with only one abstract function)
 * ⭕ Enable passing code as data (method arguments).
 * ⭕ Allow defining behavior without creating separate classes.
 *                                                                  
 * ⚠️  Why Use Lambda Expressions?
 *  ⭕ Concise Code: Reduce boilerplate compared to anonymous classes.
	⭕ Functional Programming: Treat functions as first-class citizens.
	⭕ Improved Readability: Code is easier to read and maintain.
	⭕ Enhanced Collections and Streams: Simplify operations like filtering, mapping, and iterating.
 * Java lambda expression is treated as a function, so the compiler does not create a .class file.
 * 	syntax:  (argument-list) -> {body}  ⭕ 1. Argument-list: It can be empty or non-empty as well.
 * 										⭕ 2. Arrow-token: It is used to link the arguments list and body of expression.	
 * 										⭕ 3. Body: It contains expressions and statements for lambda expression.
 * 
 */

		Lamb<Integer> oldWays = new Imple();   // first way using concrete class
		int old =  oldWays.addi(32, 43);
		System.out.println("implementing with class: " + old);
		
		System.out.println("*********************************************************************");
		
		Lamb<Integer> anony = new Lamb<>() {      // second way anonymous class
			public Integer addi(Integer i,Integer j) {
				return i + j;
			}
		};
		
		int anonymous = anony.addi(32, 43);
		System.out.println("implementing with anonymous class:" + anonymous);
		
		System.out.println("*********************************************************************");
		
		Lamb<Integer> lambda_ex = (i,j) -> {      // third way Lambda expression / Anonymous function
			return i + j;
		};
		
		int bda = lambda_ex.addi(32, 43);
		System.out.println("Using Lambda Expression: " +bda);
		
		System.out.println("*********************************************************************");
	
//*****************************************************************************************
		// some logical program using Lambda
		
		List<Integer> list = Arrays.asList(32,43,68,18,71,852,87,27,65);
		
		System.out.println("List Elements: ");
		list.forEach((n) -> System.out.println(n));
// The forEach() method internally uses the Consumer<T> functional interface, which takes one argument and performs an action.
		
		System.out.println("Even Elements: ");
		list.forEach((ev) -> {
			if(ev % 2 == 0) {
				System.out.println(ev);
			}
		});
		
		System.out.println("Odd number: ");
		list.forEach(odd -> {
			if(odd % 2 == 1) {
				System.out.println(odd);
			}
		});
		
	}
}

@FunctionalInterface
interface Lamb<T>{     // three ways to implementing this interface 1.> implement with concrete class
	T addi(T i,T j);   //  2.> using anonymous class direct in main class  3.> using Lambda Expression  
}

class Imple implements Lamb<Integer>{    // concrete class

	@Override
	public Integer addi(Integer i, Integer j) {
		int sum = i + j;
		return sum;
	}
	
}


