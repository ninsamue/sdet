package Mobile_Testing.Activity_2;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity_3_1 {
	
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Xperia M4 Aqua Dual");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("noReset", true);
        // Use your own device's messaging app
        caps.setCapability("appPackage", "com.sonyericsson.conversations");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 50);
    }
 
    @Test
    public void smsTest() {
        // Locate the button to write a new message and click it
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New conversation\"]").click();
        System.out.println("New Conversation is clicked");
    	
        // Enter the number to send message to
        String contactBoxLocator = "resourceId(\"com.sonyericsson.conversations:id/recipients_editor\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(contactBoxLocator)));
        // Enter your own phone number
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9841211111");
        System.out.println("Phone Number is entered");
        
        // Focus on the message text box
        String messageBoxLocator = "resourceId(\"com.sonyericsson.conversations:id/conversation_edit_text\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
 
        // Type in a message
        messageBoxLocator = "resourceId(\"com.sonyericsson.conversations:id/conversation_edit_text\")";
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
        composeMessageInput.sendKeys("Hello from Appium");
        System.out.println("Message Text is entered");
 
        // Send the message
        driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageButton").click();
        System.out.println("Message is sent");
        
        String notificationLocator = "resourceId(\"android:id/button1\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(notificationLocator)));
        driver.findElement(MobileBy.AndroidUIAutomator(notificationLocator)).click();
        
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
 
       // Wait for message to show
        String messageList = "resourceId(\"com.sonyericsson.conversations:id/conversationlist_item\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageList)));
        
        // Assertion
        String messageLocator = "resourceId(\"com.sonyericsson.conversations:id/conversationlist_item_message\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.RelativeLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[@text='Hello from Appium']")));
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
        System.out.println("Message received successfully!");
    }
 
    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}
