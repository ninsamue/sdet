package org.automation.HRM.testcases;

import org.automation.HRM.base.DriverInstance;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC002_Header_Image_URL extends DriverInstance  {
	
	/*
	 * Print the url of the header image to the console
	 */
	@Test
	public void getHeaderImageURL() {
		
		//Get the url of the header image
		//Print the url to the console
		System.out.println("URL of the Header Image : "+driver.findElement(By.xpath("//head/link[1]")).getAttribute("href"));
		Reporter.log("URL of the Header Image : "+driver.findElement(By.xpath("//head/link[1]")).getAttribute("href"));
	}

}
