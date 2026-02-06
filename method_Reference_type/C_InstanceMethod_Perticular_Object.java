package stream_API.method_Reference_type;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class C_InstanceMethod_Perticular_Object {

	public static void main(String[] args) {
		
/*
 * 👉 (a.k.a. Bound Method Reference)
 * “Use this specific object’s instance method as the implementation of a functional interface."
 * ⚠️ IMPORTANT
	The object is already known (fixed / bound).
	
 * This type of method reference refers to an instance method of a specific object.	
 * The object is already created, and its method is referenced directly.
 * ⏺️Uses an existing object   ⏺️Method must be non-static    ⏺️Suitable for object-specific operations
 * 	
 * Syntax:	objectReference::instanceMethod
 * 
 * Why This Works (Core Matching Rule) 
 * The JVM matches the functional interface method to the instance method of the given object.
 * 
 * >> The object is NOT passed as a parameter	>> The object is already bound
 * 
 * JVM Internals (Deep Insight)
   >>Compiled using invokedynamic
   >>Method reference converted to a method handle
   >>Object reference stored in the lambda instance
   >>JIT optimizes it to near-direct call
	👉 Performance ≈ Lambda ≈ Direct call
 *
 *  Object is fixed, method is fixed, only data comes later
 *	
 */
		
		Perticular_obj per = new Perticular_obj();
		
		per.pri("Hello");
		
		// Convert to Lambda
		Consumer<String> c = msg -> per.pri(msg); // When I get a String, call pri on object per
		
		// Convert lambda -> method reference
		//   Because the lambda only calls one method, you can shorten it to:
		
		Consumer<String> cc = per::pri; //That’s all a reference to an instance method of a particular object is.
		
		
		OrderService os = new OrderService();
		
		Predicate<Integer> pre = os::process;
		System.out.println(pre.test(23));
		System.out.println(pre.test(-23));
		
	}

}
class Perticular_obj{
	
	public void pri(String a) {
		System.out.println(a);
	}
	
}

class OrderService{
	
	boolean process(int OrderId) {
		return OrderId > 0;
	}
}

