package com.class02_;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utilis.CommonMethods;

public class SoftHardAssertExample extends CommonMethods{
   /* OrangeHRM Verify Successful LoginStep 
    * 1: Open browser and navigate to OrangeHRMStep 
    * 2: Enter valid UID and valid PWD and click login buttonStep 
    * 3: Verify user successfully logged in
    */
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test(priority=1)
	public void orangeLoginScreen() {
		String title=driver.getTitle();
		String expected="OrangeHRM";
		//if it's not matching, we will get this:
		//java.lang.AssertionError: expected [OrangeHRMssss] but found [OrangeHRM]
		Assert.assertEquals(title, expected);
		System.out.println("After hard assert");
		
	}
	//using soft assert
	@Test(enabled=false)
	public void soft() {
		String title=driver.getTitle();
		String expected="OrangeHRM";
		//if it's not matching, we will get this:
		//java.lang.AssertionError: The following asserts failed:
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(title, expected);
		System.out.println("Soft assert");
		soft.assertAll(); //shows the failure, message
	}
	
	@Test(priority=2)
	public void logo() {
		boolean logo=driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed();
	//	Assert.assertTrue(logo);
	//	System.out.println("After hard assert");
		
		SoftAssert soft2=new SoftAssert();
		soft2.assertTrue(logo);
		System.out.println("Soft assert");
		soft2.assertAll();
	}
	
	
	
	
	
}
