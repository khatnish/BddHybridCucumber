package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtils;
import utilis.ElementUtils;

public class RegisterPage {
	WebDriver driver;
	ElementUtils elementUtils;
public RegisterPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	elementUtils=new ElementUtils(driver);

}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameText;
	@FindBy(id="input-lastname")
	private WebElement lastnameText;
	@FindBy(id="input-email")
	private WebElement emailText;
	@FindBy(id="input-telephone")
	private WebElement telephoneText;
	@FindBy(id="input-password")
	private WebElement passwordText;
	@FindBy(id="input-confirm")
	private WebElement confirmText;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetter;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarning;
	
	
	public void enterFirstName(String fn) {
		elementUtils.typeTextIntoElement(firstNameText, fn,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//firstNameText.sendKeys(fn);
	}
	public void enterLastName(String ln) {
		elementUtils.typeTextIntoElement(lastnameText, ln,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//lastnameText.sendKeys(ln);
	}
	public void enterEmail(String em) {
		elementUtils.typeTextIntoElement(emailText, em,  CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//emailText.sendKeys(em);
	}
	public void enterTelephone(String tl) {
		elementUtils.typeTextIntoElement(telephoneText, tl, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//telephoneText.sendKeys(tl);
	}
	public void enterpasswordText(String pw) {
		elementUtils.typeTextIntoElement(passwordText, pw, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//passwordText.sendKeys(pw);
	}
	public void clickPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicy, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//privacyPolicy.click();
	}
	
	public AccountSuccessPage clickContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void clickNewsLetter() {
		elementUtils.clickOnElement(newsLetter, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//newsLetter.click();
	}
	
	public void enterconfirmText(String cpw) {
		elementUtils.typeTextIntoElement(confirmText, cpw, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		//confirmText.sendKeys(cpw);
	}
	
	public boolean displayDuplicateEmailWarning() {
		return	elementUtils.displayMessage(duplicateEmailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return duplicateEmailWarning.isDisplayed();
	}
	
	
	
}
