package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Academy.E2Eproject.HomePage;

public class LandingPage extends HomePage{

	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in']");
	
	By title = By.cssSelector(".text-center>h2");
	
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}

}
