package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_01_04_HRM_Create_Vacancy extends BaseClass{
	
	@Given("^I navigate to Alchemy HRM System and login to the application$")
	public void i_navigate_to_alchemy_hrm_system_and_login_to_the_application() {
		//Create Instances
		createWebDriver();
		 
		//Open browser
		driver.get("http://alchemy.hguy.co/orangehrm");
		
		
		//Enter login credentials into the respective fields
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		
		//Click login
		driver.findElement(By.id("btnLogin")).click();
	}


	@Given("^Navigate to Recruitment Page$")
	public void navigate_to_recruitment_page() {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
	}
	
	@Given("^Click on Vacancies Menu$")
	public void click_on_vacancies_menu() {
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	}
	
	@Then("^Vacancies Page should be displayed$")
	public void vacancies_page_should_be_displayed() {
		assertEquals(driver.findElement(By.xpath("//div[@id='srchVacancy']/div/h1")).getText(),"Vacancies");
	}
	
	@When("^Add Button is clicked$")
	public void add_button_is_clicked() {
		driver.findElement(By.id("btnAdd")).click();
	}
	
	@When("^Job Vacancy Form is filled and saved - job title \"(.*)\", vacancy name \"(.*)\", hiring manager \"(.*)\"$")
	public void job_vacancy_form_is_filled_and_saved(String jobTitleL,String vacancyName,String hiringManager) {
		Select jobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		jobTitle.selectByVisibleText(jobTitleL);
		
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
		
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(hiringManager);
		
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Then("^Vacancy should be created - job title \"(.*)\", vacancy name \"(.*)\", hiring manager \"(.*)\"$")
	public void vacancy_should_be_created(String jobTitleL,String vacancyName,String hiringManagerL) {
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		
		Select jobTitle = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
		jobTitle.selectByVisibleText(jobTitleL);
		
		Select jobVacancy = new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
		jobVacancy.selectByVisibleText(vacancyName);
		
		Select hiringManager = new Select(driver.findElement(By.id("vacancySearch_hiringManager")));
		hiringManager.selectByVisibleText(hiringManagerL);
		
		driver.findElement(By.id("btnSrch")).click();
		
		//Verify Vacancy
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).getText(),vacancyName);
		//Verify Job Title
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText(),jobTitleL);
		//Verify Hiring Manager
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[4]")).getText(),hiringManagerL);
		
		
	}


}
