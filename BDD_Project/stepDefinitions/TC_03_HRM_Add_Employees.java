package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_03_HRM_Add_Employees extends BaseClass{
	
	String empId="";
	@Given("^Click on the PIM option in the menu$")
	public void click_on_the_pim_option_in_the_menu() {
		WebElement PIMOptions = driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();
		PIMOptions = driver.findElement(By.id("menu_pim_viewPimModule"));
		PIMOptions.click();

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));

		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Employee Information");
		System.out.println("Employee Information Page is displayed");
	}
	
	@Given("^Click on Add Employee Button$")
	public void click_on_add_button() {
		// Click the Add button to add a new Employee
		driver.findElement(By.id("btnAdd")).click();
		System.out.println("Add Button is clicked");

	}
	

	@When("^All required fields are filled in the Add Employee form \"(.*)\", \"(.*)\"$")
	public void all_required_fields_are_filled_in_the_add_employee_form(String firstName,String lastName) {
	
		// Fill in the required fields and click Save.
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		System.out.println("Employee Details are entered");

		empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Employee Id : " + empId);
		
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(firstName+lastName);

		driver.findElement(By.id("btnSave")).click();
		System.out.println("Save Button is clicked");

	}

	@Then("Verify Employee is created {string}, {string}")
	public void verify_employee_is_created(String firstName,String lastName) {
		// Navigate back to the Admin page and verify the creation of your employee
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Employee Information')]"))));
		System.out.println("Navigated to Admin Page");

		driver.findElement(By.id("empsearch_id")).clear();
		driver.findElement(By.id("empsearch_id")).sendKeys(empId);

		driver.findElement(By.id("searchBtn")).click();
		System.out.println("The new employee created is searched");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]")).getText(), empId);
		System.out.println("Employee id is displayed correctly");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText(), firstName);
		System.out.println("First Name is displayed correctly");

		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]")).getText(), lastName);
		System.out.println("Last Name is displayed correctly");
		
		driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[1]/input")).click();
		driver.findElement(By.id("btnDelete")).click();
		
		driver.findElement(By.id("dialogDeleteBtn")).click();

	}

}
