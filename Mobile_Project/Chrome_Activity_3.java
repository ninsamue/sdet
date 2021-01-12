package Mobile_Project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Chrome_Activity_3 {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
	 @BeforeClass
	    public void startUp() throws MalformedURLException, InterruptedException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 3a Emulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("automationName", "UIAutomator2");
	        caps.setCapability("appPackage", "com.android.chrome");
	        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	        caps.setCapability("noReset", true);
	 
	        // Instantiate Appium Driver
	       
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 50);
	        
	        driver.get("https://www.training-support.net/selenium");
	        Thread.sleep(10000);
	        
	    }
	 
	 
	 @Test
	 public void openPopups() throws InterruptedException {
		 //Scroll to find the Popups card and click it.
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
	
    	 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(4).scrollIntoView(UiSelector().textContains(\"Popups\"))")).click();

		 
		 
	 }
	 
	 @DataProvider(name = "Credentials")
	 public static Object[][] tasks() {
	     return new Object[][] { {"admin","password","correct"},{"user1","pass1","incorrect"}};
	 }
	 
	 
	 @Test(dataProvider = "Credentials",priority=1)
	 public void enterCredentials(String username,String password,String credentials) {
		 //Once the page loads, find the Sign In button on the page to open a popup with the login form
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
		 
		 MobileElement btSignIn = driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]");
		 btSignIn.click();
		 
		 //Find the username and password input fields in the popup and enter the credentials
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='username']")));
		 
		 MobileElement meUsername = driver.findElementByXPath("//android.widget.EditText[@resource-id='username']");
		 meUsername.sendKeys(username);
		 
		 MobileElement mePassword = driver.findElementByXPath("//android.widget.EditText[@resource-id='password']");
		 mePassword.sendKeys(password);

		 //Click on the Log in button to submit
		 driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='action-confirmation']")));
		 
		 if(credentials.equals("correct")) {
			//Check Message when the credentials are correct
			 MobileElement confirmationMessage = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']");
			 Assert.assertEquals("Welcome Back, admin", confirmationMessage.getText());
			System.out.println("Credentials are correct");
		 }
		 else {
			//Check Message when the credentials are incorrect
			 MobileElement confirmationMessage = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']");
			 Assert.assertEquals("Invalid Credentials", confirmationMessage.getText());
			 System.out.println("Credentials are incorrect");
		 } 
	 }
	 
	 @AfterClass
	 public void tearDown() {
		 driver.quit();
	 }
	 
}
