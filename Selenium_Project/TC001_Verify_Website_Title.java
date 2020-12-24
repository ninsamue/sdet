package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC001_Verify_Website_Title extends DriverInstance {
	
	/*
	 * Read the title of the website and verify the text
	 */
	@Test
	public void checkTitle() {
		//Get the title of the website
		System.out.println("The title of the Website : "+driver.getTitle());
		Reporter.log("The title of the Website : "+driver.getTitle());
		
		//Make sure it matches “OrangeHRM” exactly
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	
	}

}
