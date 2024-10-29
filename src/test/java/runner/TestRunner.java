package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/01Login.feature",
				    "src/test/resources/features/06Logout.feature", 
				    "src/test/resources/features/02Dashboard.feature"},
					
		glue = "stepDefinitions", 
		plugin = { "html:target/cucumber.html", "json:target/cucumber.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"rerun:target/failed_scenarios.txt" }, // captures failed secnarios in a txt file
		monochrome = false, // console output color
		//tags = "  @NavBarOrderhome or @NavBarOrderprogram ", // tags from feature file
		dryRun = !true //To add new method give true
		)
		
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)

	public Object[][] scenarios() {
		return super.scenarios();
	}

}
