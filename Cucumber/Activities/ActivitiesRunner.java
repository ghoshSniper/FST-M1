package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    plugin = {"pretty"},
    monochrome = true
)

public class ActivitiesRunner {
    //This is intentionally blank
}



