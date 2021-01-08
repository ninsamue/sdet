package Mobile_Testing.Activity_2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity_2_1 {
	
	//com.google.android.apps.chrome.Main
	 AppiumDriver<MobileElement> driver = null;
	 @BeforeTest
	    public void startUp() throws MalformedURLException {
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
	        
	        
	    }
	 
	 
	  @Test
	    public void testSearchAppium() {
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	        driver.get("https://www.training-support.net/");
	 
	        //Verify Page Title
	        String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	        System.out.println("Title on Homepage: " + pageTitle);
	        
	        Assert.assertEquals(pageTitle, "Training Support");
	 
	        //Click on About Us Button
	        MobileElement aboutButton = driver.findElementByXPath("//android.view.View/android.view.View[1]/android.view.View[4]");
	        aboutButton.click();
	        System.out.println("About Us Button is clicked");
	        
	        //Verify New Page Title
	        String newPageTitle = driver
	                .findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]")
	                .getText();
	 
	        System.out.println("Title on new page: " + newPageTitle);
	 
	       
	        Assert.assertEquals(newPageTitle, "About Us");
	    }
	  
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }

	 
}
