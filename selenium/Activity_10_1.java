package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity_10_1 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver().
		WebDriver driver = new FirefoxDriver();
		
		//Open a browser with https://www.training-support.net/selenium/input-events
		driver.get("https://www.training-support.net/selenium/input-events");
		
		//Get the title of the page using driver.getTitle() and print out the title.
		System.out.println("Title of the Page : "+driver.getTitle());
		
		Actions mouseAction = new Actions(driver);
		
		WebElement dice =  driver.findElement(By.id("D3Cube"));
		WebElement diceNumber = driver.findElement(By.xpath("//div[@id='D3Cube']/div[@class='active']"));
		
		//Left click and print the value of the side in the front.
		System.out.println("Number in the dice : "+diceNumber.getText());
		System.out.println("Left Click the Dice");
		mouseAction.click(dice).build().perform();
		diceNumber = driver.findElement(By.xpath("//div[@id='D3Cube']/div[@class='active']"));
		System.out.println("Number in the dice : "+diceNumber.getText());
		
		//Double click to show a random side and print the number.
		System.out.println("Double Click the Dice");
		mouseAction.doubleClick(dice).perform();
				diceNumber = driver.findElement(By.xpath("//div[@id='D3Cube']/div[@class='active']"));
		System.out.println("Number in the dice : "+diceNumber.getText());
		
		//Right click and print the value shown on the front of the cube.
		System.out.println("Right Click the Dice");
		mouseAction.contextClick(dice).perform();
		diceNumber = driver.findElement(By.xpath("//div[@id='D3Cube']/div[@class='active']"));
		System.out.println("Number in the dice : "+diceNumber.getText());
		
		//close the browser.
		driver.close();
		
	}

}
