package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_02_CRM_Create_Lead extends BaseClass {

	
	@Given("^Navigate to Sales Leads CreateLead$")
	public void navigate_to_sales_leads_create_lead() throws InterruptedException {
		WebElement menuSales = driver.findElement(By.id("grouptab_0"));
		menuSales.click();
		
		WebElement menuLeads = driver.findElement(By.xpath("//a[@id='moduleTab_9_Leads' and text()='Leads' and contains(@href,'Sales')]"));
		
		System.out.println(menuLeads.getText());
		menuLeads.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(@class,'module-title')]")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")).click();
		
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(@class,'module-title')]"),"CREATE"));
		
		
	}

	@Then("^Fill in the Create Lead Accounts with Salution \"(.*)\", First Name \"(.*)\", Last Name \"(.*)\"$")
	public void fill_in_the_create_lead_accounts_with_salution_first_name_last_name(String salutation, String fname, String lname) throws InterruptedException {
		Thread.sleep(10000);
		
		Select salution = new Select(driver.findElement(By.id("salutation")));
		System.out.println("Salutation : "+salutation);
		//salution.selectByVisibleText(salutation);
		salution.selectByVisibleText("Ms.");
		
		driver.findElement(By.id("first_name")).sendKeys(fname);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		
		
	    

	}
	
	@Then("^Fill in the Create Lead Accounts$")
	public void fill_in_the_create_lead_accounts(String salutation, String fname, String lname) {
		Select salution = new Select(driver.findElement(By.id("salutation")));
		salution.selectByVisibleText("Ms.");
		
		driver.findElement(By.id("first_name")).sendKeys(fname);
		driver.findElement(By.id("last_name")).sendKeys(lname);
		
		driver.findElement(By.id("SAVE")).click();
		
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		
	}
	
	@Then("^Click Save to Finish$")
	public void click_save_to_finish() {
		driver.findElement(By.id("SAVE")).click();
	}
	
	@Then("^Navigate to View Leads page to see results with Salution \"(.*)\", First Name \"(.*)\", Last Name \"(.*)\"$")
	public void navigate_to_view_leads_page_to_see_results(String salutation,String fname, String lname) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionmenulink' and text()='View Leads']")));
		driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='View Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("ul.listViewLinkButton_top:nth-child(5) > li:nth-child(1) > a:nth-child(1)")).click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first_name_advanced")));
		driver.findElement(By.id("first_name_advanced")).clear();
		driver.findElement(By.id("first_name_advanced")).sendKeys(fname);
		driver.findElement(By.id("last_name_advanced")).clear();
		driver.findElement(By.id("last_name_advanced")).sendKeys(lname);
		
		driver.findElement(By.id("search_form_submit_advanced")).click();
		Thread.sleep(5000);
		
		List<WebElement> filterElements = driver.findElements(By.xpath("//td[@class=' inlineEdit']/b/a"));
		
		assertEquals(salutation+fname+" "+lname,filterElements.get(0).getText());
		
	}



}
