package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtils;
import utilis.ElementUtils;

public class LoginPages {
	WebDriver driver;
	private ElementUtils elementUtils;


	public LoginPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);

	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement errorMessage;

	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//emailField.sendKeys(emailText);
	}

	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordField.sendKeys(passwordText);
	}

	public AccountPage clickLoginButton() {
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//loginButton.click();
		return new AccountPage(driver);
	}

	public boolean displayErrorMessage() {
		return	elementUtils.displayMessage(errorMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return errorMessage.isDisplayed();
	}

}
