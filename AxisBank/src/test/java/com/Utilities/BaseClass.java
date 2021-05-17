package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends BaseTest{

public WebDriver driver;
	
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.savaari.com/");
		
	}
	
	public void tearDown() {
		driver.quit();
	}
	
}
