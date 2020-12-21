package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_12_1 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		//Navigate to https://www.training-support.net/selenium/iframes
		driver.get("https://www.training-support.net/selenium/iframes");

		//Print the title of the page
		System.out.println("The Title of the Page : "+driver.getTitle());

		driver.switchTo().frame(0);

		//Print the Heading of the 1st iframe.
		WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
		System.out.println(frameHeading1.getText());

		WebElement frame1Button=driver.findElement(By.id("actionButton"));

		//Print the Button Text and color of the button in that frame
		System.out.println(frame1Button.getText());
		System.out.println(frame1Button.getCssValue("background-color"));
		System.out.println(frame1Button.getCssValue("color"));

		//Click the Frame 1 button
		System.out.println("Click on the Frame 1 button");
		frame1Button.click();

		//Print the Button Text and color of the button in that frame
		System.out.println(frame1Button.getText());
		System.out.println(frame1Button.getCssValue("background-color"));
		System.out.println(frame1Button.getCssValue("color"));

		driver.switchTo().parentFrame();

		//Repeat Steps 3-6 with the 2nd iframe
		driver.switchTo().frame(1);

		WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
		System.out.println(frameHeading2.getText());

		WebElement frame2Button=driver.findElement(By.id("actionButton"));

		System.out.println(frame2Button.getText());
		System.out.println(frame2Button.getCssValue("background-color"));
		System.out.println(frame2Button.getCssValue("color"));
		
		System.out.println("Click on the Frame 2 button");
		frame2Button.click();
		
		System.out.println(frame2Button.getText());
		System.out.println(frame2Button.getCssValue("background-color"));
		System.out.println(frame2Button.getCssValue("color"));
		
		driver.close();


	}

}
