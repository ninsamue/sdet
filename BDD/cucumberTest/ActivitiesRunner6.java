package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/Features",
	glue = {"stepDefinitions"},
	tags = "@SmokeTest",
	plugin = {"pretty","html:BDD/test-reports/test-reports_2_6.html","json:BDD/test-reports/json-report_2_6.json"},
	monochrome = true
)
public class ActivitiesRunner6 {
}
