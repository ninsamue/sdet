package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_9_1 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser with https://training-support.net/selenium/selects using the get() method
		driver.get("https://training-support.net/selenium/selects");
		
		//Use findElement() to find the dropdown WebElement on the page.
		WebElement chosen = driver.findElement(By.id("single-value"));
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='single-select']"));
		
		//Create a new Select class object with the WebElement.
		Select list = new Select(dropdown);
		
		//Select the second option using selectByVisibleText()
		list.selectByVisibleText("Option 2");
		System.out.println(chosen.getText());
		
		//Select the third option using selectByIndex()
		list.selectByIndex(3);
		System.out.println(chosen.getText());
		
		//Select the fourth option using selectByValue()
		list.selectByValue("4");
		System.out.println(chosen.getText());
		
		//Get all the options in the dropdown and print them one by one.
        List<WebElement> options = list.getOptions();
        
        System.out.println("Items in the drop-down");
        for(WebElement option : options) 
            System.out.println("Option: " + option.getText());
        
		
        driver.close();	
		
		
	}

}	
