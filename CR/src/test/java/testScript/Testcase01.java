package testScript;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Page.CustRegPage;
import utilities.WrapperClass;

public class Testcase01 extends WrapperClass{

	@Test
	public void f() throws IOException, InterruptedException {
		launchBrowser("chrome", "https://webapps.tekstac.com/CustomerRegistration/");
		CustRegPage rbp = new CustRegPage(driver);
		rbp.fromCustregName(1, 0);
		rbp.fromCustregage(1, 1);
		rbp.fromCustregaddress(1,2);
		rbp.fromCustregph(1,3);
		rbp.fromCustregemail(1,4);
		rbp.submit();
		screenshot();
		driver.close();
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
	
}
