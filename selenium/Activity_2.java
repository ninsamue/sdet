package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver()
		WebDriver driver =new FirefoxDriver();
		
		//Open a browser with https://www.training-support.net
		driver.get("https://www.training-support.net");
		
		//Get the title of the page using driver.getTitle() and print out the title
		System.out.println("Title of the Page is : "+driver.getTitle());
		
		WebElement usingId=driver.findElement(By.id("about-link"));
		System.out.println("Text in the WebElement - By.id :"+usingId.getText());
		
		WebElement usingClassName=driver.findElement(By.className("green"));
		System.out.println("Text in the WebElement - By.className :"+usingClassName.getText());
		
		WebElement usingLinkText=driver.findElement(By.linkText("About Us"));
		System.out.println("Text in the WebElement - By.linkText :"+usingLinkText.getText());
		
		WebElement usingCSSSelector=driver.findElement(By.cssSelector("#about-link"));
		System.out.println("Text in the WebElement - By.cssSelector :"+usingCSSSelector.getText());
		
		//Close the browser with driver.close()
		driver.close();
		
	}

}
