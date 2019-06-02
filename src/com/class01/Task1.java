package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task1 extends CommonMethods{
	/*TC 1: Swag Lab Title and Login Verification
      @BeforeMethod should contain navigation to the URL and title verification
      @Test should contain steps to login and “Product” word verification
      @AfterMethod should logOut from the application and close the browser
	 */
	
	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/index.html");
	}
	
	@Test
	public void login() throws InterruptedException {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.cssSelector("input#password")), "secret_sauce");
		click(driver.findElement(By.cssSelector("input[value='LOGIN']")));
		Thread.sleep(2000);
		
		WebElement product=driver.findElement(By.xpath("//div[text()='Products']"));
		String text=product.getText();
		
		if (text.equals("Products")) {
			System.out.println("Word -Products- is verified");
		}
		else {
			System.out.println("Word -Products- is NOT verified");
		}
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		
		click(driver.findElement(By.xpath("//button[text()='Open Menu']")));
		Thread.sleep(2000);
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement logout=driver.findElement(By.xpath("//a[text()='Logout']"));
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		click(logout);
		
		Thread.sleep(2000);
		driver.quit();
	}
}
