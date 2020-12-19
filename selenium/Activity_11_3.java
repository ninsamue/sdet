package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_3 {

	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();

		//Open a browser with https://www.training-support.net/selenium/javascript-alerts
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		//Get the title of the page using driver.getTitle() and print out the title.
		System.out.println("The Title of the Page : "+driver.getTitle());

		//Use findElement() to find the button to open a PROMPT alert and click it.
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();
		
		//Switch the focus from the main window to the Alert box.
		Alert pAlert=driver.switchTo().alert();
		
		//Use sendKeys() to type in "Yes, you are!".
		pAlert.sendKeys("Yes, you are!");
		
		//Close the alert with alert.accept()
		pAlert.accept();
		
		//close() the browser
		driver.close();
		
	}

}
