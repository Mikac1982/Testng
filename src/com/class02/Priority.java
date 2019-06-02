package com.class02;

import org.testng.annotations.Test;

public class Priority {

	//if we do not specify priority, by default it's zero
	@Test()  
	public void first() {
		System.out.println("first test annatation");
	}
	
	//if there are more test with no parameters, they execute by alphabetic order
	@Test()
	public void second() {
		System.out.println("second test annatation");
	}
	
	@Test(priority=2)
	public void third() {
		System.out.println("third test annatation");
	}
	
	@Test(priority=3)
	public void fourth() {
		System.out.println("fourth test annatation");
	}
	
	
	
	
	
	
	
	
	
	
}
