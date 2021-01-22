package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_02_Job_Board_Search extends BaseClass{

	
	
	@Given("^I navigate to Alchemy Jobs site$")
	public void i_navigate_to_alchemy_jobs_site() {
		 //Create Instances
		createWebDriver();
 
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
	}

	
	@Given("^Navigate to Jobs Page$")
	public void navigate_to_jobs_page() {
		driver.findElement(By.xpath("//a[text()='Jobs']")).click();
	}
	
	
	@Given("^Enter Keyword$")
	public void enter_keyword() {
		driver.findElement(By.id("search_keywords")).sendKeys("Test Lead");
	}

	@Given("^Change Job Type to show only Full Time jobs$")
	public void change_job_type_to_show_only_full_time_jobs() {
		List<WebElement> jobTypes = driver.findElements(By.xpath("//ul[@class='job_types']/li/label/input"));
		
		for(WebElement jobType:jobTypes) {
			jobType.click();
		}
		
		driver.findElement(By.xpath("//ul[@class='job_types']/li/label/input[@value='full-time']")).click();;
		
	}
	@Given("^Click on Search Jobs$")
	public void click_on_search_jobs() {
		
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

	}
	
	@Then("^Verify Jobs are listed$")
	public void verify_jobs_are_listed() throws InterruptedException {
		Thread.sleep(5000);
		assertTrue(driver.findElement(By.xpath("//ul[@class='job_listings']/li/a/div")).getText().contains("Test Lead"));
	}
	
	@Then("^Print the title of the Job listing$")
	public void print_the_title_of_the_job_listing() {
		driver.findElement(By.xpath("//ul[@class='job_listings']/li/a/div")).click();
		
		System.out.println(driver.findElement(By.className("entry-title")).getText());
		
	}
	
	@Then("^Click on Apply for Job button$")
	public void click_on_apply_for_job_button() {
		driver.findElement(By.className("application_button")).click();
	}
	
}
