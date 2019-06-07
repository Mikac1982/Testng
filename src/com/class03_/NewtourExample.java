package com.class03_;

import org.openqa.selenium.By;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class NewtourExample extends CommonMethods{

   @BeforeGroups("Regression")
   public void setUp() {
	 setUpDriver("chrome", "http://newtours.demoaut.com/");
	 click(driver.findElement(By.xpath("//a[text()='REGISTER']")));
   }

   @Test(groups="Smoke")
   public void serInformation() {
	  sendText(driver.findElement(By.cssSelector("input#email")), "userTest"); 
	  sendText(driver.findElement(By.cssSelector("input[name='password']")), "pastTest");
	  sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")), "pastTest");
	  click(driver.findElement(By.cssSelector("input[name='register']")));
   }
   
   @Test(groups="Regression")
   public void contactInformation() {
	   sendText(driver.findElement(By.cssSelector("input[name='firstName']")), "nameTest");
	   sendText(driver.findElement(By.cssSelector("input[name='lastName']")), "lastNameTest");
	   sendText(driver.findElement(By.cssSelector("input[name='phone']")), "phoneTest");
	   sendText(driver.findElement(By.cssSelector("input[name='userName']")), "userTest");
   }

   @Test(groups="Regression")
   public void mailingInformation() {
	   sendText(driver.findElement(By.cssSelector("input[name='address1']")), "addressTest");
	   sendText(driver.findElement(By.cssSelector("input[name='city']")), "cityTest");
	   sendText(driver.findElement(By.cssSelector("input[name='state']")), "stateTest");
	   sendText(driver.findElement(By.cssSelector("input[name='postalCode']")), "postalCodeTest");
   }
   
   
   @AfterGroups("Regression")
   public void tearDown() {
	  driver.quit();
    }

}
