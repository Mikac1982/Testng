package com.class02_;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class PriorityExample2 extends CommonMethods{

	//if we have more than 1 @Test it's better to use @Before?AfterClass cause @Before?AfterMethos
	//will trigger after each @Test and close the browser before we get to the second @Test
	@BeforeClass
	public void setUp() {
		//launching the browser
		setUpDriver("chrome", "https://www.saucedemo.com");
		
		//verifying it's the right title
	//	boolean title=driver.findElement(By.xpath("//title[text()='Swag Labs']")).isDisplayed();
	//	if(title=true) {
		
		String expectedTitle="Swag Labs";	
		String title=driver.getTitle();
		if(title.equals(expectedTitle)) {
			System.out.println("This is right title");
		}else {
			System.out.println("This is wrong title");
		}
	}
	
	@Test(priority=1)
	//make sure we can login --> first priority
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		click(driver.findElement(By.cssSelector("input.btn_action")));
	}
	
	@Test(priority=2)
	//verifying it's the right text of the Products icon -->second priority
	public void mainPage() {
		String actual=driver.findElement(By.cssSelector("div.product_label")).getText();
	//	String actual=driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		String expected="Products";
		if(expected.equals(actual)) {
			System.out.println("Expected text matches actual");
		}else {
			System.out.println("Expected text does NOT matches actual");
		}
	}
	
	@AfterClass
	public void closePage() {
		driver.quit();
	}
	
	
	
	
	
}
