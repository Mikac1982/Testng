package com.class04;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class NewTourExample extends CommonMethods{

	@Parameters({"browser", "url"})
	@BeforeMethod(alwaysRun=true)
	public void setUp(String chrome, String link) {
		setUpDriver(chrome, link);
	}
	
	@Parameters({"user", "pass", "conPass"})
	@Test
    public void userInformation(String user, String pass, String conPass) {
		sendText(driver.findElement(By.cssSelector("input#email")),user);
		sendText(driver.findElement(By.cssSelector("input[name='password']")),pass);
		sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")),conPass );
		driver.findElement(By.cssSelector("input[name='register']")).click();
    }
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
