package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/HospitalProjectFeatures", // Path to feature files
        glue = {"HospitalProject.StepDefinitions",
                "hooks"}, // Path to step definition files
        plugin = { "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true,// Display readable console output
        tags = "@Login",// Run only scenarios with this tag
        dryRun = false// Check if all steps have step definitions
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    // Inherit AbstractTestNGCucumberTests to use TestNG
}
