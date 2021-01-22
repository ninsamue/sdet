package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_01_Job_Board_AddNewUser extends BaseClass {
	
    
	@Given("^I navigate to Alchemy Jobs admin site and log in$")
	public void i_navigate_to_alchemy_jobs_admin_site_and_log_in() {
		//Create Instances
		createWebDriver();
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
        
        //Enter UserName and Password and Login
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        
        driver.findElement(By.id("wp-submit")).click();
        
        System.out.println("UserName and Password entered");
	}
	
	//Locate the left hand menu and click the menu item that says “Users”.
	@Given("^Click on Users menu in the left hand menu$")
	public void click_on_users_menu_in_the_left_hand_menu() {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));
			
			WebElement menuUser = driver.findElement(By.xpath("//div[@class='wp-menu-name' and text()='Users']"));
			menuUser.click();
			
			System.out.println("User Menu is clicked");
			
	}
	
	//Locate the “Add New” button and click it.
	@Given("^Click on Add New Button$")
	public void click_on_add_new_button() {
		WebElement menuAddNew = driver.findElement(By.xpath("//li/a[@href='user-new.php' and text()='Add New']"));
		menuAddNew.click();
		
		System.out.println("Add New Option is selected");
		
	}
	
	@Then("^Add New User form should be displayed$")
	public void add_new_user_form_should_be_displayed() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Add New User')]")));
		System.out.println("Add New User");
	}
	
	@Then("^Fill in the neccessary details$")
	public void fill_in_the_neccessary_details() {
		driver.findElement(By.id("user_login")).sendKeys("Tester");
		driver.findElement(By.id("email")).sendKeys("Tester234@test.com");
		
		System.out.println("User Name and Email entered");
		
		driver.findElement(By.className("wp-generate-pw")).click();
		WebElement passFilled = driver.findElement(By.id("pass1"));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(passFilled, "data-pw"));
		
		driver.findElement(By.xpath("//span[contains(text(),'Hide')]")).click();
		
		System.out.println("Show Password is clicked");
	}
	
	@Then("^Click on Add New User Button$")
	public void click_on_add_new_user_button() {
		driver.findElement(By.id("createusersub")).click();

		try {
		driver.findElement(By.id("createusersub")).click();
		}
		catch(Exception ex) {
			
		}
		finally {
			System.out.println("Add New User Button is clicked");
		}
	}
	
	
	@Then("^Verify the User is created$")
	public void verify_the_user_is_created() {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-search-input")));
		
		driver.findElement(By.id("user-search-input")).sendKeys("Tester234@test.com");
		driver.findElement(By.id("search-submit")).click();
		
		WebElement username = driver.findElement(By.xpath("//td/a[text()='Tester234@test.com']/preceding::td[2]/strong"));
		assertEquals("Tester", username.getText());
		
		WebElement deleteOption=driver.findElement(By.xpath(("//td/a[text()='Tester234@test.com']/preceding::td[2]/div[@class='row-actions']/span[@class='delete']")));
		Actions builder = new Actions(driver);
		builder.moveToElement(username).click(deleteOption).build().perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Confirm Deletion']")));
		driver.findElement(By.xpath("//input[@value='Confirm Deletion']")).click();
	}


}
