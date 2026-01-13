package stream_API.functional_Interfaces;

import java.util.function.Supplier;

public class D_Supplier_interface {

	public static void main(String[] args) {

/*
 * A Supplier supplies (provides) a value without taking any input.
 * The Supplier Interface is a part of the java.util.function package which has been introduced since Java 8,
     to implement functional programming in Java. It represents a function which does not take in any 
     argument but produces a value of type T. 
 * Suppliers are useful when we don't need to supply any value and obtain a result at the same time.
 * The Supplier interface consists of only one function:  =>>   get()
 *  ⚠️ Why do we need Supplier?
 * Use Supplier when: ✔️ You want to generate values ✔️You want lazy creation ✔️You want to provide default values
    ✔️You don’t need input parameters  📌 Common use cases: Random number generation, Default object creation
 * 	
 */
		
		// Example like generate OTP 
		Supplier<Integer> sup = () -> {
			// Math.random() generates 0.0 to 0.9999
			return  (int)( Math.random() * 10000);
		};       // casting
			
		System.out.println(sup.get().intValue()); // ✔ Each call to get() produces a new value
		// only one method =>>   t get();    no default,static methods are available.
		
		
		// return a string
		Supplier<String> str = () -> {
			return "Hello World";
		};
		
		System.out.println(str.get());
		
		// return a Object(EmpSup)
		Supplier<EmpSup> esup = () -> {
			 return new EmpSup(1,"John",5000);
		};
		EmpSup r = esup.get();
		System.out.println(r);
		
	}

}

class EmpSup{
	int id;
	String name;
	double salary;
	
	EmpSup(int id,String name,double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return id+" " + name + " " + salary;
	}
}
