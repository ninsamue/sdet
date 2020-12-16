package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_1 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver()
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver,30);
		
		//Open a browser with https://training-support.net/selenium/dynamic-controls
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		//Get the title of the page using driver.getTitle() and print out the title
		System.out.println("The Title of the Page : "+driver.getTitle());
				
		WebElement btToggle = driver.findElement(By.id("toggleCheckbox"));
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='toggled']"));
		
		//Find the checkbox toggle button and click it.
		btToggle.click();
		
		//Wait till the checkbox disappears
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		
		//Click the button again
		btToggle.click();
		
		//Wait till it appears
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		
		//check the checkbox
		checkbox.click();
		
		System.out.println("Done");
		
		driver.close();
		
		
	}

}
