package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println("Title of the Page : "+driver.getTitle());
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@name='toggled']"));
		
		
		System.out.println("The state of the checkbox : "+checkBox.isSelected());
		
		System.out.println("Click the checkbox");
		checkBox.click();
		
		System.out.println("The state of the checkbox : "+checkBox.isSelected());
		
		driver.close();
		
	}

}
