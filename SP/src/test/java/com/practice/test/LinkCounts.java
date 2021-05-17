package com.practice.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkCounts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		//1. Count Number of Links
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Count Link of Footer Section
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3. Count Link of First Column of Footer
		WebElement footerFirstColumn = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footerFirstColumn.findElements(By.tagName("a")).size());
		
		//4. Click on each link of First Column of Footer
		for(int i=1;i<footerFirstColumn.findElements(By.tagName("a")).size();i++)
		{
			System.out.println(footerFirstColumn.findElements(By.tagName("a")).get(i).getText());
			
			//4.1 Open Link in New Tab using Ctrl + Click(Enter)
			String clickOnLinkToOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerFirstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkToOpenInNewTab);
			Thread.sleep(5000L);
		}
		
		//5. Manipulating Window/New Tab
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		driver.quit();
		
	}

}
