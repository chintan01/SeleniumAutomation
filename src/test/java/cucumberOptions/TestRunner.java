package cucumberOptions;

import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/java/Features",
		glue= "stepDefinations")



  public class TestRunner extends AbstractTestNGCucumberTests{
  
  
  }
 
//public class TestRunner {
//
//	
//}