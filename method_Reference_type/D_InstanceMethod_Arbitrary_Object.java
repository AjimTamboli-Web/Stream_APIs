package stream_API.method_Reference_type;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;


public class D_InstanceMethod_Arbitrary_Object {

	public static void main(String[] args) {
		
/*
 * Arbitrary object means == ANY object of a given type		
 * This method reference refers to an instance method of any object of a particular class. 
   The actual object is determined at runtime.
 *  		Uses class name instead of object
		Mostly used with Stream API
		Method is called on each element
 * 
 * What really happens internally?
   >>	When Java sees:-  	    String::length
   >>	It internally treats it like:-  (s) -> s.length()     ✔ s is the object ✔ length() is called on s
 * 
 * Class::method = “Call this method on whatever object is passed first”
 * In ClassName::method, the FIRST parameter becomes the OBJECT.
 * 
 * If the class name is on the left of ::, and the method is NOT static,
      then it is ALWAYS an instance method of an ARBITRARY object.
 *     
 */
		
//		For_pre fo = new For_pre();	=> this is particular object
		
		BiPredicate<For_pre,Integer> pre	= For_pre::eve;  // this is arbitrary object
		
		System.out.println(pre.test(new For_pre(), 2));
		
		Function<String,Integer> fu = String::length;
		System.out.println(fu.apply("hello"));
		
		BiFunction<For_pre,String,Integer> fun = For_pre::conv;
		System.out.println(fun.apply(new For_pre(), "Jogn:"));

	}

}
class For_pre{
	public boolean eve(int a) {
		return a % 2 == 0;
	}
	public int conv(String f) {
		return f.length();
	}
}
