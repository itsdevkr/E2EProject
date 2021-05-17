package com.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObject.HomePage;
import com.utility.BaseTest;

public class TestMy extends BaseTest{

	@Test
	public void savari() {
		
		try {
			HomePage sHomePage = new HomePage(driver);
			sHomePage.from.sendKeys("Chennai");
			 
			
		}catch(Exception e) {
			Assert.fail();
		}
		
	}
	
}
