package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Academy.E2Eproject.HomePage;

public class LoginPage extends HomePage{

	public WebDriver driver;
	
	By email = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	

	

}
