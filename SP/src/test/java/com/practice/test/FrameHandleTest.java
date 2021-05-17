package com.practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		//System.out.println(driver.findElements(By.tagName("frameset")).size());
		
		driver.switchTo().frame(0);
		//System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame("frame-middle");
		
		String text = driver.findElement(By.id("content")).getText();
		System.out.println(text);

		driver.switchTo().parentFrame();
		driver.quit();
	}

}
