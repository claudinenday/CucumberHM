package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features ="src\\test\\resources\\features\\TechfiosBilling.feature",
		glue ="steps",
		//tags ="",
		dryRun = false,
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/reports/cucumber.html"
				
				}
		
)

public class Runner {

}
