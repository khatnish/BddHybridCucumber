package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.CommonUtils;
import utilis.ElementUtils;

public class SearchPage {
	WebDriver driver;
	ElementUtils elementUtils;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);


	}

	@FindBy(linkText = "HP LP3065")
	private WebElement validproduct;

	@FindBy(xpath = "//*[@id='content']/p[2]")
	private WebElement invalidProductWarning;

	public boolean displayValidProduct() {
		return elementUtils.displayMessage(validproduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return validproduct.isDisplayed();
	}

	public boolean displayInValidProduct() {
		return elementUtils.displayMessage(invalidProductWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return invalidProductWarning.isDisplayed();
	}
}