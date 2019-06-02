package com.class02_;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssert {

	
	@Test 
	//Soft--> when we have a lot of forms to fill out, a lot of lines
	//continue with code even when line of code fails
	public void soft() {
		SoftAssert soft=new SoftAssert();
		System.out.println("before soft assert");
		soft.assertTrue(false);
		System.out.println("after soft assert");
		//to be able to see fail 
		soft.assertAll();
	}
	
	@Test
	//Hard --> for login or verification of the page (if login fail we want to stop, exit the code)
	//do NOT continue execution if there is fail, after line of code that fails it stops
	public void hard() {
		System.out.println("before hard assert");
		Assert.assertTrue(false);
		System.out.println("after hard assert");
	}
	
	
	
	
	
}
