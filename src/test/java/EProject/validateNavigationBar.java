package EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateNavigationBar extends base {

	 public static Logger log =LogManager.getLogger(base.class.getName());
		public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		
	}
	
	@Test
	
	public void basePageNavigation1() throws IOException
	{

		//one is inheritance
		driver.get(prop.getProperty("url"));

		// creating object to that class and invoke methods of it
		
		LandingPage l= new LandingPage(driver);
	//	driver.findElement(l.NavBar);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		//Assert.assertTrue(condition);
	//	Assert.assertTrue(l.getNavigationBar().isDisplayed());
	    log.info("Navigation Bar is displayed");

		
		}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
