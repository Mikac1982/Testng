package com.class02_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task2 extends CommonMethods{

//	@BeforeMethod -->won't work in this case
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}
	
	@Test(priority=1)
	//verify we navigate to the right page
	public void loginScreenTitle() {
		String loginTitle=driver.getTitle();
		String expTitel="Web Orders Login";
		if (loginTitle.equals(expTitel)) {
			System.out.println("Right title");
		}else {
			System.out.println("Wrong title");
		}
	}
	
	@Test(priority=2)
	//login 
	public void login() {
		sendText(driver.findElement(By.xpath("//input[contains(@id,'username')]")), "Tester");
		sendText(driver.findElement(By.xpath("//input[contains(@id,'password')]")), "test");
		click(driver.findElement(By.cssSelector("input.button")));
	}
	
	@Test(enabled=false)
	//verify that login text appears
	public void webOrders() {
		WebElement webOrderTitle=driver.findElement(By.xpath("//h1[text()='Web Orders']"));
	    if(webOrderTitle.isDisplayed()) {
	    	System.out.println("WebOrder title is displayed");
	    }else {
	    	System.out.println("WebOrder title is NOT displayed");
	    }
	}
	
	@AfterClass
	public void closed() {
		driver.close();
	}
	
	
}
