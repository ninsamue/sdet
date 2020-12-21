package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_1 {
	WebDriver driver;
  @BeforeMethod
  public void createDriver() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");
  }
	
  @Test
  public void f() {
	  System.out.println("The Title of the Page : "+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "Training Support");
	  
	  driver.findElement(By.id("about-link")).click();
	  System.out.println("The Title of the Page : "+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "About Training Support");
	  
  }
  
  @AfterMethod
  public void closeBrowser() {
	  driver.quit();
  }
  
   
}
