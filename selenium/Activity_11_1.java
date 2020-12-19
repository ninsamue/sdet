package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_1 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		//Open a browser with https://www.training-support.net/selenium/javascript-alerts
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		
		//Get the title of the page using driver.getTitle() and print out the title.
		System.out.println("The Title of the Page : "+driver.getTitle());
		
		//Use findElement() to find the button to open a SIMPLE alert and click it.
		WebElement simpleAlert = driver.findElement(By.id("simple"));
		simpleAlert.click();
		
		//Switch the focus from the main window to the Alert box and get the text in it and print it.
		System.out.println("The Text of the simple alert : "+driver.switchTo().alert().getText());
		
		//Finally, close the alert with alert.accept()
		driver.switchTo().alert().accept();
		
		//close() the browser
		driver.close();
		
	}

}
