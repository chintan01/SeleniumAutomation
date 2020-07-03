package EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class HomePage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
	
		driver =initializeDriver();

	}
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));

		LandingPage l= new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info(text);

	//	lp.getLogin().click();
		System.out.println(text);
		
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
		
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][3];
		
		//0th row
		data[0][0]="nonrestricted user@gmail.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";	
		
		//1st row
//		data[1][0]="restricted user@gmail.com";
//		data[1][1]="6789";
//		data[1][2]="Non Restricted User";	
//		
		return data;
		
	}
	
	
		
	}

	
		

