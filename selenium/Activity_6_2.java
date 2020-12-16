package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_6_2 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		driver.get("https://training-support.net/selenium/ajax");
		
		System.out.println("Title of the Page : "+driver.getTitle());
		
		WebElement btChangeContent=driver.findElement(By.className("violet"));
		btChangeContent.click();
		
		WebElement txtHello=driver.findElement(By.xpath("//div[@id='ajax-content']"));
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='ajax-content']"), "HELLO!"));
		System.out.println(txtHello.getText());
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='ajax-content']"), "I'm late!"));
		System.out.println(txtHello.getText());
		
		driver.close();
		
	}

}
