package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_2 {

	public static void main(String[] args) {

		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();

		//Open a browser with https://www.training-support.net/selenium/javascript-alerts
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		//Get the title of the page using driver.getTitle() and print out the title.
		System.out.println("The Title of the Page : "+driver.getTitle());
		
		//Use findElement() to find the button to open a CONFIRM alert and click it.
		WebElement confirmationAlert = driver.findElement(By.id("confirm"));
		confirmationAlert.click();
		
		//Switch the focus from the main window to the Alert box and get the text in it and print it.
		Alert cAlert=driver.switchTo().alert();
		System.out.println("The Text in the Confirmation Alert : "+cAlert.getText());
		
		//Close the alert once with alert.accept() and again with alert.dismiss()
		cAlert.accept();
		confirmationAlert.click();
		System.out.println("The Text in the Confirmation Alert : "+cAlert.getText());
		cAlert.dismiss();
		
		//close() the browser
		driver.close();
		
	}

}
