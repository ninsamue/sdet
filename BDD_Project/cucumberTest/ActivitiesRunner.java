package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features",
		glue = {"stepDefinitions"},
		tags = "@Job_Board or @HRM or @CRM",
		plugin = {"pretty","html:BDD_Project/test-reports/BDD_Cucumber_Project_Report.html","json:BDD_Project/test-reports/BDD_Cucumber_Project_Report.json"},
		monochrome = true
)
public class ActivitiesRunner {

}

