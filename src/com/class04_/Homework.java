package com.class04_;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Homework extends CommonMethods{
/*Identify Priority of Test Cases

http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx

TC 1: WebOrder Verify Successful Login ( )
Step 1: Open browser and navigate to WebOrder
Step 2: Enter valid username, enter valid password and click on the  login button
Step 3: Verify user successfully logged in

TC 2: WebOrder Creating and verifying Users( )
 Step 1: Create Two users and fill out all the required fields
 Step 2: Verify that user one name appears within the table 
 Step 3: Edit user one  and update user one’s State, assert the new updated State is displayed and save the changes.
 Step 4: Verify that user two name appears within the table 
 Step 5: Edit user two and update user two’s City and assert the new updated City is displayed and save the changes.

TC 3: WebOrder verifying Users( )
        Step 1 : Assert Both User one and User Two are displayed

Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application. 
The creation of users two should depend on the creation of users one.
The validation both users should depend on the creation of both users. 
Create xml file and share a screenshot of the test.
 */
	
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		String url="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx";
		setUpDriver("chrome", url);
		
		sendText(driver.findElement(By.cssSelector("input[id*='username']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
		click(driver.findElement(By.cssSelector("input[value='Login']")));

		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='View all orders']")).isDisplayed());
		System.out.println("User successfully logged in");
	}
	
	@Test
	public void newUserOne() throws InterruptedException {
		click(driver.findElement(By.xpath("//a[text()='Order']")));
		selectValueDropDown(driver.findElement(By.cssSelector("select[onchange*='products']")), "ScreenSaver");
		sendText(driver.findElement(By.cssSelector("input[onchange*='products']")), "10");
		sendText(driver.findElement(By.cssSelector("input[name*='Name']")), "Erica");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox2']")), "1888 kaloram st nw");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox3']")), "Washington");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox4']")), "DC");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox5']")), "20009");
		
		String valueToSelect="American Express";
		List<WebElement> cards=driver.findElements(By.name("ctl00$MainContent$fmwOrder$cardList"));
		for(WebElement card:cards) {
			if (card.isEnabled()){
				String value=card.getAttribute("value");
				if(value.equals(valueToSelect)) {
					card.click();
			    }
			}
	    }
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox6']")), "4744303699098868");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox1']")), "07/23");
		click(driver.findElement(By.xpath("//a[text()='Process']")));
		Thread.sleep(4000);
	}
		@Test(dependsOnMethods="newUserOne")
		public void validationUserOne() {
		
		click(driver.findElement(By.xpath("//a[text()='View all orders']")));
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Erica']")).isDisplayed());
		System.out.println("User 1 name appears");
		
		//edit user 1 State
		click(driver.findElement(By.xpath("//table/tbody/tr[2]/td[13]")));
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox4']")), "Virginia");
		click(driver.findElement(By.xpath("//a[text()='Update']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Virginia']")).isDisplayed());
		System.out.println("New State is verified");
	}
	
	@Test(dependsOnMethods="newUserOne")
	public void newUserTwo() throws InterruptedException {
		click(driver.findElement(By.xpath("//a[text()='Order']")));
		selectValueDropDown(driver.findElement(By.cssSelector("select[onchange*='products']")), "FamilyAlbum");
		sendText(driver.findElement(By.cssSelector("input[onchange*='products']")), "5");
		sendText(driver.findElement(By.cssSelector("input[name*='Name']")), "Britney");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox2']")), "2335 first st");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox3']")), "Boston");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox4']")), "MA");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox5']")), "02108");
		
		String valueToSelect="MasterCard";
		List<WebElement> cards=driver.findElements(By.name("ctl00$MainContent$fmwOrder$cardList"));
		for(WebElement card:cards) {
			if (card.isEnabled()){
				String value=card.getAttribute("value");
				if(value.equals(valueToSelect)) {
					card.click();
					Thread.sleep(3000);
			    }
			}
	    }
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox6']")), "2233454578189936");
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox1']")), "02/21");
		click(driver.findElement(By.xpath("//a[text()='Process']")));
		Thread.sleep(4000);
		
	}
	@Test(dependsOnMethods="newUserTwo")
	public void validationUserTwo() throws InterruptedException {
		//verify user 2 name appears
		click(driver.findElement(By.xpath("//a[text()='View all orders']")));
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Britney']")).isDisplayed());
		System.out.println("User 2 name appears");
		
		//edit user 2 city
		click(driver.findElement(By.xpath("//table/tbody/tr[2]/td[13]")));
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox3']")), "San Diego");
		click(driver.findElement(By.xpath("//a[text()='Update']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='San Diego']")).isDisplayed());
		System.out.println("New city is verified");
		Thread.sleep(4000);
	}
	
	@Test(dependsOnMethods="validationUserTwo")
	public void verifyingUsers(){
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Erica']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Britney']")).isDisplayed());
		System.out.println("User one and user two are displayed");
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		click(driver.findElement(By.xpath("//a[text()='Logout']")));
		driver.close();
	}
	
	
	
	
}
