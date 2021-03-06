package com.class04_;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class NewToursParammetersTask extends CommonMethods{

	@Parameters({"browser", "url"})
	@BeforeMethod(alwaysRun=true)
	//doesn't have to match with parameters
	public void setUp(String chrome, String link) {
		setUpDriver(chrome, link);
		click(driver.findElement(By.xpath("//a[text()='REGISTER']")));
	}
	
	@Parameters({"user", "pass", "confPass"})
	@Test
    public void userInformation(String user, String pass, String confPass) {
		sendText(driver.findElement(By.cssSelector("input#email")),user);
		sendText(driver.findElement(By.cssSelector("input[name='password']")),pass);
		sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")),confPass );
		driver.findElement(By.cssSelector("input[name='register']")).click();
    }
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
