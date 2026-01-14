package stream_API;

import java.util.*;
import java.util.function.*;

public class Stream_API_Intro {

	public static void main(String[] args) {

/**
 * Stream =>> ⭕ Stream was introduced in Java 8,the Stream API is used to process collections of objects.
              ⭕ A stream in Java is a sequence of objects that supports various methods that can be pipelined
                to produce the desired result.
 *            ⭕ Stream API is used to process collections of data in a functional style (filtering, mapping, 
                sorting, reducing) without modifying the original data source.
 * ⏺️ Use of Stream in Java 	::
 	          ⭕ Stream API is a way to express and process collections of objects.
 	          ⭕ Enable us to perform operations like filtering, mapping, reducing and sorting.
   		      ⭕ It works on:  Collection (List, Set), Arrays, I/O channels (advanced)
 * ⚠️ Features :: 
              ⭕ Does NOT modify original data, Streams are immutable. ✅ Original list remains unchanged. 
              ⭕ No storage - A Stream is not a data structure; it just takes input from Collections, Arrays or I/O channels.
              ⭕ Streams do not modify the original data; they only produce results using their methods.
              ⭕ Intermediate operations (filter, map, etc.) are lazy and return another Stream, so you can chain them together.
              ⭕ A terminal operation (like collect, forEach, count) ends the stream and gives the final result. 
              ⭕ Lazy evaluation - Intermediate operations execute only when a terminal operation is called.
              ⭕ Pipeline processing - Stream operations work as a pipeline. (Source → Intermediate → Terminal)
 * ⏺️ Advantages of Stream API : 
   		            ✔ Less boilerplate code      ✔ Readable & expressive
                    ✔ Easy parallelism	          ✔ Safer (no concurrent modification)
                    ✔ Functional programming support
 * Stream API allows functional-style, lazy, and pipeline-based processing of data from collections without 
                      modifying the original source. 
  >> Stream API has two main types: Sequential Stream (single-threaded) and Parallel Stream (multi-threaded).                   
 * There are two types of Operations in Streams:
      ⭕ 1️⃣ Intermediate Operations -  filter(), map(), flatMap(), sorted(), distinct(), limit(), skip().
      ⭕ 2️⃣ Terminal Operations  - forEach(), collect(), count(), reduce(), anyMatch(), allMatch(), findFirst().
 */
		
		List<String> list = new ArrayList<>();
		list.add("John");   list.add("Dany");  list.add("Arya");  list.add("Robert");
		list.add("Cercie"); list.add("Margreat");  list.add("Julie");
		
		System.out.println(list);
		
		Predicate<String> pre = (i) -> {
			return i.startsWith("J");
		};
		
		Consumer<String> con = (j) -> {
			System.out.println(j);
		};
		
		list.stream()
				.filter(pre)
				.forEach(con);
		
		System.out.println(list);
		
		Function<String,StringBuffer> fun = (s) -> {
			return new StringBuffer(s).reverse();
		};
		Consumer<StringBuffer> con2 = (c) -> {
			System.out.println(c);
		};
		
		
		list.stream()
				.map(fun)
				.forEach(con2)
				;
		
		System.out.println(list);
		
		
		
		
		

	}

}
