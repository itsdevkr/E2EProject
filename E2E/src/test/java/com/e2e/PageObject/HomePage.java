package com.e2e.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@id='firstName']")
	@CacheLookup
	WebElement fname;
	public WebElement setFname() {
		return fname;
	}
	
	@FindBy(xpath="//div[contains(text(),'Book')]")
	@CacheLookup
	WebElement bstore;
	public WebElement bstorelink () {
		return bstore;
	}
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	@CacheLookup
	WebElement bstoreLogin;
	public WebElement bookstoreLogin() {
		return bstoreLogin;
	}
}

