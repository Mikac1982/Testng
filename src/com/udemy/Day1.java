package com.udemy;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

	
	@Test
	public void demo() {
		System.out.println("Hello");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Bye");
	}
	
	@AfterTest
	public void lastExecution() {
		System.out.println("AFTER TEST:  will execute last");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("AFTER SUITE: I am num 1 from last ");
	}
}
