package com.class05_;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task1CrossBrowser extends CommonMethods {

	// http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx

	@Parameters({ "browser", "url", "username", "password" })
	@BeforeClass
	public void setUp(String browserType, String url, String username, String password) {

		if (browserType.equalsIgnoreCase("chrome")) {
			setUpDriver(browserType, url);
			driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(password);
			driver.findElement(By.xpath("//input[contains(@id,'login_button')]")).click();
		} 
		else if (browserType.equalsIgnoreCase("firefox")) {
			setUpDriver(browserType, url);
			driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(password);
			driver.findElement(By.xpath("//input[contains(@id,'login_button')]")).click();
		}

	}

	@DataProvider
	public Object[][] setUpData() {
		Object[][] data = new Object[2][10];

		data[0][0] = "ScreenSaver";
		data[0][1] = "9";
		data[0][2] = "Erica";
		data[0][3] = "1888 kaloram st";
		data[0][4] = "Washington";
		data[0][5] = "DC";
		data[0][6] = "20009";
		data[0][7] = "Visa";
		data[0][8] = "4744303699098868";
		data[0][9] = "08/22";

		data[1][0] = "FamilyAlbum";
		data[1][1] = "15";
		data[1][2] = "Britney";
		data[1][3] = "2335 first st";
		data[1][4] = "Boston";
		data[1][5] = "Massachusetts";
		data[1][6] = "02108";
		data[1][7] = "MasterCard";
		data[1][8] = "2233454578189936";
		data[1][9] = "03/21";

		return data;
	}

	@Test(dataProvider = "setUpData")
	public void getData(String product, String quant, String name, String street, String city, String state, String zip,
			String card, String cardNum, String expDate) throws InterruptedException {

		click(driver.findElement(By.xpath("//a[text()='Order']")));
		selectValueDropDown(driver.findElement(By.cssSelector("select[onchange*='products']")), product);
		sendText(driver.findElement(By.cssSelector("input[onchange*='products']")), quant);
		sendText(driver.findElement(By.cssSelector("input[name*='Name']")), name);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox2']")), street);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox3']")), city);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox4']")), state);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox5']")), zip);
		click(driver.findElement(By.xpath("//input[contains(@value,'" + card + "')]")));
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox6']")), cardNum);
		sendText(driver.findElement(By.cssSelector("input[name*='TextBox1']")), expDate);

		if (name.contains("Erica")) {
			takeScreenshoot("task1", "smartbearsoftwareUserOne");
		} else {
			takeScreenshoot("task1", "smartbearsoftwareUserTwo");
		}

		click(driver.findElement(By.xpath("//a[text()='Process']")));

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}

}
