package com.practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		int tableSize = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]")).size();
		
		int sum = 0;
		
		for(int i=0;i<tableSize;i++) {
			sum = sum + Integer.parseInt(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]")).get(i).getText());
		}
		
		System.out.println(sum);
	}

}
