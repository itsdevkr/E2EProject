package com.practice.test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all WebElements
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		for(int i=0;i<elementsList.size();i++) {
			System.out.println(elementsList.get(i).getText());
		}
		
		//Capture text of all WebElements to new(original) list
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Sort originalList
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare originalList vs sortedList
		Assert.assertTrue(originalList.equals(sortedList));

		//Scan the name column get text "Rice" and Print the Price.
		List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans")).
				map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
	
	}
	
	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("/following-sibling::td[1]")).getText();
		return priceValue;
	}

}
