package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class SearchStep {
	WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;
	@Given("User opens the Application")
	public void user_opens_the_application() {
	driver=	DriverFactory.getDriver();
	homePage= new HomePage(driver);
	    
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProduct) {
		 
		homePage.searchFiledText(validProduct);
		
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validProduct);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		 searchPage	=homePage.clickSearchButton();
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertTrue(searchPage.displayValidProduct());
		
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProduct) {
		
		homePage.searchFiledText(invalidProduct);
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(invalidProduct);
		
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		Assert.assertTrue(searchPage.displayInValidProduct());
		
		//Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).isDisplayed());
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {

	}
}
