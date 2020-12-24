package org.automation.HRM.testcases;

import java.util.List;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*
 * Login and retrieve the emergency contacts for the user
 */
public class TC009_Retrieve_Emergency_Contacts extends DriverInstance {
	
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
	public void retrieveEmergencyContacts() {
		
		//Navigate to the “My Info” page
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		System.out.println("My Info Menu Item is opened");
		Reporter.log("My Info Menu Item is opened | ");
		
		//Locate the left hand menu - Click on the “Emergency Contacts” menu item
		driver.findElement(By.xpath("//ul[@id='sidenav']/li/a[contains(text(),'Emergency Contacts')]")).click();
		System.out.println("Emergency Contact is clicked from the Left Hand Menu");
		Reporter.log("Emergency Contact is clicked from the Left Hand Menu | ");
		
		//Retrieve information about all the contacts listed in the table
		List<WebElement> weEmergencyContacts = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
		
		//Print all the information to the console
		System.out.println("Emergency Contacts Details");
		Reporter.log("<br/>Emergency Contacts Details<br/>");
		System.out.println("--------------------------");
		Reporter.log("--------------------------<br/>");
		for(WebElement row : weEmergencyContacts)
		{
			System.out.println(row.getText());
			Reporter.log(row.getText()+"<br/>");
		}
		System.out.println("--------------------------");
		Reporter.log("--------------------------<br/>");
		
		System.out.println("Emergency Contacts Information is retrieved");
		Reporter.log("Emergency Contacts Information is retrieved |");
			
		
	}

}
