package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtils;
import utilis.ElementUtils;

public class AccountPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformation;
	
	public boolean successMessage() {
		return elementUtils.displayMessage(editYourAccountInformation, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	//return	editYourAccountInformation.isDisplayed();
		
	}

}
