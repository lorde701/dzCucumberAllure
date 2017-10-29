import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Иванка on 28.10.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"ru.company.tests"}, plugin = {"ru.company.tests.util.AllureReporter"})
public class CucumberRunner {}
