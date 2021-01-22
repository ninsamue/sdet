package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_03_04_Job_Board_PostJob extends BaseClass {

	@Given("^Navigate to Post Jobs Page$")
	public void navigate_to_post_jobs_page() {
		driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
	}

	@Given("^Click Sign In Button and give the credentials$")
	public void sign_in_to_post_jobs() {
		driver.findElement(By.xpath("//div[contains(@class,'account-sign-in')]/a")).click();

		// Enter UserName and Password and Login
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

		driver.findElement(By.id("wp-submit")).click();

		System.out.println("UserName and Password entered");
	}

	@Then("^Enter Email \"(.*)\", Job Title \"(.*)\", Job Type \"(.*)\", Description \"(.*)\", Company Name \"(.*)\"$")
	public void enter_email_job_title_job_type_description_company_name(String email, String jobTitle, String jobType,
			String description, String companyName) {
		driver.findElement(By.id("create_account_email")).sendKeys(email);
		driver.findElement(By.id("job_title")).sendKeys(jobTitle);

		Select select = new Select(driver.findElement(By.id("job_type")));

		select.selectByVisibleText(jobType);
		
		driver.findElement(By.id("application")).sendKeys(email);
		
		driver.findElement(By.id("job_description_ifr")).sendKeys(description);
		
		driver.findElement(By.id("company_name")).sendKeys(companyName);

	}

	@Then("^Click on Preview and Post$")
	public void click_on_save_draft() {
		driver.findElement(By.xpath("//input[@name='submit_job']")).click();
		
		driver.findElement(By.id("job_preview_submit_button")).click();
		
	}
	
	@And("^Verify in the Job Listing \"(.*)\"$")
	public void verify_job_listing(String jobTitle) {

		driver.findElement(By.xpath("//a[text()='click here']")).click();
		
		assertEquals(jobTitle,driver.findElement(By.className("entry-title")).getText());
	}

}
	