package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/simple-form");
		
		System.out.println("Title of the Page : "+driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("fname");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("lname");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abc@test.com");
		driver.findElement(By.xpath("//*[@id='number']")).sendKeys("3242456324");
		driver.findElement(By.xpath("//textarea")).sendKeys("message");
		
		driver.findElement(By.xpath("//*[@value='submit']")).click();
		
		driver.switchTo().alert().accept();
				
		System.out.println("Title of the Navigated Page : "+driver.getTitle());
		driver.close();
		
	}

}
