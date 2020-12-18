package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_9_2 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		//Open the browser with https://training-support.net/selenium/selects using the get() method
		driver.get("https://training-support.net/selenium/selects");
		
		//Use findElement() to find the multi-select WebElement on the page.
		WebElement listBox=driver.findElement(By.id("multi-select"));
		WebElement chosen=driver.findElement(By.id("multi-value"));
		
		//Create a new Select class object with the WebElement.
		Select list=new Select(listBox);
		
		//Check if the HTML element is a multi-list. Proceed with other actions if it is
		if(list.isMultiple()) {
			
			//Select the 'JavaScript' option by visible text.
			list.selectByVisibleText("Javascript");
			System.out.println(chosen.getText());
			
			//Select the 'NodeJS' option by value.
			list.selectByValue("node");
			System.out.println(chosen.getText());
			
			//Select the 4th, 5th, and the 6th options by index
			list.selectByIndex(4);
			list.selectByIndex(5);
			list.selectByIndex(6);
			System.out.println(chosen.getText());
			
			//Deselect the 'NodeJS' option by value attribute
			list.deselectByValue("node");
			System.out.println(chosen.getText());
			
			//Deselect the 7th option by index
			list.deselectByIndex(7);
			
			//Print the first selected option
			System.out.println("First Selected Option : "+list.getFirstSelectedOption().getText());
			
			//Print all selected options one by one
			List <WebElement> selectedOptions=list.getAllSelectedOptions();
			
			for(WebElement sel:selectedOptions)
				System.out.println(sel.getText());
		
			 //deselect all options
			list.deselectAll();
			
			System.out.println(chosen.getText());
			
					
		}
		
		driver.close();
		
	}

}
