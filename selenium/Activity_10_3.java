package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_10_3 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//Open a browser with https://training-support.net/selenium/drag-drop
		driver.get("https://training-support.net/selenium/drag-drop");
		
		//Get the title of the page using driver.getTitle() and print out the title.
		System.out.println("The title of the Page : "+driver.getTitle());
		
		//Find the ball and simulate a click and drag to move it into "Dropzone 1"
		WebElement ball=driver.findElement(By.id("draggable"));
		WebElement dropZone1=driver.findElement(By.id("droppable"));
		WebElement dropZone2=driver.findElement(By.id("dropzone2"));
		
		Actions ballAction = new Actions(driver);
		ballAction.dragAndDrop(ball, dropZone1).perform();
		
		//Verify that the ball has entered Dropzone 1.
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dropZone1, "background-color"));
        System.out.println("ENTERED DROPZONE 1");
        
        //move the ball into "Dropzone 2".
        ballAction.dragAndDrop(ball, dropZone2).perform();
        
        //Verify that the ball has entered Dropzone 2.
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dropZone2, "background-color"));
        System.out.println("ENTERED DROPZONE 2");
        
        //close the browser.
        driver.close();
        
	}
	
	

}
