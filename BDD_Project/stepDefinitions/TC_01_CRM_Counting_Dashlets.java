package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_01_CRM_Counting_Dashlets extends BaseClass  {
	
	@Given("^I navigate to Alchemy CRM site and login to the application$")
	public void i_navigate_to_alchemy_crm_site_and_login_to_the_application() {
		//Create Instances
		createWebDriver();
 
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
        
        //Enter UserName and Password and Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        
        driver.findElement(By.id("bigbutton")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'dashlet_entire')]")));
        
	}


	@Then("^Count the Dashlets and Print$")
	public void count_the_dashlets_and_print() throws InterruptedException {
				
		
		List<WebElement> dashletElements = driver.findElements(By.xpath("//div[contains(@id,'dashlet_entire')]"));
		
		System.out.println("The number of Dashlets : "+dashletElements.size());
	}

}
