package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefination extends base{

	
	@Given("Initialize browser with chrome")
	public void initialize_browser_with_chrome() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver =initializeDriver();

	}

	@Given("Navigate to {string} Site")
	public void navigate_to_Site(String url) {
	    // Write code here that turns the phrase above into concrete actions

		driver.get(url);
	}

	@Given("Click on login link in home page to land on secure sign in page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l= new LandingPage(driver);
		if(l.getPopUpSize()>0)
		{
			l.getPopUp().click();
		}
		l.getLogin().click(); 
		
	}

	/*
	 * @When("user eneter {string} and {string} and login") public void
	 * user_eneter_and_and_login(String username, String pass) { // Write code here
	 * that turns the phrase above into concrete actions
	 * 
	 * LoginPage lp= new LoginPage(driver);
	 * 
	 * lp.getEmail().sendKeys(username); lp.getPassword().sendKeys(pass);
	 * lp.getLogin().click();
	 * 
	 * // lp.getLogin().click(); }
	 */
	
	 @When("^user eneter (.+) and (.+) and login$")
	    public void user_eneter_and_and_login(String username, String password) throws Throwable {

		 LoginPage lp= new LoginPage(driver);
		 
		  lp.getEmail().sendKeys(username);
		  lp.getPassword().sendKeys(password);
		  lp.getLogin().click();
	 }

	
	@Then("Verify user is sucessfully login")
	public void verify_user_is_sucessfully_login() {
	    // Write code here that turns the phrase above into concrete actions

		portalHomePage p = new portalHomePage(driver);
	    Assert.assertTrue(p.getSearchBox().isDisplayed());
	
	}

	
    @Given("user is on NetBanking landing page")
    public void user_is_on_netbanking_landing_page() throws Throwable {
        
        
        System.out.println("user is on NetBanking landing page $");
    }


    @When("user login with username=\"([^\"]*)\" and password=\"([^\"]*)\"")
    public void user_login_with_usernamesomething_and_passwordsomething(String strArg1, String strArg2) throws Throwable {
    System.out.println(strArg1);
    System.out.println(strArg2);
    
    }

    @Then("Home page is populated")
    public void home_page_is_populated() throws Throwable {
        System.out.println("Home page is populated");
    }

    @And("^Carts display \"([^\"]*)\"$")
    public void carts_display_something(String strArg1) throws Throwable {
    	System.out.println(strArg1);
    }
    
    @And("^close browser$")
    public void close_browser() throws Throwable {
    	driver.quit();   
    	
    }
    
}