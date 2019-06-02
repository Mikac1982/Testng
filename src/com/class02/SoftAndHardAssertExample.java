package com.class02;

import org.openqa.selenium.By;
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
	
	@Test(priority=0)
	public void orangehrmLoginScreen() {
		String title=driver.getTitle();
		String expected="OrangeHRM";
		   //HARD
		Assert.assertEquals(title, expected);
		System.out.println("After hard assert");
		   //SOFT
//	SoftAssert soft=new SoftAssert();
//	soft.assertEquals(title, expected);
//	System.out.println("Soft assert");
		
	}
	
	@Test(priority=1)
	public void logo() {
		boolean logo=driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed();
	//	Assert.assertTrue(logo);
	//	System.out.println("After hard assert");
		
		SoftAssert soft2=new SoftAssert();
		soft2.assertTrue(logo);
		System.out.println("Soft assert");
		soft2.assertAll(); //prints all and shows exception
		Assert.assertTrue(logo);
	}
	
	
	
	
	
}
