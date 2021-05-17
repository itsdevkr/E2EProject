package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest {

	WebDriver driver;
	
	@Test
	public void launchBrower() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.axisbank.com/retail/calculators/fd-calculator");
		driver.manage().window().maximize();
		
		//Type of Customer
		WebElement typeOfCustomer = driver.findElement(By.xpath("//*[@id=\"RadioButton\"]/label[2]"));
		typeOfCustomer.click();
		
		//Type of Fixed Deposit
		WebElement typeOfFixedDeposit = driver.findElement(By.xpath("//div[@class='typeOf selArrow']"));
		
		Select type = new Select(typeOfFixedDeposit);
		type.selectByIndex(2);
		
		//Loan Amount
		WebElement loanAmount = driver.findElement(By.id("loan_amount"));
		loanAmount.sendKeys("10000");
		
		//Year
		WebElement year = driver.findElement(By.xpath("//*[@id=\"ctl00_Body_C022_Col00\"]/div/div[3]/div[2]/div[1]/div/article[1]/div/div[5]/div[2]/span"));
		
		Select noOfYear = new Select(year);
		noOfYear.selectByValue("5");
		
		
		
	}
	
	public void tearDown() {
		driver.quit();
	}
}
