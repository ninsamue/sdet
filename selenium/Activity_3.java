package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new FirefoxDriver();
		
		driver.get("https://training-support.net/selenium/simple-form");
		
		System.out.println("The title of the Page : "+driver.getTitle());
		
		driver.findElement(By.id("firstName")).sendKeys("fname");
		driver.findElement(By.id("lastName")).sendKeys("lname");
		
		driver.findElement(By.id("email")).sendKeys("abc@test.com");
		
		driver.findElement(By.id("number")).sendKeys("2345678");
		
		driver.findElement(By.className("green")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
		
	}

}
