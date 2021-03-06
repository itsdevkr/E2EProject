package com.e2e.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage {

WebDriver ldriver;
	
	public BookStorePage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Book')]")
	@CacheLookup
	WebElement bstore;
	public void bstorelink () {
		bstore.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	@CacheLookup
	WebElement bstoreLogin;
	public void clikbook() {
		bstoreLogin.click();
	}
	
	@FindBy(xpath="//input[@id='userName']")
	@CacheLookup
	WebElement bookUsername;
	public WebElement setBookUsername() {
		return bookUsername;
	}
	
}
//span[contains(text(),'Login')]
//input[@id='userName']