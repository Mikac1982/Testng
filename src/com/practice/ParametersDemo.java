package com.practice;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	@Test
	@Parameters("MyName")
	//@Optional makes parameter optional
	public void test(@Optional("Mika") String name) {
		System.out.println("Name is :"+name);
	}
	
	
}
