package com.udemy;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {

	@Parameters({"URL"})
	@Test
	public void webLoginHomeLoan(String uname) {
		//selenium
		System.out.println("webloginHomePersonalLoan");
		System.out.println(uname);
	}
	
	@Test(groups= {"Smoke"})
	public void mobileLoginHomeLoan() {
		//Appium
		System.out.println("mobileloginHome");
	}
	
	@Test
	public void loginApIHomeLoan() {
		//rest API automatiom
		System.out.println("APIloginHome");
	}
	
	
	
	
	
}
