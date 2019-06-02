package com.class02_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utilis.CommonMethods;

public class SoftAndHardAssertExample extends CommonMethods{

	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test(priority=1)
	//capture the title
	public void orangehrmLoginScreen() {
		String title=driver.getTitle();
		String expectedTitle="OrangeHRM"; //title we can copy from <head>
		
		//HARD ASSERT
	//SHOWS US WHERE IT FAILS, WHICH PACKAGE CLASS METHOD AND LINE:	
	//at com.class02_.SoftAndHardAssertExample.orangehrmLoginScreen(SoftAndHardAssertExample.java:24)
		Assert.assertEquals(title, expectedTitle);
		//validated and pass assertion
//		System.out.println("after hard assert");
		
		//SOFT ASSERT
//		SoftAssert soft=new SoftAssert();
//		soft.assertNotEquals(title, expectedTitle);
//		System.out.println("soft assert");
	//	soft.assertAll();
	}
	
	
	@Test(priority=2)
	public void logo() {
		boolean logo=driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed();
		
		SoftAssert soft2=new SoftAssert();
		soft2.assertTrue(logo);
		System.out.println("soft assert");
		//print out and shows us a faller
		soft2.assertAll();
		
	//	Assert.assertTrue(logo);
	//	System.out.println("after hard assert");
	}
	
	
	
	
	
	
	
	
	
	
}
