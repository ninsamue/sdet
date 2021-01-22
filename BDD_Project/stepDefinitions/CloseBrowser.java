package stepDefinitions;

import io.cucumber.java.en.Then;

public class CloseBrowser extends BaseClass{
	
	@Then("Close the Browser")
	public void close_the_browser() {
		driver.quit();
	}

}
