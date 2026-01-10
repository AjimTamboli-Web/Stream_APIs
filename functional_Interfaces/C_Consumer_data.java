package stream_API.functional_Interfaces;

import java.util.*;
import java.util.function.Consumer;

public class C_Consumer_data {

	public static void main(String[] args) {
		//  Object Modification
		
		Employee emp = new Employee(1,"Tom",32481.32);
		List<Employee> list = new ArrayList<>();
		list.add(emp);
		for(int i = 1; i < 10;i++) {
			Employee e = new Employee(i,"John",0);
			double ar = Math.random() * 1_000_00;
			double salary = Math.round(ar * 100.0) / 100.0;
			e.salary = salary;
			list.add(e);
		}
		
		System.out.println("Before Hike: ");
	    for(Employee l: list) {
	    	System.out.println(l);
	    }
	  System.out.println("************************************");  
	    
	  //✔ Consumer is perfect for mutating objects
	    Consumer<List<Employee>> con = (r) -> {
	    	  for(Employee a:r ) {
	    		  a.salary += 10000;
	    	  }
	    };
//	    con.accept(list);

//*********************************************************************
	    
	    Consumer<List<Employee>> con2 = (w) -> {
	    	for(Employee a:w) {
	    	    a.id += 100;
	    	}
	    };
	    
	    // id update and salary hike change at a time using andThen()
	    con.andThen(con2).accept(list);
	    
	    System.out.println("After changes using andThen() method::");
	    for(Employee f: list) {
	    	System.out.println(f);
	    }
	    
//********** TASK ***************************
	    
	   List<Integer> lii = new ArrayList<>();
	   lii.add(78);
	   lii.add(7);
	   lii.add(2);
	   lii.add(3);
	   lii.add(5);
	    
	   Consumer<List<Integer>> squar = (s) -> { 
		   for(Integer r:s) {
			  int a = r*r;
			  System.out.println(a);
		   }
	   };
	   
	   Consumer<List<Integer>> cub = (q) -> {
		   for(Integer f: q) {
			   int s = f*f*f;
			   System.out.println(s);
		   }
	   };
	    
	   squar.andThen(cub).accept(lii); 
	    
	    
	    
	}
}






class Employee {
	int id;
	String name;
	double salary;
	
	Employee(int id,String name,double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return this.id + " " + this.name + " " + this.salary;
	}
}
