package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements Constant{

public WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String br) {		
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		driver.get(appUrl);
		driver.manage().deleteAllCookies();
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	
}
