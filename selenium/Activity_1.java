package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_1 {
	
	public static void main(String[] args) {
		//Create a WebDriver instance, named driver, with the FirefoxDriver()
		WebDriver driver =new FirefoxDriver();
		
		//Open a browser with https://www.training-support.net
		driver.get("https://www.training-support.net");
		
		//Close the browser with driver.close()
		driver.close();
		
	}

}
