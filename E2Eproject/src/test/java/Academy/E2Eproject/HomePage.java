package Academy.E2Eproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

public class HomePage extends Base{

	public WebDriver driver;
	@BeforeTest
	public void initiliaz() throws IOException {
		driver = LaunchBrowser();
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String Password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		//log.info("Url opened");
		
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(Password);
		System.out.println(text);
	//	log.info("Successfully validated text message");
			}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		//Oth Row
		data[0][0] = "Non restricted";
		data[0][1] = "one.gmail.com";
		data[0][2] = "password_one";
		
		//1st Row
		data[1][0] = "Restricted";
		data[1][1] = "two.gmail.com";
		data[1][2] = "password_two";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
