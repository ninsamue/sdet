package Mobile_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Chrome_Activity_1 {
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
	        
	        //Go to the following URL: https://www.training-support.net/selenium
	        driver.get("https://www.training-support.net/selenium");
	        Reporter.log("Opened URL - https://www.training-support.net/selenium | ");
	      	        
	    }
	 
	 
	 @Test(priority=0)
	 public void todoTasks() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
	
		 //Scroll to find the To-Do List card and click it.
		 driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollToEnd(4).scrollIntoView(UiSelector().textContains(\"To-Do List\"))")).click();
		 
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text='Add Task']")));
		
		 Reporter.log("Scrolled down the Page and To-Do List Option is clicked | ");
		 
	 }
	 
	 /*
	  * Once the page loads, find the input field on the page and enter the
		following three tasks:
		i. Add tasks to list
		ii. Get number of tasks
		iii. Clear the list
	  */
	 @DataProvider(name = "Tasks")
	 public static Object[][] tasks() {
	     return new Object[][] { {"Add tasks to list"},{"Get number of tasks"},{"Clear the list"}};
	 }
	 
	 @Test(dataProvider = "Tasks",priority=1)
	 public void addTasks(String task) {
		
			driver.findElementByXPath("//android.widget.EditText").sendKeys(task);
			driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
			Reporter.log(task+" Task is entered |");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@resource-id='tasksList']//android.view.View[@text='"+task+"']")));
	 }
	 
	 @Test(priority=2)
	 public void checkTasks() {
		 List<MobileElement> noOfTasks = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		 Assert.assertEquals(noOfTasks.size(), 4);
		 System.out.println("There are 4 tasks in the List");
		 Reporter.log("There are 4 tasks in the List |");
	 }
	 
	 //Click on each of the tasks added to strike them out
	 @Test(dataProvider = "Tasks", priority=3)
	 public void strikeTasks(String task) {
		 driver.findElementByXPath("//android.view.View[@resource-id='tasksList']//android.view.View[@text='"+task+"']").click();
		 Reporter.log(task+" Task is striked | ");
		 
	 }
	 
	 //clear the list.
	 @Test(priority=4)
	 public void clearTasks() {
		 driver.findElementByXPath("//android.view.View[contains(@text,'Clear List')]").click();
		 Reporter.log("Clear List Button is clicked | ");
		
	 }
	 
	 @Test(priority=5)
	 public void checkNoTasks() {
		 List<MobileElement> noOfTasks = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
		 Assert.assertEquals(noOfTasks.size(), 0);
		 System.out.println("There are no tasks in the List");
		 Reporter.log("There are no tasks in the List | ");
	 }
	 
	 @AfterClass
	 public void tearDown() {
		 driver.quit();
		 Reporter.log("Browser is closed");
	 }
	 
}
