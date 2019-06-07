package com.class03_;

import org.testng.annotations.Test;

public class DependsOnGroups {

	@Test(groups="Smoke10")
	public void one() {
		System.out.println("one test ");
	}
	
	@Test(groups="Smoke20",dependsOnGroups="Smoke10")
	public void two() {
		System.out.println("two test ");
	}
	
	@Test(groups="Smoke30",dependsOnGroups="Smoke20")
	public void three() {
		System.out.println("three test ");
	}
	
	
}
