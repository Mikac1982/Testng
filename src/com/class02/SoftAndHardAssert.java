package com.class02;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssert {

	
	@Test
	public void soft() {
		//we have to create object of SoftAssert
		//continue execution even after test fail
		SoftAssert soft=new SoftAssert();
		System.out.println("before soft assert");
		soft.assertTrue(false);
		System.out.println("after soft assert");
		soft.assertAll();
	}
	
	@Test
	public void hard() {
		System.out.println("before hard assert");
		//no need to create an object for Hard Assert; all methods are static
		//execution will stop, test fails, when actual and expected result are not matching
		Assert.assertTrue(false);
		System.out.println("after hard assert");
	}
	
	
}
