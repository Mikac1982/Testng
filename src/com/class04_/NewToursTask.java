package com.class04_;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class NewToursTask extends CommonMethods{

    //@BeforeGroups("Regression") we can't use cause BeforeGroups gets trigger just once within a class
	//when we click on register for the first case other test will not get executed cause that page 
	//does not exist anymore, we are on different page now
	
//	@BeforeGroups("Regression")
	//alwaysRun=true --> force pre conditions to always run before all Tests
    @BeforeMethod(alwaysRun =true, groups ="Regression")
    public void setUP() {
        setUpDriver("chrome", "http://newtours.demoaut.com/");
        driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
    }
    
    @Test(groups ="Smoke")
    public void userInformation() {
        sendText(driver.findElement(By.cssSelector("input#email")),"usertest@gmail.com");
        sendText(driver.findElement(By.cssSelector("input[name='password']")), "passtest");
        sendText(driver.findElement(By.cssSelector("input[name='confirmPassword']")), "passtest");
        driver.findElement(By.cssSelector("input[name='register']")).click();
    }
    //this one has to work in order for second to execute 
    @Test(groups ="Regression")
    public void contactInformation() {
        sendText(driver.findElement(By.cssSelector("input[name='firstName']")), "nameTest");    
        sendText(driver.findElement(By.cssSelector("input[name='lastName']")), "lastnameTest");
        sendText(driver.findElement(By.cssSelector("input[name='phone']")), "phoneTest");
        sendText(driver.findElement(By.cssSelector("input[name='userName']")), "userTest");
        driver.findElement(By.xpath("//input[@name='register']")).click();
        //we need this line just for @BeforeGroups/Class-> they triggers just ONCE 
        //not for BeforeMethod-> it triggers before each test
    //  driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
    }
    
    //this method depends of previous one, if contactInformation FAILS this one will SKIP
    @Test(groups ="Regression",dependsOnMethods ="contactInformation")
    public void mailingInformation() throws InterruptedException {
        sendText(driver.findElement(By.cssSelector("input[name='address1']")), "addressTest");  
        sendText(driver.findElement(By.cssSelector("input[name='city']")), "cityTest");
        sendText(driver.findElement(By.cssSelector("input[name='state']")), "stateTest");
        sendText(driver.findElement(By.cssSelector("input[name='postalCode']")), "postalTest");
        driver.findElement(By.xpath("//input[@name='register']")).click();
     //   driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
    }
    
  //@AfterGroups("Regression")
    @AfterMethod(alwaysRun = true, groups ="Regression")
    public void tearDown() {
        driver.close();
    }
	
	
}
