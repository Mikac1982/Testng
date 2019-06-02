package com.class01_;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class BeforeAndAfterMethods extends CommonMethods{

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}
	
	@Test
	public void testMethodOne() {
        System.out.println("testMethodOne");
	}
	
	@Test
	public void testMethodTwo() {
		System.out.println("testMethodTwo");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	
	
	
}
