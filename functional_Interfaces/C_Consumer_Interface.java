package stream_API.functional_Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class C_Consumer_Interface {

	public static void main(String[] args) {

/* 
 *Consumer<T> is a functional interface present in 📦 java.util.function,takes one input and returns nothing.
 * The Consumer Interface is a part of the java.util.function package which has been introduced since Java 8,
    to implement functional programming in Java. It represents a function which takes in one argument and
    produces a result. However these kind of functions don't return any value. 
 * ⭕  void accept(T t);   This method takes in one parameter,This method does not return any value.
 * This method accepts one value and performs the operation on the given argument.
 * ⭕  default method:  default Consumer <T> andThen (Consumer<? super T> after) ✔ Used to chain Consumers.
 *  It returns a composed Consumer wherein the parameterized Consumer will be executed after the first one.
 *  If evaluation of either function throws an error, it is relayed to the caller of the composed operation.
 *  ⚠ If first Consumer throws exception → second will NOT execute
 *  The function being passed as the argument should be of type Consumer.
 *  This method throws NullPointerException if the after operation is null.
 *  
 *  ⚠️  Why Consumer Exists?
 *  Before Java 8:   for(Integer i : list) {  System.out.println(i); }
 *  After Java 8:   list.forEach(i -> System.out.println(i));
     Here, forEach() internally uses Consumer.
 * Predefined Consumer Types=>> Interface  : Consumer<T>, IntConsumer, LongConsumer, DoubleConsumer 
 *                                         ✔ Avoids boxing/unboxing
 *  ✔ Consumer is perfect for mutating objects
 */
		
		
		// List<List<Integer>> = [[43,75],[76,83]] do addition in 2d list
		
         List<Integer> li1 = List.of(32,64);
         List<Integer> li2 = List.of(73,14);
         List<List<Integer>> li3 = List.of(li1,li2);
         
         System.out.println(li3);  // 2D list
         
         Cons_two add = new Cons_two();
         add.accept(li3);
//************************************************************************************************		
         System.out.println("Only Default method andThen() ");
         
        Consumer<Integer> co1 = (i) -> {
        	   System.out.println(i * 5);
        };
         
        Consumer<Integer> co2 = (i) -> {
        	System.out.println(i * 10);
        };
            
        // it do operation on both functions and show output on both
        Consumer<Integer> comparedBoth = co1.andThen(co2);
        comparedBoth.accept(5);
        
//************************************************************************************************		
       
       // add list and do operation on it   
        
        Consumer<List<Integer>> some = (doIt) -> {
        	   for(int i =0; i<doIt.size();i++) {
        		   doIt.set(i, 2*(doIt.get(i)));
        	   }
        	   System.out.println(doIt);
        };
        
        List<Integer> liInt = new ArrayList<>();
        liInt.add(3);
        liInt.add(8);
        liInt.add(2);
       
        some.accept(liInt);
        
        // To demonstrate when NullPointerException is returned.
        try{
        	 // using addThen()
        	   some.andThen(null).accept(liInt);
        }
        catch(Exception e) {
        	System.out.println("Exception:: " + e);
        }
        
        
        
        
	}
}



class Cons_one implements Consumer<List<Integer>>{

	int sum = 0;
	@Override
	public void accept(List<Integer> t) {
		for(Integer f : t) {
			sum += f;
			System.out.println("&"+f);
		}
		System.out.println(sum);
	}
	public int sumo() {
		return this.sum;
	}
}

class Cons_two implements Consumer<List<List<Integer>>>{

	@Override
	public void accept(List<List<Integer>> t) {
		List<Integer> neww = new ArrayList<Integer>();
		for(List<Integer> l : t) {
			Cons_one one = new Cons_one();
			one.accept(l);
			neww.add(one.sumo());
			System.out.println("^" + l);
		}
		System.out.println("Final addition: ");
		Cons_one two = new Cons_one();
		two.accept(neww);
		
	
	}
	
}