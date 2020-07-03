package EProject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class validateTitle extends base {

	public WebDriver driver;
	LandingPage l;
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		
		log.info("Initialize Driver");
		
		driver.get(prop.getProperty("url"));
		
		 log.info("Navigated to Home page");

	}
	
	
	@Test
	
	public void basePageNavigation1() throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
		l= new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		//Assert.assertTrue(condition);
		
		 log.info("Successfully validated Text message");
		
		}
	
@Test
	
	public void validateHeader() throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it		
		
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		//Assert.assertTrue(condition);         AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING
		
		 log.info("Successfully validate Header");

		
		}


	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
