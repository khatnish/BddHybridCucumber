package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utilis.CommonUtils;

public class RegisterStep {
	WebDriver driver;
	private CommonUtils commonUtils;
	private HomePage homePage;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		 homePage= new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=	homePage.clickRegisterOption();    
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		 commonUtils=new CommonUtils ();
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterpasswordText(dataMap.get("password"));
		registerPage.enterconfirmText(dataMap.get("password"));
		
		
//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	    
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		registerPage.clickPrivacyPolicy();
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		 accountSuccessPage=registerPage.clickContinueButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		Assert.assertTrue(accountSuccessPage.accountCreatedMessage());
		//Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
	    
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.clickNewsLetter();
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		//input[@type='radio'][@value='1'][@name='newsletter']
	}
	
	@When("User enters the details into below field")
	public void user_enters_the_details_into_below_field(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		 registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterpasswordText(dataMap.get("password"));
		registerPage.enterconfirmText(dataMap.get("password"));
		
//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
//		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	    
	}

	@Then("User should get proper warning about duplicte email")
	public void user_should_get_proper_warning_about_duplicte_email() {
//		 registerPage=new RegisterPage(driver);
		Assert.assertTrue(registerPage.displayDuplicateEmailWarning());
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any deatails into fields")
	public void user_dont_enter_any_deatails_into_fields() {
	    
	}

	

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
		
		String actualPrivacyWarningMsg= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible'] ")).getText();
		Assert.assertEquals(actualPrivacyWarningMsg, "Warning: You must agree to the Privacy Policy!");
	
		String actualFirstNameWarningMsg= driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(actualFirstNameWarningMsg, "First Name must be between 1 and 32 characters!");
		
		String actualLastNameWarningMsg= driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(actualLastNameWarningMsg, "Last Name must be between 1 and 32 characters!");
		
		String actualEmailWarningMsg= driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(actualEmailWarningMsg, "E-Mail Address does not appear to be valid!");
		
		String actualTelephoneWarningMsg= driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(actualTelephoneWarningMsg, "Telephone must be between 3 and 32 characters!");
		
		String actualPasswordWarningMsg= driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(actualPasswordWarningMsg, "Password must be between 4 and 20 characters!");
		
	    
	}
	
}
