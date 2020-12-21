package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_2 {

	WebDriver driver;

	@BeforeClass
	public void createDriver() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@Test
	public void verifyTitle() {
		String title = driver.getTitle();
		System.out.println("Title is: " + title);
		Assert.assertEquals(title, "Target Practice");
	}

	@Test
	public void verifyBlackButton() {
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
	}

	@Test(enabled = false)
	public void testcase3() {
		System.out.println("The test case is skipped");
	}

	@Test
	public void testcase4() {
		throw new SkipException("Skipping test case");   
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
