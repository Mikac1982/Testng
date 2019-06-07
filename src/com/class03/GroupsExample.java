package com.class03;

import org.testng.annotations.Test;

public class GroupsExample{
 
	
//	@BeforeGroups({"Smoke", "Regression"})
//	public void beforeGroup() {
//		System.out.println("beforeGroups");
//	}

	//inside "" are keys???

	@Test(groups ="Smoke3")
	public void one() {
		System.out.println("testOne");
	}

	@Test(groups ="Regression3")
	public void Two() {
		System.out.println("testTwo");
	}

	@Test(groups ="Smoke3")
	public void Three() {
		System.out.println("testThree");
	}

	@Test(groups ="Regression3")
	public void Four() {
		System.out.println("testFour");
	}

//	@BeforeGroups({"Smoke", "Regression"})
//	public void afterGroup() {
//		System.out.println("afterGroups");
//	}
	
	
	
	
}
