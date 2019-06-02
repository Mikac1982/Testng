package com.class02;

import org.testng.annotations.Test;

public class EnableAndDisable {

	//do NOT activate--> DISABLEING test
	@Test(enabled=false)  
	public void first() {
		System.out.println("first test annatation");
	}
	
	//if we do not specify enable, it's enabled, by default
	@Test(enabled=true, priority=1)
	public void second() {
		System.out.println("second test annatation");
	}
	
	//do NOT activate--> DISABLEING test
	@Test(enabled=false)
	public void third() {
		System.out.println("third test annatation");
	}
	
	@Test(enabled=true, priority=2)
	public void fourth() {
		System.out.println("fourth test annatation");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
