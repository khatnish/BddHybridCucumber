package stepdefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPages;
import utilis.CommonUtils;

public class LoginStep {
	WebDriver driver;
	private CommonUtils commonUtils;
	

	private LoginPages loginPage;
	private AccountPage accountPage;
	 
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage=homePage.clickLoginOption();

	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String validEmailText) {
		loginPage.enterEmailAddress(validEmailText);

	}

	@When("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String validPasswordText) {
		loginPage.enterPassword(validPasswordText);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage = new LoginPages(driver);
		accountPage=loginPage.clickLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		Assert.assertTrue(accountPage.successMessage());

	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		 commonUtils=new CommonUtils();
		 
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());

	}

	@When("User enters invaid password {string} into password field")
	public void user_enters_invaid_password_into_password_field(String invalidPassword) {
		loginPage.enterPassword(invalidPassword);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		//loginPage = new LoginPages(driver);
		Assert.assertTrue(loginPage.displayErrorMessage());
		
	}

	@When("User does not enter email address into email field")
	public void user_does_not_enter_email_address_into_email_field() {

	}

	@When("User does not enter password into password field")
	public void user_does_not_enter_password_into_password_field() {
	}

	
}
