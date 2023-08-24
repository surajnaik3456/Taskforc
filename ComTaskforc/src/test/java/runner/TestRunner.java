package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions","Hooks","TestBase"},
tags= "@Homepage",
monochrome = true,
plugin = {"json:target/cucumber.json"}
		)

public class TestRunner {

}
