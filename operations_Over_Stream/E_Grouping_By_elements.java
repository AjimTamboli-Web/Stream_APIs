package stream_API.operations_Over_Stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class E_Grouping_By_elements {

	public static void main(String[] args) {
		
		List<String> li = List.of("Jerry","Tom","Cat","Benny","Jennifer","Leonar","Li","Alan");
		
	Map<Integer,String> map =	li.stream()
//	    .collect(Collectors.toMap((i)  -> {return i.length();},(j) -> {return j;})); // <- if you have same key don't use it gives u exception
             // to avoid duplicate key exception use mergeFunction in toMap overload to resolve collisions between values associated with the same key
			// 								keyMapper			 valueMapper		      mergeFunction	
//		.collect(Collectors.toMap((i) -> {return i.length();}, (j) -> {return j;},(first,second) -> {return second;}));		
			
		.collect(Collectors.toMap((i) -> {return i.length();},     // function  <T>
								  (j) -> {return j.toLowerCase();}, // function <K>
								  (k,l) -> {return l;},              // mergeFunction <U>
								   () -> {return new LinkedHashMap<>();}));  // supplier <M> ->  a supplier providing a new empty Map into which the 
																			//					 results will be inserted

	System.out.println(map);	

System.out.println("************************************************************************");	
	// if you do not want to replace or update value, you want all values in key set also value set in one list you use groupingBy operation
	
	Map<Integer,List<String>> ma =	li.stream()
		.collect(Collectors.groupingBy((i) -> {return i.length();}));
    System.out.println("Group by length:: " + ma);
	
	// if you want grouping by particular character 
	Map<Character,List<String>> map2 =	li.stream()
			.collect(Collectors.groupingBy((i) -> {return i.charAt(0);}));
	System.out.println("Group by alphabets:: "+map2);
		
//	Set<Map.Entry<Character, List<String>>> lo = map2.entrySet();
	 
	for(Map.Entry<Character, List<String>> fo:map2.entrySet()) {
		
	   fo.getValue().stream()
	   .filter((i) -> {return i.charAt(0)=='J';})
	   .forEach(System.out::println);
		
		if(fo.getKey() == 'a'|| fo.getKey() == 'A') {
			System.out.println("Start with : " + fo);
		}
	}
	
	}

}
