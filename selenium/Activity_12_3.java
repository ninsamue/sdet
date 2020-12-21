package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_12_3 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		//Navigate to https://www.training-support.net/selenium/popups
		driver.get("https://www.training-support.net/selenium/popups");
		
		//Print the title of the page
		System.out.println("The Title of the Page : "+driver.getTitle());
				
		//Find the Sign in button and hover over it. Print the tooltip message
        WebElement button = driver.findElement(By.xpath("//button[contains(@class, 'orange')]"));
        Actions hoverAction = new Actions(driver);
        hoverAction.moveToElement(button).pause(3000).build().perform();
        
        String tooltipText = button.getAttribute("data-tooltip");
        System.out.println("Tooltip text: " + tooltipText);
        
    	
        //Click on the button
        button.click();
        
        //Wait for modal to appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        
        //Find username and pasword and fill in the details
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        //Read the login message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);
        
        //Close browser
        driver.close();
		
		
		
	}

}
