package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_3 {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/dynamic-controls");
		
		System.out.println("The Title of the Page : "+driver.getTitle());
		
		WebElement textField=driver.findElement(By.id("input-text"));
		WebElement enableInput=driver.findElement(By.id("toggleInput"));
		
		System.out.println("Is the Text Field Enabled ? "+textField.isEnabled());
			
		enableInput.click();
		
	    System.out.println("Is the Text Field Enabled ? "+textField.isEnabled());
		
		driver.close();
		
	}

}
