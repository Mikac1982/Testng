package com.practice;

import org.testng.annotations.Test;

public class TestNGDependency {

	@Test(dependsOnGroups= {"sanity.*"})
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test(groups= {"sanity4"})
	public void test2() {
		System.out.println("I am inside Test 2");
	}
	
	@Test(groups= {"sanity5"})
	public void test3() {
		System.out.println("I am inside Test 3");
	}
	
	
	
	
}
