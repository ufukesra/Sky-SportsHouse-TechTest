package sky.com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json","html:target/default-cucumber-reports"},
        features = {"src/test/resources/features"},
        glue = {"sky/com/step_def"},
        //tags = {""},
        dryRun = false
)
public class CukesRunner {
}
