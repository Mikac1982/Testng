package com.class03_;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsExample {

	@BeforeGroups({"Smoke","Regression"})
	public void beforeGroup() {
		System.out.println("beforeGroups");
	}
	
	@Test(groups="Smoke")
	public void One() {
		System.out.println("testOne");
	}
	
	@Test(groups="Regression")
	public void Two() {
		System.out.println("testTwo");
	}
	
	@Test(groups="Smoke")
	public void Three() {
		System.out.println("testThree");
	}
	
	@Test(groups="Regression")
	public void Four() {
		System.out.println("testFour");
	}
	
	@AfterGroups({"Smoke","Regression"})
	public void afterGroup() {
		System.out.println("afterGroups");
	}
}
