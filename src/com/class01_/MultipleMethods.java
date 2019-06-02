package com.class01_;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleMethods {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	@Test
	public void testOne() {
		System.out.println("testOne");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("beforeGroup");
	}
	
	@BeforeMethod
	public void beforeMethods() {
		System.out.println("beforeMethods");
	}
	
	@Test
	public void testTwo() {
		System.out.println("testTwo");
	}
	
	@AfterMethod
	public void afterMethods() {
		System.out.println("afterMethods");
	}
	
	@AfterGroups
	public void afterGroup() {
		System.out.println("afterGroup");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}
	
	@Test
	public void testThree() {
		System.out.println("testThree");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
	
	
	
	
	
	
	
}
