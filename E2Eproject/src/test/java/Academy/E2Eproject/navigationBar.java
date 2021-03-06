package Academy.E2Eproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import Resources.Base;

public class navigationBar extends Base{

	public WebDriver driver;
	@Test
	public void basePageNavigation() throws IOException {
		driver = LaunchBrowser();
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
