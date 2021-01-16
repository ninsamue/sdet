package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps{
	WebDriver driver;
	WebDriverWait wait;
	@Given("^User is on Google Home Page$")
	public void user_is_on_google_home_page() throws Throwable{
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 15);
		
		driver.get("https://www.google.com");
		
	}
	
	@When("^User types in Cheese and hits ENTER$")
	public void user_types_in_cheese_and_hits_enter() throws Throwable {
		
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
		
	}
	
	@Then("^Show how many search results were shown$")
	public void show_how_many_search_results_were_shown() throws Throwable{

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
	}
	
	@And("^Close the browser$")
	public void close_the_browser() throws Throwable{
		driver.close();
	}

	



}
