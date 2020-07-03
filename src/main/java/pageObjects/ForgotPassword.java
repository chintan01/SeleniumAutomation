package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class ForgotPassword {

	
	public WebDriver driver;
	
	By email=By.cssSelector("[id='user_email']");
	By sendMeInstructions=By.cssSelector("[type='submit']");
	
	
	
	
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
//	public WebElement sendMeInstructions()
//	{
//		return driver.findElement(sendMeInstructions);
//	}


	public WebElement sendMeInstructions() {
		// TODO Auto-generated method stub
		return driver.findElement(sendMeInstructions);
	}


	
	
	
}
