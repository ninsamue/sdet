package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*
 * Add employee qualifications
 */
public class TC007_Add_Employee_Qualification extends DriverInstance {

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
	public void addEmployeeQualification() {
		//Find the “My Info” menu item and click it.	
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		System.out.println("My Info Menu Item is clicked");
		Reporter.log("My Info Menu Item is clicked | ");
		
		//On the new page, find the Qualification option on the left side menu and click it.
		driver.findElement(By.xpath("//ul[@id='sidenav']/li/a[contains(text(),'Qualifications')]")).click();
		System.out.println("Qualifications option is selected");
		Reporter.log("Qualifications option is selected | ");
		
		//Add Work Experience and click Save.
		driver.findElement(By.id("addWorkExperience")).click();
		
		driver.findElement(By.id("experience_employer")).sendKeys("Testing");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
		
		driver.findElement(By.id("btnWorkExpSave")).click();
		System.out.println("Work Experience is Added");
		Reporter.log("Work Experience is Added | ");
		
		
		
	}

}
