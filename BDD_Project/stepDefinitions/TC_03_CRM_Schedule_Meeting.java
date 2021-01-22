package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_03_CRM_Schedule_Meeting extends BaseClass {
	@Given("^Navigate to Activities Meetings ScheduleaMeeting$")
	public void navigate_to_activities_meetings_schedulea_meeting() {
		WebElement menuActivities = driver.findElement(By.id("grouptab_3"));
		menuActivities.click();
		
		WebElement menuMeeting = driver.findElement(By.xpath("//a[@id='moduleTab_9_Meetings' and text()='Meetings']"));
		
		System.out.println(menuMeeting.getText());
		menuMeeting.click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," MEETINGS"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='Schedule Meeting']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Schedule Meeting']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]"),"CREATE"));
		
	}
	
	@Given("^Enter the details of the meeting$")
	public void enter_the_details_of_the_meeting() {
		
		driver.findElement(By.id("name")).sendKeys("Meeting for Activity 3");

	}
	
	@Given("^Search for members and add them to the meeting$")
	public void search_for_members_and_add_them_to_the_meeting(DataTable searchData) throws InterruptedException {
	
		List<List<String>> search = searchData.asLists();
		
		System.out.println("number of rows " +search.size());
		for(int i=1;i<search.size();i++) {
			driver.findElement(By.id("search_first_name")).sendKeys(search.get(i).get(0));
			driver.findElement(By.id("search_last_name")).sendKeys(search.get(i).get(1));
			driver.findElement(By.id("search_email")).sendKeys(search.get(i).get(2));
			
			driver.findElement(By.id("invitees_search")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("invitees_add_1")).click();
			
			driver.findElement(By.id("search_first_name")).clear();
			driver.findElement(By.id("search_last_name")).clear();
			driver.findElement(By.id("search_email")).clear();
		}
			
		driver.findElement(By.id("SAVE_HEADER")).click();
		
	}
	
	@Then("^Navigate to View Meetings page and confirm creation of the meeting$")
	public void navigate_to_view_meetings_page_and_confirm_creation_of_the_meeting() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='View Meetings']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='View Meetings']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]")," MEETINGS"));
		
		assertEquals(driver.findElement(By.xpath("//td[@field='name']")).getText(),"Meeting for Activity 3");
	}

}
