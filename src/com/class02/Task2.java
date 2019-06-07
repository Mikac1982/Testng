package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task2 extends CommonMethods{

	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}
	
	@Test(priority = 1)
	public void loginScreenTitle() {
	    String loginScreenTitle=driver.getTitle();
	    String exptitle ="Web Orders Login";
	if(loginScreenTitle.equals(exptitle)) {
		System.out.println("this is the right title");
	}
	else {
		System.out.println("this is the wrong  title");
	}
	}
	
	@Test(priority=2)
	public void login() {
		sendText(driver.findElement(By.xpath("//input[contains(@id,'username')]")), "Tester");
		sendText(driver.findElement(By.xpath("//input[contains(@id,'password')]")), "test");
		driver.findElement(By.xpath("//input[contains(@id,'login_button')]")).click();
	}
	
	/*
	 * weborder title is wrong
	 */
	@Test(priority=3)
	public void webOrders() {
		WebElement webOrderTitle= driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		if(webOrderTitle.isDisplayed()) {
			System.out.println("webOrderTitle is displayed");
		}
		else {
			System.out.println("webOrderTitle is not displayed");
		}
	}
	
	@AfterClass
	public void closed() {
		driver.close();
	}
	
}
