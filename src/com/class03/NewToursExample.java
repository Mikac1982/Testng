package com.class03;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class NewToursExample extends CommonMethods{

	@BeforeTest(groups="Smoke")
	public void setUP() {
	    String url="http://newtours.demoaut.com/";
	    setUpDriver("chrome", url);
	    driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
	}
	
	@Test (groups="Regression")
	public void contactInfo() {
	    sendText(driver.findElement(By.cssSelector("input[name='firstName']")), "NameTest");
	    sendText(driver.findElement(By.cssSelector("input[name='lastName']")), "lastNameTest");
	    sendText(driver.findElement(By.cssSelector("input[name='phone']")), "phoneTes");
	    sendText(driver.findElement(By.cssSelector("input[name='userName']")), "userTest");
	    
	}
	   
    @Test(groups="Smoke")
	public void userInformation() {
	        sendText(driver.findElement(By.cssSelector("input#email")), "mustafa");
	        sendText(driver.findElement(By.cssSelector("input[name='password']")), "Bahar");
	        sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")), "Bahar");
	  driver.findElement(By.cssSelector("input[name='register']")).click();
	}
	    
	@Test (groups= {"Smoke","Regression"})
	 public void mailingInfo() {
	        sendText(driver.findElement(By.cssSelector("input[name='address1']")), "NameTest");
	        sendText(driver.findElement(By.cssSelector("input[name='city']")), "lastNameTest");
	        sendText(driver.findElement(By.cssSelector("input[name='state']")), "phoneTes");
	        sendText(driver.findElement(By.cssSelector("input[name='postalCode']")), "userTest");
	       
	 }
	
	@AfterTest(groups="Regression")
	public void teardown() {

	}
}
