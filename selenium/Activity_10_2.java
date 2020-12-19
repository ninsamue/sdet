package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity_10_2 {
	
	public static void main(String[] args) {
		
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		//Open a browser with https://www.training-support.net/selenium/input-events
		driver.get("https://www.training-support.net/selenium/input-events");
		
		//Get the title of the page using driver.getTitle() and print out the title
		System.out.println("The Title of the Page : "+driver.getTitle());
		
		//Press the key of your first name in caps
		Actions keyboardActions=new Actions(driver);
		keyboardActions.sendKeys("S").perform();
		
		WebElement keyPressed=driver.findElement(By.id("keyPressed"));
		System.out.println(keyPressed.getText());
		
		//Press CTRL+a and the CTRL+c to copy all the text on the page
		Action copyAction=keyboardActions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build();
		copyAction.perform();
		
		System.out.println(keyPressed.getText());
		
		//close the browser
		driver.close();
		
		
	}

}
