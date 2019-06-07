package com.class02_;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class SwagLabsTask extends CommonMethods{

	//we use beforeClass cause method will trigger for each @Test and close it before we get to the second Test
	//BeforeClass gets trigger only once within a class level
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com");
		
		boolean swagLabs=driver.findElement(By.xpath("//title[text()='Swag Labs']")).isDisplayed();
		if (swagLabs=true) {
			System.out.println("this is the right title");
		}else {
			System.out.println("this is the wrong title");
		}
		
		//second way-easier
		String title=driver.getTitle();
		System.out.println(title);
		if (title.equals("Swag Labs")) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	 }
	
	@Test(priority=1)
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		click(driver.findElement(By.cssSelector("input.btn_action")));
	}
	
	@Test(priority=2)
	public void mainPage() {
		String text=driver.findElement(By.xpath("//div[text()='Products']")).getText();
		String expected="Products";
		
		if(text.equals(expected)) {
			System.out.println("Expected matches actual text");
		}else {
			System.out.println("Expected does NOT matche actual text");
		}
	}
	
	//AfterClass gets trigger only once within a class level
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	
	
	
	
	
}
