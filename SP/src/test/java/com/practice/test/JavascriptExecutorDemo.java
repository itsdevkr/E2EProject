package com.practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {

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
		
		//WebElement table = driver.findElement(By.cssSelector(".tableFixHead"));
		
		int tableDataSize = driver.findElements(By.xpath("//div[@style='overflow-y: auto; height: 195px;']/table/tbody/tr")).size();
	
		int sum = 0;
		for(int i=0;i<tableDataSize;i++) {
			sum = sum +	Integer.parseInt(driver.findElements(By.xpath("//div[@style='overflow-y: auto; height: 195px;']/table/tbody/tr/td[4]")).get(i).getText());
		}
		
		System.out.println(sum);
		System.out.println(driver.findElement(By.cssSelector("div.totalAmount")).getText());
		
		String total = driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim();
		
		
		Assert.assertEquals(sum, Integer.parseInt(total));
	}

}
