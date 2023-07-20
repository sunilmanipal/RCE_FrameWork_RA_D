package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//execute the cucumber class what you have
@RunWith(Cucumber.class)
//i am telling my eclipse that where is the cucumber class present
@CucumberOptions(features = {"src/test/java/SimpleBooks"},
glue= {"StepDefinition"}
)
public class TestRunner {

}
