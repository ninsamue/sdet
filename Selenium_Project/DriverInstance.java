package org.automation.HRM.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DriverInstance {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeClass
	public void createDriverInstance() {
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,50);
		driver.get("http://alchemy.hguy.co/orangehrm");
		System.out.println("Browser opened with URL - http://alchemy.hguy.co/orangehrm");
		Reporter.log("Browser opened with URL - http://alchemy.hguy.co/orangehrm\n");
		
	}
		
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser is closed");
		Reporter.log("Browser is closed\n");
	}

}
