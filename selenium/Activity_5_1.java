package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_1 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println("Title of the Page : "+driver.getTitle());
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@name='toggled']"));
		WebElement removeCheckbox = driver.findElement(By.id("toggleCheckbox"));
		
		System.out.println("Is checkbox visible ? "+checkBox.isDisplayed());
		
		System.out.println("Click the Remove Checkbox button");
		removeCheckbox.click();
		
		System.out.println("Is checkbox visible ? "+checkBox.isDisplayed());
		
		driver.close();
		
	}

}
