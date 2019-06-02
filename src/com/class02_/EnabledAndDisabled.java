package com.class02_;

import org.testng.annotations.Test;

public class EnabledAndDisabled {

	//enabled=false -> do NOT activate --> DISABLEING test (when there is some issue, we mark as disabled)
	//when some functionality/method is not working and we specify the problem--> comment it
	//it will not get executed
	@Test(enabled=false)  
	public void first() {
		System.out.println("first test annatation");
	}
	
	//for enabled we do not have to specify, it's true by default
	@Test(enabled=true, priority=1)
	public void second() {
		System.out.println("second test annatation");
	}
	
	@Test(enabled=false)
	public void third() {
		System.out.println("third test annatation");
	}
	
	@Test(enabled=true, priority=2)
	public void fourth() {
		System.out.println("fourth test annatation");
	}
	
	
	
	
}
