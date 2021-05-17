package com.practice.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDropdownAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		
		//Check and get CheckBox Value
		WebElement checkBox = driver.findElement(By.xpath("//label[@for='benz']"));
		checkBox.findElement(By.xpath("//label[@for='benz']/input")).click();
		String checkBoxValue = checkBox.getText();
		//System.out.println(checkBoxValue);
		
		//Select from dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(checkBoxValue);
		
		//Enter Name
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkBoxValue);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		String alert = driver.switchTo().alert().getText();
		
		if(alert.contains(checkBoxValue))
			System.out.println("Alert Message Success!!");
		else
			System.out.println("Alert Message Failed!!");
		
		driver.quit();

	}

}
