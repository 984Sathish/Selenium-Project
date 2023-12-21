package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\Cucumber\\ClientAppE2E.feature", //location of feature file
				 glue = "StepDefinitions",   //location of step definition file
				 monochrome = true,  //get result from readable format
				 plugin = {"html:target/cucumber.html"},   //generate report with type
				 dryRun = false
				 //tags = "tagName"
				)
public class TestRunner extends AbstractTestNGCucumberTests {

}
