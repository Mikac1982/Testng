package com.class04_;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class HomeworkDataProv extends CommonMethods{
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
	
	@Parameters({"browser", "url", "username", "password"})
	@BeforeClass(alwaysRun=true)
	public void setUp(String browser, String url, String username, String password) {
		setUpDriver(browser, url);
	
		sendText(driver.findElement(By.cssSelector("input[id*='username']")), username);
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), password);
		click(driver.findElement(By.cssSelector("input[value='Login']")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='View all orders']")).isDisplayed());
		System.out.println("User successfully logged in");
		
		click(driver.findElement(By.xpath("//a[text()='Order']")));
	}
	
	@DataProvider
	public Object[][] setUpData() {
	Object[][] data=new Object[2][9];
		
	data[0][0]="ScreenSaver";
	data[0][1]="9";	
	data[0][2]="Erica";	
	data[0][3]="1888 kaloram st";	
	data[0][4]="Washington";
	data[0][5]="DC";	
	data[0][6]="20009";	
	data[0][7]="4744303699098868";												
	data[0][8]="07/22";		
	
	data[1][0]="FamilyAlbum";
	data[1][1]="15";	
	data[1][2]="Britney";	
	data[1][3]="2335 first st";	
	data[1][4]="Boston";
	data[1][5]="Massachusetts";	
	data[1][6]="02108";
	data[1][7]="2233454578189936";												
	data[1][8]="03/21";	
	
    return data;
	}
	
	@Test(dataProvider="setUpData")
	public void getData(String product, String quant, String name, String street, String city, String state, String zip, String cardNum, String expDate) throws InterruptedException {
		
		selectValueDropDown(driver.findElement(By.cssSelector("select[onchange*='products']")), product);
		sendText(driver.findElement(By.cssSelector("input[onchange*='products']")), quant);
		sendText(driver.findElement(By.cssSelector("input[name*='Name']")), name);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox2']")), street);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox3']")), city);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox4']")), state);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox5']")), zip);	
		
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
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox6']")), cardNum);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox1']")), expDate);
		click(driver.findElement(By.xpath("//a[text()='Process']")));
		Thread.sleep(4000);
		
		 //Verify that user name appears on the table
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
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		click(driver.findElement(By.xpath("//a[text()='Logout']")));
		driver.close();
	}
	
	
	
	
	
}
