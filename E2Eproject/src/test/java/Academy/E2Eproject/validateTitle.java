package Academy.E2Eproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import Resources.Base;

public class validateTitle extends Base{

	public WebDriver driver;
	@Test
	public void basePageNavigation() throws IOException {
		driver = LaunchBrowser();
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);
		String actual = l.getTitle().getText();
		String expected = "FEATURED COURSES";
		Assert.assertEquals(actual, expected);
		
			}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
