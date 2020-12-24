package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 * Add an employee and their details to the site
 */
public class TC004_Add_New_Employee extends DriverInstance {
	
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
	
	/*
	 * Find the PIM option in the menu and click it
	 */
	@Test(dependsOnMethods = {"verifyLogin"}, priority=1)
	public void clickPIMOption() throws InterruptedException {
		
		WebElement PIMOptions=driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();
		PIMOptions=driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Employee Information");
		System.out.println("Employee Information Page is displayed");
		Reporter.log("Employee Information Page is displayed | ");
		
		
	}
	
	@Test(priority=2)
	@Parameters({"firstName","lastName"})
	public void addNewEmployee(String firstName,String lastName){
		//Click the Add button to add a new Employee
		driver.findElement(By.id("btnAdd")).click();
		System.out.println("Add Button is clicked");
		Reporter.log("Add Button is clicked | ");
		
		//Fill in the required fields and click Save.
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		System.out.println("Employee Details are entered");
		Reporter.log("Employee Details are entered | ");
		
		String empId=driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Employee Id : "+empId);
		Reporter.log("Employee Id : "+empId+" | ");
		
		driver.findElement(By.id("btnSave")).click();
		System.out.println("Save Button is clicked");
		Reporter.log("Save Button is clicked | ");
	
		//Navigate back to the Admin page and verify the creation of your employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));
		System.out.println("Navigated to Admin Page");
		Reporter.log("Navigated to Admin Page | ");	
		
		driver.findElement(By.id("empsearch_id")).clear();
		driver.findElement(By.id("empsearch_id")).sendKeys(empId);
		
		driver.findElement(By.id("searchBtn")).click();
		System.out.println("The new employee created is searched");
		Reporter.log("The new employee created is searched | ");
		
		Assert.assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")).getText(),empId);
		System.out.println("Employee id is displayed correctly");
		Reporter.log("Employee id is displayed correctly |");
		
		Assert.assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText(),firstName);
		System.out.println("First Name is displayed correctly");
		Reporter.log("First Name is displayed correctly | ");
		
		Assert.assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]")).getText(),lastName);
		System.out.println("Last Name is displayed correctly");
		Reporter.log("Last Name is displayed correctly | ");
	}

}
