package com.udemy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("BEFORE CLASS: bfeore executing any methods in day 3 class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AFTER CLASS: after executing ALL methods in day 3 class");
	}
	
	@Parameters({"URL","APIKey/username"})
	@Test
	public void webLoginCarLoan(String urlname, String key) {
		//selenium
		System.out.println("web loginCar");
		System.out.println(urlname);
		System.out.println(key);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BEFORE METHOD: I will execute BEFORE every test case in class 3");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AFTER METHOD: I will execute AFTER every test case in class 3");
	}
	
	@Test(enabled=false)
	public void mobileSignInCarLoan() {
		//Appium
		System.out.println("mobile SignIn");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BEFORE SUITE: I am num 1");
	}
	
	//wait 4 second before throwing error for this test case
	//@Test(timeOut=4000)
	
	@Test(dataProvider="getData")
	public void mobileSignOutCarLoan(String username, String password) {
		//Appium
		System.out.println("mobile SignOut");
		System.out.println(username+" "+password);
	}
	
	@Test(dependsOnMethods= {"webLoginCarLoan", "mobileSignOutCarLoan"})
	public void APIcarLoan() {
		//rest API automatiom
		System.out.println("APIloginCar");
	}
	
	@DataProvider
	public Object[][] getData() {
		//1st combination: username password - good credit history
		//2st combination: username password - no credit history
		//3st combination: username password - bad credit history
		
	Object[][] data=new Object[3][2];	
	//1st set data;
	//columns in the row are nothing but values for that particular combination(row)
	data [0][0]="firstUsername";	
	data [0][1]="firstPassword";

	//2nd set
	data [1][0]="secondUsername";	
	data [1][1]="secondPassword";
	
	//3th set data
	data [2][0]="thirdUsername";	
	data [2][1]="thirdPassword";	
		
	return data;
	}
	
	
	
	
	
	
	
	
}
