package com.class02_;

import org.testng.annotations.Test;

public class Priority {

	
	@Test
	public void first() {
		System.out.println("first test annatation");
	}
    //assigning the priority
	@Test(priority=1)
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
