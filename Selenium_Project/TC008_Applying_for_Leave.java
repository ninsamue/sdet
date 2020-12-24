package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*
 * Login and apply for a leave on the HRM site
 */
public class TC008_Applying_for_Leave extends DriverInstance {
	
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
	public void applyForLease() {
		//Navigate to the Dashboard page and click on the Apply Leave option
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		
		driver.findElement(By.id("menu_leave_applyLeave")).click();
		System.out.println("Apply Leave Option is clicked");
		Reporter.log("Apply Leave Option is clicked | ");
		
		//Select leave type and duration of the leave
		WebElement ddLeaveType = driver.findElement(By.id("applyleave_txtLeaveType"));
		Select selectLeaveType = new Select(ddLeaveType);
		
		WebElement weFromDate = driver.findElement(By.id("applyleave_txtFromDate"));
		WebElement weToDate = driver.findElement(By.id("applyleave_txtToDate"));
		
		String leaveType="Paid Leave";
		String fromDate="2020-12-31";
		String ToDate="2020-12-31";
		
		selectLeaveType.selectByVisibleText(leaveType);
		
		weFromDate.clear();
		weFromDate.sendKeys(fromDate);
		
		weToDate.clear();
		weToDate.sendKeys(ToDate);
		
		//Click Apply
		driver.findElement(By.id("applyBtn")).click();
		System.out.println(leaveType +" from "+fromDate+" to "+ToDate+" is applied.");
		Reporter.log(leaveType +" from "+fromDate+" to "+ToDate+" is applied. | ");
		
		//Navigate to the My Leave page to check the status of leave application
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
					
		driver.findElement(By.xpath("//label[contains(text(),'Cancelled')]/following::input[1]")).click();
				
		WebElement weLLFromDate = driver.findElement(By.id("calFromDate"));
		WebElement weLLToDate = driver.findElement(By.id("calToDate"));
		
		weLLFromDate.clear();
		weLLFromDate.sendKeys(fromDate);
		
		weLLToDate.clear();
		weLLToDate.sendKeys(ToDate);
		
		driver.findElement(By.id("btnSearch")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[6]/a")).getText(), "Pending Approval(1.00)");
		System.out.println("The status of the leave is in Pending Approval");
		Reporter.log("The status of the leave is in Pending Approval | ");
		
	}

}
