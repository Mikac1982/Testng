package com.udemy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	@Test(groups= {"Smoke"})
	public void loan() {
		System.out.println("Good");
	}
	
	@BeforeTest
	public void preRequest() {
		System.out.println("BEFORE TEST: I will execute first");
	}
	
	
}
