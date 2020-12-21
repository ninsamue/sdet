package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_12_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		//Navigate to https://www.training-support.net/selenium/nested-iframes
		driver.get("https://www.training-support.net/selenium/nested-iframes");
		
		//Print the title of the page
		System.out.println("The Title of the Page : "+driver.getTitle());
		
		//Traverse into the iframe that is on the page
		driver.switchTo().frame(0);
		
		//Traverse into the first iframe in that frame
		driver.switchTo().frame(0);
		
		//Print the heading of that frame
		WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
		System.out.println(frameHeading1.getText());
		
		//Navigate to the second iframe in that frame
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		
		//Print the heading of that frame
		WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
		System.out.println(frameHeading2.getText());
		
		driver.close();
	}

}
