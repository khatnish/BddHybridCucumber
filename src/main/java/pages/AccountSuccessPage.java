package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtils;
import utilis.ElementUtils;

public class AccountSuccessPage {
	WebDriver driver;
	ElementUtils elementUtils;
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);

	}
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement accountCreated;
	
	
	
	public boolean accountCreatedMessage() {
		return	elementUtils.displayMessage(accountCreated, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return accountCreated.isDisplayed();
	}

}
