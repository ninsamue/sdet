package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC003_Login_VerifyHomePage extends DriverInstance   {
	
	/*
	 * Open the site and login with the credentials provided
	 */
	@Test
	public void verifyLogin() {
		
		//Find and select the username and password fields
		//Enter login credentials into the respective fields
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		
		//Click login
		driver.findElement(By.id("btnLogin")).click();
		
		//Verify that the homepage has opened
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Dashboard");
		System.out.println("Logged in into HRM and Dashboard is open");
		Reporter.log("Logged in into HRM and Dashboard is open");
		
	}

}
