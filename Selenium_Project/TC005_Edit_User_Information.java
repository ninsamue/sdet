package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/*
 * Edit a user’s information  
 */
public class TC005_Edit_User_Information extends DriverInstance {

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
	public void editUserInformation() {

		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		//On the new page, click the Edit button.
		driver.findElement(By.id("btnSave")).click();
		System.out.println("Edit Button is clicked");
		Reporter.log("Edit Button is clicked | ");
		
		String firstName="Test9745";
		String lastName="Test9745";
		String Gender="Female";
		String Nationality="Indian";
		String DOB="1986-01-01";
		
		//Fill in the Name, Gender, Nationality, and the DOB fields
		WebElement txtFirstName = driver.findElement(By.id("personal_txtEmpFirstName"));
		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);
		
		WebElement txtLastName = driver.findElement(By.id("personal_txtEmpLastName"));
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
		
		driver.findElement(By.xpath("//label[contains(text(),'"+Gender+"')]/preceding::input[1]")).click();
		
		WebElement nationalitydd = driver.findElement(By.id("personal_cmbNation"));
		
		Select selectNationality = new Select(nationalitydd);
		selectNationality.selectByVisibleText(Nationality);
		
		
		WebElement DoB = driver.findElement(By.id("personal_DOB"));
		DoB.clear();
		DoB.sendKeys(DOB);
		System.out.println("Name, Gender, Nationality, and the DOB fields are filled");
		Reporter.log("Name, Gender, Nationality, and the DOB fields are filled | ");
		
		//Click Save.
		driver.findElement(By.id("btnSave")).click();
		System.out.println("Information edited are saved");
		Reporter.log("Information edited are saved | ");
		
	}

}
