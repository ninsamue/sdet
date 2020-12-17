package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_7_2 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver()
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//Open a browser with https://training-support.net/selenium/dynamic-attributes
		driver.get("https://training-support.net/selenium/dynamic-attributes");
		
		//Get the title of the page using driver.getTitle() and print out the title
		System.out.println("The title of the Page : "+driver.getTitle());
		
		//Find the input fields of the Sign Up form. Fill in the details in the fields with your own data.
		driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("test");
		driver.findElement(By.xpath("//input[contains(@class,'-password')]")).sendKeys("test");
		driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[1]")).sendKeys("test");
		driver.findElement(By.xpath("//input[starts-with(@class,'email')]")).sendKeys("test@test.com");
		
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		
		//Wait for success message to appear and print it to the console
		WebElement msg=driver.findElement(By.xpath("//div[@id='action-confirmation']"));
		wait.until(ExpectedConditions.textToBePresentInElement(msg, "Thank you for registering, test"));
		System.out.println(msg.getText());
		
		//Finally, close the browser.
		driver.close();
		
	}

}
