package com.e2e.TestCase;

import org.testng.annotations.Test;

import com.e2e.PageObject.BookStorePage;

public class Test002 extends BaseClass{

	@Test
	public void BookUser() {
		
		Test001 t1 = new Test001();
		t1.bookStoreWebElement();
		
		
		BookStorePage bsp = new BookStorePage(driver);
		bsp.setBookUsername().sendKeys("Hello Book");
	}
	
}
