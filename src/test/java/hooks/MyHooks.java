package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilis.ConfigReader;

public class MyHooks {
	WebDriver driver;
private ConfigReader configReader;
	@Before
	public void setup() throws IOException {
		
		configReader=new ConfigReader();
	Properties prop = configReader.intializeProperties();
		driver=DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = DriverFactory.getDriver();
		
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {
		String scanarioName= scenario.getName().replace(" ","_");
		if(scenario.isFailed()) {
			byte[]srcScreenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scanarioName);
		}
		driver.quit();
	}
}