package feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@Google"},plugin = {"pretty"  , "html:Test_Results"})
public class googleSearchTest {


    @BeforeClass
    public static void necessarySetup(){

    }

}