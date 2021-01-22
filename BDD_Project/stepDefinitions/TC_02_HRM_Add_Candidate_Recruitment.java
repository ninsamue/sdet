package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_02_HRM_Add_Candidate_Recruitment extends BaseClass {
	@Given("^Click on Add Button$")
	public void click_on_add_button() {
		driver.findElement(By.id("btnAdd")).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addCandidateHeading")));
	}

	@Then("^Fill in the details of the candidate$")
	public void fill_in_the_details_of_the_candidate() {
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("Ritu");
        driver.findElement(By.id("addCandidate_lastName")).sendKeys("Simon");
        
        driver.findElement(By.id("addCandidate_email")).sendKeys("lname.test@test.com");
	}
	@Then("^Upload a resume to the form$")
	public void upload_a_resume_to_the_form() {
		 File file = new File("Sample Resume.docx");
		
		    //Find upload field
		    WebElement uploadInput = driver.findElement(By.id("addCandidate_resume"));
		    uploadInput.sendKeys(file.getAbsolutePath());
		    

	}
	@Then("^Save Button is clicked$")
	public void save_button_is_clicked() {
	    //Click button to upload
	    driver.findElement(By.id("btnSave")).click();

	}
	@Then("^Confirm Candidate Entry in Recruitments Page$")
	public void confirm_candidate_entry_in_recruitments_page() {
		
			
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("candidateSearch_candidateName")));
		
		driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("Ritu Simon");
		
		driver.findElement(By.id("btnSrch")).click();
		
		//Verify Candidate
		assertEquals(driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[2]/td[3]/a")).getText(),"Ritu Simon");

	}

}
