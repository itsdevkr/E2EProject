package com.e2e.TestCase;

import org.testng.annotations.Test;

import com.e2e.PageObject.HomePage;

public class Test001 extends BaseClass{

	@Test
	public void firstName() {
		
		HomePage hp = new HomePage(driver);
		hp.setFname().sendKeys("Madar");
			
		
	}
	
	@Test
	public void bookStoreWebElement() {
		HomePage hp1 = new HomePage(driver);
		if(hp1.bstorelink().isDisplayed()) {
			System.out.println("Element is Displayed");
			hp1.bstorelink().click();
		
		}
		else {
			System.out.println("Element is not Displayed");
		}
	}
	
	@Test
	public void bookStoreLogin() {
		HomePage hp2 = new HomePage(driver);
		if(hp2.bookstoreLogin().isDisplayed()) {
			System.out.println("Element is Displayed");
			hp2.bookstoreLogin().click();
		}
		else {
			System.out.println("Element is not Displayed");
		}
	}
	
}
