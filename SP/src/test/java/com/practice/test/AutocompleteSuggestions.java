package com.practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutocompleteSuggestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		
		WebElement country = driver.findElement(By.xpath(".inputs.ui-autocomplete-input"));
		country.click();
		country.sendKeys("South");
		
		
		
	}

}
