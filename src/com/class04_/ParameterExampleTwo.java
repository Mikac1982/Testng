package com.class04_;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class ParameterExampleTwo extends CommonMethods{

	@Parameters({"browser","url"})
	@Test
	//we have to pass parameters keys that holds String
	public void google(String browser, String url) {
		setUpDriver(browser, url);
		System.out.println(browser);
		System.out.println(url);
	}
	
}
