package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtils;
import utilis.ElementUtils;

public class HomePage {
	WebDriver driver;
	ElementUtils elementUtils;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(xpath="//a[contains(@href,'route=account/login')]")
	private WebElement loginOption;
	@FindBy(linkText="Register")
	private WebElement RegistarOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchField;
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement seacrhButton;
	
	
	
	
	public void clickOnMyAccount() {
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
	}
	public LoginPages clickLoginOption() {
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//loginOption.click();
		return new LoginPages(driver);
	}
	
	public RegisterPage clickRegisterOption() {
		elementUtils.clickOnElement(RegistarOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//RegistarOption.click();
		return new RegisterPage(driver);
	}
	
	public void searchFiledText(String productName) {
		elementUtils.typeTextIntoElement(searchField, productName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//searchField.sendKeys(productName);
	}
	public SearchPage clickSearchButton() {
		elementUtils.clickOnElement(seacrhButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//seacrhButton.click();
		return new SearchPage(driver);
	}

}
