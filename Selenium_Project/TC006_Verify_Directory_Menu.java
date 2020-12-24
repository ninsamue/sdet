package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*
 * Verify that the “Directory” menu item is visible and clickable
 */
public class TC006_Verify_Directory_Menu extends DriverInstance {

	/*
	 * login with credentials provided
	 */
	@Test(priority=0)
	public void verifyLogin() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		
		driver.findElement(By.id("btnLogin")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Dashboard");
		System.out.println("Logged in into HRM and Dashboard is open");
		Reporter.log("Logged in into HRM and Dashboard is open | ");
		
	}
	
	@Test(priority=1)
	public void verifyDirectoryMenu() {
		//Locate the navigation menu
		WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));
		
		//Verify that the “Directory” menu item is visible and clickable.
		Assert.assertTrue(directoryMenu.isDisplayed(), "Directory Menu is not displayed");
		System.out.println("Directory Menu is displayed");
		Reporter.log("Directory Menu is displayed | ");
		
		try {
		       wait.until(ExpectedConditions.elementToBeClickable(directoryMenu));
		       System.out.println("Directory Menu is clickable");
		       Reporter.log("Directory Menu is clickable | ");
		       
		       //If clickable, click on the menu item.
		       directoryMenu.click();
		       directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));
			   directoryMenu.click();
			   System.out.println("Directory Menu is clicked");
			   Reporter.log("Directory Menu is clicked | ");
				
			   //Verify that the heading of the page matches “Search Directory”.
			   Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Search Directory");
			   System.out.println("Page Heading is Search Directory");
			   Reporter.log("Page Heading is Search Directory | ");
			   
		     }
		catch(TimeoutException e) {
		       System.out.println("Directory Menu is not clickable");
		       Reporter.log("Directory Menu is not clickable | ");
		    }
		
		
	}

}
