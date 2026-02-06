package stream_API.method_Reference_type;

import java.util.List;

public class E_Constructor_Reference {

	public static void main(String[] args) {

/*
 * A constructor reference is used to create a new object using a functional interface. 
 * It replaces a lambda expression that calls a constructor.
 * ⏺️Uses new keyword    ⏺️Commonly used with Supplier, Function     ⏺️Helps in object creation logic
 * 		
 * Syntax:	 ClassName :: new
 * 
 * ⚠️ new here is not a keyword call, it’s part of method-reference syntax.
 * 👉 Compiler chooses constructor based on functional interface signature.
 * 
 * Constructor reference is a method reference that creates a new object when the functional interface method is invoked.
 * 
 * 
 */
		
	 i_em one = (id,nam,sal) -> { return new Emp(id,nam,sal);  };  // implement interface with lambda
	 i_em two = (id,nam,sal) -> new Emp(id,nam,sal);       // with lambda direct mention(default return)
	 i_em three = Emp::new;       // Constructor reference
	 
		 one.get(54, "Jckog:",434.75	);  // all the same when executed
		 two.get(23, "Jogn", 43.65);
		 three.get(89, "Frank", 789.89);
	
		List.of("Hendry","Dom","Franck","Karl")  // reverse the string using Constructor reference
		.stream()
		.map(StringBuffer::new)   // StringBuffer have constructor that take String parameter
		.map(StringBuffer::reverse) // arbitrary object method reference
		.map(StringBuffer::toString) // arbitrary object method reference
		.forEach(System.out::println);
		 
		
	}

}

class Emp{
	int id;   String name;   double salary;
	Emp(int i,String n,double sal){
		this.id = i;
		this.name = n;
		this.salary = sal;
	}
}

interface i_em {
	public Emp get(int i,String n,double sa);
}

class Demo implements i_em{  // to implement interface (old way)
	@Override
	public Emp get(int i, String n, double sa) {
		Emp em = new Emp(i,n,sa);
		return em;
	}
	
}