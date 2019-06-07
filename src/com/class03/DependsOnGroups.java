package com.class03;

import org.testng.annotations.Test;

public class DependsOnGroups {

	@Test(groups ="Smoke11")
	public void one() {
		System.out.println("one test ");
	}
	
	@Test(groups ="Smoke12",dependsOnGroups ="Smoke13")
	public void two() {
		System.out.println("two test ");
	}
	
	@Test(groups ="Smoke13",dependsOnGroups ="Smoke11")
	public void three() {
		System.out.println("three test ");
	}

	
	
	
	
	
	
	
	
}
