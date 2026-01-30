package stream_API.operations_Over_Stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class D_Collect_in_Collector_stream {

	public static void main(String[] args) {

/*
 * 👉 collect() is a terminal operation
 * 👉 It converts a Stream into something useful (List, Set, Map, String, summary, etc.)
 *    Stream → collect() → Final Result
 *    
 *  Ex::  List<Integer> list = numbers.stream()
                            .collect(Collectors.toList());   
 * 		
 * Without collect(): ⭕ Stream is lazy		⭕ No result
 * With collect():	 ⭕ Stream executes		⭕ Data is stored / combined
 * 
 * A Collector tells collect():		1> How to collect
									2> Where to collect
									3> How to combine results (parallel streams)
 * 
 *  Technically::>>    collect(Collector<? super T, A, R>)
 * 				⭕ T -> Stream element type  ⭕ A -> Temporary container  ⭕ R -> Final result
 * 
 *  
 *  Every Collector has 4 steps 👇
 *  🔹 1. Supplier – Create container 		 ==>>  () -> new ArrayList<>()
 *  🔹 2. Accumulator – Add element	  			==>>  (list, item) -> list.add(item)
 *  🔹 3. Combiner – Merge containers (parallel) ==>> (list1, list2) -> list1.addAll(list2)
 *  🔹 4. Finisher – Final transformation 	==>>   list -> list
 *  👉 Collectors.toList() does all this for you.
 *  
 *  ⏺️ toList() =>> ✔ Allows duplicates		 ✔ Maintains order
 *  ⏺️ toSet()  =>> ✔ Removes duplicates	 ❌ No guaranteed order
 *  ⏺️ toMap()  =>> ⚠️ Duplicate keys? → Exception, ✅ Safe version: (oldVal, newVal) -> oldVal
 *  
 *  collect() = “Give me a container + rules, I’ll put stream data into it”
 */
		
	Set<Integer> li =	List.of(34,65,86,24,14,76,44,87,82,28,34,65)
						.stream()
//						.filter((i) -> (i%2==0))   // check line no 74
						
//						.collect(Collectors.toSet()); // by default it implement HashSet
						.collect(new Link_Custom());   // this custom will provide the LinkedHashSet
	
		System.out.println("Custom:" + li);
		
		
		// advance level concept in collector
		
		Collector<Integer, List<Integer>, List<Integer>> evenCollector =
			    Collector.of(
			        ArrayList::new,        // supplier
			        (list, e) -> {          // accumulator
			            if (e % 2 == 0) list.add(e);
			        },
			        (l1, l2) -> {           // combiner
			            l1.addAll(l2);
			            return l1;
			        }
			    );
		
	List<Integer> num = List.of(32,86,53,67,16,75);
	List<Integer> custom_col =num.stream()
			.collect(evenCollector);
	
		System.out.println("Even:: " + custom_col);

	}

}

class Link_Custom implements Collector<Integer,Set<Integer>,Set<Integer>>{

	@Override             // create the container for hold the returning a Set<Integer> 
	public Supplier<Set<Integer>> supplier() { 
//			return () -> {return new LinkedHashSet<Integer>();}; // using lambda expression
		return LinkedHashSet::new;       // using constructor method reference
	}

	@Override
	public BiConsumer<Set<Integer>, Integer> accumulator() {
	    return (t,u) -> {
	    	if(u%2==0) {   // filter use here
	    		t.add(u);    		
	    	}};
	}

	@Override
	public BinaryOperator<Set<Integer>> combiner() {  // use if you have two set when 2 thread run that time it add one data into another
		return (i,j) -> {                              
			i.addAll(j);
			return i;
		};
	
	}

	@Override  // ⬇️ accumulator      ⬇️ return type
	public Function<Set<Integer>, Set<Integer>> finisher() {   // same type data there is no need to change the type or data
//		return Function.identity();                          
		return (t) -> { return t;}; // both are same
	}

	@Override
	public Set<Characteristics> characteristics() {  // return a set
		return new HashSet<Collector.Characteristics>();
	}
	
}