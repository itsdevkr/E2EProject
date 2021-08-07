package Page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReaderUtility;

public class CustRegPage {

	WebDriver driver;

	public CustRegPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	ExcelReaderUtility e = new ExcelReaderUtility();

	String sheetName = "customer_valid";
	String sheetName1 = "customer_invalid";

	@FindBy(xpath="//input[@name='cname']")
	private WebElement txtCustomername;
	
	@FindBy(xpath="//input[@name='age']")
	private WebElement txtAge;
	
	@FindBy(xpath="//input[@name='phonenumber']")
	private WebElement txtPhoneNumber;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='address']")
	private WebElement txtAddress;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement btnLogin;
	
	public void fromCustregName(int rowNum, int cellNum) throws IOException, InterruptedException {

		String fromValuename = e.getCellValue(sheetName, rowNum, cellNum);

		txtCustomername.clear();
		Thread.sleep(1000);

		txtCustomername.sendKeys(fromValuename);
		Thread.sleep(1000);

		txtCustomername.sendKeys(Keys.ENTER);
	}

	public void fromCustregage(int rowNum, int cellNum) throws IOException, InterruptedException {

		String fromValueage = e.getCellValue(sheetName, rowNum, cellNum);

		txtAge.clear();
		Thread.sleep(1000);

		txtAge.sendKeys(fromValueage);
		Thread.sleep(1000);

		txtAge.sendKeys(Keys.ENTER);
	}
	
	public void fromCustregaddress(int rowNum, int cellNum) throws IOException, InterruptedException {

		String fromValueaddress = e.getCellValue(sheetName, rowNum, cellNum);

		txtAddress.clear();
		Thread.sleep(1000);

		txtAddress.sendKeys(fromValueaddress);
		Thread.sleep(1000);

		txtAddress.sendKeys(Keys.ENTER);
	}
	
	public void fromCustregph(int rowNum, int cellNum) throws IOException, InterruptedException {

		String fromValuephn = e.getCellValue(sheetName, rowNum, cellNum);

		txtPhoneNumber.clear();
		Thread.sleep(1000);

		txtPhoneNumber.sendKeys(fromValuephn);
		Thread.sleep(1000);

		txtPhoneNumber.sendKeys(Keys.ENTER);
	}

	public void fromCustregemail(int rowNum, int cellNum) throws IOException, InterruptedException {

		String fromValueemail = e.getCellValue(sheetName, rowNum, cellNum);

		txtEmail.clear();
		Thread.sleep(1000);

		txtEmail.sendKeys(fromValueemail);
		Thread.sleep(1000);

		txtEmail.sendKeys(Keys.ENTER);
	}
	
	
	
	

	public void submit() throws InterruptedException {
		btnLogin.click();
		Thread.sleep(2000);
	}

	
	
	public void details() throws InterruptedException {
		
		WebElement Element = driver.findElement(By.xpath("//h2"));
	
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		   js.executeScript("arguments[0].scrollIntoView();", Element);
		   js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", Element);
	
	}

	
}
