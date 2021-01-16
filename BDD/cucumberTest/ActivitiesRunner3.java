package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/Features",
glue = {"stepDefinitions"},
tags = "@activity1_3",
monochrome = true
)
public class ActivitiesRunner3 {
}
