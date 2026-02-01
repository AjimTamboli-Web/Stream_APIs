package stream_API.operations_Over_Stream;

import java.util.List;
import java.util.Optional;

public class F_Optional_class_overview {

	public static void main(String[] args)throws Exception {

/*
 * Optional<T> is a container object introduced in Java 8 that may or may not contain a non-null value.
 * 
 * 👉 Its main purpose: avoid NullPointerException and force you to handle the absence of a value explicitly.
 * Think of it as:	 “There might be a value, or there might be nothing — and I must deal with both cases.”
 * 
 * Creating Optional Objects
 * ⏺️ Optional.empty(): Returns an empty Optional.
   ⏺️ Optional.of(value): Returns an Optional containing the given non-null value.
   ⏺️ Optional.ofNullable(value): Returns an Optional describing the value if non-null, otherwise empty.
 * 
 * “Optional is a return-type construct, not a replacement for every null.”
 * 		
 * ✅ Use Optional as return type					❌ Don’t use Optional for fields, parameters, or serialization
 * ✅ Prefer map, ifPresent, orElseGet				❌ Don’t call get() blindly
 * 
 */
		
		String[] ob = new String[10];
//		System.out.println(ob[2].toLowerCase());  // program terminates abnormally and throws a NullPointerException.
		
		Optional<String> op2 = Optional.empty();  // Represents no value
		System.out.println(op2);
		
		Optional<String> op3 = Optional.of("Hello"); // Use only when value is guaranteed non-null
		System.out.println(op3);
		// ❌ If value is null → NullPointerException
		
		
		Optional<String> op = Optional.ofNullable(ob[2]); // Use when value may be null
		
		if(op.isPresent()) {
			String obj = ob[2].toLowerCase();
			System.out.println(obj);
		}
		else {
			System.out.println("ob is null");
		}

//**********************************************************************************************************************		

		System.out.println("<<<<<<<<< Operations in Optional classes >>>>>>>>");
		
//		Optional<String> opt = Optional.empty();
//		Optional<String> opt = Optional.of("Hello Java");
		Optional<String> opt = Optional.ofNullable("Hello Programmer");
		
// 🔹 get() ==>> 		
		if(opt.isPresent()) {              //	Checks if value exists   / ⚠️ Old style — avoid when possible
			System.out.println(opt.get()); // Returns value if present ❌ Throws NoSuchElementException if empty
		}		//			👉 Use carefully
		
		
// 🔹 ifPresent() ==>> 		// ✔ Best replacement for isPresent() + get()
		opt.ifPresent(v -> System.out.println("ifPresent(Consumer):: " + v));	// Executes logic only if value exists
		
// 🔹 or(Supplier<? extends Optional<? extends T>> supplier) ==>> “If this Optional is empty, give me another Optional.”
		Optional<String> sup = opt.or(() -> {return Optional.of("FallBack!! ");});   
		System.out.println("or(Supplier<Optiona<T>>):: "+ sup);
		
// 🔹 orElse()	==>>   // Returns value or default	
		String a = opt.orElse("default");  // ⚠️ Default is always evaluated
		System.out.println("orElse():: "+ a);
		
// 🔹 orElseGet() ==>>		Lazy default (preferred)
		String b = opt.orElseGet(() -> ("Default values"));
		System.out.println("orElseGet():: " + b); // ✔ Default evaluated only if Optional is empty
		
// 🔹 orElseThrow()	==>>  Throws exception if empty
		String c = opt.orElseThrow();   // NoSuchElementException: No value present
		System.out.println("orElseThrow():: " + c);
		
// 🔹 orElseThrow(supplier) ==>>  Throws exception if empty with supplier	(custom values pass)
		String d = opt.orElseThrow(() -> {return new RuntimeException("Values missing");});
		System.out.println("orElseThrow(Supplier):: " + d);
		
// 🔹 ifPresentOrElse(Consumer,Runnable) ==>>  ✔ Handles both cases cleanly   (Java 9+)		
		opt.ifPresentOrElse((i) -> System.out.println("ifPresentOrElse(Consumer,Runnable):: " + i),  // Consumer
						    () -> {System.out.println("Hello world");});                         // Runnable
		
//	🔹 filter(Predicate<? super T>)	==>> Keeps value only if condition passes
		Optional<String> e =  opt.filter((i) -> i.length() > 5);  // If condition fails → Optional.empty()
		System.out.println("filter(Predicate):: " + e);
		
//	🔹 map(Function<? super T, ? extends U>) ==>> Transforms value if present / If empty → remains empty
		Optional<String> upp = opt.map((i) -> (i.toUpperCase()));  // 📌 Use for simple transformations
		System.out.println("map(Function):: " + upp);
		
//	🔹 flatMap(Function<? super T, Optional<U>>) ==>> Used when mapper returns Optional  ✔ Prevents Optional<Optional<T>>
	   Optional<Integer> len =  opt.flatMap((f) -> (Optional.of(f.length())));    // 📌 Very common with nested objects
	   System.out.println("flatMap(Function<T,Optional U>):: " + len + " return length"); // 👉 Prevents Optional<Optional<T>>
		
	   System.out.println("isEmpty():: " + opt.isEmpty());
	   
	   System.out.println("isPresent():: " + opt.isPresent());
	  
// ***************************************************************************************************************************
	   System.out.println("************************************************************");
	   
	   List<Integer> li = List.of(43,65,76,24,56,82,13);
	   System.out.println("List " + li);
	   
	   Optional<Integer> max =li.stream()
	   .max((i,j) -> (Integer.compare(i, j)));
	   System.out.println("Maximum Value:: " + max.get());
	   
	   Optional<Integer> min = li.stream()
			   .min((i,j) -> (Integer.compare(i, j)));
	   System.out.println("Minimun Value:: " + min.get());
	   
	   
	}

}
